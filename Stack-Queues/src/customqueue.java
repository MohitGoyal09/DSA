public class customqueue {

    private int[] data;
    private static final int DEFAULT_SIZE = 10;
    int end = 0;

    public customqueue(int size){
        this.data = new int[size];
    }
    public customqueue(){
        this(DEFAULT_SIZE);
    }
    public boolean isFull(){
        return data.length == end;
    }
    public boolean isEmpty(){
        return end == 0;
    }
    public int remove() throws Exception{
        if (isEmpty()) throw new Exception("Queue is Empty");
        int removed = data[0];
        for (int i = 1 ; i < end ; i++ ){
            data[i-1] = data[i];
        }
        end--;
        return removed;
    }
    public boolean insert(int item){
        if (isFull()) return false;
        data[end] = item;
        end++;
        return true;
    }
    public int peek() throws Exception{
        if (isEmpty()) throw new Exception("Queue is Empty");
        return data[0];
    }
    public void display(){
        for (int i = 0 ; i < end ; i++){
            System.out.println(data[i] + " <- ");
        }
        System.out.println("END");
    }
}
