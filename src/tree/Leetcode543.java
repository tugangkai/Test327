package tree;
//
//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
//
//        示例 :
//        给定二叉树
//
//        1
//        / \
//        2   3
//        / \
//        4   5
//        返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
//
//        注意：两结点之间的路径长度是以它们之间边的数目表示。

import Common.Commons;
import basic.TreeNode;

public class Leetcode543 {
    public static void main(String[] args) {
        int []nums={1,2,4,-1,-1,5,-1,-1,3,-1,-1};
        TreeNode root= Commons.buildTree(nums);
        Leetcode543 ll=new Leetcode543();
        int res=ll.diameterOfBinaryTree(root);

        System.out.println(res-1);
    }
    private int max;
    public int diameter(TreeNode root){
        if(root==null)
            return 0;
        int left=diameter(root.left);
        int right=diameter(root.right);
        max=Math.max(left+right+1,max);
        return left>right?left+1:right+1;

    }
    public int diameterOfBinaryTree(TreeNode root) {

        diameter(root);
       return max;
    }

}
