package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BruteForce {
    public void bruteForceDecrypt(String filePath, String originalText) throws IOException {
        CeasarsCipher cipher = new CeasarsCipher();
        FileManager fileManager = new FileManager();

        // Определяем родительский каталог исходного файла
        Path parentDir = Paths.get(fileManager.readFile(filePath)).getParent();

        // Создаем директорию для хранения расшифрованных файлов
        Path decryptDir = parentDir.resolve("decryptBruteForce");
        Files.createDirectories(decryptDir); // Создаем директорию, если её нет

        for (int key = 1; key <= CeasarsCipher.ALPHABET.length; key++) {
            String decryptedText = cipher.decrypt(originalText, key);

            // Имя файла: decrypted_{ключ}.txt
            String filename = "decrypted_" + key + ".txt";
            Path outputFile = decryptDir.resolve(filename);

            // Записываем расшифрованный текст в файл
            Files.write(outputFile, decryptedText.getBytes());
        }
    }
}
