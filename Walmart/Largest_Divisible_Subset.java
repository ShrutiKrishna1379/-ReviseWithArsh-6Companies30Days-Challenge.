package Walmart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//-->LIS
public class Largest_Divisible_Subset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> list=new ArrayList<>();
        Arrays.sort(nums);
        int n=nums.length;
        int t[]=new int[n];
        Arrays.fill(t,1);

        int max=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0){
                    t[i]=Math.max(t[i],t[j]+1);
                    max=Math.max(t[i],max);
                }
            }
        }
        int temp=-1;
        for(int i=n-1;i>=0;i--){
            if(t[i]==max&&(temp==-1||temp%nums[i]==0)){
                list.add(nums[i]);
                temp=nums[i];
                max--;
            }
        }
        return list;
    }
}
