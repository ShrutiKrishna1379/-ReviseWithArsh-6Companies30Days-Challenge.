class  Find_The_Distance_Value{
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans=0;
        for (int i=0; i<arr1.length; i++){
            if (check(arr1[i],arr2,d)) ans++;
        }
        return ans;
    }

    public boolean check(int n, int[]arr, int d){
        for (int i = 0; i<arr.length; i++){
            if (Math.abs(n-arr[i])<=d) return false;
        }
        return true;
    }
}
