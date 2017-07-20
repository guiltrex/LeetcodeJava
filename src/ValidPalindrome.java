/**
 * Created by jniu on 7/14/17.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s == null || s.length()==0) return true;
        for(int i =0, j=s.length()-1; i<j;){
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            if(!Character.isLetterOrDigit(c1) || !Character.isLetterOrDigit(c2)) {
                if(!Character.isLetterOrDigit(c1)) i++;
                if(!Character.isLetterOrDigit(c2)) j--;
            } else {
                if(Character.toLowerCase(c1) != Character.toLowerCase(c2)){
                    return false;
                } else {
                    i++;
                    j--;
                }
            }
        }
        return true;
    }
}