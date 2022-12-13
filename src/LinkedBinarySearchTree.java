import java.util.Comparator;
import java.util.LinkedList;

public class LinkedBinarySearchTree<K, V>
        implements BinarySearchTree<K, V> {
    private final Node<K, V> root;
    private final Comparator<? super K> comparator;

    private static class Node<K, V> {
        private final K key;
        private final V value;
        private final Node<K, V> left;
        private final Node<K, V> right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }

        public Node(K key, V value, Node<K, V> left, Node<K, V> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public LinkedBinarySearchTree(Comparator<? super K> comparator) {
        this.comparator = comparator;
        this.root = null;
    }

    private LinkedBinarySearchTree(Comparator<? super K> comparator, Node<K, V> root) {
        this.comparator = comparator;
        this.root = root;
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public boolean containsKey(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
// ¿?

        return get(key);
    }

    private Node<K, V> getNode(Node<K, V> node, K key) {
        if (node != null) {
            //if key > key of actual node, the key we're looking for is in the right subtree
            if (comparator.compare(node.key, key) < 0) {
                getNode(node.right, key);
            }
            //if key < key of actual node, the key we're looking for is in the left subtree
            else if (comparator.compare(node.key, key) > 0) {
                getNode(node.left, key);
            }
            //otherwise, we've found the key in a node, and we return this node
            else return node;
        }
        return null;
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