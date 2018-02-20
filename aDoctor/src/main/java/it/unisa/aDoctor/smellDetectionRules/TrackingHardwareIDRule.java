package it.unisa.aDoctor.smellDetectionRules;

import java.io.IOException;
import it.unisa.aDoctor.beans.ClassBean;


public class TrackingHardwareIDRule {
	public boolean isBulkDataTransfer(ClassBean pClassBean) throws IOException {

        if (pClassBean.getTextContent().contains("TelephonyManager")&&pClassBean.getTextContent().contains("getDeviceId()")) {
            
                return true;
            
        }

        return false;
    }
	
}
