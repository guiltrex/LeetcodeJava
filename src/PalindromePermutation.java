/**
 * Created by jniu on 6/23/17.
 */
public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        if(s==null || s.length()==0) return false;
        Map<Character, Integer> map = new HashMap<>();
        char c;
        int num = 0;
        for(int i=0; i< s.length();i++){
            c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }
        for(int n: map.values()){
            num += ((n >> 1) << 1);
        }
        return num>=(s.length()-1);
    }
}

private class PalindromePermutation2 {
    public boolean canPermutePalindrome(String s) {
        if(s==null || s.length()==0) return false;
        Set<Character> set = new HashSet<Character>();
        char ch;
        for(int i =0; i< s.length();i++){
            ch = s.charAt(i);
            if(set.contains(ch)){
                set.remove(ch);
            } else {
                set.add(ch);
            }
        }
        return set.size()<=1;
    }
}