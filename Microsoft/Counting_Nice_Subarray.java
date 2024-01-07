/*Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].

1 <= nums.length <= 50000
1 <= nums[i] <= 10^5
1 <= k <= nums.length
*/

package Microsoft;

public class Counting_Nice_Subarray {
    public int numberOfSubarrays(int[] nums, int k) {
        int cnt=0,sum=0;
        int[] odd=new int[nums.length+1];
        odd[0]=1;
        for(int i: nums){
            sum+=i&1;
            if(sum>=k){
                cnt+=odd[sum-k];
            }
            odd[sum]++;
        }
        return cnt;
    }
}
