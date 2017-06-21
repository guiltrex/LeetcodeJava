/**
 * Created by jniu on 6/20/17.
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length ==0) return 0;
        int maxProfit = 0, minPP = prices[0];
        for (int i=1;i<prices.length;i++){
            if (prices[i] > minPP) {
                maxProfit = Math.max(prices[i]-minPP, maxProfit);
            } else {
                minPP = prices[i];
            }
        }
        return maxProfit;
    }
}