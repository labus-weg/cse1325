package customer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Alacarte extends Account {
    private String itemName;

    public Alacarte() {
        super();
        this.itemName = "Default Item";
    }

    public Alacarte(BufferedReader br) throws IOException {
        super(br);
        this.itemName = br.readLine();
    }

    @Override
    public void save(BufferedWriter bw) throws IOException {
        super.save(bw);
        bw.write(itemName + "\n");
    }

    @Override
    public String toString() {
        return "Alacarte Account #" + getAccountNumber() + ", Item: " + itemName;
    }
}
