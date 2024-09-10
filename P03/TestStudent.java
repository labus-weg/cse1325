public class TestStudent {
    public static void main(String[] args) {
        // Test vector #1: Valid student toString()
        Student student = new Student("Prof Rice", "1001234567", "george.rice@uta.edu");
        String expected = "Prof Rice (1001234567, george.rice@uta.edu, Account #1)";
        if (!student.toString().equals(expected)) {
            System.err.println("FAIL: Expected " + expected + " but got " + student.toString());
            System.exit(1);
        }

        // Test vector #2: Invalid email (Non-UTA)
        try {
            Student invalidStudent = new Student("John Doe", "1001234568", "john.doe@gmail.com");
            System.err.println("FAIL: Expected IllegalArgumentException for non-UTA email but got none");
            System.exit(1);
        } catch (IllegalArgumentException e) {
            // Expected
        } catch (Exception e) {
            System.err.println("FAIL: Expected IllegalArgumentException but got " + e);
            System.exit(1);
        }

        // Test vector #3: Request media
        Media media = new Media("The Little Shop of Horrors", "https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0");
        if (!student.requestMedia(media).equals("Playing The Little Shop of Horrors (https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0)")) {
            System.err.println("FAIL: Media request did not return the expected result");
            System.exit(1);
        }
    }
}
