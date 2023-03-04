

import java.util.Scanner;

public class Main_lab4 {
	
	
	public static int validateInputInt(String promptText, Scanner scanneInput, int minimum , int maximum) {
		boolean isInputDone = false; 
		int input=0;
		
		//validate the user input 
		while(!isInputDone){
			try {
				System.out.printf(promptText);
				input = scanneInput.nextInt();
				 
				 if(input>=minimum && input <= maximum) {// the input is within the valid range
					isInputDone = true;
				 }else{
					System.out.printf("Allowed range: %d - %d.\n",minimum,maximum); 
				 }	 
			}catch(Exception e){
				System.out.println("Oops!Wrong data type. Try again.");
				scanneInput.nextLine();//skip the current stuck input. 
			}
		};
		return input;
	}
	
	public static double validateInputDouble(String promptText, Scanner scanneInput, double minimum , double maximum) {	
		boolean isInputDone = false; 
		double input=0;

		//validate the user input 
		while(!isInputDone){
			try {
				System.out.printf(promptText);
				input = scanneInput.nextDouble();
				 
				 if(input>=minimum && input <= maximum) {//the input is within the valid range
					isInputDone = true;
				 }else{
					if(maximum == Double.MAX_VALUE) {
						System.out.printf("Allowed range: > %.2f \n",minimum); 
					}else {
						System.out.printf("Allowed range: %f - %f\n",minimum,maximum); 
					}
					
				 }	 
			}catch(Exception e){
				System.out.println("Oops!Wrong data type. Try again.");
				scanneInput.nextLine();//skip the current stuck input. 
			}
		};
		return input;
	}
	
	
	

	public static void main(String[] args) throws Exception {
		
		Krone[] kroneArray = new Krone[20];
		 
        kroneArray[0] = new Krone(57.12);
        kroneArray[1] = new Krone(23.44);
        kroneArray[2] = new Krone(87.43);
        kroneArray[3] = new Krone(68.99);
        kroneArray[4] = new Krone(111.22);
        kroneArray[5] = new Krone(44.55);
        kroneArray[6] = new Krone(77.77);
        kroneArray[7] = new Krone(18.36);
        kroneArray[8] = new Krone(543.21);
        kroneArray[9] = new Krone(20.21);
        kroneArray[10] = new Krone(345.67);
        kroneArray[11] = new Krone(36.18);
        kroneArray[12] = new Krone(48.48);
        kroneArray[13] = new Krone(101.00);
        kroneArray[14] = new Krone(11.00);
        kroneArray[15] = new Krone(21.00);
        kroneArray[16] = new Krone(51.00);
        kroneArray[17] = new Krone(1.00);
        kroneArray[18] = new Krone(251.00);
        kroneArray[19] = new Krone(151.00);
        
        
        System.out.println( kroneArray[19]);
       
		
        //seed the tree
		BST tree = new BST();
		for(int i = 0; i<20;i++) {
			tree.insert(kroneArray[i]);
		}

		
		tree.print4travesals(tree.getRoot());
	
		//interactivity for user to insert/search/delete/print/quit. 
		Scanner sc = new Scanner(System.in);
		
		boolean isUserDone = false;
		while(!isUserDone) {
			String promptText= "\nSelect the operation you want to execute(1-5):\n -1: insert \n -2: search \n -3: delete \n -4: print all data \n -5: exit";
			int operationRequest = validateInputInt(promptText, sc, 1, 5) ;
			
			double key;
			switch(operationRequest) {
				case 1: key = validateInputDouble("\nInput the number you want to insert into the tree:", sc, 0.00, Double. MAX_VALUE);
						boolean result = tree.insert(new Krone(key));
						tree.output(result ? "\nInsertion completed.": "\nInsertion failed. Value "+ key +" is duplicated.");
						break;
				case 2: key = validateInputDouble("\nInput the number you are looking:", sc, 0.00, Double. MAX_VALUE);
						System.out.println(tree.search(key)!=null ? "The number is found in the tree.": "The number isn't found in the tree.");
						break;
				case 3: key = validateInputDouble("\nInput the number you want to delete :", sc, 0.00, Double. MAX_VALUE);
						boolean result2 = tree.delete(key);
						tree.output(result2 ? "\nThe "+ key + " Krone is deleted.": "\nDeletion failed. The number isn't found in the tree.");
						break;
				case 4: tree.print4travesals(tree.getRoot());
						break;
				case 5: tree.print4travesals(tree.getRoot());
						System.out.println("\nLeaving this program. Bye.");
						sc.close();
						isUserDone = true; //leaving
						break;
			} 
		}
	}

}
