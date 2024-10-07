package mdi;

import moes.Moes;
import product.Media;
import customer.Student;
import java.util.Scanner;
import java.io.*;

public class Main {
    private Moes moes;
    private String output;
    private Menu menu;
    private boolean running = true;

    // Static final field for the file extension
    private static final String FILE_EXTENSION = ".moes";
    // Current filename
    private String filename = "";

    // Magic cookie and file version
    private final String MAGIC_COOKIE = "MOES_MAGIC";
    private final String FILE_VERSION = "1.0";

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
        menu.addMenuItem(new MenuItem("New Moes", () -> newMoes()));
        menu.addMenuItem(new MenuItem("Save", () -> save()));
        menu.addMenuItem(new MenuItem("Save As", () -> saveAs()));
        menu.addMenuItem(new MenuItem("Open", () -> open()));
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

    // New methods

    private void newMoes() {
        moes = new Moes();
        print("Created a new MOES instance.");
    }

    private void save() {
        if (filename.isEmpty()) {
            print("No filename specified. Use 'Save As' to specify a filename.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(MAGIC_COOKIE);
            writer.newLine();
            writer.write(FILE_VERSION);
            writer.newLine();
            moes.save(writer); // Ensure that Moes class has a method to save data
            print("Saved data to " + filename);
        } catch (IOException e) {
            error("Failed to save data", e);
        }
    }

    private void saveAs() {
        String newFilename = Menu.getString("Enter new filename (or press Enter to cancel): ", "");
        if (newFilename.isEmpty()) {
            return; // Do not save anything
        }

        if (!newFilename.endsWith(FILE_EXTENSION)) {
            newFilename += FILE_EXTENSION; // Add extension if not present
        }

        filename = newFilename; // Update current filename
        save(); // Call save to actually save data
    }

    private void open() {
        String newFilename = Menu.getString("Enter filename to open (or press Enter to cancel): ", "");
        if (newFilename.isEmpty()) {
            return; // Do not open anything
        }

        if (!newFilename.endsWith(FILE_EXTENSION)) {
            newFilename += FILE_EXTENSION; // Add extension if not present
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(newFilename))) {
            String magicCookieRead = reader.readLine();
            String fileVersionRead = reader.readLine();
            if (!MAGIC_COOKIE.equals(magicCookieRead) || !FILE_VERSION.equals(fileVersionRead)) {
                throw new IOException("Invalid file format.");
            }
            moes.load(reader); // Ensure that Moes class has a method to load data
            filename = newFilename; // Update current filename
            print("Opened file: " + filename);
        } catch (IOException e) {
            error("Failed to open file", e);
        }
    }
}
