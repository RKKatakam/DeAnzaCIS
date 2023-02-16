public class Stack extends SinglyLinkedList {
    public Stack() {
        super();
    }
    public void push(Currency data) throws Exception {
        super.insertAtFront(data);
    }
    public Currency pop() throws Exception {
        Currency data = super.getHead().getData().clone();
        super.deleteAtFront();
        return data;
    }

    public Currency peek() throws Exception {
       return super.getHead().getData().clone();
    }

    @Override
    public LinkNode getHead() throws Exception {
        throw new Exception("can't use from Stack");
    }

    @Override
    public LinkNode getTail() throws Exception {
        throw new Exception("can't use from Stack");
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



    public String printStack() throws Exception {
        return super.printList();
    }
}
