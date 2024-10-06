package product;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Models a media product to serve to the students.
 *
 * @author             Professor George F. Rice
 * @version            1.0
 * @since              1.0
 * @license.agreement  Gnu General Public License 3.0
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
     * @since           1.0
     */
    public Media(String title, String url, int points) {
        this.title = title;
        this.url = url;
        this.points = points;
        // EXTREME BONUS SOLUTION: Validate URL format
        try {
            new java.net.URI(url).toURL();
        } catch(Exception e) {
            throw new RuntimeException(url + " is invalid", e);
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
     * Returns an Order summary in receipt format.
     *
     * @return the title with parenthetical url and points
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
}