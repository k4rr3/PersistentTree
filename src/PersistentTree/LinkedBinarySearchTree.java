package PersistentTree;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class LinkedBinarySearchTree<K, V>
        implements BinarySearchTree<K, V>,
        BinaryTree<Pair<K, V>> {
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
    public boolean containsKey(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        // ¿?
        Node<K, V> node = getNode(root, key);
        if (node == null)
            throw new NullPointerException("");
        else if (node.key == null)
            throw new NoSuchElementException("");
        else
            return node.value;
    }

    private Node<K, V> getNode(Node<K, V> node, K key) {
        if (node == null)
            return null;

        return switch (comparator.compare(node.key, key)) {
            case 1 -> getNode(node.left, key);
            case -1 -> getNode(node.right, key);
            default -> node;
        };
    }

    @Override
    public LinkedBinarySearchTree<K, V> put(K key, V value) {
// ¿?
        Node<K, V> n = createNewNode(root, key, value);
        return new LinkedBinarySearchTree<>(comparator, n);
    }

    private Node<K, V> createNewNode(Node<K, V> node, K key, V value) {
        if (node != null) {
            //Si key o value son null lanza NullPointerException
            if (node.key == null || node.value == null) {
                throw new NullPointerException("");
            }

            if (comparator.compare(node.key, key) < 0) {
                return new Node<K, V>(node.key, node.value, node.left, createNewNode(node.right, key, value));
            } else if (comparator.compare(node.key, key) > 0) {
                return new Node<K, V>(node.key, node.value, createNewNode(node.left, key, value), node.right);
            } else {
//                Si key existe en el ABB de origen se modificará su actual valor por
//                value generando un nuevo nodo que represente esta modificación
//                para el árbol devuelto.
                return new Node<K, V>(node.key, value, node.left, node.right);
            }
        }
        //throw new NullPointerException("");
        //Si el arbol que teniamos estaba vacio, crearemos un nuevo nodo que será la raíz
        return new Node<K, V>(key, value);
    }

    @Override
    public LinkedBinarySearchTree<K, V> remove(K key) {
// ¿?
        if (key == null) {
            throw new NullPointerException("");
        }
        if (containsKey(key)) {
            Node<K, V> node = deleteSpecificNode(root, key);
            return new LinkedBinarySearchTree<>(comparator, node);
        } else
            throw new NoSuchElementException("");
    }


    private Node<K, V> deleteSpecificNode(Node<K, V> root, K key) {
        Node<K, V> nodeToDelete = getNode(root, key);
        if (nodeToDelete.key.equals(key)) {
            //Checking if the node that we want to delete is a leaf, or it is not
            if (nodeToDelete.left == null && nodeToDelete.right == null) {
                return new Node<>(null, null);
            }
            //Checking if the node that we want to delete has two children

            else if (nodeToDelete.left != null && nodeToDelete.right != null) {
                Node<K, V> biggestOfLeftSubtree = biggestOfLeftSubtree(nodeToDelete.left);
                deleteSpecificNode(root, biggestOfLeftSubtree.key);
                Node<K, V> childOfDeletedNode = new Node<>(biggestOfLeftSubtree.key, biggestOfLeftSubtree.value, nodeToDelete.left, nodeToDelete.right);
                Node<K, V> parentOfDeletedNode = getParentNode(root, root, nodeToDelete.key);
                return getKvNode(nodeToDelete, parentOfDeletedNode, childOfDeletedNode);
            }
            //Then it means that the node we want to delete has only one child
            else {
                Node<K, V> parentOfDeletedNode = getParentNode(root, root, nodeToDelete.key);
                Node<K, V> childOfDeletedNode;
                if (nodeToDelete.left != null) {
                    childOfDeletedNode = nodeToDelete.left;
                    return getKvNode(nodeToDelete, parentOfDeletedNode, childOfDeletedNode);

                } else {
                    childOfDeletedNode = nodeToDelete.right;
                    return getKvNode(nodeToDelete, parentOfDeletedNode, childOfDeletedNode);

                }
            }
        }
        return null;
    }

    private Node<K, V> getKvNode(Node<K, V> nodeToDelete, Node<K, V> parentOfDeletedNode, Node<K, V> childOfDeletedNode) {
        if (parentOfDeletedNode.left != nodeToDelete) {
            return new Node<>(parentOfDeletedNode.key, parentOfDeletedNode.value, parentOfDeletedNode.left, childOfDeletedNode);
        } else
            return new Node<>(parentOfDeletedNode.key, parentOfDeletedNode.value, childOfDeletedNode, parentOfDeletedNode.right);
    }

    private Node<K, V> biggestOfLeftSubtree(Node<K, V> node) {
        if (node.right != null)
            biggestOfLeftSubtree(node.right);
        return node;
    }

    private Node<K, V> getParentNode(Node<K, V> child, Node<K, V> parent, K key) {
        if (child == null)
            return null;
        switch (comparator.compare(child.key, key)) {
            case 1 -> {
                return getParentNode(child.left, child, key);
            }
            case -1 -> {
                return getParentNode(child.right, child, key);
            }
            default -> {
                return parent;
            }
        }
    }

    //--------------------------------------------------------------------------------//
    //                      SECOND PART OF THE PROJECT                                //
    //--------------------------------------------------------------------------------//
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public Pair<K, V> root() {
        if (isEmpty())
            throw new NullPointerException();

        return new Pair<K, V>(root.key, root.value);
    }

    @Override
    public BinaryTree<Pair<K, V>> left() {

        if (root == null)
            throw new NoSuchElementException("left child of empty tree");


        return new LinkedBinarySearchTree<>(comparator, root.left);


    }


    @Override
    public BinaryTree<Pair<K, V>> right() {
        if (root == null)
            throw new NoSuchElementException("right child of empty tree");

        return new LinkedBinarySearchTree<>(comparator, root.right);
    }

}