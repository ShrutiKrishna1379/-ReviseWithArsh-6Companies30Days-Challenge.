
class DataStream {
    int val, k, c;
    public DataStream(int value, int k) {
        this.val = value;
        this.k = k;
        this.c = 0;
    }
    
    public boolean consec(int num) {
        c = (num == val)? c + 1 : 0;
        return c >= k;
    }
}
//https://leetcode.com/problems/find-consecutive-integers-from-a-data-stream/
