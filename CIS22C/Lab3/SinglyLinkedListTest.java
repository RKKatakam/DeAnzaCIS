import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    public SinglyLinkedList getInitialSetup() throws Exception {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtFront(new Krone(1.42));
        list.insertAtFront(new Krone(1.43));
        list.insertAtFront(new Krone(1.44));
        list.insertAtFront(new Krone(1.45));
        list.insertAtFront(new Krone(1.46));

        return list;
    }

    public Currency getCurrencyAt(int position, SinglyLinkedList list) throws Exception {
        if (position < 0 || position >= list.getCount()) {
            throw new IndexOutOfBoundsException();
        }

        LinkNode current = list.getHead();
        for (int i = 0; i < position; i++) {
            current = current.getNext();
        }

        return current.getData();
    }

    @Test
    void insertAtFront() throws Exception {
        SinglyLinkedList list = new SinglyLinkedList();
        assertNull(list.getHead());

        list = getInitialSetup();
        assertEquals(1, list.getHead().getData().getWholePart());
        assertEquals(46, list.getHead().getData().getFractionalPart());

        assertEquals(5, list.getCount());
    }

    @Test
    void insertAtBack() throws Exception {
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

        assertEquals(3, getCurrencyAt(4, list).getWholePart());
        assertEquals(47, getCurrencyAt(4, list).getFractionalPart());

        assertThrows(IndexOutOfBoundsException.class, () -> getCurrencyAt(6, list));

        assertEquals(5, list.getCount());
    }

    @Test
    void insertAtPosition() throws Exception {
        SinglyLinkedList list = getInitialSetup();


        list.insertAtPosition(new Krone(2.47), 3);
        assertEquals(2, getCurrencyAt(3, list).getWholePart());
        assertEquals(47, getCurrencyAt(3, list).getFractionalPart());

        assertEquals(6, list.getCount());

        assertThrows(IndexOutOfBoundsException.class, () -> list.insertAtPosition(new Krone(1.47), -1));
    }


    @Test
    void deleteAtFront() throws Exception {
        SinglyLinkedList list = getInitialSetup();

        list.deleteAtFront();
        assertEquals(1, list.getHead().getData().getWholePart());
        assertEquals(45, list.getHead().getData().getFractionalPart());
        assertEquals(4, list.getCount());

        assertThrows(IndexOutOfBoundsException.class, () -> new SinglyLinkedList().deleteAtFront());
    }

    @Test
    void deleteAtBack() throws Exception {
        SinglyLinkedList list = getInitialSetup();

        list.deleteAtBack();
        assertEquals(1, list.getTail().getData().getWholePart());
        assertEquals(43, list.getTail().getData().getFractionalPart());
        assertEquals(4, list.getCount());

        assertThrows(IndexOutOfBoundsException.class, () -> new SinglyLinkedList().deleteAtBack());
    }


    @Test
    void deleteAtPosition() throws Exception {
        SinglyLinkedList list = getInitialSetup();


        list.deleteAtPosition(3);
        assertEquals(1, getCurrencyAt(3, list).getWholePart());
        assertEquals(42, getCurrencyAt(3, list).getFractionalPart());
        assertEquals(4, list.getCount());

        Currency tmp = list.deleteAtPosition(1);
        assertEquals(1, tmp.getWholePart());
        assertEquals(45, tmp.getFractionalPart());


        assertThrows(IndexOutOfBoundsException.class, () -> new SinglyLinkedList().deleteAtPosition(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> new SinglyLinkedList().deleteAtPosition(100));
    }

    @Test
    void delete() throws Exception {
        SinglyLinkedList list = getInitialSetup();

        list.delete(new Krone(1.44));
        assertEquals(1, getCurrencyAt(2, list).getWholePart());
        assertEquals(43, getCurrencyAt(2, list).getFractionalPart());
        assertEquals(4, list.getCount());

        list.delete(new Krone(1.46));
        assertEquals(1, list.getHead().getData().getWholePart());
        assertEquals(45, list.getHead().getData().getFractionalPart());
        assertEquals(3, list.getCount());

        list.delete(new Krone(1.45));
        assertEquals(1, list.getHead().getData().getWholePart());
        assertEquals(43, list.getHead().getData().getFractionalPart());
        assertEquals(2, list.getCount());

        list.delete(new Krone(1.43));
        assertEquals(1, list.getHead().getData().getWholePart());
        assertEquals(1, list.getCount());

        assertNull(list.delete(new Krone(1.43)));

    }

    @Test
    public void find() throws Exception {
        SinglyLinkedList list = getInitialSetup();

        assertEquals(0, list.find(new Krone(1.46)));
        assertEquals(1, list.find(new Krone(1.45)));
        assertEquals(2, list.find(new Krone(1.44)));
        assertEquals(3, list.find(new Krone(1.43)));
        assertEquals(4, list.find(new Krone(1.42)));

        assertEquals(-1, list.find(new Krone(1.47)));
    }

    @Test
    public void getCurrency() throws Exception {
        SinglyLinkedList list = getInitialSetup();

        assertEquals(1, list.getCurrency(0).getWholePart());
        assertEquals(46, list.getCurrency(0).getFractionalPart());

        assertEquals(1, list.getCurrency(1).getWholePart());
        assertEquals(45, list.getCurrency(1).getFractionalPart());

        assertEquals(1, list.getCurrency(2).getWholePart());
        assertEquals(44, list.getCurrency(2).getFractionalPart());

        assertEquals(1, list.getCurrency(3).getWholePart());
        assertEquals(43, list.getCurrency(3).getFractionalPart());

        assertEquals(1, list.getCurrency(4).getWholePart());
        assertEquals(42, list.getCurrency(4).getFractionalPart());

        assertThrows(IndexOutOfBoundsException.class, () -> list.getCurrency(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.getCurrency(5));
    }
}