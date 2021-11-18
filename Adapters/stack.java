package Adapters;
// import java.util.*;

public class stack {
    private class Node {
        int data = 0;
        Node next = null;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public void addFirst(int data) {
        Node node = new Node(data);
        if(this.head == null) {
            this.head = this.tail = node;
        } else {
            node.next = this.head;
            this.head = node;
        }

        this.size++;
    }

    public int removeFirst() {
        Node node = this.head;
        if(this.size == 1) {
            this.head = this.tail = null;
        } else {
            this.head = node.next;
        }

        node.next = null;
        this.size--;
        return node.data;
    }

    public int getFirst() {
        return this.head.data;
    }

    public void push(int data) {
        addFirst(data);
    }

    public int pop() {
        return removeFirst();
    }

    public int peek() {
        return getFirst();
    }

    public int size() {
        return this.size;
    }
}
