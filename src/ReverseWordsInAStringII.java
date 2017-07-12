//Refactor by defining reverse function
/**
 * Created by jniu on 7/11/17.
 */
public class ReverseWordsInAStringII {
    public void reverseWords(char[] s) {
        if(s==null || s.length<=1) return;
        char tmp;
        for(int i=0, j=i; i<=s.length; i++){
            if(i==s.length || s[i]==' '){
                for(int k = i-1; j<k; k--, j++){
                    tmp = s[j];
                    s[j] = s[k];
                    s[k] = tmp;
                }
                j = i+1;
            }
        }
        for(int i=0, j=s.length -1; i<j; i++,j--){
            tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }
}