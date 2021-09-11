package com.company;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Key {

    String keyhex = "";
    String StrHMAC = "";

    public void GenerateKeyAndHMAC (String compRun) throws NoSuchAlgorithmException, InvalidKeyException {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[16];
        random.nextBytes(bytes);
        for (byte b : bytes) {keyhex += String.format("%02X", b);}
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        sha256_HMAC.init(new SecretKeySpec(bytes, "HmacSHA256"));
        byte[] HMAC = sha256_HMAC.doFinal(compRun.getBytes());
        for (byte b : HMAC) {StrHMAC += String.format("%02X", b);}
    }

    public String GetKey(){
        return keyhex;
    }

    public String GetHMAC (){
        return StrHMAC;
    }
}
