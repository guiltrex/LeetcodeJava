/**
 * Created by jniu on 6/28/17.
 */
//80.99%
public class ShortestWordDistances {
    public int shortestDistance(String[] words, String word1, String word2) {
        int i1=-1, i2=-1, dist = words.length;
        for(int i=0; i<words.length; i++){
            if(word1.equals(words[i])){
                i1 = i;
                if(i2 >=0) dist = Math.min(dist, i1-i2);
            }
            if(word2.equals(words[i])){
                i2 = i;
                if(i1 >=0) dist = Math.min(dist, i2-i1);
            }
        }
        return dist;
    }
}