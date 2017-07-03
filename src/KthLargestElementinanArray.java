/**
 * Created by jniu on 7/3/17.
 */
// 70%
public class KthLargestElementinanArray {
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