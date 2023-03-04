import java.util.Scanner;

public class Main_lab4 {

    public static int validateInputInt(String promptText, Scanner scannerInput, int minimum, int maximum) {
        boolean isInputDone = false;
        int input = 0;

        //validate the user input
        while (!isInputDone) {
            try {
                System.out.printf(promptText);
                input = scannerInput.nextInt();

                if (input >= minimum && input <= maximum) {// the input is within the valid range
                    isInputDone = true;
                } else {
                    System.out.printf("Allowed range: %d - %d.\n", minimum, maximum);
                }
            } catch (Exception e) {
                System.out.println("Oops!Wrong data type. Try again.");
                scannerInput.nextLine();//skip the current stuck input.
            }
        }
        ;
        return input;
    }

    public static double validateInputDouble(String promptText, Scanner scanneInput, double minimum, double maximum) {
        boolean isInputDone = false;
        double input = 0;

        //validate the user input
        while (!isInputDone) {
            try {
                System.out.printf(promptText);
                input = scanneInput.nextDouble();

                if (input >= minimum && input <= maximum) {//the input is within the valid range
                    isInputDone = true;
                } else {
                    if (maximum == Double.MAX_VALUE) {
                        System.out.printf("Allowed range: > %.2f \n", minimum);
                    } else {
                        System.out.printf("Allowed range: %f - %f\n", minimum, maximum);
                    }

                }
            } catch (Exception e) {
                System.out.println("Oops!Wrong data type. Try again.");
                scanneInput.nextLine();//skip the current stuck input.
            }
        }
        ;
        return input;
    }


    public static void main(String[] args) throws Exception {
        BST tree = new BST();
       /*
       Your pgm will use the following 20 Krone objects to be created in the exact order in your main to seed the tree:
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

        tree.insert(new Krone(57.12));
        tree.insert(new Krone(23.44));
        tree.insert(new Krone(87.43));
        tree.insert(new Krone(68.99));
        tree.insert(new Krone(111.22));
        tree.insert(new Krone(44.55));
        tree.insert(new Krone(77.77));
        tree.insert(new Krone(18.36));
        tree.insert(new Krone(543.21));
        tree.insert(new Krone(20.21));
        tree.insert(new Krone(345.67));
        tree.insert(new Krone(36.18));
        tree.insert(new Krone(48.48));
        tree.insert(new Krone(101.00));
        tree.insert(new Krone(11.00));
        tree.insert(new Krone(21.00));
        tree.insert(new Krone(51.00));
        tree.insert(new Krone(1.00));
        tree.insert(new Krone(251.00));
        tree.insert(new Krone(151.00));

        // After seeding the data, perform your traversal operations in the specific sequence of breadth-first, in-order, pre-order, post-order, ensuring that output is written out to both screen and file concurrently.

        tree.print4traversals(tree.getRoot(), true);


        Scanner sc = new Scanner(System.in);

        boolean isUserDone = false;
        while (!isUserDone) {
            String promptText = "\nSelect the operation you want to execute(1-5):\n -1: insert \n -2: search \n -3: delete \n -4: print all data \n -5: exit";
            int operationRequest = validateInputInt(promptText, sc, 1, 5);

            double key;
            switch (operationRequest) {
                case 1:
                    key = validateInputDouble("\nInput the number you want to insert into the tree:", sc, 0.00, Double.MAX_VALUE);
                    Krone temp = new Krone(key);
                    boolean result = tree.insert(temp);
                    tree.output(result ? "\nInsertion completed." : "\nInsertion failed. Value " + key + " is duplicated.", false);
                    break;
                case 2:
                    key = validateInputDouble("\nInput the number you are looking:", sc, 0.00, Double.MAX_VALUE);
                    temp = new Krone(key);
                    System.out.println(tree.search(temp) != null ? "The number is found in the tree." : "The number isn't found in the tree.");
                    break;
                case 3:
                    key = validateInputDouble("\nInput the number you want to delete :", sc, 0.00, Double.MAX_VALUE);
                    temp = new Krone(key);
                    boolean result2 = tree.delete(temp);
                    tree.output(result2 ? "\nThe " + key + " Krone is deleted." : "\nDeletion failed. The number isn't found in the tree.", false);
                    break;
                case 4:
                    tree.print4traversals(tree.getRoot(), false);
                    break;
                case 5:
                    tree.print4traversals(tree.getRoot(), true);
                    System.out.println("\nLeaving this program. Bye.");
                    sc.close();
                    isUserDone = true; //leaving
                    break;
            }
        }

    }
}