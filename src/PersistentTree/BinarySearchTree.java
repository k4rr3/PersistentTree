package PersistentTree;

public interface BinarySearchTree<K, V> {
    boolean isEmpty();

    boolean containsKey(K key);

    V get(K key);

    BinarySearchTree<K, V> put(K key, V value);

    BinarySearchTree<K, V> remove(K key);
}