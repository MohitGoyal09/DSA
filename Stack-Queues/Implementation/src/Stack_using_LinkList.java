public class Stack_using_LinkList {
    public void main(String[] args) {
        stack s = new stack();
        s.push(10);
        s.pop();
        System.out.println("Element popped " + s.pop());
        System.out.println("Stack size: " + s.size());
        System.out.println("Stack is empty or not: " + s.empty());

    }
    class LinkStack{
        private class StackNode{
            int data;
            StackNode next;
            public StackNode(int d){
                data = d;
                next = null;
            }
        }
        StackNode top;
        int size;
        void stack(){
            this.top = null;
            this.size = 0;
        }
        public void push(int x){
            StackNode elm = new StackNode(x);
            elm.next = top;
            top = elm;
            size++;
        }
        public int pop(){
            if (top == null) return -1;
            StackNode temp=top;
            top=top.next;
            int result=temp.data;
            temp.next=null;
            size--;
            return result;
        }
        public int size(){
            return size;
        }
        public boolean empty(){
            return (top == null);
        }
        public void printStack() {
            StackNode current = top;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
    }

