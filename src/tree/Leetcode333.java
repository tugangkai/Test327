package tree;

import basic.TreeNode;

//Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.
//
//        Note:
//        A subtree must include all of its descendants.
//        Here's an example:
//
//        10
//        / \
//        5  15
//        / \   \
//        1   8   7
//        The Largest BST Subtree in this case is the highlighted one.
//        The return value is the subtree's size, which is 3.
//
//
//
//        Hint:
//
//        You can recursively use algorithm similar to 98. Validate Binary Search Tree at each node of the tree, which will result in O(nlogn) time complexity.
//        Follow up:
//        Can you figure out ways to solve it with O(n) time complexity?
//
//题解：
//
//        采用bottom-up的方法，简历新的class, 用来存储
//
//        当前节点为root的subtree是否是BST
//        若是，最小val 和最大val.
//        size是当前subtree的大小.
//        然后从下到上更新，若是中间过程中size 比 res大，就更新res.
//
//        Time Complexity: O(n). 每个点不会访问超过两遍. Space: O(logn). Recursion stack space.


public class Leetcode333 {
   class Node{
       boolean isBST;
       int min;
       int max;
       int size;
       public Node(){
           isBST = false;
           min = Integer.MAX_VALUE;
           max = Integer.MIN_VALUE;
           size = 0;
       }
   }
    public int largestBSTSubtree(TreeNode root){
        int res[]={0};
        helper(root,res);
        return res[0];
    }
    private Node helper(TreeNode root, int []res){
       Node cur=new Node();
       if(root==null){
           cur.isBST=true;
           return cur;
       }
       Node left=helper(root.left,res);
       Node right=helper(root.right,res);
       if(left.isBST&&root.val>left.max&&right.isBST&&root.val<right.min){
           cur.isBST=true;
           cur.min=Math.min(root.val,left.min);
           cur.max=Math.max(root.val,right.max);
           cur.size=left.size+right.size+1;
           if(cur.size>res[0])
               res[0]=cur.size;
       }
       return cur;
    }


}
