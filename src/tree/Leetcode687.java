package tree;

import Common.Commons;
import basic.TreeNode;

//给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
//
//        注意：两个节点之间的路径长度由它们之间的边数表示。
//
//        示例 1:
//
//        输入:
//
//        5
//        / \
//        4   5
//        / \   \
//        1   1   5
//        输出:
//
//        2
//        示例 2:
//
//        输入:
//
//        1
//        / \
//        4   5
//        / \   \
//        4   4   5
//        输出:
//
//        2
//        注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
public class Leetcode687 {
    public static void main(String[] args) {
       // int []nums={5,4,1,-1,-1,1,-1,-1,5,-1,5,-1,-1};
        int []nums={1,4,4,-1,-1,4,-1,-1,5,-1,5,-1,-1};
        TreeNode root= Commons.buildTree(nums);
        Leetcode687 ll=new Leetcode687();
        int res=ll.longestUnivaluePath(root);
        System.out.println(res);
    }
    public int longestUnivaluePath(TreeNode root) {

            if(root==null)
                return 0;
            helper(root);
            return max-1;
    }
    private int max;
    public int helper(TreeNode root){

        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
           return 1;
        }
        int left=helper(root.left);
        int right=helper(root.right);
        int curL=0;int curR=0;
        curL=left==0?1:(root.val==root.left.val?left+1:1);
        curR=right==0?1:(root.val==root.right.val?right+1:1);
        max=Math.max(max,curL+curR-1);
        return Math.max(curL,curR);
    }
}
