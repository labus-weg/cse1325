// Copyright 2024 by [Nafisa Nawrin Labonno]
// This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

public class TestArea {
    public static void main(String[] args) {
        // TEST VECTOR #1: Normal Sides
        if (Area.area(14, 10) != 140) {
            System.err.println("FAIL: 14x10 not 140 but " + Area.area(14, 10));
        }

        // TEST VECTOR #2: Identical Length Sides
        if (Area.area(10, 10) != 100) {
            System.err.println("FAIL: 10x10 not 100 but " + Area.area(10, 10));
        }

        // TEST VECTOR #3: Zero Length Side
        try {
            Area.area(0, 10);
            System.err.println("FAIL: Zero length side did not throw exception");
        } catch (IllegalArgumentException e) {
            // Expected exception, test passed
        }

        // TEST VECTOR #4: Negative Length Side
        try {
            Area.area(-1, -2);
            System.err.println("FAIL: Negative side did not throw exception");
        } catch (IllegalArgumentException e) {
            // Expected exception, test passed
        }
    }
}
