
/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class FindIn_MountainArray{
    public int findPeak(MountainArray mountainArr){
        int s =0; 
        int e = mountainArr.length() -1;
        while(s<e){
            int mid = s + (e-s)/2;
            if(mountainArr.get(mid)>mountainArr.get(mid+1)) e = mid;
            else s=mid+1;
        }
        return e;
    }
    public int BS(MountainArray mountainArr, int start, int end, int target, boolean left){
        while(start<=end){
            int mid = start + (end-start)/2;
            if(left){
                if(mountainArr.get(mid)> target) end = mid-1;
                else if(mountainArr.get(mid)<target) start = mid+1;
                else return mid;
            }
            else{
                if(mountainArr.get(mid)> target) start = mid+1;
            else if(mountainArr.get(mid)<target) end = mid-1;
            else return mid;
            }
            
        }
        return -1;
    }
    
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = findPeak(mountainArr);
        int ans = BS(mountainArr, 0, peak, target, true);
        if(ans == -1){
            ans = BS(mountainArr, peak+1, mountainArr.length() -1, target, false);
        }
        return ans;
    }
}
