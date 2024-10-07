package test;

package customer;

import java.io.*;

public class AccountTest {
    public static void main(String[] args) {
        try {
            Unlimited account = new Unlimited();
            BufferedWriter bw = new BufferedWriter(new FileWriter("account_test.txt"));
            account.save(bw);
            bw.close();

            BufferedReader br = new BufferedReader(new FileReader("account_test.txt"));
            Unlimited loadedAccount = new Unlimited(br);
            br.close();

            System.out.println("Original Account Number: " + account.getAccountNumber());
            System.out.println("Loaded Account Number: " + loadedAccount.getAccountNumber());

            Unlimited anotherAccount = new Unlimited();
            System.out.println("Another Account Number: " + anotherAccount.getAccountNumber());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
