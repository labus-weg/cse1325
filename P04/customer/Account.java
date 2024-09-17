// Copyright 2024 by [Nafisa Nawrin Labonno]
// This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
/**
 * Represents an abstract account for managing media playback.
 * @author Nafisa Nawrin Labonno
 * @version 1.0
 * @since 2024
 */
package customer;

import product.Media;

public abstract class Account {
    private static int accountCounter = 0; 
    private int accountNumber;

    public Account() {
        this.accountNumber = ++accountCounter;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public abstract String play(Media media);
}
