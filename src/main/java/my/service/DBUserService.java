package my.service;

import my.utils.UserService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class DBUserService implements UserService {
    private final Scanner scanner = new Scanner(System.in);
    @Override
    public void connect(String name) {
        System.out.println("Введите текст: ");
        String text = scanner.nextLine();
        UserNote userNote = new UserNote(name, LocalDateTime.now(),text);
        NotesDAO.add(userNote);
    }

    @Override
    public void read(String name) {
        List<UserNote> notes = NotesDAO.read(name);
        if (!notes.isEmpty()) {
            System.out.println("Заметки пользователя " + name + ":");
            for (UserNote userNote : notes) {
                System.out.println(userNote);
            }
        } else {
            System.out.println(" нет заметок.");
        }
    }

    @Override
    public void delete(String name) {
    NotesDAO.delete(name);
    }
}
