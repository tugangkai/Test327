package tree;

import basic.TreeNode;

//给定一个二叉树，在树的最后一行找到最左边的值。
//
//        示例 1:
//
//        输入:
//
//        2
//        / \
//        1   3
//
//        输出:
//        1
//
//
//        示例 2:
//
//        输入:
//
//        1
//        / \
//        2   3
//        /   / \
//        4   5   6
//        /
//        7
//
//        输出:
//        7
//
//
//        注意: 您可以假设树（即给定的根节点）不为 NULL。
public class Leetcode513 {

    public int findBottomLeftValue(TreeNode root) {
        helper(root,1);

        return val;
    }
    private int max=0;
    private int val=0;
    public void helper(TreeNode root,int level){
        if(root==null) return;
        if(level>max){
            max=level;
            val=root.val;
        }
        helper(root.left,level+1);
        helper(root.right,level+1);

    }
}
