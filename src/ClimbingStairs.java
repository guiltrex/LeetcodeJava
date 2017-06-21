/**
 * Created by jniu on 6/20/17.
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        int s1 = 1, s2 = 0;
        for(int i=0; i<n; i++){
            int temp = s1+s2;
            s2 = s1;
            s1 = temp;
        }
        return s1;
    }
}