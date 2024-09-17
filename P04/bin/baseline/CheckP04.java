package baseline;

import java.util.Scanner;
import customer.Student;
import product.Media;
import product.Moes;

public class CheckP04 {
    public static void main(String[] args) {
        Moes moes = new Moes();
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Add Media");
        System.out.println("2. Add Student");
        System.out.println("3. Get Media List");
        System.out.println("4. Get Student List");
        System.out.println("5. Play Media");

        while (true) {
            System.out.println("\nEnter a choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter media title: ");
                    String title = scanner.nextLine();
                    System.out.println("Enter media URL: ");
                    String url = scanner.nextLine();
                    System.out.println("Enter media points: ");
                    int points = scanner.nextInt();
                    moes.addMedia(new Media(title, url, points));
                    break;

                case 2:
                    System.out.println("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter student ID: ");
                    String id = scanner.nextLine();
                    System.out.println("Enter student email: ");
                    String email = scanner.nextLine();
                    moes.addStudent(new Student(name, id, email));
                    break;

                case 3:
                    System.out.println("Media List:");
                    System.out.println(moes.getMediaList());
                    break;

                case 4:
                    System.out.println("Student List:");
                    System.out.println(moes.getStudentList());
                    break;

                case 5:
                    System.out.println("Enter student index: ");
                    int studentIndex = scanner.nextInt();
                    System.out.println("Enter media index: ");
                    int mediaIndex = scanner.nextInt();
                    System.out.println(moes.playMedia(studentIndex, mediaIndex));
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
