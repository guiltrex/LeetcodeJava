/**
 * Created by jniu on 6/27/17.
 */
public class MinMovesToEqualArrayElements {
    public int minMoves(int[] nums) {
        int min = nums[0];
        for(int n: nums){
            min = Math.min(min, n);
        }
        int res = 0;
        for(int n: nums){
            res += n-min;
        }
        return res;
    }
}