package it.unisa.aDoctor.process;

import it.unisa.aDoctor.smellDetectionRules.ProhibitedDataTransferRule;
import it.unisa.aDoctor.smellDetectionRules.BulkDataTransferRule;
import it.unisa.aDoctor.smellDetectionRules.CVOnlyRule;
import it.unisa.aDoctor.smellDetectionRules.DurableWakeLockRule;
import it.unisa.aDoctor.smellDetectionRules.HostNameVerifierRule;
import it.unisa.aDoctor.smellDetectionRules.InefficientDataFormatAndParserRule;
import it.unisa.aDoctor.smellDetectionRules.SlowLoopRule;
import it.unisa.aDoctor.smellDetectionRules.NoLowMemoryResolverRule;
import it.unisa.aDoctor.smellDetectionRules.NoOpRule;
import it.unisa.aDoctor.smellDetectionRules.MemberIgnoringMethodRule;
import it.unisa.aDoctor.smellDetectionRules.InefficientDataStructureRule;
import it.unisa.aDoctor.smellDetectionRules.InternalGetterSetterRule;
import it.unisa.aDoctor.smellDetectionRules.DataTransmissionWithoutCompressionRule;
import it.unisa.aDoctor.smellDetectionRules.DebuggableReleaseRule;
import it.unisa.aDoctor.smellDetectionRules.InefficientSQLQueryRule;
import it.unisa.aDoctor.smellDetectionRules.LeakingInnerClassRule;
import it.unisa.aDoctor.smellDetectionRules.RigidAlarmManagerRule;
import it.unisa.aDoctor.smellDetectionRules.SetConfigChangesRule;
import it.unisa.aDoctor.smellDetectionRules.PublicDataRule;
import it.unisa.aDoctor.smellDetectionRules.LeakingThreadRule;
import it.unisa.aDoctor.smellDetectionRules.UnclosedCloseableRule;
import it.unisa.aDoctor.smellDetectionRules.BulkDataTransferRule;
import it.unisa.aDoctor.smellDetectionRules.ProhibitedDataTransferRule;
import it.unisa.aDoctor.smellDetectionRules.TrackingHardwareIDRule;
import it.unisa.aDoctor.beans.ClassBean;
import it.unisa.aDoctor.beans.PackageBean;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.eclipse.core.runtime.CoreException;

import java.io.FileWriter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.lang.StringUtils;

public class RunAndroidSmellDetection {

    private static final String NEW_LINE_SEPARATOR = "\n";
    public static String[] FILE_HEADER;

