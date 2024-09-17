// Copyright 2024 by Professor George F. Rice, modifications copyright 2024 by [Nafisa Nawrin Labonno]
// This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

package product;

public class Student {
    public Student(String name, int id, String email) {
        if(email.endsWith("@uta.edu") || email.endsWith("@mavs.uta.edu")) {
            this.name = name;
            this.id = id;
            this.email = email;
            this.account = new Account();
        } else {
            throw new IllegalArgumentException("Non-UTA email address: " + email);
        }
    }
    public String requestMedia(Media media) {
        return account.play(media);
    }
    @Override
    public String toString() {
        return name + " (" + id + ", " + email + ", Account #" + account.getAccountNumber();
    }
    private String name;
    private int id;
    private String email;
    private Account account;
}