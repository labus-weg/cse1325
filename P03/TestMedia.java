public class TestMedia {
    public static void main(String[] args) {
        Media media = new Media("The Little Shop of Horrors", "https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0");

        // Test vector: Checking if toString() works correctly
        String expected = "The Little Shop of Horrors (https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0)";
        if (!media.toString().equals(expected)) {
            System.err.println("FAIL: Expected " + expected + " but got " + media.toString());
            System.exit(1);
        }
    }
}
