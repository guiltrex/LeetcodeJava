/**
 * Created by jniu on 6/23/17.
 */
public class HouseRobberI {
    public int rob(int[] nums) {
        if(nums == null || nums.length ==0) return 0;
        int m1=nums[0], m2=0;
        for(int i =1; i<nums.length; i++){
            int temp = Math.max(nums[i]+m2, m1);
            m2 = m1;
            m1 = temp;
        }
        return Math.max(m2, m1);
    }
}