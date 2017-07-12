/**
 * Created by jniu on 7/11/17.
 */
//93%
public class DecodeWays {
    public int numDecodings(String s) {
        if(s==null || s.length()==0 || s.charAt(0) =='0') return 0;
        char[] chs = s.toCharArray();
        int n1=1, n2=1, tmp;
        for(int i=1; i<chs.length; i++){
            tmp = chs[i]!='0'?n1:0;
            if(chs[i-1] == '1' || chs[i-1]=='2' && chs[i]-'0'<=6) tmp += n2;
            n2 = n1;
            n1 = tmp;
        }
        return n1;
    }
}