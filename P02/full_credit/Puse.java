// Main class to test the Coin class functionality
public class Purse {
    public static void main(String[] args) {
        // Creating an array of Coin objects with at least one of each denomination
        Coin[] coins = new Coin[] {
            new Coin(Denomination.PENNY, 1924),
            new Coin(Denomination.NICKEL, 1965),
            new Coin(Denomination.DIME, 1980),
            new Coin(Denomination.QUARTER, 2000),
            new Coin(Denomination.PENNY, 2021)
        };

        double totalValue = 0.0;
        int earliestYear = Integer.MAX_VALUE;
        int latestYear = Integer.MIN_VALUE;

        // Iterating over the coins and calculate total value and date range
        for (Coin coin : coins) {
            totalValue += coin.getValue();
            int year = coin.getYear();
            if (year < earliestYear) {
                earliestYear = year;
            }
            if (year > latestYear) {
                latestYear = year;
            }
        }

        // Print the total value & date range
        System.out.printf("Total value of coins: $%.2f%n", totalValue);
        System.out.printf("Earliest year: %d%n", earliestYear);
        System.out.printf("Latest year: %d%n", latestYear);
    }
}
