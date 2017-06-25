/**
 * Created by jniu on 6/23/17.
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s==null || t==null ) return false;
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        if(cs.length != ct.length) return false;
        Arrays.sort(cs);
        Arrays.sort(ct);
        return Arrays.equals(cs, ct);
    }
}

private class ValidAnagram2 {
    public boolean isAnagram(String s, String t) {
        if (s==null || t==null ) return false;
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        if(cs.length != ct.length) return false;
        Map<Character, Integer> map = new HashMap<>();
        for(char c: cs){
            if(!map.containsKey(c)){
                map.put(c, 1);
            } else {
                map.put(c, map.get(c)+1);
            }
        }
        for(char c: ct){
            if(!map.containsKey(c)){
                return false;
            } else {
                int v = map.get(c);
                if(v>1){
                    map.put(c, v-1);
                } else {
                    map.remove(c);
                }
            }
        }
        return map.isEmpty();
    }
}