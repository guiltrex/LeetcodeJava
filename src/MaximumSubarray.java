//Do again
/**
 * Created by jniu on 6/20/17.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int sum = 0;
        int res = nums[0];
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            res = Math.max(res, sum);
            sum = Math.max(sum, 0);
        }
        return res;
    }
}