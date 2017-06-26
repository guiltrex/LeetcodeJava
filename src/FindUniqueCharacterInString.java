/**
 * Created by jniu on 6/25/17.
 */
public class FindUniqueCharacterInString {
    public int firstUniqChar(String s) {
        int[] chNums = new int[26];
        int id;
        for(int i = 0; i<s.length(); i++){
            id = s.charAt(i) - 'a';
            if(chNums[id] != 0){
                chNums[id] = -1;
            } else {
                chNums[id] = i+1;
            }
        }
        id = s.length();
        for(int i = 0; i<26; i++){
            if(chNums[i] > 0) id = Math.min(id, chNums[i]-1);
        }
        return id == s.length()?-1:id;
    }
}