// Count the number of incremovable subarrays
// Input: nums = [6,5,7,8]
// Output: 7
// Explanation: The 7 incremovable subarrays are: [5], [6], [5,7], [6,5], [5,7,8], [6,5,7] and [6,5,7,8].
// It can be shown that there are only 7 incremovable subarrays in nums.

package Microsoft;

public class Count_Num_Incremovable_Subarrays {
    public int incremovableSubarrayCount(int[] nums) {
        int i = 0, n = nums.length;
        while(i+1<n&&nums[i]<nums[i+1]) {
            i++;
        }
        if (i==n-1) {
            return n*(n+1)/2;
        }

        int ans=i+2;
        for (int j=n-1; j>0; j--) {
            while (i>=0&&nums[i]>=nums[j]) {
                i--;
            }
            ans+=i+2;
            if (nums[j-1]>=nums[j]) break;
        }
        return ans;
    }
}
