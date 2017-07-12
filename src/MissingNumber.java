//Do again for better implementation
/**
 * Created by jniu on 7/10/17.
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        if(nums == null) return -1;
        int res = 0;
        for(int i=1; i<=nums.length; i++) res ^= i;
        for(int i: nums) res ^= i;
        return res;
    }
}