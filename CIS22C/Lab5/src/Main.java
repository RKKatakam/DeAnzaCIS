import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Declare a hash table of size 29 elements.
        HashTable table = new HashTable(29);

         /*
       Your pgm will use the following 20 Krone objects to be created in the exact order in your main to seed the table:
Kr 57.12
Kr 23.44
Kr 87.43
Kr 68.99
Kr 111.22
Kr 44.55
Kr 77.77
Kr 18.36
Kr 543.21
Kr 20.21
Kr 345.67
Kr 36.18
Kr 48.48
Kr 101.00
Kr 11.00
Kr 21.00
Kr 51.00
Kr 1.00
Kr 251.00
Kr 151.00
*/

        table.insert(new Krone(57.12));
        table.insert(new Krone(23.44));
        table.insert(new Krone(87.43));
        table.insert(new Krone(68.99));
        table.insert(new Krone(111.22));
        table.insert(new Krone(44.55));
        table.insert(new Krone(77.77));
        table.insert(new Krone(18.36));
        table.insert(new Krone(543.21));
        table.insert(new Krone(20.21));
        table.insert(new Krone(345.67));
        table.insert(new Krone(36.18));
        table.insert(new Krone(48.48));
        table.insert(new Krone(101.00));
        table.insert(new Krone(11.00));
        table.insert(new Krone(21.00));
        table.insert(new Krone(51.00));
        table.insert(new Krone(1.00));
        table.insert(new Krone(251.00));
        table.insert(new Krone(151.00));

        //Your main will first load the data into the hash table and print the number of data items loaded, load factor and number of collisions.
        System.out.println("Number of data items loaded: " + table.getNumberOfDataItems());
        System.out.println("Load factor: " + table.getLoadFactor());
        System.out.println("Number of collisions: " + table.getNumberOfCollisions());

        // Display the hash table.
        System.out.println("The hash table:");
        for (int i = 0; i < table.getSize(); i++) {
            System.out.println("Index " + i + ": " + table.getTable()[i]);
        }


        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (true) {
            System.out.println("do you want to continue? y/n");
            input = scanner.nextLine();
            if (input.equals("y") || input.equals("Y")) {
                System.out.println("Enter a Krone to search for: ");
                input = scanner.nextLine();
                System.out.println(Double.parseDouble(input));
                Krone krone = new Krone(Double.parseDouble(input));
                int index = table.search(krone);
                if (index == -1) {
                    System.out.println("Invalid Data");
                } else {
                    System.out.println("Index " + index + ": " + table.getTable()[index]);
                }
            } else {
                break;
            }
        }
    }
}