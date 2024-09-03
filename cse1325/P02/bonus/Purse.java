import java.util.ArrayList;

public class Purse {
    private ArrayList<Coin> coins;

    public Purse() {
        coins = new ArrayList<>();
    }

    public void addCoin(Coin coin) {
        coins.add(coin);
    }

    public double totalValue() {
        double total = 0;
        for (Coin coin : coins) {
            total += coin.getValue();
            System.out.println(coin); // Print each coin
        }
        return total;
    }

    public static void main(String[] args) {
        Purse purse = new Purse();
        purse.addCoin(new Coin(Denomination.PENNY, 1980));
        purse.addCoin(new Coin(Denomination.QUARTER, 1990));
        purse.addCoin(new Coin(Denomination.DIME, 2000));

        System.out.println("Total value: " + purse.totalValue());
    }
}
