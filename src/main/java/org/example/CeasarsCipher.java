package org.example;

public class CeasarsCipher {
    static final char[] ALPHABET = "ёйцукенгшщзхъфывапролджэячсмитьбю .,”’:-!?".toCharArray();
    public String encryptedText;
    public String decryptedText;

    public void encrypt(String text, int key) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            int index = findCharacterIndex(ch);
            if (index >= 0) { // Буква найдена в нашем алфавите
                int shiftedIndex = (index + key) % ALPHABET.length;
                result.append(ALPHABET[shiftedIndex]);
            } else {
                result.append(ch); // Оставляем неприведённые символы как есть
            }
        }
        encryptedText = result.toString();
    }
    public String decrypt(String text, int key) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            int index = findCharacterIndex(ch);
            if (index >= 0) { // Буква найдена в нашем алфавите
                int shiftedIndex = (index - key + ALPHABET.length) % ALPHABET.length;
                result.append(ALPHABET[shiftedIndex]);
            } else {
                result.append(ch); // Оставляем неприведённые символы как есть
            }
        }
        return decryptedText = result.toString();
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
