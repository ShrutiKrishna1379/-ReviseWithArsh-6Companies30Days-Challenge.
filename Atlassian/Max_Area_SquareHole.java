
// Maximum Area of Square Hole in Grid

/*Input: n = 2, m = 1, hBars = [2,3], vBars = [2]
Output: 4 */

package Atlassian;

import java.util.Arrays;

public class Max_Area_SquareHole {
    
    int maxGap(int[] bar){
        Arrays.sort(bar);
        int c=2,max=2;
        for(int i=1;i<bar.length;i++){
            c=bar[i-1]+1==bar[i]?c+1:2;
            max=Math.max(max,c);
        }
        return max;
    }

    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int gap=Math.min(maxGap(hBars),maxGap(vBars));
        return gap*gap;
    }
    
}
