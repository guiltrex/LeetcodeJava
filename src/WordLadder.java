/**
 * Created by jniu on 7/2/17.
 */
//BFS, 56%
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList == null || wordList.size()==0) return 0;
        if(beginWord == null || endWord == null || beginWord.length() != endWord.length()) return 0;
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Queue<String> q = new ArrayDeque<>();
        q.add(beginWord);
        visited.add(beginWord);
        int distance = 1;
        char[] chs = new char[26];
        for(int i = 0; i<26; i++){
            chs[i] = (char)('a' + i);
        }
        while(!q.isEmpty()){
            int levelSize = q.size();
            distance++;
            for(int i=0; i<levelSize; i++){
                char[] cur = q.remove().toCharArray();
                for(int j =0; j<cur.length;j++){
                    char tmp = cur[j];
                    for(char c: chs){
                        if(c != tmp){
                            cur[j] = c;
                            String toVisit = new String(cur);
                            if(wordSet.contains(toVisit) && !visited.contains(toVisit)){
                                if(toVisit.equals(endWord)) return distance;
                                q.add(toVisit);
                                visited.add(toVisit);
                            }
                        }
                    }
                    cur[j] = tmp;
                }
            }
        }
        return 0;
    }
}