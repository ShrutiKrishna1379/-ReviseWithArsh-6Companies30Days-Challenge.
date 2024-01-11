//Find Subsequence of Length K with the Largest Sum
// Input: nums = [-1,-2,3,4], k = 3
// Output: [-1,3,4]
// Explanation: 
// The subsequence has the largest sum of -1 + 3 + 4 = 6.

package Walmart;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Largest_Sum {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        List<Integer> list=new ArrayList<>();
        for(int i:nums){ pq.add(i); list.add(i);}
        for(int i=0;i<nums.length-k;i++) list.remove(pq.remove());
        int ans[]=new int[k];
        for(int i=0;i<list.size();i++) ans[i]=list.get(i);
        return ans;
    }
}

//  public int[] maxSubsequence(int[] nums, int k) {
//         int [] res = new int [k];
//         for(int i=0; i<k; i++){
//             res[i]=nums[i];

//         }
//         for(int i=k;i<nums.length;i++){
//             int min=res[0];
//             int minIdx=0;
//             for(int j=1; j<k; j++){
//                 if(min>res[j]){
//                     min=res[j];
//                     minIdx=j;
//                 }
//             }
//              if(nums[i]>min){
//                 for(int l=minIdx+1; l<k; l++){
//                     res[l-1]=res[l];
//                 }
//                  res[k-1]=nums[i];
//              }
                
             
//         }
//         return res;
//     }
