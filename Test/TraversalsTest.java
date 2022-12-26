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

}