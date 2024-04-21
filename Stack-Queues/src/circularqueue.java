public class circularqueue {
    private int[] data;
    public static final int DEFAULT_SIZE  = 10;
    protected int  front = 0 ;
    protected int end = 0 ;
    protected int size = 0;

    public circularqueue(int size) {
        this.data = new int[size];
    }
    public circularqueue(){
        this(DEFAULT_SIZE);
    }
    public boolean isFull(){
        return size == data.length;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public boolean insert(int item){
        if (isFull()) return false;
        data[end++] = item;
        end = end % data.length;
        size++;
        return true;
    }
    public int remove() throws Exception{
         if (isEmpty()) throw new Exception("Queue is Empty");
         int remove = data[front];
         front = front % data.length;
         size--;
         return remove;
    }
    public int peek() throws Exception{
        if (isEmpty()) throw new Exception("Queue is Empty");
        return data[front];
    }
    public void display() throws Exception{
        if (isEmpty()) throw new Exception("Queue is Empty");
        int i = front;
        do {
            System.out.println(data[i] + " -> ");
            i++;
            i %= data.length;
        } while ( i != end);
        System.out.println("END");
    }
}
