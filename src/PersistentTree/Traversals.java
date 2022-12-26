package PersistentTree;

import java.util.*;

public class Traversals {
    public static <E> List<E> inorder(BinaryTree<E> tree) {
        List<E> result = new ArrayList<>();
        //inorderRec(result, tree);
        result = inorderIter(tree);
        return result;
    }

    private static <E> void inorderRec(List<E> result,
                                       BinaryTree<E> tree) {
        if (tree != null && !tree.isEmpty()) {
            inorderRec(result, tree.left());
            result.add(tree.root());
            inorderRec(result, tree.right());
        }
    }

    public static <E> List<E> inorderIter(BinaryTree<E> tree) {
        List<E> result = new ArrayList<>();
        Deque<BinaryTree<E>> stack = new ArrayDeque<>();

        if (tree.isEmpty()) {
            return result;
        }

        BinaryTree<E> actual = tree;
        while (!actual.isEmpty()) {
            stack.addFirst(actual);
            actual = actual.left();
        }

        while (!stack.isEmpty()) {
            BinaryTree<E> current = stack.removeFirst();
            result.add(current.root());

            if (current.right() != null && !current.right().isEmpty()) {
                current = current.right();

                while (!current.isEmpty()) {
                    stack.addFirst(current);
                    current = current.left();
                }
            }
        }
        return result;
    }
}