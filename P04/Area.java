// Copyright 2024 by [Nafisa Nawrin Labonno]
// This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

public class Area {
    public static int area(int length, int width) {
        if (length <= 0 || width <= 0) 
            throw new IllegalArgumentException("Invalid length or width");
        return length * width;
    }
}

