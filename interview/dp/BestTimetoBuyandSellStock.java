package interview.dp;
/**
Thoughts:
Variant of maxsub array problem
So use Kadanes algorithm
compute the profit by diference of stock price ith day and i-1th day.
check if cumulative profit is more than 0 then its the curMax
then check max maximum of curMax sofar.
*/
class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int max=0,curMax=0;
        for(int i=1;i<prices.length;i++){
            curMax= Math.max(0,curMax+=prices[i]-prices[i-1]);
            max=Math.max(max,curMax);
        }
        return max;
    }
}