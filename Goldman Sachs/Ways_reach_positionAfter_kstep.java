/*Input: startPos = 1, endPos = 2, k = 3
  Output: 3
Explanation: We can reach position 2 from 1 in exactly 3 steps in three ways:
- 1 -> 2 -> 3 -> 2.
- 1 -> 2 -> 1 -> 2.
- 1 -> 0 -> 1 -> 2.
It can be proven that no other way is possible, so we return 3. */


import java.util.Arrays;

public class Ways_reach_positionAfter_kstep {
    public int numberOfWays(int startPos, int endPos, int k) {
        int t[][]=new int[3000][k+1];
        for(int i=0;i<t.length;i++) Arrays.fill(t[i],-1);

        return solve(startPos,endPos,k,t);
    }
    public int solve(int startPos, int endPos, int k, int[][] t) {
        if(startPos==endPos&&k==0) return 1;
        if(k==0) return 0;
        if(t[startPos+1000][k]!=-1) return t[startPos+1000][k];
        int l=solve(startPos-1,endPos,k-1,t); 
        int r=solve(startPos+1,endPos,k-1,t);
        return t[startPos+1000][k]=(l+r)%1000000007; 
    }
}
