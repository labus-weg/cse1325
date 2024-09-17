// Copyright 2024 by Professor George F. Rice, modifications copyright 2024 by [Nafisa Nawrin Labonno]
// This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.


package test;
import customer.Account;

public class TestAccount {
    public static void main(String[] args) {
        int result = 0;
        
        // Verify that the first account number created is ``1``, and the second account number is ``2``.
        for(int expected = 1; expected < 3; ++expected) {
            Account account = new Account();
            int actual = account.getAccountNumber();
            if(actual != expected) {
                System.err.println("FAIL: Expected account number " + expected + '\n'
                                 + "      Actual   account number " + actual);
                result = 1;
            }
        }

        if(result != 0) System.err.println("\nFAIL: Error code " + result);
        System.exit(result);
    }
}
