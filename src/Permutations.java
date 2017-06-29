/**
 * Created by jniu on 6/28/17.
 */
//Recursive- backtracking 92.87%
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return res;
        helper(res, nums, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, int[] nums, int start){
        if(start == nums.length-1) {
            List<Integer> tmp = new ArrayList<Integer>();
            for(int n: nums) tmp.add(n);
            res.add(tmp);
        } else {
            for(int i=start; i<nums.length; i++){
                swap(nums, start, i);
                helper(res, nums, start+1);
                swap(nums, start, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        if(i == j) return;
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

//Recursive, 21.72%
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return res;
        if(nums.length == 1) {
            List<Integer> l = new ArrayList<>();
            l.add(nums[0]);
            res.add(l);
        }
        int last = nums.length-1;
        for(int i = 0; i<= last; i++){
            swap(nums, i, last);
            int[] rest = Arrays.copyOfRange(nums, 0, last);
            swap(nums, i, last);
            List<List<Integer>> restPerm = permute(rest);
            for(List<Integer> list: restPerm){
                list.add(nums[i]);
            }
            res.addAll(restPerm);
        }
        return res;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}


//No array copy - recursive 34.5%
public class Permutations2 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return res;
        return helper(nums, nums.length-1);
    }

    private List<List<Integer>> helper(int[] nums, int end){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(end==0){
            List<Integer> singlePoint = new ArrayList<Integer>();
            singlePoint.add(nums[0]);
            res.add(singlePoint);
            return res;
        }
        for(int i=0; i<=end; i++){
            swap(nums, i, end);
            List<List<Integer>> lists = helper(nums, end-1);
            swap(nums, i, end);
            for(List<Integer> li: lists){
                li.add(nums[i]);
            }
            res.addAll(lists);
        }
        return res;
    }

    private void swap(int[] nums, int i, int j){
        if(i == j) return;
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}