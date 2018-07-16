package tree;
//题目链接: https://leetcode.com/problems/inorder-successor-in-bst/
//
//        Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
//


import Common.Commons;
import basic.TreeNode;

public class Leetcode285 {
    public static void main(String[] args) {
        Leetcode285 l285=new Leetcode285();
        int nums[]={2,1,-1,-1,3,-1,-1};
        TreeNode root= Commons.buildTree(nums);
         TreeNode succ=  l285.inorderSuccessor(root,root.left);
        System.out.println(succ.val);
    }
    public TreeNode  inorderSuccessor(TreeNode root, TreeNode p){
        if(root==null||p==null)
            return null;
        TreeNode ans=null;
        while(root!=null)
        {
            if(root.val>p.val){
                ans=root;
                root=root.left;
            }else{
                root=root.right;
            }

        }
        return ans;
    }


}

