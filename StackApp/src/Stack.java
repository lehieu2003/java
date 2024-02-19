public class Stack {
    private int maxSize;
    private long[] stackArray;
    private int first;
    private int nItems;
    public Stack(int maxSize){
        this.maxSize = maxSize;
        stackArray = new long[maxSize];
        first = -1;
        nItems = 0;
    }
    public boolean isEmpty(){
        return nItems == 0;
    }
    public void insert(long key){
        if (first == maxSize - 1) {
            throw new IllegalArgumentException("The stack is full");
        }
        first++;
        stackArray[first] = key;
        nItems++;
    }
    public long delete(){
        if (isEmpty()){
            throw new IllegalArgumentException("the stack is empty");
        }else {
            nItems--;
            return stackArray[first--];
        }
    }
    public void display(){
        System.out.println("Stack: ");
        for (int i = first; i >= 0; i--) {
            System.out.print(stackArray[i] + " ");
        }
    }
}
