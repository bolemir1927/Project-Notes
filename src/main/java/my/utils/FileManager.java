package my.utils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    public static void writeToFile(String text, File file) {

        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(text + "\n");
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + file.getAbsolutePath());;
        }
    }

    public static void readFile(File file) {

        try (FileReader reader = new FileReader(file)) {
            int ch;
            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + file.getAbsolutePath());
        }
    }

    public static void deleteFile(File file) {
        boolean isDelete = file.delete();
        if (isDelete){
            System.out.println("Файл удален: " + file.getAbsolutePath());
        } else {
            System.out.println("Файл не удален: " + file.getAbsolutePath());
        }
    }
}
