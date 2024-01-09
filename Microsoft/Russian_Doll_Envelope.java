/*Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
Output: 3
Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]). */

package Microsoft;

import java.util.Arrays;
import java.util.Comparator;

public class Russian_Doll_Envelope {
    
    public int maxEnvelopes(int[][] envelopes) {
      if(envelopes==null||envelopes.length==0||envelopes[0]==null||envelopes[0].length!=2) return 0;
       Arrays.sort(envelopes, new Comparator<int[]>(){
           public int compare(int[] arr1, int[] arr2){
               if(arr1[0]==arr2[0]) return arr2[1]-arr1[1];
               else return arr1[0]-arr2[0];
           }
       });

       int t[]=new int[envelopes.length];
       int c=0;
       for(int[] en: envelopes){
           int idx= Arrays.binarySearch(t,0,c,en[1]);
           if(idx<0) idx=-(idx+1);
           t[idx]=en[1];
           if(idx==c) c++;
       }
       return c;
    }
}
