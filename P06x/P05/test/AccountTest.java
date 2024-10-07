package customer;

import java.io.*;

public class AccountTest {
    public static void main(String[] args) {
        try {
            // Create an instance of a concrete subclass (e.g., Unlimited)
            Unlimited account = new Unlimited();

            // Save the account to a file
            BufferedWriter bw = new BufferedWriter(new FileWriter("account_test.txt"));
            account.save(bw);
            bw.close();

            // Load the account from the file
            BufferedReader br = new BufferedReader(new FileReader("account_test.txt"));
            Unlimited loadedAccount = new Unlimited(br);
            br.close();

            // Display loaded account details
            System.out.println("Original Account Number: " + account.getAccountNumber());
            System.out.println("Loaded Account Number: " + loadedAccount.getAccountNumber());

            // Verify that nextAccountNumber has been updated
            Unlimited anotherAccount = new Unlimited();
            System.out.println("Another Account Number: " + anotherAccount.getAccountNumber());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Concrete subclass for testing
package customer;

import java.io.BufferedReader;
import java.io.IOException;

public class Unlimited extends Account {
    public Unlimited() {
        super();
    }

    public Unlimited(BufferedReader br) throws IOException {
        super(br);
    }

    @Override
    public String toString() {
        return "Unlimited Account #" + getAccountNumber();
    }
}
