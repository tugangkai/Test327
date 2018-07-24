package tree;

import Common.Commons;
import basic.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Leetcode865 {

//
//    给定一个根为 root 的二叉树，每个结点的深度是它到根的最短距离。
//
//    如果一个结点在整个树的任意结点之间具有最大的深度，则该结点是最深的。
//
//    一个结点的子树是该结点加上它的所有后代的集合。
//
//    返回能满足“以该结点为根的子树中包含所有最深的结点”这一条件的具有最大深度的结点。
//
//
//
//    示例：
//
//    输入：[3,5,1,6,2,0,8,null,null,7,4]
//    输出：[2,7,4]
//    解释：
//
//    我们返回值为 2 的结点，在图中用黄色标记。
//    在图中用蓝色标记的是树的最深的结点。
//    输入 "[3, 5, 1, 6, 2, 0, 8, null, null, 7, 4]" 是对给定的树的序列化表述。
//    输出 "[2, 7, 4]" 是对根结点的值为 2 的子树的序列化表述。
//    输入和输出都具有 TreeNode 类型。
public static void main(String[] args) {
    int []nums={3,5,6,-1,-1,2,7,-1,-1,4,-1,-1,1,0,-1,-1,8,-1,-1};
    TreeNode root= Commons.buildTree(nums);
    Leetcode865 ll=new Leetcode865();
    TreeNode subroot=ll.subtreeWithAllDeepest(root);
    System.out.println(subroot.val);

}
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        List<TreeNode> list=new ArrayList<TreeNode>();
        lastDepthNode(root,list);
        TreeNode subroot=LCA(root,list.get(0),list.get(1));
        return subroot;


    }
    public TreeNode LCA(TreeNode root,TreeNode p,TreeNode q){
        if(root==null)
            return null;
        if(root==p||root==q)
            return root;
        TreeNode left=LCA(root.left,p,q);
        TreeNode right=LCA(root.right,p,q);

        if(left==null)
            return right;
        if(right==null)
            return left;
        return root;
    }
    public void lastDepthNode(TreeNode root,List<TreeNode> list){
        ArrayDeque<TreeNode> queue=new ArrayDeque();
        queue.offer(root);
        TreeNode leftNode=null;
        TreeNode rightNode=null;
        while(!queue.isEmpty()){
            int size=queue.size();
            boolean first=true;
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                if(first) {
                    leftNode=node;
                    first=false;
                }
                if(node.left!=null){
                    queue.offer(node.left);

                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                rightNode=node;
            }


        }
        list.add(leftNode);
        list.add(rightNode);

    }



//    private TreeNode solve(TreeNode root, int deps) {
//        if (root == null)
//            return null;
//        if (deps == 1)
//            return root;
//        TreeNode left = solve(root.left, deps - 1);
//        TreeNode right = solve(root.right, deps - 1);
//        if (left == null)
//            return right;2

//        if (right == null)
//            return left;
//        return root;
//    }
//
//    private int getMaxDep(TreeNode root) {
//        if (root == null)
//            return 0;
//        return Math.max(getMaxDep(root.left), getMaxDep(root.right)) + 1;
//    }

}
