public class Leetcode111 {

    public int minDepth(TreeNode root) {
            if(root==null)
                return 0;

            if(root.left==null)
                return minDepth(root.right)+1;
            if(root.right==null)
                return minDepth(root.left)+1;
            else{
                int left=minDepth(root.left);
                int right=minDepth(root.right);
                return  left>right?right+1:left+1;
            }

    }
//    public int minLevel(TreeNode node,int min,int level){
//        if(node==null){
//            if(level-1<min)
//                min=level-1;
//            return min;
//        }
//        minLevel(node.left,min,level+1);
//        minLevel(node.right,min,level+1);
//
//        return min;
//    }

    public static void main(String[] args) {
        TreeNode head=new TreeNode(3);
        TreeNode t1=new TreeNode(9);
        TreeNode t2=new TreeNode(20);
        TreeNode t3=new TreeNode(15);
        TreeNode t4=new TreeNode(7);
        head.left=t1;
        head.right=t2;
        t2.left=t3;
        t2.right=t4;
        Leetcode111 l111=new Leetcode111();
        int min=l111.minDepth(head);
        System.out.println(min);

    }
}
