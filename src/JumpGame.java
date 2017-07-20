/**
 * Created by jniu on 7/13/17.
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length ==0) return true;
        int r=0, l = 0;
        while(l<=r){
            int max = r;
            for(int i = l; i<=r; i++){
                max = Math.max(max, i+nums[i]);
            }
            l = r+1;
            r = max;
            if(r >=nums.length-1) return true;
        }
        return false;
    }
}

//refactored a bit
public class JumpGame2 {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length ==0) return true;
        int r=0;
        for(int i = 0; i<nums.length && r<nums.length-1; i++){
            if(i>r) return false;
            r = Math.max(r, i+nums[i]);
        }
        return true;
    }
}