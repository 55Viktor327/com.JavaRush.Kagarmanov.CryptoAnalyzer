package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileManager {
    public String readFile(String filePath) throws IOException {
        // Логика чтения файла
        Path path = Paths.get(filePath);
        if(!Files.exists(path)){
            throw new IOException("File does not exist");
        }
        return new String(Files.readAllBytes(path));
    }

    public void writeFile(String filePath, String content) throws IOException {
        // Логика записи файла
        Path path = Paths.get(filePath);
        Files.createDirectories(path.getParent());
        Files.writeString(path, content);
    }

    public static void fileSaver(String filePath) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Получаем объект Path и извлекаем родительскую директорию
            File file = Paths.get(filePath).toFile();
            String directoryPath = file.getParent();

            if (directoryPath != null && !directoryPath.isEmpty()) {
                System.out.print("Введите новое имя файла: ");
                String newFileName = scanner.nextLine().trim();

                // Формируем полный путь к новому файлу
                String fullNewFilePath = directoryPath + "/" + newFileName;
                System.out.println("Новый файл будет сохранён по следующему пути: " + fullNewFilePath);
            } else {
                System.err.println("Ошибка: не удалось определить директорию файла.");
            }
        } finally {
            scanner.close(); // Обязательно закрываем сканнер
        }
    }
}