//https://leetcode.com/problems/maximum-product-after-k-increments/description/

class MaximumProduct{
    public int maximumProduct(int[] nums, int k) {
        int mod = 1000000007;
        long sum = 1;
        int i = 0;
 
        int arr[] = new int[2000002];
        int max = 0; 
        while(i < nums.length){ 
            max = Math.max(max, nums[i]);
            if(nums[i] != 0) sum = (long) sum * nums[i];
            arr[nums[i++]]++;
        }
    
        while(arr[0] > 0) {
            if(k == 0) {
            return 0;
            } 
            arr[0]--;
            arr[1]++;
            k--;
            max = Math.max(max, 1);
        }
        
        while(arr[1] > 0) {
            if(k == 0) return (int) sum; 

            sum = (long) (sum * 2) % mod;
            arr[1]--;
            arr[2]++;
            k--;
            max = Math.max(max, 2);
        }

        i = 2;
        while(k > 0) {
            if(arr[i] > 0) {
                arr[i]--;
                arr[i + 1]++;
                max = Math.max(max, i + 1);
                k--;
            }
            else i++;
        }
        long nSum = 1;
        i = 2;
        
        while(i <= max) {
            while(arr[i] > 0) {
                nSum = (long) (nSum * i) % mod;
                arr[i]--;
            }
            i++;
        }
        return (int) nSum;
    }
}
