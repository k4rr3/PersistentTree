import PersistentTree.LinkedBinarySearchTree;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.util.Comparator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedBinarySearchTreeTest {

    Comparator<Integer> cmp = Comparator.naturalOrder();
    LinkedBinarySearchTree<Integer, Integer> arbII = new LinkedBinarySearchTree<>(cmp);
    LinkedBinarySearchTree<Integer, String> arbIS = new LinkedBinarySearchTree<>(cmp);

    @Test
    void isEmpty() {
        assertTrue(arbII.isEmpty());
        arbII = arbII.put(23, 2);
        assertFalse(arbII.isEmpty());
    }

    @Test
    public void testContainsKey() {


        arbIS = arbIS.put(5, "five");
        arbIS = arbIS.put(3, "three");
        arbIS = arbIS.put(2, "two");
        arbIS = arbIS.put(1, "one");
        arbIS = arbIS.put(4, "four");
        arbIS = arbIS.put(6, "six");
        arbIS = arbIS.put(7, "seven");

        assertTrue(arbIS.containsKey(5));
        assertTrue(arbIS.containsKey(3));
        assertTrue(arbIS.containsKey(2));
        assertTrue(arbIS.containsKey(1));
        assertTrue(arbIS.containsKey(4));
        assertTrue(arbIS.containsKey(6));
        assertTrue(arbIS.containsKey(7));
        assertFalse(arbIS.containsKey(8));
    }


    @Test
    public void testGet() {
        LinkedBinarySearchTree<Integer, String> arbIS = new LinkedBinarySearchTree<>(cmp);

        arbIS = arbIS.put(5, "five");
        arbIS = arbIS.put(3, "three");
        arbIS = arbIS.put(2, "two");
        arbIS = arbIS.put(1, "one");
        arbIS = arbIS.put(4, "four");
        arbIS = arbIS.put(6, "six");
        arbIS = arbIS.put(7, "seven");

        assertEquals("five", arbIS.get(5));
        assertEquals("three", arbIS.get(3));
        assertEquals("two", arbIS.get(2));
        assertEquals("one", arbIS.get(1));
        assertEquals("four", arbIS.get(4));
        assertEquals("six", arbIS.get(6));
        assertEquals("seven", arbIS.get(7));
        //LinkedBinarySearchTree<Integer, String> finalTree = arbIS;
        //assertThrows(NoSuchElementException.class, () -> finalTree.get(8));
    }


    @Test
    void put() {
        arbII = arbII.put(4, 40).put(2, 20).put(9, 90);
        assertEquals(40, arbII.get(4));
        assertEquals(20, arbII.get(2));
        assertEquals(90, arbII.get(9));
        LinkedBinarySearchTree<Integer, Integer> finalTree = arbII;
        assertThrows(NoSuchElementException.class, () -> finalTree.get(100));

        LinkedBinarySearchTree<Integer, Integer> finalTree2 = arbII;
        assertThrows(NullPointerException.class, () -> finalTree.get(null));

    }

    @Test
    void remove() {
        arbII = arbII.put(30, 30).put(20, 20).put(15, 15).put(10, 10).put(17, 17).put(25, 25).put(40, 40).put(50, 50).put(45, 45).put(44, 44).put(60, 60);
        arbII = arbII.remove(40);
        assertFalse(arbII.containsKey(40));
    }

    @Test
    void remove2() {
        arbII = arbII.put(30, 30).put(20, 20).put(15, 15).put(10, 10).put(17, 17).put(25, 25).put(40, 40).put(50, 50).put(45, 45).put(44, 44).put(60, 60);
        arbII = arbII.remove(20);
        assertFalse(arbII.containsKey(20));
    }

    @Test
    public void testRemove() {
        // Añadir algunos elementos al árbol
        arbII = arbII.put(5, 5).put(3, 3).put(7, 7);
        // Eliminar el elemento con clave 3
        arbII = arbII.remove(3);
        // Comprobar que el elemento con clave 3 ha sido eliminada
        assertFalse(arbII.containsKey(3));
    }

    @Test
    void deleteSpecificNodeLeaf() {
        arbII = arbII.put(4, 40).put(2, 20).put(9, 90).put(1, 10);
        arbII = arbII.remove(1);
        assertFalse(arbII.containsKey(1));
    }

    @Test
    void deleteSpecificNodeTwoChildren() {
        arbII = arbII.put(4, 40).put(2, 20).put(9, 90).put(1, 10).put(3, 30).put(8, 80);
        arbII = arbII.remove(2);
        assertFalse(arbII.containsKey(2));
        assertTrue(arbII.containsKey(1));
        assertTrue(arbII.containsKey(3));
        assertTrue(arbII.containsKey(8));
        assertTrue(arbII.containsKey(9));
    }

    @Test
    void deleteSpecificNodeOneChild() {
        arbII = arbII.put(4, 40).put(2, 20).put(9, 90).put(1, 10).put(3, 30);
        arbII = arbII.remove(9);
        assertFalse(arbII.containsKey(9));
        assertTrue(arbII.containsKey(1));
        assertTrue(arbII.containsKey(2));
        assertTrue(arbII.containsKey(3));
        assertTrue(arbII.containsKey(4));
    }
    @Test
    void testRemoveNonExistingNode() {
        LinkedBinarySearchTree<Integer, Integer> tree = new LinkedBinarySearchTree<>(cmp);

        // Agregamos algunos nodos al árbol
        tree = tree.put(30, 30).put(20, 20).put(15, 15).put(10, 10).put(17, 17).put(25, 25).put(40, 40).put(50, 50).put(45, 45).put(44, 44).put(60, 60);

        // Intentamos eliminar un nodo que no existe en el árbol
        LinkedBinarySearchTree<Integer, Integer> finalTree = tree;
        assertThrows(NoSuchElementException.class, () -> finalTree.remove(100));
        LinkedBinarySearchTree<Integer, Integer> finalTree2 = tree;
        assertThrows(NullPointerException.class, () -> finalTree.remove(null));
    }


}