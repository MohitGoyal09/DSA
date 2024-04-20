public class customstack {

    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int ptr = -1;

    public customstack(){
        this(DEFAULT_SIZE);
    }

    public customstack(int size) {
        this.data = new int[size];
    }
    public boolean isFull(){
        return ptr == data.length -1;
    }
    public boolean isEmpty(){
        return ptr == -1;
    }
    public boolean push(int item){
        if (isFull()) {
            System.out.println("Stack is full");
            return false;
        }
        ptr++;
        data[ptr] = item;
        return true;
    }
    public int pop() throws Stackexception{
       if (isEmpty()){
           throw new Stackexception("Cannot pop from an empty stack!!");
       }
       return data[ptr--];
    }
    public int peek() throws Stackexception{
        if (isEmpty()){
            throw new Stackexception("Cannot peek from an empty stack!!");
        }
        return data[ptr];
    }
}
