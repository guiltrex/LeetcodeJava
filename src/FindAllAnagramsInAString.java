/**
 * Created by jniu on 6/23/17.
 */
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();
        int[] ccp = new int[26];
        int validTot = 0;
        List<Integer> res = new ArrayList<>();
        if (cp.length > cs.length || cp.length == 0) return res;
        for(char c: cp){
            ccp[c-'a'] += 1;
            validTot++;
        }

        for(int i=0, j=0; i < cs.length && j<=cs.length - cp.length;){
            int nl = ccp[cs[i]-'a'];
            if(nl>0){
                validTot--;
                ccp[cs[i]-'a']-=1;
                i++;
            } else if(j<i){
                validTot++;
                ccp[cs[j]-'a']+=1;
                j++;
            } else {
                j++;
                i++;
            }
            if(validTot == 0) {
                res.add(j);
                ccp[cs[j]-'a']+=1;
                validTot++;
                j++;
            }
        }
        return res;
    }
}


private class FindAllAnagramsInAString2 {
    public List<Integer> findAnagrams(String s, String p) {
        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();
        List<Integer> res = new ArrayList<>();
        if (cp.length > cs.length || cp.length == 0) return res;
        int[] ccp = new int[26];
        int validTot = cp.length;
        for(char c: cp){
            ccp[c-'a'] += 1;
        }
        for(int i=0, j=0; i<cs.length;){
            if(ccp[cs[i]-'a']>0){
                validTot--;
            }
            ccp[cs[i]-'a']--;
            i++;
            if(validTot == 0) res.add(j);
            if(i-j == cp.length && ccp[cs[j]-'a'] >=0){
                validTot++;
            }
            if(i-j == cp.length) {
                ccp[cs[j]-'a']++;
                j++;
            }

        }
        return res;
    }
}