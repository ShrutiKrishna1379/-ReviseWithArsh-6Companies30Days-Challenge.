// Maximum product of the length of two palindromic subsequences
// Input: s = "leetcodecom"
// Output: 9
// Explanation: An optimal solution is to choose "ete" for the 1st subsequence and "cdc" for the 2nd subsequence.
// The product of their lengths is: 3 * 3 = 9.


package Microsoft;

public class Max_Product {
    public int maxProduct(String s) {
        int n=s.length(),ans=0;
        for(int i=0;i<=(1<<n);i++){
            String s1="",s2="";
            for(int j=0;j<n;j++){
                if(((1<<j)&i)>0) s1+=s.charAt(j);
                else s2+=s.charAt(j);
            }
            ans=Math.max(ans,solve(s1)*solve(s2));
        }
        return ans;
    }

    int solve(String s){
        String str="";
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            str=c+str;
        }
        return lcs(s,str);
    }

    int lcs(String s1,String s2){
        int x=s1.length(),y=s2.length();
        int t[][]=new int[x+1][y+1];
        for(int i=0;i<x+1;i++){
            for(int j=0;j<y+1;j++){
                if(i==0||j==0) t[i][j]=0;
                else if(s1.charAt(i-1)==s2.charAt(j-1)) t[i][j]=1+t[i-1][j-1];
                else t[i][j]=Math.max(t[i-1][j],t[i][j-1]); 
            }
        }
        return t[x][y];
    }
}


/*class Solution {
    private int palSize(String s, int mask) {
        int p1=0, p2=s.length(), res = 0;
        while(p1 <= p2) {
            if((mask & (1 << p1)) == 0)
                p1++;
            else if((mask & (1 << p2)) == 0)
                p2--;
            else if(s.charAt(p1) != s.charAt(p2))
                return 0;
            else 
                res += 1 + (p1++ != p2-- ? 1 : 0);
        }
        return res;
    }

    public int maxProduct(String s) {
        int n = s.length(), res = 0;
        int[] dp = new int[1<<n];
        int mask = (1 << n) - 1;
        for(int i=1; i<=mask; i++) 
            dp[i] = palSize(s, i);
        for(int i=mask ; i>=0; i--) {
            if(dp[i]*(n-dp[i]) > res) {
                int x = i^mask;
                for(int j=x; j>0; j=(j-1)&x)
                    res = Math.max(res, dp[i]*dp[j]);
            }
        }
        return res;
    }
} */