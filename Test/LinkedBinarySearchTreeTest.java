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
        arb = arb.put(30, 30).put(20, 20).put(15, 15).put(10, 10).put(17, 17).put(25, 25).put(40, 40).put(50, 50).put(45, 45).put(44, 44).put(60, 60);
        arb = arb.remove(40);
        assertFalse(arb.containsKey(40));
    }
    @Test
    void remove2() {
        arb = arb.put(30, 30).put(20, 20).put(15, 15).put(10, 10).put(17, 17).put(25, 25).put(40, 40).put(50, 50).put(45, 45).put(44, 44).put(60, 60);
        arb = arb.remove(20);
        assertFalse(arb.containsKey(20));
    }
}