import java.util.Stack;

public class span_stock {
}
class Pair{
    int price;
    int span;
    Pair(int price , int span){
        this.price = price;
        this.span = span;
    }
}
class StockSpanner {
    private Stack<Pair> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && price >= stack.peek().price) span += stack.pop().span;
        stack.push(new Pair(price , span));
        return stack.peek().span;
    }
}