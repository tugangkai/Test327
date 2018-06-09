public class Leetcode105 {

//    根据一棵树的前序遍历与中序遍历构造二叉树。
//
//    注意:
//    你可以假设树中没有重复的元素。
//
//    例如，给出
//
//    前序遍历 preorder = [3,9,20,15,7]
//    中序遍历 inorder = [9,3,15,20,7]
//    返回如下的二叉树：
//
//            3
//            / \
//            9  20
//            /  \
//            15   7

    public TreeNode buildTree(int[] preorder, int[] inorder) {


        return    buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    public TreeNode buildTree(int []preorder,int ps,int pe,int []inorder,int is,int ie){
        if(pe==ps)
            return new TreeNode(preorder[pe]);
        if(pe>ps)
            return null;
        int k=is;
      //  int j=is;
        for(;k<ie;k++){
            if(inorder[k]==preorder[ps])
                break;
        }
        //根节点
        TreeNode root=new TreeNode(preorder[ps]);
        root.left=buildTree(preorder,ps+1,ps+k-is,inorder,is,k-1);
        root.right=buildTree(preorder,ps+k-is+1,pe,inorder,k+1,ie);
        return root;



    }

    public static void main(String[] args) {
        Leetcode
    }

}
