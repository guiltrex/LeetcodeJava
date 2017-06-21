//Do again
/**
 * Created by jniu on 6/20/17.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x<0) return false;
        int mask = 1;
        while(x/mask>=10 || x/mask<=-10){
            mask *=10;
        }
        int curDigit = 10, cx = x;
        while (mask>=10){
            if(cx/mask % 10 != cx%curDigit){
                return false;
            } else {
                cx /= 10;
                mask /= 100;
            }
        }
        return true;
    }
}

public class PalindromeNumber2 {
    public boolean isPalindrome(int x) {
        if (x<0 || (x>0 && x%10 == 0)) return false;
        int rx = 0;
        while(x>rx){
            rx = rx*10 + x%10;
            x /= 10;
        }
        return x == rx || rx/10 == x;
    }
}