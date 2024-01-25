
public class Stock_buy_sell {
    public static void main(String[] args) {
            int arr[] = {7,1,5,3,6,4};
            int maxPro = maxProfit(arr);
            System.out.println("Max profit is: " + maxPro);
        }

        // ? Burrte Force
       // ! Time complexity : O(n^2)
       // ! Space complexity : O(1)
        static int maxProfit(int[] arr) {
            int maxPro = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] > arr[i]) {
                        maxPro = Math.max(arr[j] - arr[i], maxPro);
                    }
                }
            }
            return maxPro;
        }

        // ? Optimal 1
    // ! Time complexity : O(n)
    // ! Space complexity : O(1)
        static int optimal1(int[] prices){
            int n = prices.length;
            int profit = 0;
            int min = prices[0];
            for ( int i = 1 ; i < n ; i++){
                int great = prices[i] - min;
                profit = Math.max(profit , great);
                min = Math.min(min , prices[i]);
            }
            return profit;
        }

        // ? Optimal 2
        static int optimal2(int[] prices){
            int n = prices.length;
            int profit = 0;
            int min = prices[0];
            for ( int i = 1 ; i < n ; i++){
                profit = Math.max(profit , prices[i] - min);
                min = Math.min(min , prices[i]);
            }
            return profit;
        }
    }


