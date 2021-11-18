package Adapters;
import java.util.*;

public class stackUsingQueue {
    private int size = 0;
    private int topEle = 0;
    private LinkedList<Integer> q = new LinkedList<>();
    private LinkedList<Integer> temp = new LinkedList<>();
    
    public stackUsingQueue() {
        
    }
    
    public void push(int x) {
        q.addLast(x);
        topEle = x;
        this.size++;
    }
    
    public void swapData(LinkedList<Integer> q1, LinkedList<Integer> q2) {
        while(q1.size() != 1) {
            q2.addLast(q1.removeFirst());
        }
    }
    
    public int pop() {
        swapData(q, temp);
        int rv = q.removeFirst();
        if(temp.size() != 0) {
            swapData(temp, q);
            topEle = temp.getFirst();
            q.addLast(temp.removeFirst());
        }
        this.size--;
        return rv;
    }
    
    public int top() {
        return topEle;
    }
    
    public boolean empty() {
        return this.size == 0;
    }
}
