// Copyright 2024 by Professor George F. Rice, modifications copyright 2024 by [Nafisa Nawrin Labonno]
// This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.


package product;

/**
 * Represents a media item in the system.
 * 
 * @author Nafisa Nawrin Labonno
 * @version 0.2
 * @since 2024
 */
public class Media {
    private String title;
    private String url;
    private int points;

    /**
     * Constructs a Media object with the given title, URL, and points.
     * 
     * @param title the title of the media
     * @param url the URL of the media
     * @param points the number of points required to play the media
     * @since 2024
     */
    public Media(String title, String url, int points) {
        this.title = title;
        this.url = url;
        this.points = points;
    }

    /**
     * Gets the number of points required to play the media.
     * 
     * @return the number of points required
     * @since 2024
     */
    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return title + " (" + url + ", " + points + " points)";
    }
}
