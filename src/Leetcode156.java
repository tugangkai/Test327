public class Leetcode156 {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        TreeNode l1=new TreeNode(2);
        TreeNode r1=new TreeNode(3);
        TreeNode l2=new TreeNode(4);
        TreeNode r2=new TreeNode(5);
        root.left=l1;
        root.right=r1;
        l1.left=l2;
        l1.right=r2;
        Leetcode156 l156=new Leetcode156();
        l156.postOrder(root);
        TreeNode newRoot= l156.upsideDown(root);
        System.out.println("--------------------");
        l156.postOrder(newRoot);

    }
    public void postOrder(TreeNode node){

        if(node!=null){
            System.out.println(node.val);
            postOrder(node.left);
            postOrder(node.right);
        }

    }
    public TreeNode upsideDown(TreeNode root){
        if(root==null||root.left==null){
            return root;
        }
        TreeNode node=upsideDown(root.left);
        root.left.left=root.right;
        root.left.right=root;
        root.left=null;
        root.right=null;
        return node;


    }
}
