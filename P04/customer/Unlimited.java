// Copyright 2024 by [Nafisa Nawrin Labonno]
// This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.


/**
 * Represents an account with unlimited media access.
 * @author Nafisa Nawrin Labonno
 * @version 1.0
 * @since 2024
 */
package customer;

import product.Media;

public class Unlimited extends Account {
    public Unlimited() {
    }

    @Override
    public String play(Media media) {
        return "Playing " + media;
    }
}