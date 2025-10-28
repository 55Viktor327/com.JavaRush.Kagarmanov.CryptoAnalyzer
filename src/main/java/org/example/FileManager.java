package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileManager {
    private String filePath;
    private String currentFilePath;
    private String basePath;

    public void setBasePath(String path) {
        this.basePath = path;
    }

    public String constructFullPath(String fileName) {
        if (this.basePath == null || this.basePath.isEmpty()) {
            throw new IllegalStateException("Базовый путь не установлен.");
        }

        Path fullPath = Paths.get(basePath).resolve(fileName);
        return fullPath.normalize().toString();
    }

       public void setFilePath(String filePath) throws IOException {
        this.filePath = filePath.trim();
        checkAndCreateIfNotExists(this.filePath);
    }

    private void checkAndCreateIfNotExists(String filePath) throws IOException {
        Path path = Paths.get(filePath);
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

    public String readData() throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public void writeData(String data) throws IOException {
        if(currentFilePath == null || currentFilePath.isBlank()) {
            throw new IllegalStateException("Имя файла не установлено");
        }
        Files.write(Paths.get(currentFilePath), data.getBytes());
    }

    public String getFilePath() {
        return filePath;
    }

    public static String cleanUpPath(String path) {
        return path.trim().replaceAll("^\"|\"$", "");
    }
}