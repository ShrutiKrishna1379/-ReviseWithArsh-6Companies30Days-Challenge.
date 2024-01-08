/*Input: nums = [1,5,1,1,6,4]
Output: [1,6,1,5,1,4]
Explanation: [1,4,1,5,1,6] is also accepted. */

package Microsoft;

import java.util.Arrays;

public class Wiggle_Sort {
    
    public void wiggleSort(int[] nums) {
        int n=nums.length-1;
        int[] arr = nums.clone();
        Arrays.sort(arr);
        for(int i=1;i<nums.length;i+=2) nums[i]=arr[n--];
        for(int i=0;i<nums.length;i+=2) nums[i]=arr[n--];
    }
}
