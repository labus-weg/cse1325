package mdi;

import customer.Student;
import product.Media;

import java.util.Scanner;

public class Main {
    private Moes moes;
    private Menu menu;
    private String output;
    private boolean running;

    public Main() {
        moes = new Moes();
        menu = new Menu();
        initializeMenu();
        output = "";
        running = true;
    }

    private void initializeMenu() {
        menu.addMenuItem(new MenuItem("Add Student", this::addStudent));
        menu.addMenuItem(new MenuItem("List Students", this::listStudents));
        menu.addMenuItem(new MenuItem("Add Media", this::addMedia));
        menu.addMenuItem(new MenuItem("List Media", this::listMedia));
        menu.addMenuItem(new MenuItem("Play Media", this::playMedia));
        menu.addMenuItem(new MenuItem("List Available Points", this::listAvailablePoints));
        menu.addMenuItem(new MenuItem("Buy Points", this::buyPoints));
        menu.addMenuItem(new MenuItem("Exit", this::endApp));
    }

    public void mdi() {
        Scanner scanner = new Scanner(System.in);
        while (running) {
            System.out.println(output);
            System.out.println("Main Menu:");
            System.out.println(menu);
            System.out.print("Select an option: ");
            int command = getInt(scanner);
            if (command >= 0 && command < menu.getItems().size()) {
                menu.run(command);
            } else {
                output += "Invalid selection. Please try again.\n";
            }
            output = "";  // Clear output after displaying the menu
        }
        scanner.close();
    }

    private void addStudent() {
        String name = getString("Enter name: ");
        int id = getInt("Enter ID: ");
        String email = getString("Enter email: ");
        boolean unlimited = getBoolean("Unlimited account? (true/false): ");
        
        try {
            Student student = new Student(name, id, email, unlimited);
            moes.addStudent(student);
            output += "Student added: " + student + "\n";
        } catch (IllegalArgumentException e) {
            output += "Error: " + e.getMessage() + "\n";
        }
    }

    private void listStudents() {
        output += "Student List:\n" + moes.getStudentList() + "\n";
    }

    private void addMedia() {
        String title = getString("Enter media title: ");
        String type = getString("Enter media type: ");
        
        Media media = new Media(title, type);
        moes.addMedia(media);
        output += "Media added: " + media + "\n";
    }

    private void listMedia() {
        output += "Media List:\n" + moes.getMediaList() + "\n";
    }

    private void playMedia() {
        int studentIndex = getInt("Enter student index: ");
        int mediaIndex = getInt("Enter media index: ");
        
        String result = moes.playMedia(studentIndex, mediaIndex);
        output += result + "\n";
    }

    private void listAvailablePoints() {
        int studentIndex = getInt("Enter student index: ");
        
        int points = moes.getPoints(studentIndex);
        output += "Student " + studentIndex + " has " + points + " points.\n";
    }

    private void buyPoints() {
        int studentIndex = getInt("Enter student index: ");
        int currentPoints = moes.getPoints(studentIndex);
        
        System.out.print("Current points: " + currentPoints + ". How many points to buy? ");
        int pointsToBuy = getInt();
        
        if (pointsToBuy < 0) {
            output += "Cannot buy negative points.\n";
        } else {
            String result = moes.buyPoints(studentIndex, pointsToBuy);
            output += result + "\n";
        }
    }

    private void endApp() {
        running = false;
        output += "Exiting the application. Goodbye!\n";
    }

    private String getString(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private int getInt(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextInt();
    }

    private int getInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private boolean getBoolean(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextBoolean();
    }

    public static void main(String[] args) {
        Main mainApp = new Main();
        mainApp.mdi();
    }
}
