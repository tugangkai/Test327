public class Leetcode110 {

//    给定一个二叉树，判断它是否是高度平衡的二叉树。
//
//    本题中，一棵高度平衡二叉树定义为：
//
//    一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
//    示例 1:
//
//    给定二叉树 [3,9,20,null,null,15,7]
//
//            3
//            / \
//            9  20
//            /  \
//            15   7
//    返回 true 。
//
//    示例 2:
//
//    给定二叉树 [1,2,2,3,3,null,null,4,4]
//
//            1
//            / \
//            2   2
//            / \
//            3   3
//            / \
//            4   4
//    返回 false 。
public int maxDepth(TreeNode root) {
    if(root==null)
        return 0;
    int left=maxDepth(root.left);
    int right=maxDepth(root.right);
    return left>right?left+1:right+1;
}
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        int x=maxDepth(root.left)-maxDepth(root.right);
        if(x>1||x<-1)
            return false;
        else{
            return isBalanced(root.left)&&isBalanced(root.right);
        }



    }
}
