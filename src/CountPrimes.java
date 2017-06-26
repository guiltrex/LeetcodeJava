//Do again
/**
 * Created by jniu on 6/26/17.
 */

//original 48.25%
public class CountPrimes {
    public int countPrimes(int n) {
        if(n<=2) return 0;
        boolean[] notPrimes = new boolean[n];
        int count = 0;
        for(int i=2; i < n; i++){
            if(!notPrimes[i]){
                count++;
                for(int j=2; i*j<n; j++){
                    notPrimes[i*j] = true;
                }
            }
        }
        return count;
    }
}

//optimized 81.84%
public class CountPrimes1 {
    public int countPrimes(int n) {
        if(n<=2) return 0;
        boolean[] notPrimes = new boolean[n];
        int count = 0;
        for(int i=2; i*i < n; i++){
            if(!notPrimes[i]){
                for(int j=i*i; j<n; j+=i){
                    notPrimes[j] = true;
                }
            }
        }

        for(int i=2; i<n; i++){
            if(!notPrimes[i]) count++;
        }
        return count;
    }
}

//most optimized 96.82%
public class CountPrimes2 {
    public int countPrimes(int n) {
        if(n<=2) return 0;
        boolean[] notPrimes = new boolean[n];
        int count = 0;
        for(int i=3; i*i < n; i+=2){
            if(!notPrimes[i]){
                for(int j=i; i*j<n; j+=2){
                    notPrimes[i*j] = true;
                }
            }
        }

        for(int i = 3; i<n; i+=2){
            if(!notPrimes[i]) count++;
        }
        return count+1;
    }
}