/**
 * Created by jniu on 7/12/17.
 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if(num==null || num.length() ==0 || num.length() ==k) return "0";
        char[] chs = num.toCharArray();
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i =0; i<chs.length; i++){
            int cur = chs[i] - '0';
            while(k>0 && !dq.isEmpty() && dq.peek()>cur){
                dq.pop();
                k--;
            }
            dq.push(cur);
        }
        int end = dq.size()-1;
        for(int i = end; i>=0; i--){
            chs[i]=(char)('0'+dq.pop());
        }
        if(k>0) end = end-k;
        int start = 0;
        while(start<=end && chs[start]=='0') start++;
        return (start>end? "0" : new String(chs, start, end-start+1));
    }
}