//Do again
/**
 * Created by jniu on 6/26/17.
 */
public class LetterCombinationsOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0 || digits.equals("1") || digits.equals("0")) return res;

        Queue<List<Character>> q = new ArrayDeque<List<Character>>();
        List<Character> list = new ArrayList<Character>();
        q.add(list);

        for(int i = 0; i<digits.length(); i++){
            int qs = q.size();

            char[] chs = maps[digits.charAt(i)-'0'];
            if(chs.length > 0){
                for(int j=0; j<qs; j++){
                    List<Character> curList = q.remove();
                    for(char ch: chs){
                        List<Character> newList = new ArrayList<>(curList);
                        newList.add(ch);
                        q.add(newList);
                    }
                }
            }
        }

        for(List<Character> l : q){
            StringBuilder bd = new StringBuilder();
            for(char ch: l){
                bd.append(ch);
            }
            if(bd.length()>0) {
                res.add(bd.toString());
            }
        }
        return res;
    }

    private char[][] maps = {
            new char[0],
            new char[0],
            new char[]{'a','b','c'},
            new char[]{'d','e','f'},
            new char[]{'g','h','i'},
            new char[]{'j','k','l'},
            new char[]{'m','n','o'},
            new char[]{'p','q','r','s'},
            new char[]{'t','u','v'},
            new char[]{'w','x','y','z'}
    };
}