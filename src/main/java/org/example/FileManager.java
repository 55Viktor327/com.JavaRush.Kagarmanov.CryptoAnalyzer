package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileManager {

    public String readFile(String filePath) throws IOException {
        // Логика чтения файла
        Path path = Paths.get(filePath.replace("\"", "").trim());
        if(!Files.exists(path)){
            throw new IOException("File does not exist");
        }
        return new String(Files.readAllBytes(path));
    }

    public void writeFile(String filePath, String content) throws IOException {
        // Логика записи файла
        Path path = Paths.get(filePath.replace("\"", "").trim());
        Files.createDirectories(path.getParent());
        Files.writeString(path, content);
    }

    public static void fileSaver(String filePath) throws IOException {
        Path path = Paths.get(filePath.replace("\"", "").trim());
        if (!Files.exists(path)) {
            System.out.print("Указанный файл не существует. Создать указанный файл и каталог? (Да/Нет): ");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine().trim().toLowerCase();

            if ("да".equals(choice)) {
                Files.createDirectories(path.getParent());
                Files.createFile(path);
                System.out.println("Новый файл успешно создан по адресу: " + filePath);
            } else {
                throw new IOException("Файл не найден и не создан по запросу пользователя.");
            }
        }
    }
}