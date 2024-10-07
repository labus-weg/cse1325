package customer;

import java.io.BufferedReader;
import java.io.IOException;

public class Unlimited extends Account {
    public Unlimited() {
        super(); // Call the superclass constructor
    }

    public Unlimited(BufferedReader br) throws IOException {
        super(br); // Call the superclass constructor
    }

    @Override
    public String toString() {
        return "Unlimited Account #" + getAccountNumber();
    }
}
