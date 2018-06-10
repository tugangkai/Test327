public class Leetcode112 {

    public boolean hasPathSum(TreeNode root, int sum) {
        return hasPathSum(root,sum,root.val);
    }
    public boolean hasPathSum(TreeNode root,int sum,int cur){
        if(root==null){
            if(cur==sum)
                return true;
            else
                return false;
        }

        if(root.left==null)
            return hasPathSum(root.right,sum,cur+(root.right==null?0:root.right.val));
        if(root.right==null)
              return hasPathSum(root.left,sum,cur+(root.left==null?0:root.left.val));
        return hasPathSum(root.right,sum,cur+(root.right==null?0:root.right.val))||
                hasPathSum(root.left,sum,cur+(root.left==null?0:root.left.val));
//        if(hasPathSum(root.left,sum,cur+(root.left==null?0:root.left.val)))
//            return true;
//
//        if(hasPathSum(root.right,sum,cur+(root.right==null?0:root.right.val)))
//        {
//            return true;
//        }

    }


//    public boolean hasPathSum(TreeNode root, int sum) {
//        if(root == null)
//            return false;
//
//        if(root.left == null && root.right == null)
//            return sum == root.val;
//
//        return hasPathSum(root.left, sum - root.val)
//                || hasPathSum(root.right, sum - root.val);
//    }

    public static void main(String[] args) {

    }
}
