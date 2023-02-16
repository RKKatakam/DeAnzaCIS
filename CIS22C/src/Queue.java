public class Queue extends SinglyLinkedList {


    public Queue() {
        super();
    }

    public void enqueue(Currency data) throws Exception {
        super.insertAtBack(data);
    }

    public Currency dequeue() throws Exception {
        Currency data = this.getHead().getData().clone();
        super.deleteAtFront();
        return data;
    }

    @Override
    public void insertAtFront(Currency data) throws Exception {
        throw new Exception("can't use from Stack");
    }

    @Override
    public void insertAtBack(Currency data) throws Exception {
        throw new Exception("can't use from Stack");
    }


    @Override
    public void deleteAtFront() throws Exception {
        throw new Exception("can't use from Stack");
    }

    @Override
    public void deleteAtBack() throws Exception {
        throw new Exception("can't use from Stack");
    }

    @Override
    public void insertAtPosition(Currency data, int position) throws Exception {
        throw new Exception("can't use from Stack");
    }

    @Override
    public Currency deleteAtPosition(int position) throws Exception {
        throw new Exception("can't use from Stack");
    }


    @Override
    public Currency delete(Currency currency) throws Exception {
        throw new Exception("can't use from Stack");
    }


    @Override
    public int find(Currency currency) throws Exception {
        throw new Exception("can't use from Stack");
    }

    @Override
    public Currency getCurrency(int index) throws Exception {
        throw new Exception("can't use from Stack");
    }

    @Override
    public String printList() throws Exception {
        throw new Exception("can't use from Stack");
    }

    public Currency peekFront() throws Exception {
        return super.getHead().getData().clone();
    }

    public Currency peekRear() throws Exception {
        return super.getTail().getData().clone();
    }

    public String printQueue() throws Exception {
        return super.printList();
    }
}
