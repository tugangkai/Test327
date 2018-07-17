package tree;

import basic.TreeNode;

public class RemoveBSTNode {


    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return root;
        if(root.val>key){
            root.left=deleteNode(root.left,key);
            return root;
        }
        if(root.val<key){
            root.right=deleteNode(root.right,key);
            return root;
        }

        TreeNode left=root.left;
        TreeNode right=root.right;
        TreeNode tmp=left;
        if(root.left==null||root.right==null){
            return root.left==null?root.right:root.left;
        }
        while(tmp.right!=null){
            tmp=tmp.right;
        }
        tmp.right=right.left;

        right.left=root.left;
        return right;






    }

}
