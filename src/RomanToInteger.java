/**
 * Created by jniu on 7/11/17.
 */
//70%
public class RomanToInteger {
    public int romanToInt(String s) {
        if(s == null || s.length()==0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        char[] chs = s.toCharArray();
        int res = 0;
        for(int i = 0; i<chs.length; i++){
            if(i==chs.length-1){
                res += map.get(chs[i]);
            } else {
                int next = map.get(chs[i+1]);
                int cur = map.get(chs[i]);
                if(cur < next) {
                    res -= cur;
                } else {
                    res += cur;
                }
            }
        }
        return res;
    }
}