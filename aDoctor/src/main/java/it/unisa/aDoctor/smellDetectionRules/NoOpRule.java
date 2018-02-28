package it.unisa.aDoctor.smellDetectionRules;

import java.io.IOException;
import it.unisa.aDoctor.beans.ClassBean;


public class NoOpRule {
	public boolean isNoOP(ClassBean pClassBean) throws IOException {

		if (pClassBean.getTextContent().contains("implements X509TrustManager")) {
            
           if(!(pClassBean.getTextContent().contains("checkValidity()")
        		 ||pClassBean.getTextContent().contains("getNotAfter()")
        		 ||pClassBean.getTextContent().contains("getNotBefore()")
        		 ||pClassBean.getTextContent().contains("getSigAlgName()")
        		 ||pClassBean.getTextContent().contains("getSigAlgoID()")
        		 ||pClassBean.getTextContent().contains("getTBSCertificate()"))) {
			
			return true;
           }
    }

        return false;
    }
	
}
