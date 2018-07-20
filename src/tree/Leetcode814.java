package tree;
//给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。
//
//        返回移除了所有不包含 1 的子树的原二叉树。
//
//        ( 节点 X 的子树为 X 本身，以及所有 X 的后代。)
//
//        示例1:
//        输入: [1,null,0,0,1]
//        输出: [1,null,0,null,1]
//
//        解释:
//        只有红色节点满足条件“所有不包含 1 的子树”。
//        右图为返回的答案。
//
//
//        示例2:
//        输入: [1,0,1,0,0,0,1]
//        输出: [1,null,1,null,1]
//
//
//
//        示例3:
//        输入: [1,1,0,1,1,0,1,0]
//        输出: [1,1,0,1,1,null,1]


import Common.Commons;
import basic.TreeNode;

public class Leetcode814 {

    public static void main(String[] args) {
      //  int []nums={1,-1,0,0,-1,-1,1,-1,-1};
        int []nums={1,0,0,-1,-1,0,-1,-1,1,0,-1,-1,1,-1,-1};

        TreeNode root= Commons.buildTree(nums);
        Leetcode814 ll=new Leetcode814();
        TreeNode newRoot=ll.pruneTree(root);
        Commons.postOrderSearch(newRoot);
       // System.out.println(newRoot.val);
    }
    public boolean helper(TreeNode root,TreeNode parent){
        if(root==null)
            return false;
        boolean left=helper(root.left,root);
        boolean right=helper(root.right,root);

        boolean flag=(root.val==1);
        boolean res=left||right||flag;
        if(!res){
            if(parent==null){
                root=null;
            }
            if(parent.left==root){
                parent.left=null;
            }else if(parent.right==root){
                parent.right=null;
            }
        }
        return res;





    }
    public TreeNode pruneTree(TreeNode root) {
        helper(root,null);
        return root;
    }


//    public TreeNode pruneTree(TreeNode root) {
//        if(root == null) return null;
//        root.left = pruneTree(root.left);
//        root.right = pruneTree(root.right);
//        if(root.left == null && root.right == null && root.val == 0)
//            return null;
//        else return root;
//    }

}
