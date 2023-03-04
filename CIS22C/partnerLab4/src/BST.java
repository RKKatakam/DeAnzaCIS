
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class BST {
	private BSTNode root;
	private PrintStream out;
	
	public BST(){
		this.root = null;
		try {
			this.out = new PrintStream(new FileOutputStream("./output.txt",true));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	


	public BSTNode getRoot() {
		return root;
	}

	public void setRoot(BSTNode root) {
		this.root = root;
	}


	/*
	 * search the tree for a node with the given key
	 *
	 */
	public BSTNode search(double key){
		BSTNode curNode = root;
	   while (curNode != null) {
	      if (key == curNode.getData().actualValue()) {
	         return curNode ;// Found
	      }
	      else if (key < curNode.getData().actualValue()) {
	    	  curNode = curNode.getLeftChild();
	      }
	      else {
	    	  curNode = curNode.getRightChild();
	      }
	   }
	   return null; // Not found
	}


	public boolean insert(Krone krone) { //not allow duplication 
		BSTNode curNode = root;
		
		if(curNode == null) { //empty tree
			BSTNode newNode = new BSTNode(krone);
			this.root = newNode;
			return true;
		}
		while(curNode!=null) {
			if(krone.actualValue() < curNode.getData().actualValue()) { //smaller 
				if(curNode.getLeftChild()== null) { //no left child
					BSTNode newNode = new BSTNode(krone);
					curNode.setLeftChild(newNode);
					curNode = null;
					return true;
				}else {
					curNode = curNode.getLeftChild();
				}
			}else if(krone.actualValue() > curNode.getData().actualValue()) { //bigger 
				if(curNode.getRightChild()== null) { //no right child
					BSTNode newNode = new BSTNode(krone);
					curNode.setRightChild(newNode);
					curNode = null;
					return true;
				}else {
					curNode = curNode.getRightChild();
				}
			}else {
				curNode = null; //duplicated key -> leaving 
			}
		}
		
		return false;
	}
	
	public boolean delete(double key) {
		BSTNode parent = null;
		BSTNode curNode = root;
		while (curNode!=null) { // Search for node
	      if (curNode.getData().actualValue() == key) { // Node found 
	         if (curNode.getLeftChild()==null &&  curNode.getRightChild()==null) { // Remove leaf
	            if (parent == null) // Node is root
	               root = null;
	            else if (parent.getLeftChild() == curNode) 
	            	parent.setLeftChild(null);
	            else
	            	parent.setRightChild(null);
	         }
	         else if (curNode.getRightChild()==null) {                // Remove node with only left child
	            if (parent==null) // Node is root
	               root = curNode.getLeftChild();
	            else if (parent.getLeftChild() == curNode) 
	            	parent.setLeftChild(curNode.getLeftChild());
	            else
	            	parent.setRightChild(curNode.getLeftChild());
	         }
	         else if (curNode.getLeftChild() == null) {                // Remove node with only right child
	            if (parent== null) // Node is root
	               root = curNode.getRightChild();
	            else if (parent.getLeftChild() == curNode) 
	               parent.setLeftChild(curNode.getRightChild()); 
	            else
	               parent.setRightChild(curNode.getRightChild());
	         }
	         else {                                      // Remove node with two children
	            // Find successor (leftmost child of right subtree)
	        	 BSTNode suc = curNode.getRightChild();
	            while (suc.getLeftChild()!=null) {
	               suc = suc.getLeftChild();
	            }
	            
	            double successorData = suc.getData().actualValue();
	            delete(successorData);     // Remove the successor
	            curNode.setData(new Krone(successorData)); 
	         }
	         return true;// Node found and removed
	      }
	      else if (curNode.getData().actualValue() < key) { // Search right
	         parent = curNode;
	         curNode = curNode.getRightChild();
	      }
	      else {                     // Search left
	    	 parent = curNode;
	    	 curNode = curNode.getLeftChild();
	      }
	   }
	 
		   return false; // Node not found

	}

	
	public void printBreadthFirstOrder(BSTNode node) throws Exception {
		Queue queue = new Queue();
		BSTNode curNode = node;
		
		if(curNode == null) {
			return;
		}
		
		queue.enqueue(curNode.getData());
		
		while(!queue.isListEmpty()) {
			double value = queue.peekFront().actualValue();
			//find the BSTNode 
			curNode = search(value);
			
			if(curNode.getLeftChild()!=null) {
				queue.enqueue(curNode.getLeftChild().getData());
			}
			if(curNode.getRightChild()!=null) {
				queue.enqueue(curNode.getRightChild().getData());
			}	
	
			output(queue.dequeue());
		}
	}
	
	public void printInOrder(BSTNode node) {
		if(node == null) {
			return;
		}
		printInOrder(node.getLeftChild());
		output(node.getData());
		printInOrder(node.getRightChild());
	}
	
	public void printPreOrder(BSTNode node) {
		if(node == null) {
			return;
		}
		output(node.getData());
		printPreOrder(node.getLeftChild());
		printPreOrder(node.getRightChild());
	}
	
	public void printPostOrder(BSTNode node) {
		if(node == null) {
			return;
		}
		printPostOrder(node.getLeftChild());
		printPostOrder(node.getRightChild());
		output(node.getData());
	}
	
	
	//count how many nodes in a tree
	public int count(BSTNode node) throws Exception {
		int count =0;
		
		Queue queue = new Queue();
		
		if(node == null) {
			return 0;
		}
		
		queue.enqueue(node.getData());
		count++;
		while(!queue.isListEmpty()) {
			double value = queue.peekFront().actualValue();
			//find the BSTNode 
			node = search(value);
			
			if(node.getLeftChild()!=null) {
				queue.enqueue(node.getLeftChild().getData());
				count++;
			}
			if(node.getRightChild()!=null) {
				queue.enqueue(node.getRightChild().getData());
				count++;
			}	
			queue.dequeue();
		}
		return count;
	}
	
	
	
	public boolean isEmpty() {
		return root ==null;
	}
	
	
	public void empty() {
		root = null;
	}
	
	public void print4travesals(BSTNode node) throws Exception {
		//breadth-first
		output("\n--------Breadth-first--------");
		printBreadthFirstOrder(node);
		//in-order
		output("\n--------In-order--------");
		printInOrder(node);
		//pre-order
		output("\n--------pre-order--------");
		printPreOrder(node);
		//post-order
		output("\n--------post-order--------");
		printPostOrder(node);
	}
	
	
	//print the data both to the console and to the text file. 
	public <T> void output(final T msg) {        
	    System.out.println(msg);
	    out.println(msg); //PrintStream object
	}

	
}
