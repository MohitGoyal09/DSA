public class browser_history {
}
class Node1{
    String val;
    Node1 next;
    Node1 back;
    public Node1(String val){
        this.val = val;
        this.next = null;
        this.back = null;
    }
}

class BrowserHistory {

    Node1 curr;

    public BrowserHistory(String homepage) {
        curr = new Node1(homepage);

    }

    public void visit(String url) {
        Node1 newnode = new Node1(url);
        curr.next = newnode;
        newnode.back = curr;
        curr = newnode;
    }

    public String back(int steps) {
        while (steps > 0){
            if (curr.back != null){
                curr = curr.back;
            } else break;
            steps--;

        }

        return curr.val;
    }

    public String forward(int steps) {
        while (steps > 0){
            if (curr.next != null) curr = curr.next;
            else break;
            steps--;
        }

        return curr.val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */