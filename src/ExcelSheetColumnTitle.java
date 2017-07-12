/**
 * Created by jniu on 7/11/17.
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n>0){
            char ch = (char)('A' + (n-1)%26);
            sb.append(ch);
            n = (n-1)/26;
        }
        return sb.reverse().toString();
    }
}