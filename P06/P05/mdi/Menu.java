package mdi;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);
    private List<MenuItem> items = new ArrayList<>();

    public void addMenuItem(MenuItem item) {
        items.add(item);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.size(); ++i)
            sb.append(" " + i + "] " + items.get(i) + "\n");
        return sb.toString();
    }

    public void run(int itemNumber) {
        items.get(itemNumber).run();
    }

    public static int getInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next();
            System.out.print(prompt);
        }
        return scanner.nextInt();
    }

    public static int getInt(String prompt, String defaultValue) {
        System.out.print(prompt);
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            scanner.next();
            return Integer.parseInt(defaultValue);
        }
    }

    public static String getString(String prompt, String defaultValue) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        return input.isEmpty() ? defaultValue : input;
    }

    public static char getChar(String prompt, String defaultValue) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        return input.isEmpty() ? defaultValue.charAt(0) : input.charAt(0);
    }
}
