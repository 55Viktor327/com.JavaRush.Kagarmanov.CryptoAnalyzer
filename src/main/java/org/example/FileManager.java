package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileManager {

//    Поле хранит путь к обрабатываемому файлу.

    private String filePath;

//     * Метод устанавливает путь к файлу, запрашивая ввод у пользователя. После ввода проверяется существование файла.
//     * Если файл отсутствует, предлагается создание нового файла и каталога.


    public void setFilePath(Scanner scanner) throws IOException {
        System.out.print("Введите полный путь к файлу: ");
        this.filePath = scanner.nextLine();

        // Проверяем, существует ли файл по введенному пути
        if (!Files.exists(Paths.get(filePath))) {
            System.out.println("Указанный путь '" + filePath + "' не существует.");

            System.out.print("Создать указанный файл и каталог? (Да/Нет): ");
            String choice = scanner.nextLine().trim().toLowerCase();

            if ("да".equals(choice)) {
                Files.createDirectories(Paths.get(filePath).getParent());
                Files.createFile(Paths.get(filePath));
                System.out.println("Новый файл успешно создан по адресу: " + filePath);
            }
        }
    }
//
//     Чтение содержимого файла и возврат строкового представления его содержимого.
//     return содержимое файла в виде строки, где каждая новая строка обозначается символом "\\\\n"

    public String readData() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(this.filePath));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\\n");
        }
        reader.close();
        return sb.toString();
    }
//
//Запись переданных данных в файл. Старые данные будут перезаписаны новыми.
//data строковые данные, предназначенные для записи в файл

    public void writeData(String data) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(this.filePath));
        writer.print(data);
        writer.close();
    }
}