/**
 * Created by jniu on 6/23/17.
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        if(s==null) return 0;
        char[] strChs = s.toCharArray();
        int[] chsNum = new int[64];
        int res = 0;
        boolean flag = false;
        for(char c: strChs){
            chsNum[c-'A']++;
        }
        for(int cn: chsNum){
            res += 2*(cn/2);
            if(!flag && cn % 2 == 1) flag = true;
        }
        return res + (flag?1:0);
    }
}