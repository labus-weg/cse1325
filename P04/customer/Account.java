// Copyright 2024 by [Nafisa Nawrin Labonno]
// This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

package product;

public class Account {
    private static int accountCounter = 0;  // To generate unique account numbers
    private int accountNumber;

    public Account() {
        this.accountNumber = ++accountCounter;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String play(Media media) {
        return "Playing " + media;
   
    }
}
