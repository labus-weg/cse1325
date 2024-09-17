package customer;
import product.Media;

/**
 * Represents an account where media is accessed by spending points.
 */
public class Alacarte extends Account {
    private int pointsRemaining;

    /**
     * Default constructor initializing pointsRemaining to 0.
     */
    public Alacarte() {
        this.pointsRemaining = 0;
    }

    /**
     * Adds points to the pointsRemaining field.
     * @param points The number of points to add.
     */
    public void buyPoints(int points) {
        this.pointsRemaining += points;
    }

    /**
     * Returns the number of points remaining.
     * @return The points remaining.
     */
    public int getPointsRemaining() {
        return pointsRemaining;
    }

    /**
     * Plays the media if enough points are available; otherwise, prompts to buy more points.
     * @param media The media to play.
     * @return A message indicating whether the media is being played or if more points are needed.
     */
    @Override
    public String play(Media media) {
        if (pointsRemaining >= media.getPoints()) {
            pointsRemaining -= media.getPoints();
            return "Playing " + media;
        } else {
            return "Buy more points: Requires " + media.getPoints() +
                   " points, you have " + pointsRemaining + " points";
        }
    }
}
