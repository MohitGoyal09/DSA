import java.util.*;
public class final_prices_with_special_discount {
    public static void main(String[] args) {
        int[] prices = {8, 4, 6, 2, 3};
        int[] ans = finalPrices(prices);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    // ! How it works :
    /* We use a stack to keep track of indices of prices that haven't found their discount yetFor each price,
    we check if it can be used as a discount for any previous prices
    If the current price is lower than the price at the top of the stack,
     we apply it as a discountWe continue this process for all prices in the array
     */
    public static int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                prices[stack.pop()] -= prices[i];
            }
            stack.push(i);
        }
        return prices;
    }
}



