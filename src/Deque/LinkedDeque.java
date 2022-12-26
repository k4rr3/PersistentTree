/*
package Deque;

import java.util.LinkedList;

public class LinkedDeque<E> extends LinkedList<E> {
    private Node<E> top;

    private static class Node<E> {
        private E element;
        private Node<E> next;

        private Node(E element, Node<E> node) {
            this.element = element;
            this.next = node;
        }
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public E top() {
        return top.element;
    }

    @Override
    public E pop() {
        this.top = top.next;
        return null;
    }

    @Override
    public void push(E e) {
        this.top = new Node<E>(e, this.top);
    }
}
*/
