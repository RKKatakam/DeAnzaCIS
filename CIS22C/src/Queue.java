public class Queue {
    private final SinglyLinkedList queue;

    public Queue() {
        queue = new SinglyLinkedList();
    }

    public void enqueue(Currency data) {
        queue.insertAtBack(data);
    }

    public Currency dequeue() {
        Currency data = queue.getHead().getData().clone();
        queue.deleteAtFront();
        return data;
    }

    public Currency peekFront() {
        return queue.getHead().getData().clone();
    }

    public Currency peekRear() {
        return queue.getTail().getData().clone();
    }

    public String printQueue() {
        StringBuilder result = new StringBuilder();
        LinkNode current = queue.getHead();
        while (current != null) {
            result.append(current.getData().toString());
            result.append("\t");
            current = current.getNext();
        }
        return result.toString();
    }
}
