// Raghava Krishna Katakam and Hsin Huei Li, we are in the in Person block.
// the lab number is 3
// This purpose of this assignment is to implement SinglyLinkedList,Queue and Stack with Currency objects, and do operations with those collection types.


public class LinkNode {
    private Currency data;
    private LinkNode next;

    public LinkNode(Currency data) {
        this.data = data;
        this.next = null;
    }

    /* Getters
     * pre: none
     * post: none
     * return: a attribute value from LinkNode 
     */
    public Currency getData() {
        return data;
    }


    public LinkNode getNext() {
        return next;
    }

    /* Setter
     * pre: an object of Currency
     * post: assign the argument to the data attribute 
     * return: none
     */
    public void setData(Currency data) {
        this.data = data;
    }

    /* Setter
     * pre: an object of LinkNode
     * post: assign the argument to the next attribute 
     * return: none 
     */
    public void setNext(LinkNode next) {
        this.next = next;
    }
}
