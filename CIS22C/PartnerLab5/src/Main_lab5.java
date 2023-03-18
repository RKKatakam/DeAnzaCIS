import java.util.Scanner;

public class Main_lab5 {

	public static void main(String[] args) {
		
		HashTable hashTable = new HashTable(29);
		
		hashTable.insert(new Krone(57.12));//index 5 
		hashTable.insert(new Krone(23.44));
		hashTable.insert(new Krone(87.43));
		hashTable.insert(new Krone(68.99));
		hashTable.insert(new Krone(111.22));
		hashTable.insert(new Krone(44.55));
		hashTable.insert(new Krone(77.77));
		hashTable.insert(new Krone(18.36));
		hashTable.insert(new Krone(543.21));
		hashTable.insert(new Krone(20.21));
		hashTable.insert(new Krone(345.67));
		hashTable.insert(new Krone(36.18));
		hashTable.insert(new Krone(48.48));
		hashTable.insert(new Krone(101.00));
		hashTable.insert(new Krone(11.00));
		hashTable.insert(new Krone(21.00));
		hashTable.insert(new Krone(51.00));
		hashTable.insert(new Krone(1.00));
		hashTable.insert(new Krone(251.00));
		hashTable.insert(new Krone(151.00));
		
		
		System.out.println("Total "+ hashTable.getNumOfItems() +" items in the HashTable.");
		System.out.print("Load factor : ");
		hashTable.printLoadFactor();
		System.out.print("\n");
		System.out.println("Accumulated number of collisions :"+ hashTable.getAccumulatedCollision());
		
		hashTable.printData();
		System.out.println("------------------------------------");
		
		
		
		
		//interactive part
	    Scanner sc = new Scanner(System.in);

        boolean isUserDone = false;
        while (!isUserDone) {
        	System.out.println("\nEnter the Krone value you are looking for, or enter q to exit: ");
        	String userInput = sc.nextLine();
        	if(userInput.equals("q")) {
        		isUserDone = true; 
        	}else {
        		try {
        			Double input = Double.parseDouble(userInput);
            		if(input >= 0) {
            			int index = hashTable.search(new Krone(input));
            			System.out.println(index<0? "The number isn't found in the HashTable.\n" : "The number is found at index "+index +"\n" );
            		}else {
            			System.out.println("Invalid input, please enter a positive double. ");
            		}
        		}catch(Exception e) {
        			System.out.println("Invalid input! please try again. ");
        		}

        	}
        }

        sc.close();
        System.out.println("Leaving this program.Bye.");

	}

}
