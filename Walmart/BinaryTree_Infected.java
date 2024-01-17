// Amount of time for binary tree to be infected

/*/**
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

package Walmart;

import javax.swing.tree.TreeNode;

public class BinaryTree_Infected {
    
    int ans= 0;
    public int amountOfTime(TreeNode root, int start) {
        solve(root, start);
        return ans;
    }

    public int solve(TreeNode root, int start) {
        if (root == null) return 0;
        int depth = 0;
        int left=solve(root.left, start);
        int right= solve(root.right, start);
        
        if (root.val == start) {
            ans= Math.max(left,right);
            depth = -1;
        } else if (left>=0&& right>=0) {
            depth = Math.max(left, right) + 1;
        } else {
            ans= Math.max(ans, Math.abs(left) + Math.abs(right));
            depth = Math.min(left,right)- 1;
        }
        return depth;
    }
}