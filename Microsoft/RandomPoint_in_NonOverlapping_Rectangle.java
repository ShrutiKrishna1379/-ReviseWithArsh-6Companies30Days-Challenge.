package Microsoft;

public class RandomPoint_in_NonOverlapping_Rectangle {
    
    int[][] rects;
    int[] areas;
    int sum;

    public RandomPoint_in_NonOverlapping_Rectangle(int[][] rects) {
        this.rects = rects;
        areas = new int[rects.length];
        sum=0;
        int i=0;
        for (int[] rect : rects) {
            areas[i] = (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            sum+=areas[i++];
        }
    }
    
    public int[] pick() {
        int point=(int)(Math.random()*sum)+1;
        int i=0;
        while (point>areas[i]) {
            point-=areas[i++];
        }
        int[] rect=rects[i];
        point--;
        int dist = rect[3] - rect[1] + 1;
        return new int[] {rect[0] + point / dist, rect[1] + point % dist};
    }
}

