// Copyright 2024 by Professor George F. Rice, modifications copyright 2024 by [Nafisa Nawrin Labonno]
// This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

package product;

public class Media {
    public Media(String title, String url) {
        this.title = title;
        this.url = url;
        // EXTREME BONUS SOLUTION
        try {
            new java.net.URI(url).toURL();
        } catch(Exception e) {
            throw new RuntimeException(url + " is invalid", e);
        }
        // END EXTREME BONUS SOLUTION
    }
    @Override
    public String toString() {
        return title + " (" + url + ")";
    }
    private String title;
    private String url;
}