//Do again
/**
 * Created by jniu on 6/28/17.
 */
//81.41%
public class ShortestDistanceII {
    final private String[] words;
    private Map<List<String>, Integer> cache;
    private Map<String, List<Integer>> indices;

    public WordDistance(String[] words) {
        this.words = words;
        cache = new HashMap<>();
        indices = new HashMap<>();
        for(int i=0; i<words.length; i++){
            String cur = words[i];
            List<Integer> cl;
            if(indices.containsKey(cur)){
                cl = indices.get(cur);
            } else {
                cl = new ArrayList<>();
            }
            cl.add(i);
            indices.put(cur, cl);
        }
    }

    public int shortest(String word1, String word2) {
        List<String> pair;
        if(word1.compareTo(word2) < 0){
            pair = Arrays.asList(word1, word2);
        } else {
            pair = Arrays.asList(word2, word1);
        }
        if(cache.containsKey(pair)) return cache.get(pair);

        int dist = words.length;
        List<Integer> indices1 = indices.get(word1);
        List<Integer> indices2 = indices.get(word2);
        for(int i=0, j=0; i<indices1.size() && j<indices2.size(); ){
            int p1 = indices1.get(i);
            int p2 = indices2.get(j);
            if(p1>p2){
                dist = Math.min(dist, p1-p2);
                j++;
            } else {
                dist = Math.min(dist, p2-p1);
                i++;
            }
            if(dist == 1) break;
        }

        cache.put(pair, dist);
        return dist;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */