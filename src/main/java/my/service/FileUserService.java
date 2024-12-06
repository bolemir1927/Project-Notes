package my.service;

import my.utils.FileManager;
import my.utils.UserService;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class FileUserService implements UserService {
    private final Scanner scanner = new Scanner(System.in);
    private final static String PATH = "src/main/java/my/resurces/";

    @Override
    public void connect(String fileName) {
        File file = new File(PATH + fileName + ".txt");
        if (file.exists()) {
            System.out.println("Файл для пользователя " + fileName + " существует");
        }
        System.out.println("Введите текст: ");
        String text = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = LocalDateTime.now().format(formatter);
        text = fileName + "-" + formattedDateTime + ": " + text;
        FileManager.writeToFile(text, file);

    }

    @Override
    public void read(String fileName) {
        File file = new File(PATH + fileName + ".txt");
        if (!file.exists()) {
            System.out.println("Файл пользователя " + fileName);
            return;
        }
        FileManager.readFile(file);
    }

    @Override
    public void delete(String fileName) {
        File file = new File(PATH + fileName + ".txt");
        if (!file.exists()) {
            System.out.println("Файл для пользователя " + fileName + "не существует");
            return;
        }
        FileManager.deleteFile(file);
    }
}