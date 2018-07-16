package Common;

import basic.TreeNode;

public class Commons {
    static int i;
    public static  TreeNode buildTree(int []nums){
        if(nums[i]==-1)
            return null;
        TreeNode root=new TreeNode(nums[i]);
        i++;
        root.left=buildTree(nums);
        i++;
        root.right=buildTree(nums);
        return root;



    }
    public static void postOrderSearch(TreeNode root){
        if(root!=null){
            System.out.println(root.val);
            postOrderSearch(root.left);
            postOrderSearch(root.right);
        }
    }
    public static void main(String[] args) {
        int nums[]={1,2,-1,-1,3,-1,-1};
        Commons cms=new Commons();
        TreeNode root=cms.buildTree(nums);
        postOrderSearch(root);
    }

}
