package Adapters;
import java.util.LinkedList;

public class queueUsingStack {
    
    LinkedList<Integer>st = new LinkedList<>();
    LinkedList<Integer>temp = new LinkedList<>();

    queueUsingStack() {

    }

    public void push(int x) {
        st.addFirst(x);
    }

    public void swapData(LinkedList<Integer> st1, LinkedList<Integer> st2) {
        while(st1.size() != 0) {
            st2.addFirst(st1.removeFirst());
        }
    }

    public int pop() {
        swapData(st, temp);
        int rv = temp.removeFirst();
        swapData(temp, st);
        return rv;
    }

    public int peek() {
        swapData(st, temp);
        int rv = temp.getFirst();
        swapData(temp, st);
        return rv;
    }

    public boolean isEmpty() {
        return this.st.size() == 0;
    }
}
