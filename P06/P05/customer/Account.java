package customer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Abstract Account class representing a student's account.
 * Handles unique account numbering and saving/loading account data.
 */
public abstract class Account {
    // Static field to track the next available account number
    private static int nextAccountNumber = 1;
    
    // Unique account number for each instance
    private int accountNumber;

    /**
     * Default constructor for creating a new Account.
     * Assigns a unique account number and increments the static counter.
     */
    public Account() {
        this.accountNumber = nextAccountNumber++;
    }

    /**
     * Reconstructor constructor for creating an Account from a BufferedReader.
     * Reads the account number and updates the static counter.
     * 
     * @param br BufferedReader to read account data from
     * @throws IOException if an I/O error occurs during reading
     */
    public Account(BufferedReader br) throws IOException {
        // Read the account number from the stream
        this.accountNumber = Integer.parseInt(br.readLine());
        
        // Read and update the nextAccountNumber from the stream
        nextAccountNumber = Integer.parseInt(br.readLine());
    }

    /**
     * Saves the account details to a BufferedWriter.
     * Writes the account number and the next available account number.
     * 
     * @param bw BufferedWriter to write account data to
     * @throws IOException if an I/O error occurs during writing
     */
    public void save(BufferedWriter bw) throws IOException {
        bw.write(accountNumber + "\n");
        bw.write(nextAccountNumber + "\n");
    }

    /**
     * Getter for the account number.
     * 
     * @return the unique account number
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * Setter for the account number.
     * (Optional: Depending on whether you need to modify the account number externally)
     * 
     * @param accountNumber the account number to set
     */
    protected void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
}
