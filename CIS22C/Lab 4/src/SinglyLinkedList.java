public class SinglyLinkedList {
    private int count;
    private LinkNode head;
    private LinkNode tail;

    public SinglyLinkedList() {
        this.count = 0;
        this.head = null;
        this.tail = null;
    }

    public int getCount() {
        return count;
    }

    public LinkNode getHead() throws Exception {
        return head;
    }

    public LinkNode getTail() throws Exception {
        return tail;
    }


    /*Function - insertAtFront - inserts a new node at the front of the list
     * pre: none
     * post: a new node is inserted at the front of the list
     */
     public void insertAtFront(Currency data) throws Exception {
        LinkNode newNode = new LinkNode(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
        count++;
    }

    /*Function - insertAtBack - inserts a new node at the back of the list
     * pre: none
     * post: a new node is inserted at the back of the list
     */
    public void insertAtBack(Currency data) throws Exception {
        LinkNode newNode = new LinkNode(data);
        if (head == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        count++;
    }

    public void deleteAtFront() throws Exception {
        if (head == null) {
            throw new IndexOutOfBoundsException("List is empty");
        } else {
            head = head.getNext();
            count--;
        }
    }

    public void deleteAtBack() throws Exception {
        if (head == null) {
            throw new IndexOutOfBoundsException("List is empty");
        } else if (count == 1) {
            head = null;
            tail = null;
            count--;
        } else {
            LinkNode current = head;
            while (current.getNext() != tail) {
                current = current.getNext();
            }
            current.setNext(null);
            tail = current;
            count--;
        }
    }

    /*Function - insertAtPosition - inserts a new node at the specified position in the list
     * pre: none
     * post: a new node is inserted at the specified position in the list
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
            LinkNode current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            count++;
        }
    }

    public Currency deleteAtPosition(int position) throws Exception {
        Currency deleted;

        if (position < 0 || position >= count) {
            throw new IndexOutOfBoundsException("Invalid position");
        } else if (position == 0) {
            deleted = head.getData();
            deleteAtFront();
            return deleted;
        } else if (position == count - 1) {
            deleted = tail.getData();
            deleteAtBack();
            return deleted;
        } else {
            LinkNode current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.getNext();
            }
            deleted = current.getNext().getData();
            current.setNext(current.getNext().getNext());
            count--;
            return deleted;
        }
    }


    public Currency delete(Currency currency) throws Exception {
        int index = find(currency);
        if (index != -1) {
            return deleteAtPosition(index);
        }

        return null;
    }

    public int find(Currency currency) throws Exception {
        LinkNode current = head;
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

    public Currency getCurrency(int index) throws Exception {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Invalid position");
        } else {
            LinkNode current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            return current.getData();
        }
    }

    public String printList() throws Exception {
        StringBuilder result = new StringBuilder();
        LinkNode current = head;
        while (current != null) {
            result.append(current.getData().toString());
            result.append("\t");
            current = current.getNext();
        }
        return result.toString();
    }

    public boolean isListEmpty() {
        return head == null;
    }

    public int countCurrency( Currency currency){
        int count = 0;
        LinkNode current = head;
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
