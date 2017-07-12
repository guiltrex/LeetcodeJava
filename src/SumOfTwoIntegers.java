/**
 * Created by jniu on 7/10/17.
 */
public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        if(a==0 || b==0) return a==0?b:a;
        int op1 = a, op2 = b;
        while(op2 != 0){
            int tmp = op1 ^ op2;
            op2 = (op1 & op2) << 1;
            op1 = tmp;
        }
        return op1;
    }
}

public class substractionOfTwoIntegers {
    public int substract(int a, int b) {
        if (a == 0 || b == 0) return a == 0 ? b : a;
        int op1 = a, op2 = -b;
        while (op2 != 0) {
            int borrow = (~op1) & op2;
            op1 = op1 ^ op2;
            op2 = borrow << 1;
        }
        return op1;
    }
}