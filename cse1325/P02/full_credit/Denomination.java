public enum Denomination {
    PENNY(0.01),
    NICKEL(0.05),
    DIME(0.10),
    QUARTER(0.25);

    private final double value;

    private Denomination(double value) {  //Constructor for the Denomination enum
        this.value = value;
    }


    public double getValue() {  //Getting the coin's value
        return value;
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
