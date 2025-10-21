package org.example;

import java.util.ArrayList;
import java.util.List;

public class BruteForce {

    public static  List<String> bruteForceDecrypt(String encryptedText) {
        List<String> possibleDecryptions = new ArrayList<>();
        for (int shift = 0; shift < CeasarsCipher.ALPHABET.length; shift++) {
            String decryptedText = CeasarsCipher.decrypt(encryptedText, shift);
            possibleDecryptions.add(decryptedText);
        }
        return possibleDecryptions;
    }
}
