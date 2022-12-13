import java.util.Comparator;

public class LinkedBinarySearchTree<K, V>
        implements BinarySearchTree<K, V> {
    private final Node<K, V> root;
    private final Comparator<? super K> comparator;

    private static class Node<K, V> {
        private final K key;
        private final V value;
        private final Node<K, V> left;
        private final Node<K, V> right;

        private Node() {
            key = null;
            value = null;
            left = null;
            right = null;
        }
// ¿?
    }

    public LinkedBinarySearchTree(
            Comparator<? super K> comparator, Node<K, V> root, Comparator<? super K> comparator1) {
        this.root = root;
// ¿?
        this.comparator = comparator1;
    }

    private LinkedBinarySearchTree(
            Comparator<? super K> comparator,
            Node<K, V> root) {
        this.comparator = null;
        this.root = null;
    }

    @Override
    public boolean isEmpty() {
// ¿?
        return true;
    }

    @Override
    public boolean containsKey(K key) {
// ¿?
        return true;
    }

    @Override
    public V get(K key) {
// ¿?

        return get(key);
    }

    @Override
    public LinkedBinarySearchTree<K, V> put(K key, V value) {
// ¿?
        return new LinkedBinarySearchTree<>(comparator, root);
    }

    @Override
    public LinkedBinarySearchTree<K, V> remove(K key) {
// ¿?
        return new LinkedBinarySearchTree<>(comparator, root);
    }
}