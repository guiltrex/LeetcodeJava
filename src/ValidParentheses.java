/**
 * Created by jniu on 6/23/17.
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Deque<Character> deq = new ArrayDeque<>();
        char[] chs = s.toCharArray();
        for(char c: chs){
            if(c == '(' || c== '{' || c=='['){
                deq.push(c);
            } else {
                if(!deq.isEmpty()){
                    char start = deq.pop();
                    if(!match(start, c)) return false;
                } else {
                    return false;
                }
            }
        }
        return deq.isEmpty();
    }

    private boolean match(char s, char e){
        return s =='(' && e==')' || s =='[' && e==']' || s =='{' && e=='}';
    }
}