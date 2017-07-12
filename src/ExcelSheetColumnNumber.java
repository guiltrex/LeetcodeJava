/**
 * Created by jniu on 7/11/17.
 */
//48%
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        if(s==null || s.length()==0) return 0;
        char[] chs = s.toCharArray();
        int res = 0;
        for(int i=0; i<chs.length; i++){
            res = res*26 + 1 + chs[i]-'A';
        }
        return res;
    }
}