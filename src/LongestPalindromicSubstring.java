//Do again using DP
/**
 * Created by jniu on 7/1/17.
 */
//62%
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";
        char[] chs = s.toCharArray();
        int res = 1, start=0, end = 0;
        for(int i = 0; i<s.length()-1; i++){
            for(int d = 0; d<=1; d++){
                int j = i, k=i+d;
                while(j>=0 && k<s.length() && chs[j] == chs[k]){
                    k++;
                    j--;
                }
                if(k-j-1 > res){
                    start = j+1;
                    end = k-1;
                    res = k-j-1;
                }
            }
        }
        return s.substring(start, end+1);
    }
}