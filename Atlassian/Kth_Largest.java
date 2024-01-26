
// Kth Largest Element in a Stream
/*Input
["KthLargest", "add", "add", "add", "add", "add"]
[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
Output
[null, 4, 5, 5, 8, 8] */

package Atlassian;

import java.util.PriorityQueue;

public class Kth_Largest {
    
    PriorityQueue<Integer>pq=new PriorityQueue<>();
    int k;
    public Kth_Largest(int k, int[] nums) {
        this.k=k;
        for(int i:nums) add(i);
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size()>k) pq.remove();
        return pq.peek();
    }

}
/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */