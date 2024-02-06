/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Node{
    public int maxVal,minVal,maxsum;
    Node(int max,int min,int maxsum){
        this.maxVal=max;
        this.minVal=min;
        this.maxsum=maxsum;
    }
}
class Solution {
    int max=0;
    public int maxSumBST(TreeNode root) {
        solve(root);
        return max;
    }
    public Node solve(TreeNode root){
        if(root==null) return new Node(Integer.MIN_VALUE,Integer.MAX_VALUE,0);
        Node left=solve(root.left);
        Node right=solve(root.right);

        if(left.maxVal<root.val&&root.val<right.minVal){
            max=Math.max(max,root.val+left.maxsum+right.maxsum);
            return new Node(Math.max(root.val,right.maxVal), Math.min(root.val,left.minVal),root.val+left.maxsum + right.maxsum);
        }
        return new Node(Integer.MAX_VALUE,Integer.MIN_VALUE,Math.max(left.maxsum,right.maxsum));
    }
}
