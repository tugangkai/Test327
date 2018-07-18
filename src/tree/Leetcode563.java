package tree;

import Common.Commons;
import basic.TreeNode;

//给定一个二叉树，计算整个树的坡度。
//
//        一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
//
//        整个树的坡度就是其所有节点的坡度之和。
//
//        示例:
//
//        输入:
//        1
//        /   \
//        2     3
//        输出: 1
//        解释:
//        结点的坡度 2 : 0
//        结点的坡度 3 : 0
//        结点的坡度 1 : |2-3| = 1
//        树的坡度 : 0 + 0 + 1 = 1
public class Leetcode563 {
    public static void main(String[] args) {
        Leetcode563 ll=new Leetcode563();
        int []nums={1,2,-1,-1,3,-1,-1};
        TreeNode root= Commons.buildTree(nums);

        int res=ll.findTilt(root);
        System.out.println(res);
    }
    public int findTilt(TreeNode root) {
            find(root);
            return sum;
    }
    private int sum=0;
    public int find(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=find(root.left);
        int right=find(root.right);
        sum+=Math.abs(left-right);
        return left+right+root.val;

    }
}
