// K-diff Pairs in an Array

/*Input: nums = [3,1,4,1,5], k = 2
  Output: 2
  Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
  Although we have two 1s in the input, we should only return the number of unique pairs. */

package Walmart;

import java.util.HashSet;

public class K_diff_Pairs_in_Array {
    public int findPairs(int[] nums, int k) {

        HashSet<Integer> set=new HashSet<>();
        HashSet<Integer> set1=new HashSet<>();
        
        for(int i:nums){
            if(set.contains(i)) set1.add(i);
            set.add(i);
        }
        
        if(k==0) return set1.size();
        
        int cnt=0;
        for(int i:set){
            if(set.contains(k+i)) cnt++;
        }
        return cnt;
    }
}
