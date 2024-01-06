/*Input: radius = 1, xCenter = 0, yCenter = 0, x1 = 1, y1 = -1, x2 = 3, y2 = 1
Output: true
Explanation: Circle and rectangle share the point (1,0).

Return true if the circle and rectangle are overlapped otherwise return false.*/

package Microsoft;

public class Overlap_Circle_And_Rectangle {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int x=Math.max(x1,Math.min(xCenter,x2));
        int y=Math.max(y1,Math.min(yCenter,y2));
        int xdis=xCenter-x;
        int ydis=yCenter-y;
        int dis=xdis*xdis+ydis*ydis;
        return dis<=radius*radius;
    }
}
