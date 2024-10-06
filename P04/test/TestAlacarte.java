package test;

import customer.Alacarte;
import product.Media;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAlacarte {

    private Alacarte alacarte;

    @BeforeEach
    public void setUp() {
        alacarte = new Alacarte();
    }

    @Test
    public void testBuyPointsIncreasesPoints() {
        int initialPoints = alacarte.getPointsRemaining();
        int pointsToAdd = 50;
        alacarte.buyPoints(pointsToAdd);
        assertEquals(initialPoints + pointsToAdd, alacarte.getPointsRemaining());
    }

    @Test
    public void testPlayMediaWithSufficientPoints() {
        Media media = new Media("Sample Media", 20);
        alacarte.buyPoints(30); // Ensure sufficient points
        String result = alacarte.playMedia(media);
        assertEquals("Playing Sample Media", result);
    }

    @Test
    public void testPlayMediaReducesPoints() {
        Media media = new Media("Sample Media", 20);
        alacarte.buyPoints(30); // Ensure sufficient points
        alacarte.playMedia(media);
        assertEquals(10, alacarte.getPointsRemaining());
    }

    @Test
    public void testPlayMediaWithInsufficientPoints() {
        Media media = new Media("Sample Media", 50);
        alacarte.buyPoints(20); // Insufficient points
        String result = alacarte.playMedia(media);
        assertEquals("Buy more points: Requires 50 points, you have 20", result);
    }
}
