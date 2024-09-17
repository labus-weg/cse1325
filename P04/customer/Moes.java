package customer;

import java.util.ArrayList;

public class Moes {

    private ArrayList<Media> library = new ArrayList<>();
    private ArrayList<Student> customers = new ArrayList<>();

    public Moes() {
    }

    public void addMedia(Media media) {
        library.add(media);
    }

    public String getMediaList() {
        StringBuilder mediaList = new StringBuilder();
        for (int i = 0; i < library.size(); i++) {
            Media media = library.get(i);
            mediaList.append(i).append(") ").append(media.toString()).append("\n");
        }
        return mediaList.toString();
    }

    public void addStudent(Student student) {
        customers.add(student);
    }

    public String getStudentList() {
        StringBuilder studentList = new StringBuilder();
        for (int i = 0; i < customers.size(); i++) {
            Student student = customers.get(i);
            studentList.append(i).append(") ").append(student.toString()).append("\n");
        }
        return studentList.toString();
    }

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

    public String playMedia(int studentIndex, int mediaIndex) {
        Student student = customers.get(studentIndex);
        Media media = library.get(mediaIndex);
        return student.requestMedia(media);
    }
}
