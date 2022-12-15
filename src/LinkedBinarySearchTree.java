import java.util.Comparator;
import java.util.NoSuchElementException;

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
        Node<K, V> node = getNode(root, key);
        if (node == null)
            throw new NullPointerException("");
        else if (node.key == null)
            throw new NoSuchElementException("");
        else
            return node.value;
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
        return new LinkedBinarySearchTree<>(comparator, createNewNode(root, key, value));
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
            return new LinkedBinarySearchTree<>(comparator, deleteSpecificNode(root, key));
        }
        return new LinkedBinarySearchTree<>(comparator, root);
    }

    private Node<K, V> deleteSpecificNode(Node<K, V> node, K key) {
        if (node != null) {
            //Si key o value son null lanza NullPointerException
//            if (node.key == null || node.value == null) {
//                throw new NullPointerException("");
//            }
            Node<K, V> leftNode = node.left;
            Node<K, V> rightNode = node.right;
            if (leftNode != null && leftNode.key == key) {
                leftNode.left =
                return leftNode.left;
            } else if (rightNode != null && rightNode.key == key) {
                return rightNode.left;
            }
            if (comparator.compare(node.key, key) < 0) {
                return new Node<K, V>(node.key, node.value, leftNode, deleteSpecificNode(rightNode, key));
            } else if (comparator.compare(node.key, key) > 0) {
                return new Node<K, V>(node.key, node.value, deleteSpecificNode(leftNode, key), rightNode);
            } else {
//                Si key existe en el ABB
                if (leftNode.key == null)
                    return new Node<K, V>(null, null);
            }
        }
    }
}