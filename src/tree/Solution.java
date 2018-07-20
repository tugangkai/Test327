package tree;

import Common.Commons;
import basic.TreeNode;

public class Solution {
    public static void main(String[] args) {
        // int []nums={5,4,1,-1,-1,1,-1,-1,5,-1,5,-1,-1};
        int []nums={1,4,4,-1,-1,4,-1,-1,5,-1,5,-1,-1};
        TreeNode root= Commons.buildTree(nums);
        Solution ll=new Solution();
        int res=ll.longestUnivaluePath(root);
        System.out.println(res);
    }
    public int longestUnivaluePath(TreeNode root) {
        if(root!=null)dfs(root,root.val-1);
        return max;
    }
    int max = 0;
    private int dfs(TreeNode root, int v){
        if(root==null) return 0;
        int left = dfs(root.left,root.val);
        int right = dfs(root.right,root.val);
        int cnt  = left+right;
        int ret = Math.max(left,right);
        max=Math.max(cnt,max);
        if(root.val==v) {
            return ret+1;

        }else {
            return 0;
        }
    }
}
