/**
 * Created by jniu on 7/14/17.
 */
public class NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int sum = 0;
        while(n!=0){
            sum += n & 1;
            n = n>>>1;
        }
        return sum;
    }
}

public class NumberOf1Bits2 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int sum = 0;
        int mask = 1;
        while(mask!=0){
            if((mask & n) != 0) sum++;
            mask <<= 1;
        }
        return sum;
    }
}