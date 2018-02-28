package it.unisa.aDoctor.smellDetectionRules;

import java.io.IOException;
import it.unisa.aDoctor.beans.ClassBean;


public class HostNameVerifierRule {
	public boolean isHostNameVerifier(ClassBean pClassBean) throws IOException {
		
        if (pClassBean.getTextContent().contains("AllowAllHostNameVrifier()")) {
            
                return true;
            
        }

        return false;
    }
	
}
