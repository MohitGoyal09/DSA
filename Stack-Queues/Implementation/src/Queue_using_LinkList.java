public class Queue_using_LinkList {
    public static void main(String[] args) {

    }
    class QueueNode
    {
        int val;
        QueueNode next;
        QueueNode(int data)
        {
            val = data;
            next = null;
        }
    }
    class LinkQueue{
        QueueNode Front , Rear = null;
        int size = 0;
        boolean empty(){
            return (Front == null) ;
        }
        int peek(){
            if (empty()){
                System.out.println("Queue is Empty!");
                return -1;
            }
            return Front.val;
        }
        int size(){
            return size;
        }
        void enqueue(int x){
            QueueNode temp = new QueueNode(x);
            if(empty()){
                System.out.println("Queue is full!");
            } else {
                if(Front == null){
                    Front = temp;
                    Rear = temp;
                } else {
                    Rear.next = temp;
                    Rear = temp;
                }
                System.out.println(x + " is added to Queue!");
                size++;
            }
        }
        void dequeue(){
            if(empty()){
                System.out.println("Queue is Empty!");
            } else {
                System.out.println(Front.val + " is deleted from Queue!");
                Front = Front.next;
                size--;
            }
        }
    }
}
