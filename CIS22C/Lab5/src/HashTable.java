public class HashTable {
    private final Krone[] table;
    private int numberOfDataItems;
    private int numberOfCollisions;
    private final int size;
    private double loadFactor;

    public HashTable(int size) {
        this.size = size;
        table = new Krone[size];
        numberOfDataItems = 0;
        numberOfCollisions = 0;
    }


    /*Function - insert - inserts the given object of type Krone into the hash table
     * pre: Krone - object of type Krone that is not null
     * post: if the table is not full, the object is inserted into the table
     *       if the table is full, an error message is displayed
     */
    public void insert(Krone k) {
        //do check if the table is full
        if (numberOfDataItems == table.length) {
            System.out.println("Table is full");
            return;
        }

        int index = hash(k);
        if (table[index] != null) {
            numberOfCollisions++;
            int i = 1;
            while (table[index] != null) {
                index = (index + (i * i)) % size;
                i++;
            }
        }
        table[index] = k;
        numberOfDataItems++;
        loadFactor = (double) numberOfDataItems / size;
    }

    /*Function - search - searches for the given object of type Krone in the hash table
     * pre: Krone - object of type Krone that is not null
     * post: if the object is found in the table, the index of the object is returned
     *       if the object is not found in the table, -1 is returned
     */
    public int search(Krone k) {
        int index = hash(k);
        if (table[index] != null) {
            int i = 1;
            while (table[index] != null) {
                if (table[index].isEquals(k)) {
                    return index;
                }
                index = (index + (i * i)) % size;
                i++;
            }
        }
        return -1;
    }

    /*Function - hash - computes the hash value for the given object of type Krone
     * pre: Krone - object of type Krone that is not null
     * post: returns the hash value computed using the formula ((m * w) + (n * f)) % size
     */
    public int hash(Krone k) {
        int m = 2;
        int n = 3;
        int w = k.getWholePart();
        int f = k.getFractionalPart();
        return ((m * w) + (n * f)) % size;
    }

    /*Function - getTable - returns the hash table as an array of Krone objects
     * pre: none
     * post: returns the hash table as an array of Krone objects
     */
    public Krone[] getTable() {
        return table;
    }

    /*Function - getNumberOfDataItems - returns the number of data items currently stored in the hash table
     * pre: none
     * post: returns the number of data items currently stored in the hash table
     */
    public int getNumberOfDataItems() {
        return numberOfDataItems;
    }

    /*Function - getNumberOfCollisions - returns the number of collisions that have occurred during insertion into the hash table
     * pre: none
     * post: returns the number of collisions that have occurred during insertion into the hash table
     */
    public int getNumberOfCollisions() {
        return numberOfCollisions;
    }

    /*Function - getSize - returns the size of the hash table
     * pre: none
     * post: returns the size of the hash table
     */
    public int getSize() {
        return size;
    }


    /*Function - getLoadFactor - returns the load factor of the hash table
     * pre: none
     * post: returns the load factor of the hash table
     */
    public double getLoadFactor() {
        return loadFactor;
    }
}
