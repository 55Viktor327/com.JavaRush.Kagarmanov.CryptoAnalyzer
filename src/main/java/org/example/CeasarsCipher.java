package org.example;

public class CeasarsCipher {
    private static final char[] ALPHABET = "ёйцукенгшщзхъфывапролджэячсмитьбю .,”’:-!?".toCharArray();

    public static String encrypt(String text, int shift) {
        return transformedText(text, shift);
    }
    public static String decrypt(String encryptedText, int shift) {

        return transformedText(encryptedText, -shift);
    }

    private static String transformedText(String text, int shift) {

        StringBuilder result = new StringBuilder();

        for(char character : text.toCharArray()) {
            int originalPosition = findCharacterIndex(character);
            if (originalPosition != -1) {
                int newPosition = originalPosition + shift;
                if (newPosition >= ALPHABET.length) {
                    newPosition = (originalPosition + shift) % ALPHABET.length;
                    char newChar = ALPHABET[newPosition];
                    result.append(newChar);
                }
            }else{
                result.append(character);
            }
        }
        return result.toString();
    }

    private static int findCharacterIndex(char letter) {
        for (int i = 0; i < ALPHABET.length; i++) {
            if (letter == ALPHABET[i]) {
                return i;
            }
        }
        return -1;
    }
}
