package it.unisa.aDoctor.ui;

import it.unisa.aDoctor.process.RunAndroidSmellDetection;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URISyntaxException;
import javax.swing.JFileChooser;
import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.CoreException;

/**
 *
 * @author Dario Di Nucci
 */
public class MainUI extends javax.swing.JFrame {

    public MainUI() {
        initComponents();
        PrintStream out = new PrintStream(new TextAreaOutputStream(statusLabel));
        System.setOut(out);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        inputFolderField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        outputFileField = new javax.swing.JTextField();
        startProcessButton = new javax.swing.JButton();
        inputFolderButton = new javax.swing.JButton();
        outputFolderButton = new javax.swing.JButton();
        viewResults = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        statusLabel = new javax.swing.JTextArea();
        DTWCCheck = new javax.swing.JCheckBox();
        DRCheck = new javax.swing.JCheckBox();
        DWCheck = new javax.swing.JCheckBox();
        IDFPCheck = new javax.swing.JCheckBox();
        IDSCheck = new javax.swing.JCheckBox();
        ISQLQCheck = new javax.swing.JCheckBox();
        IGSCheck = new javax.swing.JCheckBox();
        LICCheck = new javax.swing.JCheckBox();
        LTCheck = new javax.swing.JCheckBox();
        MIMCheck = new javax.swing.JCheckBox();
        NLMRCheck = new javax.swing.JCheckBox();
        PDCheck = new javax.swing.JCheckBox();
        RAMCheck = new javax.swing.JCheckBox();
        SLCheck = new javax.swing.JCheckBox();
        UCCheck = new javax.swing.JCheckBox();
        BDTCheck = new javax.swing.JCheckBox();
        PDTCheck = new javax.swing.JCheckBox();
        OPCheck  = new javax.swing.JCheckBox();
        THIDCheck = new javax.swing.JCheckBox();
        SCCCheck = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("aDoctor");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/aDoctor.png")).getImage());
        setResizable(false);

        jLabel1.setText("Input Folder");

        inputFolderField.setEditable(false);
        inputFolderField.setToolTipText("Path of the Android SDK Platform Tools folder.");

        jLabel2.setText("Output File");

        outputFileField.setEditable(false);
        outputFileField.setToolTipText("Device power profile (see https://source.android.com/devices/tech/power/).");

        startProcessButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/play-button.png"))); // NOI18N
        startProcessButton.setText("Start Process");
        startProcessButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startProcessButtonActionPerformed(evt);
            }
        });

        inputFolderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder.png"))); // NOI18N
        inputFolderButton.setText("Open");
        inputFolderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputFolderButtonActionPerformed(evt);
            }
        });

        outputFolderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder.png"))); // NOI18N
        outputFolderButton.setText("Open");
        outputFolderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputFolderButtonActionPerformed(evt);
            }
        });

        viewResults.setIcon(new javax.swing.ImageIcon(getClass().getResource("/results.png"))); // NOI18N
        viewResults.setText("Results");
        viewResults.setEnabled(false);
        viewResults.setFocusPainted(false);
        viewResults.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewResultsActionPerformed(evt);
            }
        });

        jScrollPane1.setToolTipText("");
        jScrollPane1.setEnabled(false);

        statusLabel.setEditable(false);
        statusLabel.setColumns(20);
        statusLabel.setDisabledTextColor(new java.awt.Color(1, 1, 1));
        statusLabel.setEnabled(false);
        jScrollPane1.setViewportView(statusLabel);

        DTWCCheck.setSelected(true);
        DTWCCheck.setText("DTWC");
        DTWCCheck.setToolTipText("Data Transmission Without Compression");

        DRCheck.setSelected(true);
        DRCheck.setText("DR");
        DRCheck.setToolTipText("Debuggable Release");

        DWCheck.setSelected(true);
        DWCheck.setText("DW");
        DWCheck.setToolTipText("Durable Wakelock");

        IDFPCheck.setSelected(true);
        IDFPCheck.setText("IDFP");
        IDFPCheck.setToolTipText("Inefficient Data Format and Parser");

        IDSCheck.setSelected(true);
        IDSCheck.setText("IDS");
        IDSCheck.setToolTipText("Inefficient Data Structure");

        ISQLQCheck.setSelected(true);
        ISQLQCheck.setText("ISQLQ");
        ISQLQCheck.setToolTipText("Inefficient SQL Query");

        IGSCheck.setSelected(true);
        IGSCheck.setText("IGS");
        IGSCheck.setToolTipText("Internal Getter and Setter");

        LICCheck.setSelected(true);
        LICCheck.setText("LIC");
        LICCheck.setToolTipText("Leaking Inner Class");

        LTCheck.setSelected(true);
        LTCheck.setText("LT");
        LTCheck.setToolTipText("Leaking Thread");

        MIMCheck.setSelected(true);
        MIMCheck.setText("MIM");
        MIMCheck.setToolTipText("Member Ignoring Method");

        NLMRCheck.setSelected(true);
        NLMRCheck.setText("NLMR");
        NLMRCheck.setToolTipText("No Low Memory Resolver");

        PDCheck.setSelected(true);
        PDCheck.setText("PD");
        PDCheck.setToolTipText("Public Data");

        RAMCheck.setSelected(true);
        RAMCheck.setText("RAM");
        RAMCheck.setToolTipText("Rigid Alarm Manager");

        SLCheck.setSelected(true);
        SLCheck.setText("SL");
        SLCheck.setToolTipText("Slow Loop");

        UCCheck.setSelected(true);
        UCCheck.setText("UC");
        UCCheck.setToolTipText("Unclosed Closable");
        
        BDTCheck.setSelected(true);
        BDTCheck.setText("BDT");
        BDTCheck.setToolTipText("Bulk Data Transfer");
        
        PDTCheck.setSelected(true);
        PDTCheck.setText("PDT");
        PDTCheck.setToolTipText("Prohibited Data Transfer");
        
        OPCheck.setSelected(true);
        OPCheck.setText("OP");
        OPCheck.setToolTipText("Overdrawn Pixel");
        
        THIDCheck.setSelected(true);
        THIDCheck.setText("THID");
        THIDCheck.setToolTipText("Tracking Hardware ID");
        
        SCCCheck.setSelected(true);
        SCCCheck.setText("SCC");
        SCCCheck.setToolTipText("Set Config Changes");
