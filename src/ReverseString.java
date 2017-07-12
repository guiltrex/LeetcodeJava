/**
 * Created by jniu on 7/10/17.
 */
public class ReverseString {
    public String reverseString(String s) {
        if(s == null) return null;
        char[] arr = s.toCharArray();
        char tmp;
        for(int i=0, j=arr.length-1; i<j; i++, j--){
            tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        return new String(arr);
    }
}