package product;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Models a media product to serve to the students.
 */
public class Media {
    // Fields to hold media details
    private String title;
    private String url;
    private int points;

    /**
     * Creates a Media instance.
     *
     * @param title     the name by which the media is known
     * @param url       the Uniform Resource Locator of the media
     * @param points    the cost for accessing the media
     * @throws IllegalArgumentException if the URL is invalid or points are negative
     * @since 1.0
     */
    public Media(String title, String url, int points) {
        this.title = title;
        validateUrl(url);
        this.points = points;

        // Validate points
        if (points < 0) {
            throw new IllegalArgumentException("Points cannot be negative.");
        }
    }

    /**
     * Validates the URL format.
     *
     * @param url the URL to validate
     * @throws IllegalArgumentException if the URL is invalid
     */
    private void validateUrl(String url) {
        try {
            new java.net.URI(url).toURL();
        } catch (Exception e) {
            throw new IllegalArgumentException(url + " is invalid", e);
        }
    }

    /**
     * Returns the number of points required to access this media.
     *
     * @return the cost in points
     */
    public int getPoints() {
        return points;
    }

    /**
     * Returns the title of the media.
     *
     * @return the title of the media
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the URL of the media.
     *
     * @return the URL of the media
     */
    public String getUrl() {
        return url;
    }

    /**
     * Returns an Order summary in receipt format.
     *
     * @return the title with parenthetical URL and points
     */
    @Override
    public String toString() {
        return title + " (" + url + ", " + points + " points)";
    }

    /**
     * Saves the media details to a file using BufferedWriter.
     *
     * @param bw the BufferedWriter used to write the data to a file
     * @throws IOException if an I/O error occurs during writing
     */
    public void save(BufferedWriter bw) throws IOException {
        // Write each field to the file
        bw.write(title + '\n');        // Save title
        bw.write(url + '\n');          // Save URL
        bw.write(Integer.toString(points) + '\n'); // Save points as a string
    }

    /**
     * Checks if two Media objects are equal based on title, url, and points.
     *
     * @param obj the object to compare
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Media)) return false;
        Media other = (Media) obj;
        return title.equals(other.title) && url.equals(other.url) && points == other.points;
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object
     */
    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + url.hashCode();
        result = 31 * result + points;
        return result;
    }
}
