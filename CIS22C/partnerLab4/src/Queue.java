// Raghava Krishna Katakam and Hsin Huei Li, we are in the in Person block.
// the lab number is 3
// This purpose of this assignment is to implement SinglyLinkedList,Queue and Stack with Currency objects, and do operations with those collection types.

public class Queue extends SinglyLinkedList {


    public Queue() {
        super();
    }
    
    
    public boolean isQueueEmpty() throws Exception {
    	return getHead()== null;
    }

   /*Function:- enqueue - adds one Currency object at the end of the Queue
     * pre: takes a Currency object as parameter 
     * post: call a parent function insertAtBack() and passes the Currency object to it.
     * return: none
     */
    public void enqueue(Currency data) throws Exception {
        super.insertAtBack(data);
    }

    /*Function:- dequeue - remove one Currency object at the top of the Queue
     * pre: none
     * post: call parent functions to get the data from the top item, then call in parent function deleteAtFront() to remove it. 
     * return: a copy of data in the Currency object
     */
    public Currency dequeue() throws Exception {    	
        Currency data = this.getHead().getData().clone();
        super.deleteAtFront();
        return data;
    }


    /*Function:- peekFront - returns a copy of the Currency object at the top of the Queue.
     * pre: none
     * post: get the Currency object and clone it.
     * return: a copy of the Currency object
     */
    public Currency peekFront() throws Exception {
        return super.getHead().getData().clone();
    }

      /*Function:- peekRear - returns a copy of the Currency object at the end of the Queue.
     * pre: none
     * post: get the Currency object and clone it.
     * return: a copy of the Currency object
     */
    public Currency peekRear() throws Exception {
        return super.getTail().getData().clone();
    }

    /*Function - printQueue - returns a string of all the Currency objects of the Queue from front to end.
     * pre: none
     * post: calls parent function printList();
     * return: a String 
     */
    public String printQueue() throws Exception {
        return super.printList();
    }



   /* Function: - insertAtFront - a overriding funtion, throw Exception if it's called by a Queue object. 
     * pre: none
     * post: throw Exception if it's called by a Queue object. 
     * return: none 
     */
    @Override
    public void insertAtFront(Currency data) throws Exception {
        throw new Exception("can't use from Queue");
    }

   /* Function: - insertAtBack - a overriding funtion, throw Exception if it's called by a Queue object. 
     * pre: none
     * post: throw Exception if it's called by a Queue object. 
     * return: none 
     */
    @Override
    public void insertAtBack(Currency data) throws Exception {
        throw new Exception("can't use from Queue");
    }

   /* Function: - deleteAtFront - a overriding funtion, throw Exception if it's called by a Queue object. 
     * pre: none
     * post: throw Exception if it's called by a Queue object. 
     * return: none 
     */
    @Override
    public void deleteAtFront() throws Exception {
        throw new Exception("can't use from Queue");
    }

   /* Function: - deleteAtBack - a overriding funtion, throw Exception if it's called by a Queue object. 
     * pre: none
     * post: throw Exception if it's called by a Queue object. 
     * return: none 
     */
    @Override
    public void deleteAtBack() throws Exception {
        throw new Exception("can't use from Queue");
    }


   /* Function: - insertAtPosition - a overriding funtion, throw Exception if it's called by a Queue object. 
     * pre: none
     * post: throw Exception if it's called by a Queue object. 
     * return: none 
     */
    @Override
    public void insertAtPosition(Currency data, int position) throws Exception {
        throw new Exception("can't use from Queue");
    }


   /* Function: - deleteAtPosition - a overriding funtion, throw Exception if it's called by a Queue object. 
     * pre: none
     * post: throw Exception if it's called by a Queue object. 
     * return: none 
     */
    @Override
    public Currency deleteAtPosition(int position) throws Exception {
        throw new Exception("can't use from Queue");
    }

   /* Function: - delete - a overriding funtion, throw Exception if it's called by a Queue object. 
     * pre: none
     * post: throw Exception if it's called by a Queue object. 
     * return: none 
     */
    @Override
    public Currency delete(Currency currency) throws Exception {
        throw new Exception("can't use from Queue");
    }

   /* Function: - find - a overriding funtion, throw Exception if it's called by a Queue object. 
     * pre: none
     * post: throw Exception if it's called by a Queue object. 
     * return: none 
     */
    @Override
    public int find(Currency currency) throws Exception {
        throw new Exception("can't use from Queue");
    }

   /* Function: - getCurrency - a overriding funtion, throw Exception if it's called by a Queue object. 
     * pre: none
     * post: throw Exception if it's called by a Queue object. 
     * return: none 
     */
    @Override
    public Currency getCurrency(int index) throws Exception {
        throw new Exception("can't use from Queue");
    }

   /* Function: - printList - a overriding funtion, throw Exception if it's called by a Queue object. 
     * pre: none
     * post: throw Exception if it's called by a Queue object. 
     * return: none 
     */
    @Override
    public String printList() throws Exception {
        throw new Exception("can't use from Queue");
    }


}
