/**
 * Created by jniu on 6/23/17.
 */
//Or use Integer instead of int for max array
public class ThirdMaxNumber {
        public int thirdMax(int[] nums) {
            if(nums == null || nums.length == 0) return 0;
            if(nums.length == 1) return nums[0];
            if(nums.length == 2) return Math.max(nums[0], nums[1]);
            Set<Integer> set = new HashSet<>();
            int[] max = new int[]{Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};

            for(int i = 0; i<nums.length; i++){
                if(!set.contains(nums[i])){
                    insert(max, nums[i]);
                    set.add(nums[i]);
                }
            }
            if(set.size()<3){
                return max[0];
            } else {
                return max[2];
            }
        }

        private void insert(int[] max, int n){
            if(n>max[0]){
                max[2] = max[1];
                max[1] = max[0];
                max[0] = n;
            } else if(n<max[0] && n>max[1]){
                max[2] = max[1];
                max[1] = n;
            } else if(n<max[1] && n>max[2]){
                max[2] = n;
            }
        }
    }

}


private class ThirdMaxNumber2 {
    public int thirdMax(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        Set<Integer> set = new HashSet<>();
        Queue<Integer> pq = new PriorityQueue<>(3);
        set.add(nums[0]);
        pq.add(nums[0]);
        for(int i = 1; i<nums.length; i++){
            if(!set.contains(nums[i])){
                if(pq.size()==3){
                    if( pq.peek()<nums[i]) {
                        pq.remove();
                        pq.add(nums[i]);
                    }
                } else {
                    pq.add(nums[i]);
                }
                set.add(nums[i]);
            }
        }
        int res = pq.peek();

        if (pq.size()<3){
            while(!pq.isEmpty()){
                res = pq.remove();
            }
        }
        return res;
    }
}