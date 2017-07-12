//Do again using build-in functions
/**
 * Created by jniu on 7/11/17.
 */
//90%
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        if(s==null || s.length() ==0) return "";
        StringBuilder sb = new StringBuilder();
        char[] chs = s.toCharArray();
        boolean inWord = chs[chs.length-1] != ' ';
        int j = chs.length;
        for(int i=chs.length-1; i>=0; i--){
            if(chs[i]==' '){
                if(inWord){
                    sb.append(chs, i+1, j-i-1);
                    sb.append(' ');
                    j = i;
                    inWord = false;
                } else {
                    j--;
                }
            } else {
                inWord = true;
            }
        }
        if(inWord) {
            sb.append(chs, 0, j);
        } else {
            if(sb.length()>0) sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
}