package tree;

//给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。
//
//        给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
//
//        示例 1:
//
//        输入:
//        2
//        / \
//        2   5
//        / \
//        5   7
//
//        输出: 5
//        说明: 最小的值是 2 ，第二小的值是 5 。
//        示例 2:
//
//        输入:
//        2
//        / \
//        2   2
//
//        输出: -1
//        说明: 最小的值是 2, 但是不存在第二小的值。

import basic.TreeNode;

public class Leetcode671 {

    private int first=Integer.MAX_VALUE,second=Integer.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        helper(root);
        if(second==Integer.MAX_VALUE){
            return -1;
        }else
            return second;
    }
    public void helper(TreeNode root){
        if(root==null)
            return;
        if(root.val<first){
            first=root.val;
            second=first;
        }else if(root.val<second){
            second=root.val;
        }
        helper(root.left);
        helper(root.right);


    }


//    public int findSecondMinimumValue(TreeNode root) {
//        int num=getGreaterThanValue(root,root.val);
//        return (num!=root.val)?num:-1;
//
//    }
//
//    public int getGreaterThanValue(TreeNode root, int num) {
//        if (root.val > num)
//            return root.val;
//        if (root.left == null)
//            return num;
//        int left = root.left.val;
//        int right = root.right.val;
//        if (left > num && right > num) {
//            return Math.min(left, right);
//        } else {
//            left = getGreaterThanValue(root.left, num);
//            right = getGreaterThanValue(root.right, num);
//            if (left != num && right != num)
//                return Math.min(left, right);
//            return Math.max(left, right);
//        }
//    }
}
