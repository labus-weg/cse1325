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
        students.add(student);
    }

    public void addMedia(Media media) {
        mediaList.add(media);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Student student : students) {
            sb.append("Student: ").append(student.getName()).append("\n");
        }
        for (Media media : mediaList) {
            sb.append("Media: ").append(media.toString()).append("\n");
        }
        return sb.toString();
    }
}
