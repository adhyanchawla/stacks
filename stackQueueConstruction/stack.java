package stackQueueConstruction;
public class stack {
    private int[] arr;
    private int tos;
    private int NoOfElements;
    private int MaxCapacity;

    stack(int size) {
        initialize(size);
    }

    stack() {
        //first line should be this if you want to do constuctor chaining
        this(10); //constructor chaining
    }

    protected void initialize(int size) {
        this.NoOfElements = 0;
        this.MaxCapacity = size;
        this.arr = new int[size];
        this.tos = -1;
    }

    private void overflowException() throws Exception{
        if(this.NoOfElements == this.MaxCapacity) {
            throw new Exception("StackOverflow");
        }
    }

    private void underflowException() throws Exception{
        if(this.tos == -1) {
            throw new Exception("StackUnderflow");    
        }
    }

    public int capacity() {
        return this.MaxCapacity;
    }

    public void displayStack() {
        for(int i = tos; i >= 0; i--) {
            System.out.print(this.arr[i] + " ");
        }
    }

    public int size() {
        return this.NoOfElements;
    }

    public void push(int data) throws Exception{
        overflowException();
        arr[++this.tos] = data;
        this.NoOfElements++;
    }

    public int peek() throws Exception {
        underflowException();
        return this.arr[this.tos];
    }

    public int pop() throws Exception {
        underflowException();
        int rv = this.arr[this.tos--];
        this.NoOfElements--;
        return rv;
    }
}