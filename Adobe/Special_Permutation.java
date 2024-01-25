/*You are given a 0-indexed integer array nums containing n distinct positive integers. 
A permutation of nums is called special if:
  For all indexes 0 <= i < n - 1, either nums[i] % nums[i+1] == 0 or nums[i+1] % nums[i] == 0.
  Return the total number of special permutations. As the answer could be large, return it modulo 109 + 7.
  
Example 1:
Input: nums = [2,3,6]
Output: 2
Explanation: [3,6,2] and [2,6,3] are the two special permutations of nums.*/

class Special_Permutation {
    int mod = (int)1e9+7;
    int[][] t;
    public int specialPerm(int[] nums) {
        int n = nums.length;
        t = new int[n][1<<n];
        for(int[] i : t)Arrays.fill(i,-1);
        return helper(nums,0,0);
    }
    int helper(int[] nums, int i, int mask){
        int n = nums.length;
        if(mask==((1<<n)-1))return 1;
        if(t[i][mask]!=-1)return t[i][mask];
        int count = 0;
        for(int k = 0;k<n;k++){
            boolean vis = ((mask & (1<<k))!=0);
            if(!vis){
               if(mask==0 || nums[i]%nums[k]==0 || nums[k]%nums[i]==0){
                   int newMask = (mask | (1<<k));
                   count = (count%mod + helper(nums,k,newMask)%mod)%mod;
               } 
            }
        }
        return t[i][mask] = count;
    }    
}
