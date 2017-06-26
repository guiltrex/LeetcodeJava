/**
 * Created by jniu on 6/26/17.
 */
//This solution may be overflow when numbers[0] is close to MIN_VALUE or numbers[length-1] is close to MAX_VALUE;
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        for(int i =0, j=numbers.length-1; i<j;){
            if(numbers[i]+numbers[j]>target){
                j--;
            } else if(numbers[i]+numbers[j]<target){
                i++;
            } else {
                return new int[]{i+1, j+1};
            }
        }
        return new int[2];
    }
}

//No overflow concern
public class TwoSumII2 {
    public int[] twoSum(int[] numbers, int target) {
        for(int i =0, j=numbers.length-1; i<j;){
            if(numbers[j]>target-numbers[i]){
                j--;
            } else if(numbers[i]<target-numbers[j]){
                i++;
            } else {
                return new int[]{i+1, j+1};
            }
        }
        return new int[2];
    }
}