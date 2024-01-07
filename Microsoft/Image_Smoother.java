// Time Complexity: O(m * n)
// Space Complexity: O(m * n)

package Microsoft;

public class Image_Smoother {
    public int[][] imageSmoother(int[][] img) {
        int ans[][]= new int[img.length][img[0].length];
        for(int i=0;i<img.length;i++){
            for(int j=0;j<img[0].length;j++){
                ans[i][j]= solve(img,i,j);
            }
        }
        return ans;
    }
    int solve(int[][] img, int x, int y){
        int sum=0,c=0;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                int X=x+i;
                int Y=y+j;
                if(X<0||X>=img.length||Y<0||Y>=img[0].length) continue;
                sum+=img[X][Y];
                c++;
            }
        }
        return sum/c;
    }
}

