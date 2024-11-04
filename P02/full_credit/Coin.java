// Class representing a coin with a denomination and year
public class Coin {
    private Denomination denomination; // The type of coin
    private int year; // The year the coin was minted

    // Constructor to initialize the denomination and year
    public Coin(Denomination denomination, int year) {
        this.denomination = denomination;
        this.year = year;
    }

    // Method to get the value of the coin
    public double getValue() {
        switch (denomination) {
            case PENNY:   return 0.01;
            case NICKEL:  return 0.05;
            case DIME:    return 0.10;
            case QUARTER: return 0.25;
            default:     throw new IllegalArgumentException("Unknown denomination: " + denomination);
        }
    }

    // Method to get the year of the coin   //Comments for clarity
    public int getYear() {
        return year;
    }
}
