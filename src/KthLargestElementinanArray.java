//Do again in quick select
/**
 * Created by jniu on 7/3/17.
 */
//95% quick select
public class KthLargestElementinanArray1 {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length ==0) return 0;
        int i = 0, j=nums.length-1;
        int index, pivot;
        while(i<j){
            index = i+(j-i)/2;
            swap(nums, index, j);
            pivot = nums[j];
            int l = i;
            for(int m = i; m<j; m++){
                if(nums[m]>=pivot){
                    swap(nums, m, l);
                    l++;
                }
            }
            swap(nums, j, l);
            if(l==k-1){
                return nums[l];
            } else if(l>k-1){
                j = l-1;
            } else {
                i = l+1;
            }
        }
        return nums[i];
    }

    private void swap(int[] nums, int i, int j){
        if(i==j) return;
        int tmp = nums[i];
        nums[i]= nums[j];
        nums[j] = tmp;
    }
}

// 70%
public class KthLargestElementinanArray2 {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length ==0) return 0;
        Queue<Integer> pq = new PriorityQueue<>(k);

        for(int n: nums){
            if(pq.size()<k){
                pq.add(n);
            } else {
                int min = pq.element();
                if(n>min){
                    pq.remove();
                    pq.add(n);
                }
            }
        }
        return pq.element();
    }
}