// Raghava Krishna Katakam and Hsin Huei Li, we are in the in Person block.
// the lab number is 2
// This purpose of this assignment is to implement polymorphism and with currencies and do operations with those currencies
public abstract class Currency {
    private int wholePart;
    private int fractionalPart;

    public Currency(double value) {

        if (value < 0) {
            throw new IllegalArgumentException("Value cannot be negative");
        }
        wholePart = (int) value;
        fractionalPart = Math.round((float) ((value - wholePart) * 100)); // had to use Math.round to get the correct value
    }

    public Currency(Currency currency) {
        this.wholePart = currency.wholePart;
        this.fractionalPart = currency.fractionalPart;
    }

    // Getters
    /* pre: none
     * post: returns a value from currency
     */
    public int getWholePart() {
        return wholePart;
    }

    public int getFractionalPart() {
        return fractionalPart;
    }

    /*Function - add - adds the value of the parameter to the value of the calling object
     * pre: Currency - object of type Currency that is not null
     * post: adds the value of the parameter to the value of the object
     *       also will throw an exception if the currency types are not the same
     */
    public void add(Currency currency) {

        if (isNotSameCurrency(currency)) {
            throw new IllegalArgumentException("invalid addition");
        }

        this.wholePart += currency.getWholePart();
        this.fractionalPart += currency.getFractionalPart();
        if (this.fractionalPart >= 100) {
            this.wholePart += this.fractionalPart / 100;
            this.fractionalPart = this.fractionalPart % 100;
        }
    }


    /*Function - subtract - subtracts the value of the parameter from the value of the calling object
     * pre: Currency - object of type Currency that is not null
     * post: subtracts the value of the parameter from the value of the object
     *       also will throw an exception if the currency types are not the same or if the value of the parameter is greater than the value of the calling object
     */
    public void subtract(Currency currency) {

        if (!this.isGreater(currency) || isNotSameCurrency(currency)) {
            throw new IllegalArgumentException("invalid subtraction");
        }


        this.wholePart -= currency.getWholePart();
        this.fractionalPart -= currency.getFractionalPart();
        if (this.fractionalPart < 0) {
            this.wholePart -= 1;
            this.fractionalPart += 100;
        }
    }

    /*Function - isEquals - checks if the value of the parameter is equal to the value of the calling object
     * pre: Currency - object of type Currency that is not null
     * post: returns true if the value of the calling object is greater than the value of the parameter
     *       returns false if the value of the calling object is less than or equal to the value of the parameter
     *      also will throw an exception if the currency types are not the same
     */
    public boolean isEquals(Currency currency) {

        if (isNotSameCurrency(currency)) {
            throw new IllegalArgumentException("Currency types must be the same");
        }
        return this.wholePart == currency.getWholePart() && this.fractionalPart == currency.getFractionalPart();
    }

    /*Function - isNotSameCurrency - checks if the currency types are the same
        * pre: Currency - object of type Currency that is not null
        * post: returns true if the currency types are not the same
        *      returns false if the currency types are the same
     */
    private boolean isNotSameCurrency(Currency currency) {
        return this.getClass() != currency.getClass();
    }

    /*Function - isGreater - checks if the value of the calling object is greater than the value of the parameter
     * pre: Currency - object of type Currency that is not null
     * post: returns true if the value of the calling object is greater than the value of the parameter
     *       returns false if the value of the calling object is less than or equal to the value of the parameter
     *     also will throw an exception if the currency types are not the same
     */
    private boolean isGreater(Currency currency) {

        if (this.getClass() != currency.getClass()) {
            throw new IllegalArgumentException("Currency types must be the same");
        }

        if (this.wholePart > currency.getWholePart()) {
            return true;
        } else if (this.wholePart == currency.getWholePart()) {
            return this.fractionalPart > currency.getFractionalPart();
        }
        return false;
    }

    /*Function - clone - returns a copy of the calling object
     * pre: none
     * post: returns a copy of the calling object
     */
    public abstract Currency clone();

    /*Function - toString - returns a string representation of the type of currency of the calling object
     * pre: none
     * post: returns a string representation of the Type of the calling object
     */
    public abstract String getCurrencyName();

    /*Function - toString - returns a string representation of the value of the calling object
     * pre: none
     * post: returns a string representation of the value of the calling object and the type of currency
     */
    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return this.wholePart + "." + this.fractionalPart + " " + this.getCurrencyName();
    }
}
