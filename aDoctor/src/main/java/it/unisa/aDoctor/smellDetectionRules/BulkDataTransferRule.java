package it.unisa.aDoctor.smellDetectionRules;

import java.io.IOException;

import it.unisa.aDoctor.beans.ClassBean;

public class BulkDataTransferRule {

    public boolean isBulkDataTransfer(ClassBean pClassBean) throws IOException {

        if (pClassBean.getTextContent().contains("HttpPost ")||pClassBean.getTextContent().contains("NfcAdapter ")||
            pClassBean.getTextContent().contains("NetworkFragment ")||pClassBean.getTextContent().contains("HttpURLConnection")) {
            if (!pClassBean.getTextContent().contains("NetworkInfo")) {
                return true;
            }
        }

        return false;
    }
}
