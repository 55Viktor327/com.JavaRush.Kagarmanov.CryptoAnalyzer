package org.example;


import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        FileManager fileManager = new FileManager();
        CeasarsCipher cipher = new CeasarsCipher();
        String userInput = null;
        String fileName = null;
        String fullPath  = null;

        int key;

        System.out.println("Добро пожаловать в приложение \"CryptoAnalyzer\"!\n");
        System.out.println("    Данная пррограмма предназначена для зашифровывания и расшифровывания текста методом Гая Юлия Цезаря!");
        System.out.println("Она имеет следующие возможности:");
        System.out.println("1 - Зашифровать текст");
        System.out.println("2 - Расшифровать текст");
        System.out.println("3 - Расшифровать текст методом Brute Force (грубой силы)");
        System.out.println("Какой пункт меню Вы выбираете?");
        int option = input.nextInt();
        input.nextLine();

        switch (option) {
            case 1:
                System.out.print("Введите полный путь к файлу: ");
                userInput = fileManager.cleanUpPath(input.nextLine());
                fileManager.setBasePath(userInput);
                System.out.print("Введите ключ: ");
                key = input.nextInt();
                input.nextLine();
                System.out.print("Введите имя файла для сохранения данных: ");
                fileName = input.nextLine().trim();
                fullPath = fileManager.constructFullPath(fileName);
                fileManager.setFilePath(fullPath);
                cipher.encrypt(fileManager.readData(), key);
                fileManager.writeData(cipher.encryptedText);
                break;

            case 2:
                System.out.print("Введите полный путь к файлу: ");
                userInput = fileManager.cleanUpPath(input.nextLine());
                fileManager.setBasePath(userInput);
                System.out.print("Введите ключ: ");
                key = input.nextInt();
                input.nextLine();
                System.out.print("Введите имя файла для сохранения данных: ");
                fileName = input.nextLine().trim();
                fullPath = fileManager.constructFullPath(fileName);
                fileManager.setFilePath(fullPath);
                cipher.decrypt(fileManager.readData(), key);
                fileManager.writeData(cipher.decryptedText);
                break;

            case 3:
                System.out.println("Введите полный путь к файлу: ");
                userInput = fileManager.cleanUpPath(input.nextLine());
                fileManager.setFilePath(userInput);
                BruteForce bruteForce = new BruteForce();
                bruteForce.bruteForceDecrypt(fileManager, fileManager.readData());
                break;
        }
    }
}