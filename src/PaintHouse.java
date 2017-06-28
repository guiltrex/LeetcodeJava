/**
 * Created by jniu on 6/28/17.
 */
public class PaintHouse {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length ==0 || costs[0] == null || costs[0].length < 3) return 0;
        int c0 = costs[0][0], c1=costs[0][1], c2=costs[0][2];
        int tmp0, tmp1, tmp2;

        for(int i=1; i<costs.length; i++){
            tmp0 = Math.min(c2+costs[i][0], c1+costs[i][0]);
            tmp1 = Math.min(c2+costs[i][1], c0+costs[i][1]);
            tmp2 = Math.min(c1+costs[i][2], c0+costs[i][2]);
            c0 = tmp0;
            c1 = tmp1;
            c2 = tmp2;
        }

        return Math.min(c2, Math.min(c0, c1));
    }
}