import PersistentTree.LinkedBinarySearchTree;
import PersistentTree.Pair;
import PersistentTree.Traversals;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TraversalsTest {


    @Test
    public void testInorderIterative() {
        // Creamos el árbol binario de búsqueda

        LinkedBinarySearchTree<Integer, String> tree = new LinkedBinarySearchTree<>(Comparator.naturalOrder());
        tree = tree.put(50, "Cincuenta");
        tree = tree.put(30, "Treinta");
        tree = tree.put(70, "Setenta");
        tree = tree.put(20, "Veinte");
        tree = tree.put(40, "Cuarenta");
        tree = tree.put(60, "Sesenta");
        tree = tree.put(80, "Ochenta");
        // Obtenemos el resultado del recorrido en inorden
        List<Pair<Integer, String>> result = Traversals.inorder(tree);
        // Comprobamos que el resultado sea el esperado
        List<Pair<Integer, String>> expected = Arrays.asList(
                new Pair<>(20, "Veinte"),
                new Pair<>(30, "Treinta"),
                new Pair<>(40, "Cuarenta"),
                new Pair<>(50, "Cincuenta"),
                new Pair<>(60, "Sesenta"),
                new Pair<>(70, "Setenta"),
                new Pair<>(80, "Ochenta")
        );
        assertIterableEquals(expected, result);
    }

    @Test
    public void testInorderIterativeShort() {
        // Creamos el árbol binario de búsqueda
        LinkedBinarySearchTree<Integer, String> tree = new LinkedBinarySearchTree<>(Comparator.naturalOrder());
        tree = tree.put(50, "Cincuenta");
        tree = tree.put(30, "Treinta");
        tree = tree.put(20, "Veinte");
        // Obtenemos el resultado del recorrido en inorden
        List<Pair<Integer, String>> result = Traversals.inorder(tree);
        // Comprobamos que el resultado sea el esperado
        List<Pair<Integer, String>> expected = Arrays.asList(
                new Pair<>(20, "Veinte"),
                new Pair<>(30, "Treinta"),
                new Pair<>(50, "Cincuenta")
        );
        assertIterableEquals(expected, result);
    }

    @Test
    void testInorderIterEmptyTree() {
        LinkedBinarySearchTree<Integer, Integer> tree = new LinkedBinarySearchTree<>(Comparator.naturalOrder());
        List<Pair<Integer, Integer>> expected = new ArrayList<>();
        assertEquals(expected, Traversals.inorderIter(tree));
    }

    @Test
    void testInorderIterSingleNodeTree() {
        LinkedBinarySearchTree<Integer, Integer> tree = new LinkedBinarySearchTree<>(Comparator.naturalOrder());
        tree = tree.put(5, 5);

        List<Pair<Integer, Integer>> expected = List.of(new Pair<>(5, 5));
        assertEquals(expected, Traversals.inorderIter(tree));
    }

    @Test
    void testInorderIterCompleteTreeHeight2() {
        LinkedBinarySearchTree<Integer, Integer> tree = new LinkedBinarySearchTree<>(Comparator.naturalOrder());
        tree = tree.put(5, 5);
        tree = tree.put(3, 3);
        tree = tree.put(7, 7);
        List<Pair<Integer, Integer>> expected = List.of(new Pair<>(3, 3), new Pair<>(5, 5), new Pair<>(7, 7));
        assertEquals(expected, Traversals.inorderIter(tree));
    }

    @Test
    void testInorderIterBalancedTreeHeight3() {
        LinkedBinarySearchTree<Integer, Integer> tree = new LinkedBinarySearchTree<>(Comparator.naturalOrder());
        tree = tree.put(5, 5);
        tree = tree.put(3, 3);
        tree = tree.put(7, 7);
        tree = tree.put(2, 2);
        tree = tree.put(4, 4);
        tree = tree.put(6, 6);
        tree = tree.put(8, 8);
        List<Pair<Integer, Integer>> expected = List.of(
                new Pair<>(2, 2),
                new Pair<>(3, 3),
                new Pair<>(4, 4),
                new Pair<>(5, 5),
                new Pair<>(6, 6),
                new Pair<>(7, 7),
                new Pair<>(8, 8));
        assertEquals(expected, Traversals.inorderIter(tree));
    }

    @Test
    void testInorderIterRightSubtreeHeight2() {
        LinkedBinarySearchTree<Integer, Integer> tree = new LinkedBinarySearchTree<>(Comparator.naturalOrder());
        tree = tree.put(5, 5);
        tree = tree.put(7, 7);
        tree = tree.put(8, 8);
        List<Pair<Integer, Integer>> expected = List.of(
                new Pair<>(5, 5),
                new Pair<>(7, 7),
                new Pair<>(8, 8));
        assertEquals(expected, Traversals.inorderIter(tree));

    }
}