// Minimum moves to equal array elements

/*Input: nums = [1,2,3]
Output: 2
Explanation:
Only two moves are needed (remember each move increments or decrements one element):
[1,2,3]  =>  [2,2,3]  =>  [2,2,2] */

package Microsoft;

import java.util.Arrays;

public class Minimum_moves {
    
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid=(nums.length-1)/2;
        int sum=0;
        for(int i=0;i<nums.length;i++) sum+=Math.abs(nums[mid]-nums[i]);
        return sum;
    }
}
