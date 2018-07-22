package tree;

import Common.Commons;
import basic.TreeNode;

public class CountCompleteTreeNode
{

    public static void main(String[] args) {
        CountCompleteTreeNode ct=new CountCompleteTreeNode();
        int []nums={1,2,3,-1,-1,-1,4,-1,-1};
        TreeNode root= Commons.buildTree(nums);
        int res=ct.countNodes(root);
        System.out.println(res);
    }
    public int countNodes(TreeNode root) {
        if(root==null)
            return 0;
        int leftDepth=0;
        int rightDepth=0;
        for(TreeNode p=root;p!=null;p=p.left){
            leftDepth++;
        }
        for(TreeNode p=root;p!=null;p=p.right){
            rightDepth++;
        }
        if(rightDepth==leftDepth){
            return (int)Math.pow(2,leftDepth)-1;
        }
        return 1+countNodes(root.left)+countNodes(root.right);

    }


}
