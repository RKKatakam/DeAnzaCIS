import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class BST {
    //Declare and implement a BST as a link-based ADT whose data will be Krone objects - the data will be inserted based on the actual money value of your Krone objects as a combination of the whole value and fractional value attributes.
    // For the BST, implement the four traversal methods as well as methods for the usual search, insert, delete, print, count, isEmpty, empty operations and any other needed.

    private BSTNode root;
    private int count;
    private PrintStream out;

    public BST() {
        root = null;
        count = 0;

        try {
            out = new PrintStream(new FileOutputStream("output.txt", false));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /*Fucntion - isEmpty - checks if the tree is empty
     *pre - none
     * post - returns true if the tree is empty, false otherwise
     */
    public boolean isEmpty() {
        return root == null;
    }

    /*Function - getters
     */
    public int getCount() {
        return count;
    }

    public BSTNode getRoot() {
        return root;
    }


    /*Function - search - searches the tree for a node with the given key
     *pre - key is the key to search for
     * post - returns the node with the given key or null if not found
     */
    public Currency search(Krone krone) {
        if (root == null) {
            return null;
        }

        if (root.getData().isEquals(krone)) {
            return root.getData();
        }

        while (root != null) {
            if (root.getData().isEquals(krone)) {
                return root.getData();
            } else if (root.getData().getValue() - krone.getValue() > 0) {
                root = root.getLeftChild();
            } else {
                root = root.getRightChild();
            }
        }

        return null;
    }

    /*Function - insert - inserts a node with the given key into the tree
     *pre - key is the key to insert
     * post - returns true if the key was inserted, false if it was already in the tree
     */
    public boolean insert(Krone krone) {
        if (root == null) {
            root = new BSTNode(krone);
            count++;
            return true;
        }

        BSTNode current = root;
        BSTNode parent = null;

        while (current != null) {
            if (current.getData().isEquals(krone)) {
                return false;
            } else if (current.getData().getValue() - krone.getValue() > 0) {
                parent = current;
                current = current.getLeftChild();
            } else {
                parent = current;
                current = current.getRightChild();
            }
        }

        if (parent.getData().getValue() - krone.getValue() > 0) {
            parent.setLeftChild(new BSTNode(krone));
        } else {
            parent.setRightChild(new BSTNode(krone));
        }

        count++;
        return true;
    }

    /*Function - delete - deletes a node with the given key from the tree
     *pre - key is the key to delete
     * post - returns true if the key was deleted, false if it was not in the tree
     */
    public boolean delete(Krone krone) {
        BSTNode current = root;
        BSTNode parent = null;
        boolean isLeftChild = false;

        // if root is krone
        if (root.getData().isEquals(krone)) {
            if (root.getLeftChild() == null && root.getRightChild() == null) {
                root = null;
            } else if (root.getLeftChild() == null) {
                root = root.getRightChild();
            } else if (root.getRightChild() == null) {
                root = root.getLeftChild();
            } else {
                root = deleteNodeWithBothChild(root);
            }
            count--;
            return true;
        }

        // Find the node to delete
        while (current != null) {
            if (current.getData().isEquals(krone)) {
                break;
            } else if (current.getData().getValue() - krone.getValue() > 0) {
                parent = current;
                current = current.getLeftChild();
                isLeftChild = true;
            } else {
                parent = current;
                current = current.getRightChild();
                isLeftChild = false;
            }
        }

        if (current == null) {
            return false;
        }


        if (current.getLeftChild() == null && current.getRightChild() == null) { // If the node to delete has no child
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.setLeftChild(null);
            } else {
                assert parent != null;
                parent.setRightChild(null);
            }
        } else if (current.getLeftChild() == null) { // If the node to delete has only Left child
            if (current == root) {
                root = current.getRightChild();
            } else if (isLeftChild) {
                parent.setLeftChild(current.getRightChild());
            } else {
                assert parent != null;
                parent.setRightChild(current.getRightChild());
            }
        } else if (current.getRightChild() == null) { // If the node to delete has only Right child
            if (current == root) {
                root = current.getLeftChild();
            } else if (isLeftChild) {
                parent.setLeftChild(current.getLeftChild());
            } else {
                assert parent != null;
                parent.setRightChild(current.getLeftChild());
            }
        } else { // If the node to delete has both Left and Right child
            BSTNode successor = deleteNodeWithBothChild(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.setLeftChild(successor);
            } else {
                assert parent != null;
                parent.setRightChild(successor);
            }
        }

        count--;
        return true;
    }

    /*Function - deleteNodeWithBothChild - deletes a node with both child
     *pre - current is the node to delete
     * post - returns the successor of the node to delete
     */
    private BSTNode deleteNodeWithBothChild(BSTNode current) {
        BSTNode successor = current.getRightChild();
        if (successor.getLeftChild() == null) {
            successor.setLeftChild(current.getLeftChild());
        } else {
            BSTNode successorParent = successor;
            while (successor.getLeftChild() != null) {
                successorParent = successor;
                successor = successor.getLeftChild();
            }
            successorParent.setLeftChild(successor.getRightChild());
            successor.setLeftChild(current.getLeftChild());
            successor.setRightChild(current.getRightChild());
        }

        return successor;
    }

    /*Function - printInOrder - prints the tree in order
     *pre - Krone object to look for
     *   - boolean to print to file or not
     * post - the tree is printed in order
     */
    private BSTNode getNode(Krone krone) {
        BSTNode current = root;
        while (current != null) {
            if (current.getData().isEquals(krone)) {
                return current;
            } else if (current.getData().getValue() - krone.getValue() > 0) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }
        return null;
    }

    /*Function - printInOrder - prints the tree in order
     *pre - BstNode object to start from
     *   - boolean to print to file or not
     * post - the tree is printed in breadth First order
     */
    public void printBreadthFirstOrder(BSTNode node, boolean printToFall) throws Exception {
        if (node == null) {
            return;
        }

        Queue queue = new Queue();
        queue.enqueue(node.getData());

        while (!queue.isListEmpty()) {
            BSTNode current = getNode(new Krone(queue.dequeue().getValue()));
            assert current != null;
            output(current.getData().toString(), printToFall);
            if (current.getLeftChild() != null) {
                queue.enqueue(current.getLeftChild().getData());
            }
            if (current.getRightChild() != null) {
                queue.enqueue(current.getRightChild().getData());
            }
        }

    }

    /*Function - printInOrder - prints the tree in order
     *pre - BstNode object to start from
     *    - boolean to print to file or not
     * post - the tree is printed in order
     */
    public void printInOrder(BSTNode node, boolean printToFile) {
        if (node == null) {
            return;
        }
        printInOrder(node.getLeftChild(), printToFile);
        output(node.getData().toString(), printToFile);
        printInOrder(node.getRightChild(), printToFile);
    }

    /*Function - printPreOrder - prints the tree in pre order
     *pre - BstNode object to start from
     *    - boolean to print to file or not
     * post - the tree is printed in pre order
     */
    public void printPreOrder(BSTNode node, boolean printToFile) {
        if (node == null) {
            return;
        }
        output(node.getData().toString(), printToFile);
        printPreOrder(node.getLeftChild(), printToFile);
        printPreOrder(node.getRightChild(), printToFile);
    }

    /*Function - printPostOrder - prints the tree in post order
     *pre - BstNode object to start from
     * post - the tree is printed in post order
     */
    public void printPostOrder(BSTNode node, boolean printToFile) {
        if (node == null) {
            return;
        }
        printPostOrder(node.getLeftChild(), printToFile);
        printPostOrder(node.getRightChild(), printToFile);
        output(node.getData().toString(), printToFile);
    }

    /*Function - print4traversals - prints the tree in breadth first, in order, pre order and post order
     *pre - BstNode object to start from
     *    - boolean to print to file or not
     * post - the tree is printed in breadth first, in order, pre order and post order
     */
    public void print4traversals(BSTNode node, boolean printToFile) throws Exception {
        //breadth-first
        output("\n--------Breadth-first--------", printToFile);
        printBreadthFirstOrder(node, printToFile);
        //in-order
        output("\n--------In-order--------", printToFile);
        printInOrder(node, printToFile);
        //pre-order
        output("\n--------pre-order--------", printToFile);
        printPreOrder(node, printToFile);
        //post-order
        output("\n--------post-order--------", printToFile);
        printPostOrder(node, printToFile);
    }


    /*Function - output - prints the tree in breadth first, in order, pre order and post order
     *pre - BstNode object to start from
     *    - boolean to print to file or not
     * post - the tree is printed in breadth first, in order, pre order and post order
     */
    public void output(String msg, boolean printToFile) {
        System.out.println(msg);
        if (printToFile) {
            out.println(msg); //PrintStream object
        }

    }
};