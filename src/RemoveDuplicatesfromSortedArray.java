//Do it again
/**
 * Created by jniu on 6/29/17.
 */
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums==null || nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        int rb = 1;
        for(int i=1;i<nums.length; i++){
            if(nums[i] != nums[i-1]) {
                nums[rb]=nums[i];
                rb++;
            }
        }
        return rb;
    }
}