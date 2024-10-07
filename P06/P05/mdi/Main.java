package mdi;

import moes.Moes;
import product.Media;
import customer.Student;
import java.util.Scanner;

public class Main {
    private Moes moes;
    private String output;
    private Menu menu;
    private boolean running = true;

    public Main() {
        this.moes = new Moes();
        this.output = "";
        this.menu = new Menu();
        initializeMenu();
    }

    private void initializeMenu() {
        menu.addMenuItem(new MenuItem("Add Student", () -> addStudent()));
        menu.addMenuItem(new MenuItem("List All Students", () -> listStudents()));
        menu.addMenuItem(new MenuItem("Add Media", () -> addMedia()));
        menu.addMenuItem(new MenuItem("List Media", () -> listMedia()));
        menu.addMenuItem(new MenuItem("Play Media", () -> playMedia()));
        menu.addMenuItem(new MenuItem("List Available Points", () -> listAvailablePoints()));
        menu.addMenuItem(new MenuItem("Buy Points", () -> buyPoints()));
        menu.addMenuItem(new MenuItem("Exit", () -> endApp()));
    }

    public void mdi() {
        while (running) {
            try {
                Integer i = selectFromMenu();
                if (i != null) menu.run(i);
            } catch (Exception e) {
                error("Invalid command", e);
            }
        }
    }

    private final String title = "\n".repeat(255) +
    """
                           \\\\\\///                          
                          / _  _ \\                         
                        (| (.)(.) |)                        
     .----------------.OOOo--()--oOOO.---------------.
     |                                               |
     |    Mavs Online Entertainment System (MOES)    |
     |    Version 0.3.0           ©2024 Prof Rice    |
     |                                               |
     '-----------------------------------------------'
    """;

    private final String sep = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";

    private Integer selectFromMenu() {
        if (!output.isEmpty()) output = sep + output + sep;
        System.out.println(title + menu + output);
        output = "";
        return Menu.getInt("Selection? ");
    }

    private void print(Object s) {
        output += "\n" + s + "\n";
    }

    private void error(Object s, Exception e) {
        output += "\n#### " + s + '\n';
        if (e != null) {
            output += "  => " + e + '\n';
        }
    }

    private void endApp() {
        running = false;
    }

    private void playMedia() {
        try {
            print(moes.playMedia(inputStudentIndex(), inputMediaIndex()));
        } catch (Exception e) {
            error("Unable to play media", e);
        }
    }

    private void listMedia() {
        try {
            print("Media Available via MOES\n========================");
            print(moes.getMediaList());
        } catch (Exception e) {
            error("Unable to display media list", e);
        }
    }

    private void listAvailablePoints() {
        try {
            int studentIndex = inputStudentIndex();
            print(moes.getStudent(studentIndex) + " has " + moes.getPoints(studentIndex) + " points");
        } catch (Exception e) {
            error("Unable to look up point totals", e);
        }
    }

    private void buyPoints() {
        try {
            int studentIndex = inputStudentIndex();
            int currentPoints = moes.getPoints(studentIndex);
            System.out.println(moes.getStudent(studentIndex) + " currently has " + currentPoints + " points");
            int buyPoints = Menu.getInt("Number of additional points to buy? ");
            if (buyPoints <= 0) {
                error("Can only buy positive points", null);
                return;
            }
            print(moes.buyPoints(studentIndex, buyPoints));
            print(moes.getStudent(studentIndex) + " bought " + buyPoints + " points");
        } catch (Exception e) {
            error("Unable to buy points", e);
        }
    }

    private void addStudent() {
        try {
            String name = Menu.getString("Student name? ", "");
            Integer id = Menu.getInt("Student ID? ", "");
            String email = Menu.getString("Student email? ", "");
            Character account = Menu.getChar("(a)lacarte or (u)nlimited? ", "");

            if (name != null && id != null && email != null && account != null) {
                Student student = new Student(name, id, email, Character.toUpperCase(account) == 'U');
                moes.addStudent(student);
                print("Added student: " + student);
            }
        } catch (Exception e) {
            error("Unable to add student", e);
        }
    }

    private void listStudents() {
        try {
            print("Students Registered with MOES\n===============================");
            print(moes.getStudentsList());
        } catch (Exception e) {
            error("Unable to display student list", e);
        }
    }

    private void addMedia() {
        // Implementation for adding media
    }

    private int inputStudentIndex() {
        return Menu.getInt("Enter student index: ");
    }

    private int inputMediaIndex() {
        return Menu.getInt("Enter media index: ");
    }
}
