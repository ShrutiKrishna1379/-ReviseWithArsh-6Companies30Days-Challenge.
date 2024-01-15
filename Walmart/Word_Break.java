/*Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code". */

package Walmart;

import java.util.List;

public class Word_Break {
    
     public boolean wordBreak(String s, List<String> wordDict) {
        Boolean t[]= new Boolean [s.length() + 1];
        return canBreak(s, wordDict, 0, t);
    }

    boolean canBreak(String s, List<String> wordDict, int i, Boolean [] t) {
        if (i== s.length())
            return true;

        if (t[i] != null)
            return t[i];

        for (String word: wordDict) {
            if (s.startsWith(word, i) && canBreak(s, wordDict, i+word.length(), t))
                return true;
        }

        return t[i] = false;
    }

}
