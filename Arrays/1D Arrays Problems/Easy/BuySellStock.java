public class BuySellStock {
/*  
    Problem = Best time to buy and sell stock (Leetcode 121)
    Time complexity = O(n)
    Space complexity = O(1);

*/
    public static int maxProfit(int prices[]){
        int buy = prices[0];
        int profit = 0;
        for(int i = 0; i<prices.length; i++){
            if(prices[i]<buy){
                buy = prices[i];
            }
            profit = Math.max(profit,prices[i]-buy);
        }
        return profit;
    }

    public static void main(String[] args){
        int prices[] = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}

// Output = 5
