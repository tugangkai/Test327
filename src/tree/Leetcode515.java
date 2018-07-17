package tree;

import Common.Commons;
import basic.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

//您需要在二叉树的每一行中找到最大的值。
//
//        示例：
//
//        输入:
//
//        1
//        / \
//        3   2
//        / \   \
//        5   3   9
//
//        输出: [1, 3, 9]
public class Leetcode515 {
    public static void main(String[] args)
    {
        Leetcode515 ll=new Leetcode515();
        int []nums={1,3,5,-1,-1,3,-1,-1,2,-1,9,-1,-1};
        TreeNode root= Commons.buildTree(nums);
        List<Integer> res=ll.largestValues(root);
        for(int i:res){
            System.out.println(i);
        }
    }
//    public List<Integer> largestValues(TreeNode root)
//    {    List<Integer> list=new ArrayList<Integer>();
//        if(root==null)
//            return list;
//
//        ArrayDeque<TreeNode> stack=new ArrayDeque<>();
//        stack.push(root);
//        while(!stack.isEmpty())
//        {
//            int n=stack.size();
//            int max=0;
//            for(int i=0;i<n;i++){
//                TreeNode node=stack.poll();
//                max=Math.max(node.val,max);
//                if(node.left!=null){
//                    stack.offer(node.left);
//                }
//                if(node.right!=null){
//                    stack.offer(node.right);
//                }
//            }
//            list.add(max);
//        }
//
//        return list;
//
//    }
    public List<Integer> largestValues(TreeNode root){

        List<Integer> list=new ArrayList();

        check(root,0,list);
        return list;
    }
    public void check(TreeNode root,int height,List<Integer> list){
        if(root==null){
            return ;
        }
        if(list.size()<=height){
            list.add(root.val);
        }else{
            list.set(height,Math.max(list.get(height),root.val));
        }
        check(root.left,height+1,list);
        check(root.right,height+1,list);


    }




}