    // The folder contains the set of Android apps that need to be analyzed
    public static void main(String[] args) throws IOException, CoreException {

        SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
        System.out.println("Started at " + ft.format(new Date()));

        // Folder containing android apps to analyze
        File experimentDirectory = FileUtils.getFile(args[0]);
        File fileName = new File(args[1]);
        String smellsNeeded = args[2];

        FILE_HEADER = new String[StringUtils.countMatches(smellsNeeded, "1") + 1];

        BulkDataTransferRule bulkDataTransferRule=new BulkDataTransferRule();
        DataTransmissionWithoutCompressionRule dataTransmissionWithoutCompressionRule = new DataTransmissionWithoutCompressionRule();
        DebuggableReleaseRule debbugableReleaseRule = new DebuggableReleaseRule();
        DurableWakeLockRule durableWakeLockRule = new DurableWakeLockRule();
        InefficientDataFormatAndParserRule inefficientDataFormatAndParserRule = new InefficientDataFormatAndParserRule();
        InefficientDataStructureRule inefficientDataStructureRule = new InefficientDataStructureRule();
        InefficientSQLQueryRule inefficientSQLQueryRule = new InefficientSQLQueryRule();
        InternalGetterSetterRule internaleGetterSetterRule = new InternalGetterSetterRule();
        LeakingInnerClassRule leakingInnerClassRule = new LeakingInnerClassRule();
        LeakingThreadRule leakingThreadRule = new LeakingThreadRule();
        MemberIgnoringMethodRule memberIgnoringMethodRule = new MemberIgnoringMethodRule();
        NoLowMemoryResolverRule noLowMemoryResolverRule = new NoLowMemoryResolverRule();
        PublicDataRule publicDataRule = new PublicDataRule();
        RigidAlarmManagerRule rigidAlarmManagerRule = new RigidAlarmManagerRule();
        SlowLoopRule slowLoopRule = new SlowLoopRule();
        UnclosedCloseableRule unclosedCloseableRule = new UnclosedCloseableRule();
        ProhibitedDataTransferRule prohibitedDataTransferRule = new ProhibitedDataTransferRule();
        TrackingHardwareIDRule trackingHardwareIDRule = new TrackingHardwareIDRule();
        SetConfigChangesRule setConfigChangesRule = new SetConfigChangesRule();
        NoOpRule noOpRule = new NoOpRule();
        HostNameVerifierRule hostNameVerifierRule = new HostNameVerifierRule();
        CVOnlyRule cvOnlyRule = new CVOnlyRule();
//-----place1 instantiate the rule
        String[] smellsType = {"DTWC", "DR", "DW", "IDFP", "IDS", "ISQLQ", "IGS", "LIC", "LT", "MIM", "NLMR", "PD", "RAM", "SL", "UC","BDT","PDT", "NO", "THID", "SCC", "HNV","CVO"};
//-----place2 include in the string
        FILE_HEADER[0] = "Class";

        int headerCounter = 1;

        for (int i = 0; i < smellsNeeded.length(); i++) {
            if (smellsNeeded.charAt(i) == '1') {
                FILE_HEADER[headerCounter] = smellsType[i];
                headerCounter++;
            }
        }

PrintWriter out = new PrintWriter(new FileWriter(args[0]+ "\\refactor.txt")); 
        
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);
        FileWriter fileWriter = new FileWriter(fileName);
        try (CSVPrinter csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat)) {
            csvFilePrinter.printRecord((Object[]) FILE_HEADER);

            String deb="0";
            String feb="0";
            if (smellsNeeded.charAt(1) == '1'){
                for (File project : experimentDirectory.listFiles()) {
                    if(RunAndroidSmellDetection.getAndroidManifest(project)!=null){
                        if (debbugableReleaseRule.isDebuggableRelease(RunAndroidSmellDetection.getAndroidManifest(project))) {
                            deb="1";
                        }
                    }
                }
            }

            if (smellsNeeded.charAt(19) == '1'){
                for (File project : experimentDirectory.listFiles()) {
                    if(RunAndroidSmellDetection.getAndroidManifest(project)!=null){
                        if (setConfigChangesRule.isSetConfigChanges(RunAndroidSmellDetection.getAndroidManifest(project))) {
                            feb="1";
                        }
                    }
                }
            }

            for (File project : experimentDirectory.listFiles()) {

                if (!project.isHidden()) {

                    // Method to convert a directory into a set of java packages.
                    ArrayList<PackageBean> packages = FolderToJavaProjectConverter.convert(project.getAbsolutePath());

                    for (PackageBean packageBean : packages) {

                        for (ClassBean classBean : packageBean.getClasses()) {

                            List record = new ArrayList();

                            System.out.println("-- Analyzing class: " + classBean.getBelongingPackage() + "." + classBean.getName());

                            record.add(classBean.getBelongingPackage() + "." + classBean.getName());

                            if (smellsNeeded.charAt(0) == '1') {
                                if (dataTransmissionWithoutCompressionRule.isDataTransmissionWithoutCompression(classBean)) {
                                    record.add("1");
                                    out.println("\nProblem  -->> Data transmission without compression.This leads to higher battery consumption");
                                    out.println("\nFound at -->> " + classBean.getBelongingPackage() + "." + classBean.getName());
                                    out.println("\nSolution -->> Use any data compression library like GZIP");
                                } else {
                                    record.add("0");
                                }
                            }

                            if (smellsNeeded.charAt(1) == '1') {
                                record.add(deb);
                                if (deb=="1") {
                                    out.println("\nProblem  -->> Security issue in the app by providing debugging access to authorized individuals");
                                    out.println("Found at -->> AndroidManifest.xml file");
                                    out.println("Solution -->> Change debuggable attribute to false in the Androidmanifest.xml file");
                                }
                            }

                            if (smellsNeeded.charAt(2) == '1') {
                                if (durableWakeLockRule.isDurableWakeLock(classBean)) {
                                    record.add("1");
                                    out.println("\nProblem  -->> Wakelock not released. This leads to wastage of battery by keeping device in wakelock state");
                                    out.println("Found at -->> " + classBean.getBelongingPackage() + "." + classBean.getName());
                                    out.println("Solution -->> Insert a wakelock.release() statement or use the timed wakelock acquire()");
                                } else {
                                    record.add("0");
                                }
                            }

                            if (smellsNeeded.charAt(3) == '1') {
                                if (inefficientDataFormatAndParserRule.isInefficientDataFormatAndParser(classBean)) {
                                    record.add("1");
                                    out.println("\nProblem  -->>  Using Inefficient Parsers.Tree parsers are slower and consume more memory.");
                                    out.println("Found at -->> " + classBean.getBelongingPackage() + "." + classBean.getName());
                                    out.println("Solution -->> Implement stream parsers and replace the tree parsers for better perfomance");
                                } else {
                                    record.add("0");
                                }
                            }

                            if (smellsNeeded.charAt(4) == '1') {
                                if (inefficientDataStructureRule.isInefficientDataStructure(classBean)) {
                                    record.add("1");
                                    out.println("\nProblem  -->>  Using inefficient data structures in this class");
                                    out.println("Found at -->> " + classBean.getBelongingPackage() + "." + classBean.getName());
                                    out.println("Solution -->> Replace instances of HashMap with SparseArray<BitMap> for efficency");
                                } else {
                                    record.add("0");
                                }
                            }

                            if (smellsNeeded.charAt(5) == '1') {
                                if (inefficientSQLQueryRule.isInefficientSQLQuery(classBean)) {
                                    record.add("1");
                                    out.println("\nProblem  -->> SQL queries are used which cause overhaed in Androiid");
                                    out.println("Found at -->> " + classBean.getBelongingPackage() + "." + classBean.getName());
                                    out.println("Solution -->> Send direct queries to web server and recieve compressed response");
                                } else {
                                    record.add("0");
                                }
                            }

                            if (smellsNeeded.charAt(6) == '1') {
                                if (internaleGetterSetterRule.isInternalGetterSetter(classBean)) {
                                    record.add("1");
                                    out.println("\nProblem  -->>  Using virtual methods is expensive in Android");
                                    out.println("Found at -->> " + classBean.getBelongingPackage() + "." + classBean.getName());
                                    out.println("Solution -->> Access internal fields directly");
                                } else {
                                    record.add("0");
                                }
                            }

                            if (smellsNeeded.charAt(7) == '1') {
                                if (leakingInnerClassRule.isLeakingInnerClass(classBean)) {
                                    record.add("1");
                                    out.println("\nProblem  -->>  Non-static inner class holding references to outer class");
                                    out.println("Found at -->> " + classBean.getBelongingPackage() + "." + classBean.getName());
                                    out.println("Solution -->> Make the inner class static");
                                } else {
                                    record.add("0");
                                }
                            }

                            if (smellsNeeded.charAt(8) == '1') {
                                if (leakingThreadRule.isLeakingThread(classBean)) {
                                    record.add("1");
                                    out.println("\nProblem  -->>  Thread not stopped. Leads to memory leak.");
                                    out.println("Found at -->> " + classBean.getBelongingPackage() + "." + classBean.getName());
                                    out.println("Solution -->> Stop the thread using stop()");
                                } else {
                                    record.add("0");
                                }
                            }

                            if (smellsNeeded.charAt(9) == '1') {
                                if (memberIgnoringMethodRule.isMemberIgnoringMethod(classBean)) {
                                    record.add("1");
                                    out.println("\nProblem  -->> Non static method does not refer to any internal field");
                                    out.println("Found at -->> " + classBean.getBelongingPackage() + "." + classBean.getName());
                                    out.println("Solution -->> Make the class static");
                                } else {
                                    record.add("0");
                                }
                            }

                            if (smellsNeeded.charAt(10) == '1') {
                                if (noLowMemoryResolverRule.isNoLowMemoryResolver(classBean)) {
                                    record.add("1");
                                    out.println("\nProblem  -->> Method not found to clean caches or unnecessary resources cause abnormal programm termination,Memory Efficiency and Stability.");
                                    out.println("Found at -->> " + classBean.getBelongingPackage() + "." + classBean.getName());
                                    out.println("Solution -->> Use Activity.onLowMemory()");
                                } else {
                                    record.add("0");
                                }
                            }

                            if (smellsNeeded.charAt(11) == '1') {
                                if (publicDataRule.isPublicData(classBean)) {
                                    record.add("1");
                                    out.println("\nProblem  -->> Private data is publicly accessible cause scurity issue");
                                    out.println("Found at -->> " + classBean.getBelongingPackage() + "." + classBean.getName());
                                    out.println("Solution -->> Use (Context.MODE_PRIVATE) ");
                                } else {
                                    record.add("0");
                                }
                            }

                            if (smellsNeeded.charAt(12) == '1') {
                                if (rigidAlarmManagerRule.isRigidAlarmManager(classBean)) {
                                    record.add("1");
                                    out.println("\nProblem  -->> Every AlarmManager-triggered operation wakes up the phone cause Efficiency, Energy Efficiency issue.");
                                    out.println("Found at -->> " + classBean.getBelongingPackage() + "." + classBean.getName());
                                    out.println("Solution -->> use AlarmManager.setInexactRepeating(int type, long triggerAtMillis, long intervalMillis, PendingIntent operation)");
                                } else {
                                    record.add("0");
                                }
                            }

                            if (smellsNeeded.charAt(13) == '1') {
                                if (slowLoopRule.isSlowLoop(classBean)) {
                                    record.add("1");
                                    out.println("\nProblem  -->> A slow version of a for-loop is used cause Efficiency issue.");
                                    out.println("Found at -->> " + classBean.getBelongingPackage() + "." + classBean.getName());
                                    out.println("Solution -->> use  for(String s : strings) { /* do something using s */ } ");
                                    
                                } else {
                                    record.add("0");
                                }
                            }

                            if (smellsNeeded.charAt(14) == '1') {
                                if (unclosedCloseableRule.isUnclosedCloseable(classBean)) {
                                    record.add("1");
                                    out.println("\nProblem  -->> An object implementing the java.io.Closeable is not closed cause Memory Efficiency issue.");
                                    out.println("Found at -->> " + classBean.getBelongingPackage() + "." + classBean.getName());
                                    out.println("Solution -->> The object should be closed properly with  object_name.close(); ");
                                } else {
                                    record.add("0");
                                }
                            }
                            
                            if (smellsNeeded.charAt(15) == '1') {
                                if (bulkDataTransferRule.isBulkDataTransfer(classBean)) {
                                    record.add("1");
                                    out.println("\nProblem  -->> No network check was initiated");
                                    out.println("Found at -->> " + classBean.getBelongingPackage() + "." + classBean.getName());
                                    out.println("Solution -->> Check network status before transfering data over it.");
                                } else {
                                    record.add("0");
                                }
                            }
                            
                            if (smellsNeeded.charAt(16) == '1') {
                                if (prohibitedDataTransferRule.isProhibitedDataTransfer(classBean)) {
                                    record.add("1");
                                    out.println("\nProblem  -->> Not checked if background data was activated");
                                    out.println("Found at -->> " + classBean.getBelongingPackage() + "." + classBean.getName());
                                    out.println("Solution -->> Check network status before transfering data over it.");
                                } else {
                                    record.add("0");
                                }
                            }
                            
                            if (smellsNeeded.charAt(17) == '1') {
                                if (noOpRule.isNoOP(classBean)) {
                                    record.add("1");
                                    out.println("\nProblem  -->> SSL certificates are not checked. Vulnerable to MITM attacks");
                                    out.println("Found at -->> " + classBean.getBelongingPackage() + "." + classBean.getName());
                                    out.println("Solution -->> Verify the certificates");
                                } else {
                                    record.add("0");
                                }
                            }
                            if (smellsNeeded.charAt(18) == '1') {
                                if (trackingHardwareIDRule.isTrackingHardwareID(classBean)) {
                                    record.add("1");
                                    out.println("\nProblem  -->> The permission READ_PHONE_STATE is used which can be misused. Also it is neither stable nor reliable.");
                                    out.println("Found at -->> " + classBean.getBelongingPackage() + "." + classBean.getName());
                                    out.println("Solution -->> Use the Settings.Secure.ANDROID_ID string");
                                } else {
                                    record.add("0");
                                }
                            }
                            
                            if (smellsNeeded.charAt(19) == '1') {
                                record.add(feb);
                                if (feb=="1") {
                                    out.println("\nProblem  -->> Handling configurations manually causes memory bugs");
                                    out.println("Found at -->> This is an activity level smell");
                                    out.println("Solution -->> Use retained fragment");
                                }
                            }
                            
                            if (smellsNeeded.charAt(20) == '1') {
                                if (hostNameVerifierRule.isHostNameVerifier(classBean)) {
                                    record.add("1");
                                    out.println("\nProblem  -->> All Host Names are allowed. Vulnerable to MITM attacks");
                                    out.println("Found at -->> " + classBean.getBelongingPackage() + "." + classBean.getName());
                                    out.println("Solution -->> Verify Host Names");
                                } else {
                                    record.add("0");
                                }
                            }
                            
                            if (smellsNeeded.charAt(21) == '1') {
                                if (cvOnlyRule.isCVOnly(classBean)) {
                                    record.add("1");
                                    out.println("\nProblem  -->> Only validity of the certificate is verified.");
                                    out.println("Found at -->> " + classBean.getBelongingPackage() + "." + classBean.getName());
                                    out.println("Solution -->> Check other validations");
                                } else {
                                    record.add("0");
                                }
                            }
           //-----place3 add the conditions and refactoring messages
                            csvFilePrinter.printRecord(record);
                        }
                    }
                }
            }
        }
        System.out.println("CSV file was created successfully!");
        System.out.println("Finished at " + ft.format(new Date()));
        out.close();
    }

    public static File getAndroidManifest(File dir) {
        File androidManifest = null;

            if (dir.getName().equals("AndroidManifest.xml")) {
                androidManifest = dir;
            }
  
        return androidManifest;
    }

}
