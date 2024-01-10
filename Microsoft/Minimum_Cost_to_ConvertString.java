//Floyd-Warshall's algorithm

package Microsoft;

public class Minimum_Cost_to_ConvertString {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] dist=new int[26][26];
        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++) dist[i][j]=Integer.MAX_VALUE;
        }
        for(int i=0;i<cost.length;i++){
            dist[original[i]-'a'][changed[i]-'a']=Math.min(dist[original[i]-'a'][changed[i]-'a'],cost[i]);
        }

        for(int i=0;i<26;i++) dist[i][i]=0;
        for(int k=0;k<26;k++){
            for(int i=0;i<26;i++){
                for(int j=0;j<26;j++){
                    if(dist[i][k]==Integer.MAX_VALUE||dist[k][j]==Integer.MAX_VALUE) continue;
                    dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }
        
        long ans=0;
        for(int i=0;i<source.length();i++){
            if(source.charAt(i)==target.charAt(i)) continue;
            if(dist[source.charAt(i)-'a'][target.charAt(i)-'a']==Integer.MAX_VALUE) return -1;
            ans+=dist[source.charAt(i)-'a'][target.charAt(i)-'a'];
        }
        return ans;
    }
}

/*Input: source = "abcd", target = "acbe", original = ["a","b","c","c","e","d"], changed = ["b","c","b","e","b","e"], cost = [2,5,5,1,2,20]
Output: 28
Explanation: To convert the string "abcd" to string "acbe":
- Change value at index 1 from 'b' to 'c' at a cost of 5.
- Change value at index 2 from 'c' to 'e' at a cost of 1.
- Change value at index 2 from 'e' to 'b' at a cost of 2.
- Change value at index 3 from 'd' to 'e' at a cost of 20.
The total cost incurred is 5 + 1 + 2 + 20 = 28.
It can be shown that this is the minimum possible cost.*/