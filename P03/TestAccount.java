public class TestAccount {
    public static void main(String[] args) {
        // Test vector #1: Check account number generation
        Account account1 = new Account();
        Account account2 = new Account();

        if (account1.getAccountNumber() != 1) {
            System.err.println("FAIL: First account number should be 1 but got " + account1.getAccountNumber());
            System.exit(1);
        }

        if (account2.getAccountNumber() != 2) {
            System.err.println("FAIL: Second account number should be 2 but got " + account2.getAccountNumber());
            System.exit(1);
        }
    }
}
