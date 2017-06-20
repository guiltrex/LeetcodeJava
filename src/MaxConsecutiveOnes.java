/**
 * Created by jniu on 6/20/17.
 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums==null || nums.length == 0) return 0;
        int s = -1, e=0, ml=0;
        for(;e<nums.length;e++){
            if (nums[e] == 0) {
                ml = Math.max(ml, e-s-1);
                s = e;
            }
        }
        ml = Math.max(ml, e-s-1);
        return ml;
    }
}