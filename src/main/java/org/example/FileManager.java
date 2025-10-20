package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {

    public String readFile(String filePath) throws IOException {

        Path path = Path.of(filePath);


        if (!path.getParent().toFile().exists()) {

            Files.createDirectories(path.getParent());
        }

        if (!Files.exists(path)) {
            Files.createFile(path);
        }

        byte[] bytes = Files.readAllBytes(path);
        return new String(bytes, StandardCharsets.UTF_8);
    }

    public void writeFile(String content, String directory, String filename) {
        try {
            // Создаем полный путь к файлу, объединяя каталог и имя файла
            Path path = Paths.get(directory).resolve(filename);

            Files.createDirectories(path.getParent());
            Files.createFile(path);

            // Записываем содержимое в файл
            Files.writeString(path, content);
        } catch (IOException e) {
            System.err.println("Ошибка при работе с файлами: " + e.getMessage());
            e.printStackTrace();
        }
    }
}