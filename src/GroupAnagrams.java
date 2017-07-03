/**
 * Created by jniu on 6/29/17.
 */
//using map and sort each string, 94%
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String str: strs){
            String key = getAnagramKey(str);
            if(map.containsKey(key)){
                map.get(key).add(str);
            } else {
                List<String> group = new ArrayList<String>();
                group.add(str);
                map.put(key, group);
            }
        }

        return new ArrayList<List<String>>(map.values());
    }

    private String getAnagramKey(String str){
        char[] chs = str.toCharArray();
        Arrays.sort(chs);
        return new String(chs);
    }
}