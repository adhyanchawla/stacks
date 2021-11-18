package Adapters;

public class queue {
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

    public void addLast(int data) { 
        Node node = new Node(data);
        if(this.head == null) {
            this.head = this.tail = null;
        } else {
            this.tail.next = node;
            this.tail = node;
        }

        this.size++;
    }

    public int removeFirst() {
        Node node = this.head;
        if(this.size == 1) {
            this.tail = this.head = null;
        } else {
            this.head = this.head.next;
        }

        node.next = null;
        this.size--;
        return node.data;
    }

    public int getFirst() {
        return this.head.data;
    }

    public int size() {
        return this.size;
    }

    public void push(int data) {
        addLast(data);
    }

    public int pop() {
        return removeFirst();
    }

    public int peek() {
        return getFirst();
    }
}
