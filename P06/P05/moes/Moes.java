package moes;

import customer.Student;
import product.Media;

import java.util.ArrayList;
import java.util.List;

public class Moes {
    private List<Student> students;
    private List<Media> mediaList;

    public Moes() {
        students = new ArrayList<>();
        mediaList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (student != null) {
            students.add(student);
        } else {
            throw new IllegalArgumentException("Cannot add null student.");
        }
    }

    public void addMedia(Media media) {
        if (media != null) {
            mediaList.add(media);
        } else {
            throw new IllegalArgumentException("Cannot add null media.");
        }
    }

    public int getPoints(int studentIndex) {
        validateStudentIndex(studentIndex);
        return students.get(studentIndex).getAccount().getPoints();
    }

    public String buyPoints(int studentIndex, int points) {
        validateStudentIndex(studentIndex);
        if (points <= 0) {
            return "Points to buy must be positive.";
        }
        students.get(studentIndex).getAccount().addPoints(points);
        return points + " points bought successfully.";
    }

    public String playMedia(int studentIndex, int mediaIndex) {
        validateStudentIndex(studentIndex);
        validateMediaIndex(mediaIndex);

        Student student = students.get(studentIndex);
        Media media = mediaList.get(mediaIndex);

        if (student.getAccount().canAfford(media.getPointsRequired())) {
            student.getAccount().subtractPoints(media.getPointsRequired());
            return "Playing " + media.getTitle() + ": " + media.getUrl();
        } else {
            return "Not enough points to play this media.";
        }
    }

    public String getStudentsList() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < students.size(); i++) {
            sb.append(i).append(": ").append(students.get(i).getName()).append("\n");
        }
        return sb.toString();
    }

    public String getMediaList() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mediaList.size(); i++) {
            sb.append(i).append(": ").append(mediaList.get(i).toString()).append("\n");
        }
        return sb.toString();
    }

    private void validateStudentIndex(int index) {
        if (index < 0 || index >= students.size()) {
            throw new IndexOutOfBoundsException("Invalid student index: " + index);
        }
    }

    private void validateMediaIndex(int index) {
        if (index < 0 || index >= mediaList.size()) {
            throw new IndexOutOfBoundsException("Invalid media index: " + index);
        }
    }
}
