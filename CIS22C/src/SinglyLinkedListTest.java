import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    @Test
    void insertAtFront() {
        SinglyLinkedList list = new SinglyLinkedList();
        assertNull(list.getHead());


        list.insertAtFront(new Krone(1.43));
        list.insertAtFront(new Krone(1.44));
        list.insertAtFront(new Krone(1.45));
        list.insertAtFront(new Krone(1.46));

        assertEquals(1, list.getHead().getData().getWholePart());
        assertEquals(46, list.getHead().getData().getFractionalPart());

        assertEquals(4, list.getCount());
    }

    @Test
    void insertAtBack() {
        SinglyLinkedList list = new SinglyLinkedList();


        list.insertAtBack(new Krone(1.43));
        assertEquals(1, list.getHead().getData().getWholePart());
        assertEquals(43, list.getHead().getData().getFractionalPart());

        list.insertAtFront(new Krone(1.44));
        list.insertAtFront(new Krone(1.45));
        list.insertAtFront(new Krone(1.46));
        list.insertAtBack(new Krone(3.47));

        assertEquals(3, list.getTail().getData().getWholePart());
        assertEquals(47, list.getTail().getData().getFractionalPart());

        assertEquals(3, list.getHead().getNext().getNext().getNext().getNext().getData().getWholePart());
        assertEquals(47, list.getHead().getNext().getNext().getNext().getNext().getData().getFractionalPart());

        assertNull(list.getHead().getNext().getNext().getNext().getNext().getNext());

        assertEquals(5, list.getCount());
    }

    @Test
    void insertAtPosition() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtFront(new Krone(1.43));
        list.insertAtFront(new Krone(1.44));
        list.insertAtFront(new Krone(1.45));
        list.insertAtFront(new Krone(1.46));


        list.insertAtPosition(new Krone(2.47), 3);
        assertEquals(2, list.getHead().getNext().getNext().getNext().getData().getWholePart());
        assertEquals(47, list.getHead().getNext().getNext().getNext().getData().getFractionalPart());

        assertEquals(5, list.getCount());

        assertThrows(IndexOutOfBoundsException.class, () -> list.insertAtPosition(new Krone(1.47), -1));
    }


    @Test
    void deleteAtFront(){
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtFront(new Krone(1.43));
        list.insertAtFront(new Krone(1.44));
        list.insertAtFront(new Krone(1.45));
        list.insertAtFront(new Krone(1.46));

        list.deleteAtFront();
        assertEquals(1, list.getHead().getData().getWholePart());
        assertEquals(45, list.getHead().getData().getFractionalPart());
        assertEquals(3, list.getCount());

        assertThrows(IndexOutOfBoundsException.class, () -> new SinglyLinkedList().deleteAtFront());
    }

    @Test
    void deleteAtBack(){
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtFront(new Krone(1.43));
        list.insertAtFront(new Krone(1.44));
        list.insertAtFront(new Krone(1.45));
        list.insertAtFront(new Krone(1.46));

        list.deleteAtBack();
        assertEquals(1, list.getTail().getData().getWholePart());
        assertEquals(44, list.getTail().getData().getFractionalPart());
        assertEquals(3, list.getCount());

        assertThrows(IndexOutOfBoundsException.class, () -> new SinglyLinkedList().deleteAtBack());
    }
}