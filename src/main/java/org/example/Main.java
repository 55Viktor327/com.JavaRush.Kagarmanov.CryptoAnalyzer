package org.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Callable;

@Command(name = "caesar-cipher", version = "1.0",
        description = "Приложение для шифрования и дешифрования текста методом Цезаря.",
        mixinStandardHelpOptions = true)

public class Main implements Callable<Integer> {

    @Parameters(paramLabel = "<file>", arity = "1..*", description = "Файл(-ы) с текстом для обработки.")
    private String[] files;

    @Option(names = {"-m", "--mode"}, description = "Режим работы: encrypt|decrypt", required = true)
    private String mode;

    @Option(names = {"-k", "--key"}, description = "Значение ключа для шифрования/дешифрования.", required = true)
    private int key;

    @Option(names = {"-o", "--output"}, description = "Имя выходного файла. По умолчанию stdout.")
    private String outputFile;

    String content = new String(Files.readAllBytes(Paths.get(files[0])), StandardCharsets.UTF_8);
    Cipher cipher = new Cipher(); // Создаем экземпляр класса Cipher

    String processedContent;
        if ("encrypt".equals(mode)) {
        processedContent = cipher.encrypt(content, key); // Вызываем метод шифрования
    } else if ("decrypt".equals(mode)) {
        processedContent = cipher.decrypt(content, key); // Вызываем метод дешифрования
    } else {
        System.err.println("Ошибка: неверный режим работы. Используйте 'encrypt' или 'decrypt'.");
        return 1;
    }

        if (outputFile != null) {
        Files.write(Paths.get(outputFile), processedContent.getBytes(StandardCharsets.UTF_8));
        System.out.println("Результат успешно сохранён в файл: " + outputFile);
    } else {
        System.out.println(processedContent);
    }

        return 0;
}

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Main()).execute(args);
        System.exit(exitCode);
    }
}