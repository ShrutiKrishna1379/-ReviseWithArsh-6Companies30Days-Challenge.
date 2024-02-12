//https://leetcode.com/problems/map-of-highest-peak/

class MapOf_HighestPeak{
    public int[][] highestPeak(int[][] isWater) {
        int R=isWater.length;
        int C=isWater[0].length;
        int ans[][]= new int[R][C];
        Queue<int[]> q= new LinkedList<>();
        for(int[] row:ans){
            Arrays.fill(row,-1);
        }
        
        for (int i=0; i<R; i++){
            for (int j=0; j<C; j++){
                if(isWater[i][j]==1){
                    ans[i][j]=0;
                    q.add(new int[]{i,j});
                }
            }
        }

        while(!q.isEmpty()){
            int r=q.peek()[0];
            int c=q.peek()[1];
            q.remove();
            fillArray(ans,ans[r][c]+1,r,c,q);
        }
        return ans;
    }

    public void fillArray(int[][] arr,int val,int i, int j,Queue<int[]> q){
        if(i>0 && arr[i-1][j]==-1){
            arr[i-1][j]=val;
            q.add(new int[]{i-1,j});
        }
        if(j>0 && arr[i][j-1]==-1){
            arr[i][j-1]=val;
            q.add(new int[]{i,j-1});
        }
        if(i<arr.length-1 && arr[i+1][j]==-1){
            arr[i+1][j]=val;
            q.add(new int[]{i+1,j});
        }
        if(j<arr[0].length-1 && arr[i][j+1]==-1){
            arr[i][j+1]=val;
            q.add(new int[]{i,j+1});
        }
    }
}
