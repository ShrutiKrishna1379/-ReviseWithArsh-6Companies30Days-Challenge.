
//random values can be gererated equally if we traverse row wise or column wise.

/* --->Time complexity:
Solution() -> O(1)
flip() -> O(1)
reset() -> O(1) */

// --->Space complexity: O(m*n)

class Filp_Matrix {
    int i=0,j=0;
    int m=0, n=0;
    public Filp_Matrix(int m, int n) {
        this.m=m;
        this.n=n;
    }
    
    public int[] flip() {
        j++;
        if(j==n){
            j=0;i++;
        }
        if(i==m){
            i=0;j=0;
        }
        return new int[]{i,j};
    }
    
    public void reset() {
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */

