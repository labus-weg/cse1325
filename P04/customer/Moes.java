package customer;

import product.Media;

import java.util.ArrayList;

/**
 * Manages a collection of media and students, allowing for media management,
 * student account operations, and media playback requests.
 * 
 * @author Nafisa Nawrin Labonno
 * @version 1.0
 * @since 2024
 */
public class Moes {

    private ArrayList<Media> library = new ArrayList<>();
    private ArrayList<Student> customers = new ArrayList<>();

    /**
     * Constructs a new Moes instance with empty media and student lists.
     * 
     * @since 2024
     */
    public Moes() {
    }

    /**
     * Adds a media item to the media library.
     * 
     * @param media The media item to be added to the library.
     * @since 2024
     */
    public void addMedia(Media media) {
        library.add(media);
    }

    /**
     * Returns a string representation of all media items in the library.
     * 
     * @return A string listing all media items.
     * @since 2024
     */
    public String getMediaList() {
        StringBuilder mediaList = new StringBuilder();
        for (int i = 0; i < library.size(); i++) {
            Media media = library.get(i);
            mediaList.append(i).append(") ").append(media.toString()).append("\n");
        }
        return mediaList.toString();
    }

    /**
     * Adds a student to the list of customers.
     * 
     * @param student The student to be added to the customer list.
     * @since 2024
     */
    public void addStudent(Student student) {
        customers.add(student);
    }

    /**
     * Returns a string representation of all students in the customer list.
     * 
     * @return A string listing all students.
     * @since 2024
     */
    public String getStudentList() {
        StringBuilder studentList = new StringBuilder();
        for (int i = 0; i < customers.size(); i++) {
            Student student = customers.get(i);
            studentList.append(i).append(") ").append(student.toString()).append("\n");
        }
        return studentList.toString();
    }

    /**
     * Returns the number of points remaining for a specified student.
     * 
     * @param studentIndex The index of the student in the customer list.
     * @return The number of points remaining for the student.
     * @since 2024
     */
    public int getPoints(int studentIndex) {
        Student student = customers.get(studentIndex);
        Account account = student.getAccount();

        if (account instanceof Alacarte) {
            return ((Alacarte) account).getPointsRemaining();
        } else if (account instanceof Unlimited) {
            return Integer.MAX_VALUE;
        } else {
            throw new UnsupportedOperationException("Unknown subclass of Account");
        }
    }

    /**
     * Adds points to a specified student's account.
     * 
     * @param studentIndex The index of the student in the customer list.
     * @param points The number of points to be added.
     * @return A message indicating the new number of points or a notice for unlimited accounts.
     * @since 2024
     */
    public String buyPoints(int studentIndex, int points) {
        Student student = customers.get(studentIndex);
        Account account = student.getAccount();

        if (account instanceof Alacarte) {
            Alacarte alacarte = (Alacarte) account;
            alacarte.buyPoints(points);
            return "Points remaining: " + alacarte.getPointsRemaining();
        } else if (account instanceof Unlimited) {
            return "Student has an unlimited account and needs no additional points.";
        } else {
            throw new UnsupportedOperationException("Unknown subclass of Account");
        }
    }

    /**
     * Requests a media item for a specified student.
     * 
     * @param studentIndex The index of the student in the customer list.
     * @param mediaIndex The index of the media item in the library.
     * @return A message indicating the result of the media request.
     * @since 2024
     */
    public String playMedia(int studentIndex, int mediaIndex) {
        Student student = customers.get(studentIndex);
        Media media = library.get(mediaIndex);
        return student.requestMedia(media);
    }
}
