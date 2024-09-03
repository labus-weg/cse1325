import java.util.ArrayList;
import java.util.List;

public class Purse {
    private List<Coin> coins = new ArrayList<>();

    public void addCoin(Coin coin) {
        coins.add(coin);
    }

    public double totalValue() {
        double total = 0.0;
        for (Coin coin : coins) {
            total += coin.getValue();
        }
        return total;
    }

    public double totalWeight() {
        double total = 0.0;
        for (Coin coin : coins) {
            total += coin.getWeight();
        }
        return total;
    }

    public static void main(String[] args) {
        Purse purse = new Purse();
        purse.addCoin(new Coin(Denomination.PENNY, 1982));
        purse.addCoin(new Coin(Denomination.NICKEL, 1990));
        purse.addCoin(new Coin(Denomination.QUARTER, 2000));

        System.out.println("Total Value: " + purse.totalValue());
        System.out.println("Total Weight: " + purse.totalWeight());
        for (Coin coin : purse.coins) {
            System.out.println(coin);
        }
    }
}


public class Purse {
    private List<Coin> coins = new ArrayList<>();

    public void addCoin(Coin coin) {
        coins.add(coin);
    }

    public double totalValue() {
        double total = 0;
        for (Coin coin : coins) {
            total += coin.getValue();
            System.out.println(coin); // Print coin details
        }
        return total;
    }

    public double totalWeight() {
        double total = 0;
        for (Coin coin : coins) {
            total += coin.getWeight();
        }
        return total;
    }

    public static void main(String[] args) {
        Purse purse = new Purse();
        purse.addCoin(new Coin(Denomination.PENNY, 1980));
        purse.addCoin(new Coin(Denomination.NICKEL, 1990));
        purse.addCoin(new Coin(Denomination.DIME, 2000));
        purse.addCoin(new Coin(Denomination.QUARTER, 2010));
        
        System.out.println("Total value: " + purse.totalValue());
        System.out.println("Total weight: " + purse.totalWeight() + " grams");
    }
}
