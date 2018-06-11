public class Leetcode114 {

    public void flatten(TreeNode root){
        while(root!=null){
            if(root.left!=null){
                if(root.right!=null){
                    TreeNode pre=root.left;
                    TreeNode op=pre;
                    while(op.right!=null){
                        op=op.right;
                    }
                    op.right=root.right;
                    root.right=pre;
                    root.left=null;
                }else{
                    TreeNode pre=root.left;
                    root.right=pre;
                    root.left=null;
                }


            }
            root=root.right;
        }



    }

}