//------place 2
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(outputFileField)
                            .addComponent(inputFolderField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputFolderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(outputFolderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(DTWCCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(DRCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(DWCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ISQLQCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(IGSCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(LICCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IDFPCheck, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LTCheck, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IDSCheck, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MIMCheck, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(NLMRCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(PDCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(RAMCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(SLCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(UCCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(BDTCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(PDTCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(OPCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27)
                            .addComponent(THIDCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(SCCCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
//----place3
                     
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(startProcessButton, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewResults, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(inputFolderField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputFolderButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(outputFileField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outputFolderButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IDSCheck)
                    .addComponent(IDFPCheck)
                    .addComponent(DWCheck)
                    .addComponent(DRCheck)
                    .addComponent(DTWCCheck))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LTCheck)
                        .addComponent(MIMCheck))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ISQLQCheck)
                        .addComponent(IGSCheck)
                        .addComponent(LICCheck)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SLCheck)
                    .addComponent(UCCheck)
                    .addComponent(RAMCheck)
                    .addComponent(PDCheck)
                    .addComponent(NLMRCheck))

//-----place4
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(THIDCheck)
                        .addComponent(SCCCheck)
                        .addComponent(OPCheck)
                        .addComponent(PDTCheck)
                        .addComponent(BDTCheck))
                    .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startProcessButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewResults, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        startProcessButton.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startProcessButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startProcessButtonActionPerformed
        statusLabel.setText(null);
        viewResults.setEnabled(false);
        String inputPath = this.inputFolderField.getText();
        String outputPath = this.outputFileField.getText();
//-----place5 change array size
        Integer[] smellTypesNeeded = new Integer[20];
        int numOfSmells = 0;
        if (DTWCCheck.isSelected()) {
            smellTypesNeeded[0] = 1;
            numOfSmells++;
        } else {
            smellTypesNeeded[0] = 0;
        }
        if (DRCheck.isSelected()) {
            smellTypesNeeded[1] = 1;
            numOfSmells++;
        } else {
            smellTypesNeeded[1] = 0;
        }
        if (DWCheck.isSelected()) {
            smellTypesNeeded[2] = 1;
            numOfSmells++;
        } else {
            smellTypesNeeded[2] = 0;
        }
        if (IDFPCheck.isSelected()) {
            smellTypesNeeded[3] = 1;
            numOfSmells++;
        } else {
            smellTypesNeeded[3] = 0;
        }
        if (IDSCheck.isSelected()) {
            smellTypesNeeded[4] = 1;
            numOfSmells++;
        } else {
            smellTypesNeeded[4] = 0;
        }
        if (ISQLQCheck.isSelected()) {
            smellTypesNeeded[5] = 1;
            numOfSmells++;
        } else {
            smellTypesNeeded[5] = 0;
        }
        if (IGSCheck.isSelected()) {
            smellTypesNeeded[6] = 1;
            numOfSmells++;
        } else {
            smellTypesNeeded[6] = 0;
        }
        if (LICCheck.isSelected()) {
            smellTypesNeeded[7] = 1;
            numOfSmells++;
        } else {
            smellTypesNeeded[7] = 0;
        }
        if (LTCheck.isSelected()) {
            smellTypesNeeded[8] = 1;
            numOfSmells++;
        } else {
            smellTypesNeeded[8] = 0;
        }
        if (MIMCheck.isSelected()) {
            smellTypesNeeded[9] = 1;
            numOfSmells++;
        } else {
            smellTypesNeeded[9] = 0;
        }
        if (NLMRCheck.isSelected()) {
            smellTypesNeeded[10] = 1;
            numOfSmells++;
        } else {
            smellTypesNeeded[10] = 0;
        }
        if (PDCheck.isSelected()) {
            smellTypesNeeded[11] = 1;
            numOfSmells++;
        } else {
            smellTypesNeeded[11] = 0;
        }
        if (RAMCheck.isSelected()) {
            smellTypesNeeded[12] = 1;
            numOfSmells++;
        } else {
            smellTypesNeeded[12] = 0;
        }
        if (SLCheck.isSelected()) {
            smellTypesNeeded[13] = 1;
            numOfSmells++;
        } else {
            smellTypesNeeded[13] = 0;
        }
        if (UCCheck.isSelected()) {
            smellTypesNeeded[14] = 1;
            numOfSmells++;
        } else {
            smellTypesNeeded[14] = 0;
        }
//-----place6 
        if (BDTCheck.isSelected()) {
            smellTypesNeeded[15] = 1;
            numOfSmells++;
        } else {
            smellTypesNeeded[15] = 0;
        }
        if (PDTCheck.isSelected()) {
            smellTypesNeeded[16] = 1;
            numOfSmells++;
        } else {
            smellTypesNeeded[16] = 0;
        }
        if (OPCheck.isSelected()) {
            smellTypesNeeded[17] = 1;
            numOfSmells++;
        } else {
            smellTypesNeeded[17] = 0;
        }
        if (THIDCheck.isSelected()) {
            smellTypesNeeded[18] = 1;
            numOfSmells++;
        } else {
            smellTypesNeeded[18] = 0;
        }
        if (SCCCheck.isSelected()) {
            smellTypesNeeded[19] = 1;
            numOfSmells++;
        } else {
            smellTypesNeeded[19] = 0;
        }
        
        String smellTypesString = StringUtils.join(smellTypesNeeded);
        boolean valid = true;
        if (inputPath.isEmpty()) {
            System.out.println("Input folder not selected.");
            valid = false;
        }
        if (outputPath.isEmpty()) {
            System.out.println("Output file not selected.");
            valid = false;
        }
        if (numOfSmells == 0) {
            System.out.println("None of the smells has been selected.");
            valid = false;
        }
        if (valid == false) {
            return;
        }

        String[] args = {inputPath, outputPath, smellTypesString};

        try {
            RunAndroidSmellDetection.main(args);
            viewResults.setEnabled(true);
        } catch (IOException | CoreException ex) {
            System.out.println("Errore!");
        }

    }//GEN-LAST:event_startProcessButtonActionPerformed

    private void inputFolderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputFolderButtonActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        int res = chooser.showOpenDialog(null);
        if (res == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            String filename = f.getAbsolutePath();
            inputFolderField.setText(filename);
        }
    }//GEN-LAST:event_inputFolderButtonActionPerformed

    private void outputFolderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputFolderButtonActionPerformed
        JFileChooser chooser = new JFileChooser();
        int res = chooser.showOpenDialog(null);
        if (res == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            String filename = f.getAbsolutePath();
            outputFileField.setText(filename);
        }
    }//GEN-LAST:event_outputFolderButtonActionPerformed

    private void viewResultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewResultsActionPerformed
        this.setVisible(false);
        new ResultsUI(this.outputFileField.getText()).setVisible(true);
    }//GEN-LAST:event_viewResultsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            OUTER:
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if (info.getName() != null) {
                    switch (info.getName()) {
                        case "GTK+":
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break OUTER;
                        case "Windows":
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break OUTER;
                        case "Nimbus":
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        default:
                            break;
                    }
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(
                () -> {
                    new MainUI().setVisible(true);
                }
        );
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox DRCheck;
    private javax.swing.JCheckBox DTWCCheck;
    private javax.swing.JCheckBox DWCheck;
    private javax.swing.JCheckBox IDFPCheck;
    private javax.swing.JCheckBox IDSCheck;
    private javax.swing.JCheckBox IGSCheck;
    private javax.swing.JCheckBox ISQLQCheck;
    private javax.swing.JCheckBox LICCheck;
    private javax.swing.JCheckBox LTCheck;
    private javax.swing.JCheckBox MIMCheck;
    private javax.swing.JCheckBox NLMRCheck;
    private javax.swing.JCheckBox PDCheck;
    private javax.swing.JCheckBox RAMCheck;
    private javax.swing.JCheckBox SLCheck;
    private javax.swing.JCheckBox UCCheck;
//----place7
    private javax.swing.JCheckBox BDTCheck;
    private javax.swing.JCheckBox PDTCheck;
    private javax.swing.JCheckBox OPCheck;
    private javax.swing.JCheckBox THIDCheck;
    private javax.swing.JCheckBox SCCCheck;
    private javax.swing.JButton inputFolderButton;
    private javax.swing.JTextField inputFolderField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField outputFileField;
    private javax.swing.JButton outputFolderButton;
    private javax.swing.JButton startProcessButton;
    private javax.swing.JTextArea statusLabel;
    private javax.swing.JButton viewResults;
    // End of variables declaration//GEN-END:variables
}
