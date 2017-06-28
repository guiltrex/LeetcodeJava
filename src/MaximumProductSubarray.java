/**
 * Created by jniu on 6/27/17.
 */
//94%
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int m = nums[0], pmax = nums[0]>0? nums[0]: 0, nmin = nums[0]<0? nums[0]: 0, tmp = 0;
        for(int i=1; i<nums.length; i++){
            if(nums[i]==0){
                pmax = 0;
                nmin = 0;
            } else if(nums[i]>0){
                pmax = (pmax == 0? nums[i]: (pmax * nums[i]));
                nmin = (nmin == 0? 0 : (nmin * nums[i]));
            } else {
                tmp = pmax;
                pmax = (nmin == 0? 0: (nmin * nums[i]));
                nmin = (tmp == 0? nums[i]: (tmp * nums[i]));
            }
            m = Math.max(pmax, m);
        }
        return m;
    }
}

//with some refactoring 55.62%
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int m = nums[0], pmax = nums[0]>0? nums[0]: 0, nmin = nums[0]<0? nums[0]: 0, tmp = 0;
        for(int i=1; i<nums.length; i++){
            if(nums[i]<0){
                tmp = pmax;
                pmax = nmin;
                nmin = tmp;
            }
            pmax = Math.max(nums[i], pmax*nums[i]);
            nmin = Math.min(nums[i], nmin*nums[i]);
            m = Math.max(pmax, m);
        }
        return m;
    }
}