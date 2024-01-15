/*Input: ages = [16,16]
Output: 2
Explanation: 2 people friend request each other. */


package Walmart;

public class Friends_Of_Appropriate_Ages {
        public int numFriendRequests(int[] ages) {
            int[] cnt=new int[121];
            for (int i : ages) {
                cnt[i]++;
            }
            int[] t = new int[121];
            t[0] = cnt[0];
            for (int i = 1; i < 121; i++) {
                t[i]=t[i-1]+cnt[i];
            }
            int ans=0;
            for (int i=15;i<121;i++) {
                if (cnt[i]==0) {
                    continue;
                }
                int c =t[i]-t[i/2+7];
                ans+=(c*cnt[i]-cnt[i]);
            }
            return ans;
        }
}
