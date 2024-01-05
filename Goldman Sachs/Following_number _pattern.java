/*Input: IIDDD  (I--Increase, D--Decrease)
Output:126543*/

import java.util.*;
class Following_number_pattern {
    static String printMinNumberForPattern(String S){
        // code here
        String ans="";
        Stack<Integer> s = new Stack<>();
        int n=1;
        for(int i=0;i<S.length();i++){
            s.push(n);
            n++;
            if(S.charAt(i)=='I'){
                while(!s.isEmpty()) ans+=Integer.toString(s.pop());
            }
        }
        s.push(n);
        while(!s.isEmpty()) ans+=Integer.toString(s.pop());
        return ans;
    }
}
