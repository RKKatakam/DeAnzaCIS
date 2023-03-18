
public class HashTable {
	
	private int size;
	private Krone[] table; 
	private int numOfItems = 0;
	private double loadFactor; 
	private int accumulatedCollision = 0;
	
//	boolean debug = true;
	
	//getters  
	public int getSize() {
		return size;
	}

	public int getNumOfItems() {
		return numOfItems;
	}

	public double getLoadFactor() {
		return loadFactor;
	}

	public Krone[] getTable() {
		return table;
	}
	
	public int getAccumulatedCollision() {
		return accumulatedCollision;
	}

	//constructor 
	HashTable(int size){
		this.size = size;
		this.table = new Krone[size];
	}
	
	//return time of collision during the insertion.
	public int insert(Krone data){
		int index= pseudorandomFunction(data.getWholePart(), data.getFractionalPart());
		int iterationNum = 0;
		
		boolean isDone= false;
		while(!isDone){
			if(table[index]==null){  //empty buckets, insert data.
				table[index]= data;
				numOfItems++;
				double sizeD = size;
				loadFactor = numOfItems/sizeD;
				isDone = true; //inserted
			}else{					//non-empty buckets. open addressing.
				iterationNum++;
				index = quadraticFunction(index,iterationNum);
			}
		}
//		if(debug) {
//			System.out.println("number: "+ data.getValue());
//			System.out.println("no of collision: "+ iterationNum);
//			System.out.println("final index: "+ index);
//		}
		accumulatedCollision = accumulatedCollision + iterationNum;
		return iterationNum;
	}

	//return the index of the target items if it's found, other wise, return -1. 
	public int search(Krone data){
		int index = pseudorandomFunction(data.getWholePart(),data.getFractionalPart());
		int iterationNum = 0;
		
		boolean isDone = false;
		while(!isDone) {
			if(table[index]==null) {
				index = -1; //not found
				isDone = true;
			}else if(table[index].isEquals(data)){
				isDone = true; // found
			}else {
				iterationNum++;
				index = quadraticFunction(index,iterationNum); 
			}
		}
		return index;
		
	}

	//hash function 
	public int pseudorandomFunction(int whole, int fraction){
		//  (m*w +  n*f) % size - where size = 29, m = 2, n = 3, w = whole value, f = fractional value.
		int index= (2*whole + 3*fraction) % size;
		return index;
	}
	
	//handling collision
	public int quadraticFunction(int index, int iterationNum) {
		 return (index+iterationNum*iterationNum)%size;
	}
	
	public void printLoadFactor() {
		System.out.printf("%.2f%%", loadFactor);
	}

	
	public void printData() {
		for(int i=0; i<table.length;i++) {
			if(table[i]!= null){
				System.out.println(i+" "+table[i].getValue());
			}else {
				System.out.println(i+" is null");
			}
		}
	}
		
		
		

}
