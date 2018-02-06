package it.unisa.aDoctor.smellDetectionRules;

import java.io.IOException;

import it.unisa.aDoctor.beans.ClassBean;

public class BulkDataTransferRule {

    public boolean isBulkDataTransfer(ClassBean pClassBean) throws IOException {

        if (pClassBean.getTextContent().contains("HttpPost ")||pClassBean.getTextContent().contains("NfcAdapter ")||
            pClassBean.getTextContent().contains("NetworkFragment ")||pClassBean.getTextContent().contains("HttpURLConnection")) {
            if (!(pClassBean.getTextContent().contains("NetworkInfo")&&pClassBean.getTextContent().contains("ConnectivityManager"))) {
                return true;
            }
            if (!(pClassBean.getTextContent().contains("ConnectivityManager.TYPE_MOBILE")
                  &&pClassBean.getTextContent().contains("ConnectivityManager.TYPE_WIFI")
                  &&pClassBean.getTextContent().contains("TelephonyManager.NETWORK_TYPE_UMTS"))) {
                return true;
            }
        }

        return false;
    }
}
