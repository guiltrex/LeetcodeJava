/**
 * Created by jniu on 6/20/17.
 */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int totProfit = 0;
        for(int i=0; i<prices.length-1; i++){
            totProfit += Math.max(prices[i+1]-prices[i], 0);
        }
        return totProfit;
    }
}