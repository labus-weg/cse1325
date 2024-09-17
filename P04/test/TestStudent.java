// Copyright 2024 by Professor George F. Rice, modifications copyright 2024 by [Nafisa Nawrin Labonno]
// This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

package test;

import customer.Student;
import product.Media;

public class TestStudent {
    public static void main(String[] args) {
        int vector = 1;
        int result = 0;

        Student s1 = new Student("Prof Rice", 1234567890, "george.rice@uta.edu");
        String actual = s1.toString();
        String expected = "Prof Rice (1234567890, george.rice@uta.edu, Account #" + s1.getAccountNumber() + ")";
        if (!actual.equals(expected)) {
            System.err.println("FAIL: Expected student " + expected + '\n'
                                + "  Actual   student " + actual);
            result |= vector;
        }
        vector <<= 1;

        String badEmail = "george.rice@example.com";
        try {
            Student s2 = new Student("Prof Rice", 1234567890, badEmail);
            System.err.println("FAIL: Expected IllegalArgumentException for " + badEmail);
            System.err.println("      NO exception thrown");
            result |= vector;
        } catch (IllegalArgumentException e) {
            expected = "Non-UTA email address: " + badEmail;
            actual = e.getMessage();
            if (!actual.equals(expected)) {
                System.err.println("FAIL: Expected message " + expected + '\n'
                                    + "  Actual   message " + actual);
                result |= vector;
            }
        } catch (Exception e) {
            System.err.println("FAIL: Expected IllegalArgumentException for " + badEmail);
            System.err.println("      Following exception thrown instead\n" + e);
            result |= vector;
        }

        String title = "The Little Shop of Horrors";
        String url = "https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0";
        Media media = new Media(title, url, 0);
        expected = "Playing " + title + " (" + url + ")";
        actual = s1.requestMedia(media);
        if (!actual.equals(expected)) {
            System.err.println("FAIL: Expected media request result \n" + expected + '\n'
                                + "  Actual   media request result \n" + actual);
            result |= vector;
        }
        vector <<= 1;

        if (result != 0) System.err.println("\nFAIL: Error code " + result);
        System.exit(result);
    }
}