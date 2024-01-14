/*Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer. */

package Walmart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Sort_Character_By_Frequency {
    
    public String frequencySort(String s) {
        HashMap<Character,Integer> map=new HashMap<>();

        for(char i:s.toCharArray()) map.put(i,map.getOrDefault(i,0)+1);
        
        List<Character> list=new ArrayList<>(map.keySet());
        
        list.sort((a,b)-> map.get(b)-map.get(a));
        
        StringBuilder ans=new StringBuilder();
        for(char c:list){
            for(int j=0;j<map.get(c);j++) ans.append(c);
        }
        
        return ans.toString();
    }
}
