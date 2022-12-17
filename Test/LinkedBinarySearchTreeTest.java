import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class LinkedBinarySearchTreeTest {

    Comparator<Integer> cmp = Comparator.naturalOrder();
    LinkedBinarySearchTree<Integer, Integer> arb = new LinkedBinarySearchTree<>(cmp);

    @Test
    void isEmpty() {
        assertTrue(arb.isEmpty());
        arb = arb.put(23, 2);
        assertFalse(arb.isEmpty());
    }

    @Test
    void containsKey() {
    }

    @Test
    void get() {
    }

    @Test
    void put() {
        arb = arb.put(4, 40).put(2, 20).put(9, 90);
        assertEquals(40, arb.get(4));
        assertEquals(20, arb.get(2));
        assertEquals(90, arb.get(9));
        //assertNull(arb1.get(100));
    }

    @Test
    void remove() {
    }
}