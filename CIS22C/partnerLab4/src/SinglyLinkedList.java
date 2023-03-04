// Raghava Krishna Katakam and Hsin Huei Li, we are in the in Person block.
// the lab number is 3
// This purpose of this assignment is to implement SinglyLinkedList,Queue and Stack with Currency objects, and do operations with those collection types.

public class SinglyLinkedList {
    private int count;
    private LinkNode start;
    private LinkNode end;

    public SinglyLinkedList() {
        this.count = 0;
        this.start = null;
        this.end = null;
    }


    /* Getters
     * pre: none
     * post: none
     * return: a attribute value from SinglyLinkedList 
     */
    public int getCount() {
        return count;
    }

    public LinkNode getHead() throws Exception {
        return start;
    }

    public LinkNode getTail() throws Exception {
        return end;
    }


    /*Function - insertAtFront - inserts a new node at the front of the list
     * pre: none
     * post: a new node is inserted at the front of the list
     */
     public void insertAtFront(Currency data) throws Exception {
        LinkNode newNode = new LinkNode(data);
        if (start == null) {
            start = newNode;
            end = newNode;
        } else {
            newNode.setNext(start);
            start = newNode;
        }
        count++;
    }

    /*Function - insertAtBack - inserts a new node at the back of the list
     * pre: none
     * post: a new node is inserted at the back of the list
     */
    public void insertAtBack(Currency data) throws Exception {
        LinkNode newNode = new LinkNode(data);
        if (start == null) {
            start = newNode;
        } else {
            end.setNext(newNode);
        }
        end = newNode;
        count++;
    }

    /*Function:- deleteAtFront - remove one Currency object at the front of the Linked List
     * pre: none
     * post: if the Linked List is empty, throw IndexOutOfBoundsException; else, remove the first items in the queue.
     * return: none
     */
    public void deleteAtFront() throws Exception {
        if (start == null) {
            throw new IndexOutOfBoundsException("List is empty");
        } else if (count == 1) {
            start = null;
            end = null;
            count--;
        } else {
            start = start.getNext();
            count--;
        }
    }

    /*Function: - deleteAtBack - remove one Currency object at the end of the Linked List
     * pre: none
     * post: if the Linked List is empty, throw IndexOutOfBoundsException, else, remove the first items in the Linked List.
     * return: none
     */
    public void deleteAtBack() throws Exception {
        if (start == null) {
            throw new IndexOutOfBoundsException("List is empty");
        } else if (count == 1) {
            start = null;
            end = null;
            count--;
        } else {
            LinkNode current = start;
            while (current.getNext() != end) {
                current = current.getNext();
            }
            current.setNext(null);
            end = current;
            count--;
        }
    }

    /*Function - insertAtPosition - inserts a new node at the specified position in the list
     * pre: none
     * post: a new node is inserted at the specified position in the list
     * return :none 
     */
    public void insertAtPosition(Currency data, int position) throws Exception {
        if (position < 0 || position > count) {
            throw new IndexOutOfBoundsException("Invalid position");
        } else if (position == 0) {
            insertAtFront(data);
        } else if (position == count) {
            insertAtBack(data);
        } else {
            LinkNode newNode = new LinkNode(data);
            LinkNode current = start;
            for (int i = 0; i < position - 1; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            count++;
        }
    }

    /*Function - deleteAtPosition - delete a node at the specified position in the list
     * pre: an index  
     * post: a node is deleted at the specified position in the list
     * return : the Currency object in the deleted node. 
     */
    public Currency deleteAtPosition(int position) throws Exception {
        Currency deleted;

        if (position < 0 || position >= count) {
            throw new IndexOutOfBoundsException("Invalid position");
        } else if (position == 0) {
            deleted = start.getData();
            deleteAtFront();
            return deleted;
        } else if (position == count - 1) {
            deleted = end.getData();
            deleteAtBack();
            return deleted;
        } else {
            LinkNode current = start;
            for (int i = 0; i < position - 1; i++) {
                current = current.getNext();
            }
            deleted = current.getNext().getData();
            current.setNext(current.getNext().getNext());
            count--;
            return deleted;
        }
    }


    /*Function - delete - deletes that Currency object from the list .
     * pre: a Currency object  
     * post: if the Currency object is found in the list, delete it. 
     * return : a copy of the Currency if the Currency object is found in the list, return null if it's not found.
     */
    public Currency delete(Currency currency) throws Exception {
        int index = find(currency);
        if (index != -1) {
            return deleteAtPosition(index);
        }

        return null;
    }

    /*Function - find -  returns the node index at which the Currency is found in the list.
     * pre: a Currency object  
     * post: check if the type and value of the Currency is the same as one of the Currencies in the list.
     * return : return the index at which the Currency is found, otherwise, return -1. 
     */
    public int find(Currency currency) throws Exception {
        LinkNode current = start;
        int position = 0;
        while (current != null) {
            boolean isEquals;
            try {
                isEquals = current.getData().isEquals(currency);
            } catch (Exception e) {
                continue;
            }
            if (isEquals) {
                return position;
            }
            current = current.getNext();
            position++;
        }
        return -1;
    }

    /*Function - getCurrency -  find and return the Currency object at a particular index in the list.
     * pre:an index values
     * post: check if the type and value of the Currency is the same as one of the Currencies in the list.
     * return : the Currency object at the particular index 
     */
    public Currency getCurrency(int index) throws Exception {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Invalid position");
        } else {
            LinkNode current = start;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            return current.getData();
        }
    }

    /*Function - printList - returns a string of all the Currency objects in the list in the order of index
     * pre: none
     * post: signifying the contents of the list, appends them to a StringBilder instance.
     * return: a String 
     */
    public String printList() throws Exception {
        StringBuilder result = new StringBuilder();
        LinkNode current = start;
        while (current != null) {
            result.append(current.getData().toString());
            result.append("\t");
            current = current.getNext();
        }
        return result.toString();
    }


    /*Function - isListEmpty - check if the list is empty or not
     * pre: none
     * post: check if the start is null or not 
     * return: returns true if the list is empty; return flase if it's not empty.
     */
    public boolean isListEmpty() {
        return start == null;
    }

    /*Function - countCurrency - count the number of a particular Currency in the list.
     * pre: a Currency object
     * post: if the Currency is found in the list, count it.  
     * return: return the count number
     */
    public int countCurrency( Currency currency){
        int count = 0;
        LinkNode current = start;
        while (current != null) {
            boolean isEquals;
            try {
                isEquals = current.getData().isEquals(currency);
            } catch (Exception e) {
                continue;
            }
            if (isEquals) {
                count++;
            }
            current = current.getNext();
        }
        return count;
    }
}
