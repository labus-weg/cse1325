// Copyright 2024 by Professor George F. Rice, modifications copyright 2024 by [Nafisa Nawrin Labonno]
// This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

public class TestMedia {
    public static void main(String[] args) {
        int vector = 1;
        int result = 0;
        
        // Verify that media returns the correct string representation.
        String title = "The Little Shop of Horrors";
        String url = "https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0";
        Media media = new Media(title, url);
        String expected = title + " (" + url + ")";
        String actual = media.toString();
        if(!actual.equals(expected)) {
            System.err.println("FAIL: Expected media " + expected + '\n'
                             + "      Actual   media " + actual);
            result |= vector;
        }
        
        // EXTREME BONUS SOLUTION
        vector <<= 1;
        String[] goodURLs = new String[]{"https://youtube.com", "file://media/lib/garp.mp4"};
        String[] badURLs = new String[]{"htt://badurl.com", "flub://badurl.com", "hello.world"};
        
        for(String goodURL : goodURLs) {
            try {
                Media m = new Media("Title", goodURL);
            } catch(Exception e) {
                System.err.println("FAIL: Unexpected exception for URL " + goodURL);
                System.err.println(e);
                result |= vector;
            }
        }
        
        for(String badURL : badURLs) {
            try {
                Media m = new Media("Title", badURL);
                System.err.println("FAIL: Missing exception for URL " + badURL);
                result |= vector;
            } catch(Exception e) {
            }
        }
        // END EXTREME BONUS SOLUTION


        if(result != 0) System.err.println("\nFAIL: Error code " + result);
        System.exit(result);
    }
}