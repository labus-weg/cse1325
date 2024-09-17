package customer;

import product.Media;

public class Student {
    private String name;
    private int id;
    private String email;
    private Account account;

    public Student(String name, int id, String email) {
        if (email.endsWith("@uta.edu") || email.endsWith("@mavs.uta.edu")) {
            this.name = name;
            this.id = id;
            this.email = email;
            this.account = new Unlimited(); // or another type based on your needs
        } else {
            throw new IllegalArgumentException("Non-UTA email address: " + email);
        }
    }

    public Account getAccount() {
        return account;
    }

    public String requestMedia(Media media) {
        return account.play(media);
    }

    @Override
    public String toString() {
        return name + " (" + id + ", " + email + ", Account #" + account.getAccountNumber() + ")";
    }
}
