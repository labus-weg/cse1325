package mdi;

import moes.Moes;
import customer.Student;
import product.Media;
import menu.Menu;
import menu.MenuItem;

public class Main {
    private Moes moes;
    private Menu menu;

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        moes = new Moes();
        menu = new Menu();

        menu.addMenuItem(new MenuItem("Add Student",             () -> addStudent()));
        menu.addMenuItem(new MenuItem("List Students",           () -> listStudents()));
        menu.addMenuItem(new MenuItem("Add Media",               () -> addMedia()));  
        menu.addMenuItem(new MenuItem("List Media",              () -> listMedia()));
        menu.addMenuItem(new MenuItem("Play Media",              () -> playMedia()));
        menu.addMenuItem(new MenuItem("List Available Points",   () -> listAvailablePoints()));
        menu.addMenuItem(new MenuItem("Buy Points",              () -> buyPoints()));
        menu.addMenuItem(new MenuItem("Exit",                    () -> endApp()));

        while (true) {
            System.out.println(menu);
            int choice = Menu.getInt("Enter a menu option: ");
            menu.run(choice);
        }
    }
}
