/* Input: matches = [[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]
Output: [[1,2,10],[4,5,7,8]]
Explanation:
Players 1, 2, and 10 have not lost any matches.
Players 4, 5, 7, and 8 each have lost one match.
Players 3, 6, and 9 each have lost two matches.
Thus, answer[0] = [1,2,10] and answer[1] = [4,5,7,8].
*/

package Adobe;
import java.util.*;
// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.LinkedList;
// import java.util.List;
// import java.util.Map;

public class Find_Players_withZeroAndOne_Losses {

    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer,Integer> map=new HashMap<>();
        List<List<Integer>> ans=new LinkedList<>();

        for(int[] a: matches){
            map.put(a[0],map.getOrDefault(a[0],0));
            map.put(a[1],map.getOrDefault(a[1],0)+1);
        }

        List<Integer> zero=new ArrayList<>();
        List<Integer> one=new ArrayList<>();

        for(Map.Entry<Integer,Integer> m: map.entrySet()){
            if(m.getValue()==0) zero.add(m.getKey());
            else if(m.getValue()==1) one.add(m.getKey());
        }

        Collections.sort(zero);
        Collections.sort(one);
        ans.add(zero);
        ans.add(one);

        return ans;
    }
}
/*class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> zero = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        int[] arr = new int[100001];
        int max = -1, x = 0, y = 0;
        for (int[] i : matches) {
            x = i[0];
            y = i[1];
            arr[y] += 2;
            if (arr[x] == 0)
                arr[x] = -1;
            max = Math.max(max, Math.max(x, y));
        }
        int i = 0;
        while (i <= max) {
            while (i < max && arr[i] == 0)
                i++;
            if (arr[i] == -1)
                zero.add(i);
            else if (arr[i] == 1 || arr[i] == 2)
                one.add(i);
            i++;
        }
        ans.add(zero);
        ans.add(one);
        return ans;
    }
} */