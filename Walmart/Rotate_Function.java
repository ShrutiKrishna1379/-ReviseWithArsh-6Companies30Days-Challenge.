

package Walmart;

public class Rotate_Function {
    public int maxRotateFunction(int[] nums) {
        int sum=0,F=0;
        for(int i=0;i<nums.length;i++){ F+=i*nums[i];sum+=nums[i];}
        int ans=F;
        // F(k) = F(k-1) + sum - nBk[0]
        for(int i=nums.length-1;i>=1;i--){ F+=sum-nums.length*nums[i]; ans=Math.max(F,ans);}
        return ans;
    }
}
