/*Input: s = "leetscode", dictionary = ["leet","code","leetcode"]
Output: 1
Explanation: We can break s in two substrings: "leet" from index 0 to 3 and 
"code" from index 5 to 8. There is only 1 unused character (at index 4), so we return 1. */

package Walmart;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Extra_Characters_in_String {

    public int minExtraChar(String s, String[] dictionary) {

        int n=s.length();
        int t[]=new int[n+1];
        Arrays.fill(t,0);

        Set<String> set=new HashSet<>(Arrays.asList(dictionary));
        
        for(int i=1;i<n+1;i++){
            t[i]=t[i-1]+1;
            for(int j=1;j<=i;j++){
                if(set.contains(s.substring(i-j,i))) t[i]=Math.min(t[i],t[i-j]);
            }
        }
        return t[n];
    }
}
