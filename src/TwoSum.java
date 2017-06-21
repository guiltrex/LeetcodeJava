/**
 * Created by jniu on 6/21/17.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        int diff, ci;
        for(int i=0; i< nums.length; i++){
            diff = target - nums[i];
            if(map.containsKey(diff)){
                ci = map.get(diff);
                return new int[]{ci, i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }
}