/*N = 3
Arr[] = {1, 3, 3}
Output: 3 2
Explanation: Repeating number is 3 and 
smallest positive missing number is 2. */

import java.util.*;
class Find_Missing_and_Repeating {
    int[] findTwoElement(int arr[], int n) {
        // code here
        int ans[]=new int[2];
        Arrays.sort(arr);
        
        if(arr[0]!=1) ans[1]=1;
        if((arr[0]==arr[1])&&(arr[0]==1)) ans[0]=1;

        for(int i=1;i<n;i++){
            if(arr[i-1]==arr[i]) ans[0]=arr[i];
            if(arr[0]==1&&arr[i]!=arr[i-1]+1){
                if(arr[i-1]!=arr[i]) ans[1]=arr[i-1]+1;
            }
        }
        if(ans[1]==0) ans[1]=arr[n-1]+1;
        return ans;
    }
}
