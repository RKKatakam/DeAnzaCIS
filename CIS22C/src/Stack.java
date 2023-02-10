/*constructor and createStack (optional) methods,
        push which takes a Currency object as parameter and adds it to the top of the stack.
        pop which takes no parameter and removes and returns the Currency object from the top of the stack.
        peek which takes no parameter and returns a copy of the Currency object at the top of the stack.
        printStack method which returns a string signifying the contents of the stack from the top to bottom, tab spaced.
        destructor and/or destroyStack (optional) methods.
        Ensure that the Stack objects do not allow Linked List functions to be used on them.*/
public class Stack extends SinglyLinkedList {
    public Stack() {
        super();
    }
    public void push(Currency data) {
        insertAtFront(data);
    }
    public Currency pop() {
        Currency data = getHead().getData();
        deleteAtFront();
        return data;
    }

    public Currency peek() {
       return getHead().getData().clone();
    }


    public String printStack() {
        StringBuilder result = new StringBuilder();
        LinkNode current = getHead();
        while (current != null) {
            result.append(current.getData().toString()).append("\t");
            current = current.getNext();
        }
        return result.toString();
    }
}
