// Raghava Krishna Katakam and Hsin Huei Li, we are in the in Person block.
// the lab number is 3
// This purpose of this assignment is to implement SinglyLinkedList,Queue and Stack with Currency objects, and do operations with those collection types.

public class Krone extends Currency {

    private final String name = "Krone";
    public Krone(double value) {
        super(value);
    }

    @Override
    public Currency clone() {
        return new Krone(this.getWholePart() + this.getFractionalPart() / 100.0);
    }


    /*Function - toString - returns a string representation of the value of the calling object
     * pre: none
     * post: returns a string representation of the value of the calling object
     */
    @Override
    public String getCurrencyName() {
        return name;
    }

}
