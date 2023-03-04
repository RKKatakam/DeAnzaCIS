public class BSTNode {
    private BSTNode leftChild;
    private BSTNode rightChild;
    private Currency data;

    public BSTNode(Currency k){
        this.leftChild = null;
        this.rightChild = null;
        this.data = k;
    }

    /**
     * Function - gettters and setters
     *
     */
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

    public Currency getData() {
        return data;
    }

    public void setData(Currency data) {
        this.data = data;
    }


}
