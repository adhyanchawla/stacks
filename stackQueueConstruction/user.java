package stackQueueConstruction;
public class user {
    
    public static void main(String[] args) throws Exception {
        DynamicStack st = new DynamicStack(10);

        for(int i = 0; i <= 10; i++) {
            st.push(i * 10);
        }

        st.displayStack();

        // System.out.println(st.peek());
    }
}
