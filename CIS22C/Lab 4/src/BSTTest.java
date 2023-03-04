import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTTest {

    @Test
    void search() {
        BST bst = getSampleBst();


        assertEquals(1.0, bst.search(new Krone(1.0)).getValue());
        assertEquals(2.0, bst.search(new Krone(2.0)).getValue());
        assertEquals(3.0, bst.search(new Krone(3.0)).getValue());
        assertEquals(4.0, bst.search(new Krone(4.0)).getValue());
        assertEquals(5.0, bst.search(new Krone(5.0)).getValue());
        assertEquals(6.0, bst.search(new Krone(6.0)).getValue());

    }

    private BST getSampleBst() {
        BST bst = new BST();
        bst.insert(new Krone(1.0));
        bst.insert(new Krone(2.0));
        bst.insert(new Krone(3.0));
        bst.insert(new Krone(4.0));
        bst.insert(new Krone(5.0));
        bst.insert(new Krone(6.0));
        return bst;
    }

    @Test
    void insert() {
        BST bst = getSampleBst();

        assertEquals(6, bst.getCount());
    }

    @Test
    void delete(){
        BST bst = getSampleBst();
        bst.delete(new Krone(1.0));
        assertEquals(5, bst.getCount());
        bst.delete(new Krone(2.0));
        assertEquals(4, bst.getCount());
        bst.delete(new Krone(3.0));
        assertEquals(3, bst.getCount());
        bst.delete(new Krone(4.0));
        assertEquals(2, bst.getCount());
        bst.delete(new Krone(5.0));
        assertEquals(1, bst.getCount());
        bst.delete(new Krone(6.0));
        assertEquals(0, bst.getCount());
    }
}