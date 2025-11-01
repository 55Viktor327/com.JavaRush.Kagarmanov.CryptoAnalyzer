package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileManager {

    public static String readFile(String filePath) throws IOException {
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

    public static String fileSaver(String filePath) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите путь к файлу в котором хотите сохранить файл: ");
        filePath = scan.nextLine();
        Path path = Paths.get(filePath.replace("\"", "").trim());
        Path parentDir = Paths.get(path.getParent().toUri());
        Files.createDirectories(parentDir);
        System.out.println("Введите имя файла: ");
        String fileName = scan.nextLine();
        Path outputFile = parentDir.resolve(fileName);
        return outputFile.toString();
    }
}