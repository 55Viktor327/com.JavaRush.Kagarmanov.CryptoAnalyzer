package org.example;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

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

    public void writeFile(String content, String filePath) {


    }

}