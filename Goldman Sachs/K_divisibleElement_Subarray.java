/*Given an integer array nums and two integers k and p, return the number of distinct subarrays,
 which have at most k elements that are divisible by p. */

 /*Input: nums = [2,3,3,2,2], k = 2, p = 2
Output: 11 */


import java.util.*;
class K_divisibleElement_Subarray {
    public int countDistinct(int[] nums, int k, int p) {
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            int c=0;
            StringBuilder str=new StringBuilder();
            
            for(int j=i;j<nums.length;j++){
                if(nums[j]%p==0) c++;
                if(c>k) break;
                str.append(nums[j]+" ");
                set.add(str.toString());
            }
        }
        return set.size();
    }
}