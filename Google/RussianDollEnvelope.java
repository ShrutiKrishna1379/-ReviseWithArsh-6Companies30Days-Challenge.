package Google;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelope {
    
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
