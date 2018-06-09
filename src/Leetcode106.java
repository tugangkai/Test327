public class Leetcode106 {

//    根据一棵树的中序遍历与后序遍历构造二叉树。
//
//    注意:
//    你可以假设树中没有重复的元素。
//
//    例如，给出
//
//    中序遍历 inorder = [9,3,15,20,7]
//    后序遍历 postorder = [9,15,7,20,3]
//    返回如下的二叉树：
//
//            3
//            / \
//            9  20
//            /  \
//            15   7
    //根据中序和后序建立二叉树

    /**
     * 建立的方法
     * 根据后序数组的最后一个元素确定中序的根节点，建立根节点，随后将树分为左子树和右子树
     * @param inorder
     * @param postorder
     *
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
            if(inorder==null||postorder==null)
                return  null;
            return buildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);


    }
    public TreeNode buildTree(int []inorder,int is,int ie,int []postorder,int ps,int pe){
        if(is>ie)
            return null;
        if(is==ie)
            return new TreeNode(inorder[is]);

        int k=0;
        for(k=is;k<=ie;k++){
            if(postorder[pe]==inorder[k])
                break;
        }
        TreeNode root=new TreeNode(postorder[pe]);
        root.left=buildTree(inorder,is,k-1,postorder,ps,ps+k-is-1);
        root.right=buildTree(inorder,k+1,ie,postorder,ps+k-is,pe-1);
        return root;




    }
    public void preorderTraversel(TreeNode root){
        if(root!=null){
            System.out.println(root.val);
            preorderTraversel(root.left);
            preorderTraversel(root.right);
        }

    }
    public void midorderTraversal(TreeNode root){
        if(root!=null){
            midorderTraversal(root.left);
            System.out.println(root.val);
            midorderTraversal(root.right);
        }
    }
public static void main(String[] args) {
    Leetcode106 l106=new Leetcode106();
    int []midorder={9,3,15,20,7};
    int []postorder={9,15,7,20,3};
    TreeNode head=l106.buildTree(midorder  ,postorder);
    System.out.println(head.val);
    l106.preorderTraversel(head);
    System.out.println("midorderTraversel is:--------------->");;
    l106.midorderTraversal(head);
    }
}
