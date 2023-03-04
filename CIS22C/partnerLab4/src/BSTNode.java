

public class BSTNode {
	private BSTNode leftChild;
	private BSTNode rightChild;
	private Krone data;
	
	protected BSTNode(Krone k){
		this.leftChild = null;
		this.rightChild = null;
		this.data = k;
	}

	public BSTNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BSTNode leftChild) {
		this.leftChild = leftChild;
	}

	public BSTNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(BSTNode rightChild) {
		this.rightChild = rightChild;
	}

	public Krone getData() {
		return data;
	}

	public void setData(Krone data) {
		this.data = data;
	}
	
	

}
