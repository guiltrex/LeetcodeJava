//Do again using constant space
/**
 * Created by jniu on 7/10/17.
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        if(nums==null || nums.length == 0) return 0;
        int res = nums[0];
        for(int i=1; i<nums.length; i++) res ^= nums[i];
        return res;
    }
}