public class Stack extends SinglyLinkedList {
    public Stack() {
        super();
    }
    public void push(Currency data) {
        insertAtFront(data);
    }
    public Currency pop() {
        Currency data = getHead().getData().clone();
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
