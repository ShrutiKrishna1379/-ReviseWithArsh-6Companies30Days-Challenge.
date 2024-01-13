// Maximum Length Of Repeated Subarray

/*Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
Output: 3
Explanation: The repeated subarray with maximum length is [3,2,1]. */

package Walmart;

public class Maximum_Length {
    public int findLength(int[] nums1, int[] nums2) {

        int n=nums1.length, m=nums2.length,max=0;

        int t[][]=new int[n+1][m+1];

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                
                if(nums1[i-1]==nums2[j-1]){

                    t[i][j]=1+t[i-1][j-1];
                    max=Math.max(max,t[i][j]);

                }
                else t[i][j]=0;
            }
        }
        return max;
    }
}
