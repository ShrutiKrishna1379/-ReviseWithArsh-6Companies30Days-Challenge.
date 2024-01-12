// Input: words = ["i","love","leetcode","i","love","coding"], k = 2
// Output: ["i","love"]
// Explanation: "i" and "love" are the two most frequent words.
// Note that "i" comes before "love" due to a lower alphabetical order.

package Walmart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Top_K_FreqWords {
     public List<String> topKFrequent(String[] words, int k) {
        Map<String , Integer> freq = new HashMap<>();
       
        for(String i : words) freq.put(i,freq.getOrDefault(i, 0) + 1);
         ArrayList<String> ans = new ArrayList<>(freq.keySet());
         
        Collections.sort(ans , (a,b) -> freq.get(b) != freq.get(a) ? freq.get(b) - freq.get(a) : a.compareTo(b));
        return ans.subList(0,k);
    }
}
