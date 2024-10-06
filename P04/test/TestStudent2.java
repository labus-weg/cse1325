package test;

import customer.Student;
import customer.Alacarte;
import customer.Unlimited;
import product.Media;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestStudent {

    private Student student;

    @BeforeEach
    public void setUp() {
        student = new Student(new Unlimited()); // Initialize with Unlimited account
    }

    @Test
    public void testRequestMediaWithUnlimitedAccount() {
        Media media = new Media("Sample Media", 10);
        String result = student.requestMedia(media);
        assertEquals("Playing Sample Media", result);
    }

    @Test
    public void testRequestMediaWithAlacarteSufficientPoints() {
        Alacarte alacarte = new Alacarte();
        alacarte.buyPoints(50);
        student.setAccount(alacarte);
        Media media = new Media("Sample Media", 20);
        String result = student.requestMedia(media);
        assertEquals("Playing Sample Media", result);
    }

    @Test
    public void testRequestMediaWithAlacarteInsufficientPoints() {
        Alacarte alacarte = new Alacarte();
        alacarte.buyPoints(10); // Insufficient points
        student.setAccount(alacarte);
        Media media = new Media("Sample Media", 20);
        String result = student.requestMedia(media);
        assertEquals("Buy more points: Requires 20 points, you have 10", result);
    }
}
