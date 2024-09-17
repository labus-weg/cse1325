package customer;

import product.Media;

public class Alacarte extends Account {
    private int pointsRemaining;

    public void buyPoints(int points) {
        pointsRemaining += points;
    }

    public int getPointsRemaining() {
        return pointsRemaining;
    }

    @Override
    public String play(Media media) {
        int pointsRequired = media.getPoints();
        if (pointsRemaining >= pointsRequired) {
            pointsRemaining -= pointsRequired;
            return "Playing " + media.toString();
        } else {
            return "Buy more points: Requires " + pointsRequired +
                   " points, you have " + pointsRemaining + " points.";
        }
    }
}
