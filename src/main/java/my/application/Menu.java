package my.application;

import my.service.UserConfig;
import my.service.FileUserService;
import my.utils.UserService;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        UserConfig.getInstance().initializeDatabase();
        Scanner scanner = new Scanner(System.in);
        String fileName;
        UserService userService = new FileUserService();
        while (true) {

            System.out.println("--- Меню ---");
            System.out.println("1) Подключить пользователя для запси");
            System.out.println("2) Прочитать записи пользователя");
            System.out.println("3) Удалить записи пользователя");
            System.out.println("4) Выйти");
            System.out.print("Ваш выбор: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Введите имя пользователя: ");
                    fileName = scanner.next();
                    userService.connect(fileName);
                    break;
                case 2:
                    System.out.print("Введите имя пользователя: ");
                    fileName = scanner.next();
                    userService.read(fileName);
                    break;
                case 3:
                    System.out.print("Введите имя пользователя: ");
                    fileName = scanner.next();
                    userService.delete(fileName);
                    break;
                case 4:
                    System.out.println("Выход из программы.");
                    System.exit(0);

                default:
                    System.out.println("Некорректный выбор.");
            }
        }
    }
}
