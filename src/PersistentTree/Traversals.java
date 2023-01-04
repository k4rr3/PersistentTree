package PersistentTree;

import java.util.*;

public class Traversals {
    public static <E> List<E> inorder(BinaryTree<E> tree) {
        List<E> result = new ArrayList<>();
            //RECURSIVE INORDER ALGORITHM
        //inorderRec(result, tree);

            //ITERATIVE INORDER ALGORITHM WITH CONTEXTS AND ENUMS
        //result = inorderIter(tree);

            //OPTIMIZED ITERATIVE INORDER ALGORITHM WITH CONTEXTS AND ENUMS
        result = inorderIterOptimized(tree);

            //ITERATIVE INORDER ALGORITHM WITHOUT CONTEXTS AND ENUMS
        //result = inorderIterWithoutContext(tree);

        return result;
    }

    private static <E> void inorderRec(List<E> result,
                                       BinaryTree<E> tree) {
        if (!tree.isEmpty()) {
            inorderRec(result, tree.left());
            result.add(tree.root());
            inorderRec(result, tree.right());
        }
    }

    private static class Context<E> {
        BinaryTree<E> tree;
        EntryPoint entryPoint;

        public Context(BinaryTree<E> tree, EntryPoint entryPoint) {
            this.tree = tree;
            this.entryPoint = entryPoint;
        }
    }

    enum EntryPoint {
        CALL, RESUME, RESUME2
    }
  public static <E> List<E> inorderIter(BinaryTree<E> tree) {
        List<E> result = new ArrayList<>();
        Deque<Context> stack = new ArrayDeque<>();

        if (tree.isEmpty()) {
            return result;
        }

        stack.addFirst(new Context(tree, EntryPoint.CALL));
        while (!stack.isEmpty()) {
            var context = stack.removeFirst();
            switch (context.entryPoint) {
                case CALL -> {
                    var actual = context.tree;
                    while (!actual.isEmpty()) {
                        stack.addFirst(new Context(actual, EntryPoint.RESUME));
                        actual = actual.left();
                    }
                }
                case RESUME -> {
                    result.add((E) context.tree.root());
                    if (context.tree.right() != null && !context.tree.right().isEmpty()) {
                        stack.addFirst(new Context(context.tree.right(), EntryPoint.RESUME2));
                    }
                }
                case RESUME2 -> {
                    var current = context.tree;
                    while (!current.isEmpty()) {
                        stack.addFirst(new Context(current, EntryPoint.RESUME));
                        current = current.left();
                    }
                }
            }
        }
        return result;
    }

    private static class ContextOptimized<E> {
        BinaryTree<E> tree;
        EntryPointOptimized entryPoint;

        public ContextOptimized(BinaryTree<E> tree, EntryPointOptimized entryPoint) {
            this.tree = tree;
            this.entryPoint = entryPoint;
        }
    }

    enum EntryPointOptimized {
        CALL, RESUME
    }

    public static <E> List<E> inorderIterOptimized(BinaryTree<E> tree) {
        List<E> result = new ArrayList<>();
        Deque<ContextOptimized> stack = new ArrayDeque<>();

        if (tree.isEmpty()) {
            return result;
        }

        stack.addFirst(new ContextOptimized(tree, EntryPointOptimized.CALL));
        while (!stack.isEmpty()) {
            var context = stack.removeFirst();
            switch (context.entryPoint) {
                case CALL -> {
                    var actual = context.tree;
                    while (!actual.isEmpty()) {
                        stack.addFirst(new ContextOptimized(actual, EntryPointOptimized.RESUME));
                        actual = actual.left();
                    }
                }
                case RESUME -> {
                    result.add((E) context.tree.root());
                    if (context.tree.right() != null && !context.tree.right().isEmpty()) {
                        stack.addFirst(new ContextOptimized(context.tree.right(), EntryPointOptimized.CALL));
                    }
                }
            }
        }
        return result;
    }


     public static <E> List<E> inorderIterWithoutContext(BinaryTree<E> tree) {
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