/**
 * Created by jniu on 6/29/17.
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if(nums == null) return 0;
        int last = 0;
        for(int i=0; i<nums.length; i++){
            if(val != nums[i]){
                nums[last] = nums[i];
                last++;
            }
        }
        return last;
    }
}