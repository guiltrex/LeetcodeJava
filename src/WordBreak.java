//Do BFS in the future
/**
 * Created by jniu on 6/29/17.
 */
//DFS 40%
public class WordBreak1 {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s==null || s.length() == 0) return false;
        set = new HashSet<String>(wordDict);
        cache = new HashSet<String>();
        return helper(s);
    }

    private boolean helper(String s){
        if(set.contains(s)) return true;
        if(s.length() == 1) return set.contains(s);
        if(cache.contains(s)) return false;

        for(int i=1; i<s.length(); i++){
            String str1 = s.substring(0, i);
            if(set.contains(str1)){
                String str2 = s.substring(i, s.length());
                if(helper(str2)) return true;
            }
        }

        cache.add(s);
        return false;
    }

    private Set<String> cache;
    private Set<String> set;
}

//DP 72.24%
public class WordBreak2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s==null || s.length() == 0) return false;
        Set<String> set = new HashSet<String>(wordDict);
        int n = s.length();
        boolean[] res = new boolean[n];
        for(int i=0; i<n; i++){
            res[i] = set.contains(s.substring(0, i+1));
            for(int j=i-1; !res[i] && j>=0;j--){
                res[i] = res[j] && set.contains(s.substring(j+1, i+1));
            }
        }
        return res[n-1];
    }
}

//BFS