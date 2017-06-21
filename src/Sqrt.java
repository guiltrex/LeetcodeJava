//Do again
/**
 * Created by jniu on 6/20/17.
 */
public class Sqrt {
    public int mySqrt(int x) {
        if(x<=0) return 0;
        int l = 1, r = x, mid = 1;
        while(l<=r){
            mid = l + (r-l)/2;
            if(mid < x/mid){
                l = mid + 1;
            } else if (mid > x/mid){
                r = mid - 1;
            } else {
                r = mid;
                break;
            }
        }
        return r;
    }
}

private class SqrtNewTon1{
    public int mySqrt(int x) {
        if(x<=0) return 0;
        if(x<4) return 1;
        int t = 2;
        while( t > x/t || (t+1)<x/(t+1)){
            t= (t+x/t)/2;
        }
        if(t==x/t) {
            return t;
        } else if(t+1 == x/(t+1)) {
            return t+1;
        } else {
            return t;
        }
    }
}

private class SqrtNewTon2{
    public int mySqrt(int x) {
        if(x<=0) return 0;
        if(x<4) return 1;
        int t = 2;
        while(!(t<=x/t && t+1>=x/(t+1))){
            t = (int)(x/(t/2.0+x/(2.0*t)));
        }
        if(t==x/t){
            return t;
        } else if(t+1 == x/(t+1)) {
            return t+1;
        } else { return t;}
    }
}