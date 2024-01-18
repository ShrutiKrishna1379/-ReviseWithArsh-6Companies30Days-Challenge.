// Longest Word in Dictionary through deleting

/*Input: s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
Output: "apple" */

package Adobe;

import java.util.List;

public class Longest_Word {
    public String findLongestWord(String s, List<String> dictionary) {
        String ans="";
        for (String c: dictionary)
            if ((c.length()>ans.length() || c.length()==ans.length() && c.compareTo(ans)<0) && isSubseq(c, s))
            ans=c;
        return ans;
    }
    public boolean isSubseq(String a, String b){
        int i=-1, j=-1;
        while (++i<a.length()) if ((j=b.indexOf(a.charAt(i), j+1))==-1) return false;
        return true;
    }
}
