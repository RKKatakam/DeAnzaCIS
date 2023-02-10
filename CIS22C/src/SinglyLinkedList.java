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

    public LinkNode getHead() {
        return head;
    }

    public LinkNode getTail() {
        return tail;
    }


    /*Function - insertAtFront - inserts a new node at the front of the list
     * pre: none
     * post: a new node is inserted at the front of the list
     */
    public void insertAtFront(Currency data) {
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
    public void insertAtBack(Currency data) {
        LinkNode newNode = new LinkNode(data);
        if (head == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
        count++;
    }

    protected void deleteAtFront() {
        if (head == null) {
            throw new IndexOutOfBoundsException("List is empty");
        } else {
            head = head.getNext();
            count--;
        }
    }

    protected void deleteAtBack() {
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
    public void insertAtPosition(Currency data, int position) {
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

    public void deleteAtPosition(int position) {
        if (position < 0 || position >= count) {
            throw new IndexOutOfBoundsException("Invalid position");
        } else if (position == 0) {
            deleteAtFront();
        } else if (position == count - 1) {
            deleteAtBack();
        } else {
            LinkNode current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
            count--;
        }
    }


    public void delete(Currency currency){
        LinkNode current = head;
        LinkNode previous = null;
        while(current != null){
            boolean isEquals = false;
           try {
                isEquals = current.getData().isEquals(currency);
           } catch (Exception e) {
              continue;
           }
            if(isEquals){
                if(previous == null){
                    deleteAtFront();
                }else{
                    previous.setNext(current.getNext());
                    count--;
                }
                break;
            }
            previous = current;
            current = current.getNext();
        }
    }

}
