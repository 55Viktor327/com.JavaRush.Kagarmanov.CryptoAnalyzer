package org.example;


import java.io.IOException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        FileManager fileManager = new FileManager();
        CeasarsCipher cipher = new CeasarsCipher();
        String userInput = null;
        int key;

        System.out.println("Добро пожаловать в приложение \"CryptoAnalyzer\"!\n");
        System.out.println("    Данная пррограмма предназначена для зашифровывания и расшифровывания текста методом Гая Юлия Цезаря!");
        System.out.println("Она имеет следующие возможности:");
        System.out.println("1 - Зашифровать текст");
        System.out.println("2 - Расшифровать текст");
        System.out.println("3 - Расшифровать текст методом Brute Force (грубой силы)");
        System.out.println("0 - Выход из программы");
        System.out.println("Какой пункт меню Вы выбираете?");
        int option = input.nextInt();
        input.nextLine();

        switch (option) {
            case 1:
                System.out.print("Введите полный путь к файлу: ");
                userInput = input.nextLine();
                System.out.print("Введите ключ: ");
                key = input.nextInt();
                input.nextLine();
                cipher.encrypt(fileManager.readFile(userInput), key);
                fileManager.fileSaver(userInput);
                fileManager.writeFile(userInput, cipher.encryptedText);
                break;

            case 2:
                System.out.print("Введите полный путь к файлу: ");
                userInput = input.nextLine();
                System.out.print("Введите ключ: ");
                key = input.nextInt();
                input.nextLine();
                cipher.decrypt(fileManager.readFile(userInput), key);
                fileManager.fileSaver(userInput);
                fileManager.writeFile(userInput, cipher.decryptedText);
                break;

            case 3:
                System.out.print("Введите полный путь к файлу: ");
                userInput = input.nextLine();
                BruteForce bruteForce = new BruteForce();
                bruteForce.bruteForceDecrypt(userInput, fileManager.readFile(userInput));
                break;

            case 0:
                System.exit(0);
        }
    }
}