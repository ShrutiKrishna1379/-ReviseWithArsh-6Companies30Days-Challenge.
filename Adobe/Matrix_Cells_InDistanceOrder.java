package Adobe;

public class Matrix_Cells_InDistanceOrder {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {

        int[][] ans = new int[rows*cols][]; ans[0] = new int[] {rCenter, cCenter};
        int idx = 1;
        int max= Math.max( rCenter, rows-rCenter-1 ) + Math.max( cCenter, cols-cCenter-1 );
        
        for (int i = 1; i <= max; i++) { 
            int r = rCenter - i;int c = cCenter;

            for (int j = i; j > 0;j--) {    
                if (r >= 0 && c >= 0)  ans[idx++] = new int[] {r, c};
                r++;c--;}

            for (int j = i; j > 0; j--) {
                if (r < rows && c >= 0)  ans[idx++] = new int[] {r, c};
                r++;c++;}
        
            for (int j = i; j > 0; j--) {
                if (r < rows && c < cols) ans[idx++] = new int[] {r, c};
                r--;c++;}

            for (int j = i; j > 0; j--) {
                if (r >= 0 && c < cols)  ans[idx++] = new int[] {r, c};
                r--;c--;}
        }
        return ans;
    }
}
