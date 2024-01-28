/*Input: startWords = ["ant","act","tack"], targetWords = ["tack","act","acti"]
Output: 2
Explanation:
- In order to form targetWords[0] = "tack", we use startWords[1] = "act", append 'k' to it, and rearrange "actk" to "tack".
- There is no string in startWords that can be used to obtain targetWords[1] = "act".
  Note that "act" does exist in startWords, but we must append one letter to the string before rearranging it.
- In order to form targetWords[2] = "acti", we use startWords[1] = "act", append 'i' to it, and rearrange "acti" to "acti" itself.*/

class CountWord_ObtainedAfterAdding_Letter {
  
    public int wordCount(String[] startWords, String[] targetWords) {
        Set<Integer> set = new HashSet<>();
        for(String w : startWords){
            int temp = 0;
            for(char c : w.toCharArray()) temp |= (1 << (c - 'a'));
            set.add(temp);
        }
        int ans = 0;
        for(String w : targetWords){
            int temp = 0;
            char[] s = w.toCharArray();
            for(char c : s) temp |= (1 << (c - 'a'));
            for(int i = 0; i < s.length; i++){
                if(set.contains(temp & ~(1 << (s[i] - 'a')))){
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
