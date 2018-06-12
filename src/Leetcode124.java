public class Leetcode124 {


    private int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        max(root);
        return max;



    }

    public int max(TreeNode root){
        if(root==null)
            return 0;

        int lmax=max(root.left);
        int rmax=max(root.right);
        int cur=root.val;
        if(lmax>0)
            cur+=lmax;
        if(rmax>0)
            cur+=rmax;
        if(cur>max)
            max=cur;

        return Math.max(root.val,Math.max(root.val+lmax,root.val+rmax));

    }



    public static void main(String[] args) {
        Leetcode124 l124=new Leetcode124();
        TreeNode head=new TreeNode(-2);
        TreeNode t1=new TreeNode(1);
       // TreeNode t2=new TreeNode(3);
        head.left=t1;
      //  head.right=t2;
        int res=l124.maxPathSum(head);
        System.out.println(res);

    }
}
