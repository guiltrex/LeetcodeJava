/**
 * Created by jniu on 6/27/17.
 */
//40%
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int fct = 1;
        int[] output = new int[nums.length];
        output[0]=1;
        for(int i = 1; i<nums.length; i++){
            output[i]=output[i-1]*nums[i-1];
        }
        for(int i=nums.length-2; i>=0; i--){
            fct = fct*nums[i+1];
            output[i] = output[i]*fct;
        }
        return output;
    }
}

//almost the same, just a small refactor
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        output[0]=1;
        for(int i = 1; i<nums.length; i++){
            output[i]=output[i-1]*nums[i-1];
        }
        for(int i=nums.length-1, fct = 1; i>=0; i--){
            output[i] = output[i]*fct;
            fct = fct*nums[i];
        }
        return output;
    }
}