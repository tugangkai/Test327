package tree;

import Common.Commons;
import basic.TreeNode;

public class Leetcode226 {

    public static void main(String[] args) {
        Leetcode226 ll=new Leetcode226();
        int []nums={4,2,1,-1,-1,3,-1,-1,7,6,-1,-1,9,-1,-1};
        TreeNode root= Commons.buildTree(nums);
        TreeNode newRoot=ll.invertTree(root);
        Commons.postOrderSearch(newRoot);

    }
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return null;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        root.left=invertTree(root.left);
        root.right=invertTree(root.right);

        return root;
    }
}
