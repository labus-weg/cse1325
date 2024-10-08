package customer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Student {
    private String name;
    private String id;
    private int gradeLevel;
    private Account account;

    public Student(String name, String id, int gradeLevel, Account account) {
        this.name = name;
        this.id = id;
        this.gradeLevel = gradeLevel;
        this.account = account;
    }

    public Student(BufferedReader br) throws IOException {
        this.name = br.readLine();
        this.id = br.readLine();
        this.gradeLevel = Integer.parseInt(br.readLine());

        String accountType = br.readLine();
        switch (accountType) {
            case "Unlimited":
                this.account = new Unlimited(br);
                break;
            case "Alacarte":
                this.account = new Alacarte(br);
                break;
            default:
                throw new IOException("Unknown account type: " + accountType);
        }
    }

    public void save(BufferedWriter bw) throws IOException {
        bw.write(name + "\n");
        bw.write(id + "\n");
        bw.write(gradeLevel + "\n");
        bw.write(account.getClass().getSimpleName() + "\n");
        account.save(bw);
    }

    // Getter methods to access private fields while maintaining encapsulation
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public Account getAccount() {
        return account;
    }
}
