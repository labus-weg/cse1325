package mdi;

import moes.Moes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static Moes moes;
    private static String filename;

    public static void main(String[] args) {
        moes = new Moes();

        if (args.length > 0) {
            filename = args[0];
            loadMoesFromFile(filename);
        } else {
            filename = "untitled.moes";
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter command (addStudent, addMedia, exit):");
            String command = scanner.nextLine();

            if (command.equalsIgnoreCase("addStudent")) {
                System.out.print("Enter student name: ");
                String studentName = scanner.nextLine();
                moes.addStudent(new Student(studentName));
                autoSave();
            } else if (command.equalsIgnoreCase("addMedia")) {
                System.out.print("Enter media title: ");
                String mediaTitle = scanner.nextLine();
                System.out.print("Enter media URL: ");
                String mediaUrl = scanner.nextLine();
                System.out.print("Enter points required: ");
                int pointsRequired = Integer.parseInt(scanner.nextLine());
                moes.addMedia(new Media(mediaTitle, mediaUrl, pointsRequired));
                autoSave();
            } else if (command.equalsIgnoreCase("exit")) {
                break;
            }
        }
        scanner.close();
    }

    private static void autoSave() {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(moes.toString());
        } catch (IOException e) {
            System.err.println("Error saving file: " + e.getMessage());
        }
    }

    private static void loadMoesFromFile(String filename) {
        File file = new File(filename);
        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    // Logic to parse line and add to `moes`
                    // Implement your parsing logic here
                }
            } catch (IOException e) {
                System.err.println("Error loading file: " + e.getMessage());
            }
        }
    }
}
