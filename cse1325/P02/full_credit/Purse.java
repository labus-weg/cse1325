public double getPurseValue() {
    double totalValue = 0.0;
    for (Coin coin : coins) {
        totalValue += coin.getValue();
    }
    return totalValue;
}

public void sortCoins() {
    Arrays.sort(coins, Comparator.comparingInt(Coin::getYear));
}
