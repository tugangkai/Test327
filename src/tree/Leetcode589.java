package tree;

import Common.Node;
import basic.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Leetcode589 {
//    给定一个N叉树，返回其节点值的前序遍历。
//
//
//
//    例如，给定一个 3叉树 :
//
//
//                1
//             3  2   4
//        5     6
//
//
//    返回其前序遍历: [1,3,5,6,2,4]。
//
//
//
//    说明: 递归法很简单，你可以使用迭代法完成此题吗?

//    public List<Integer> preorder(Node root) {
//            List<Integer> list=new ArrayList<Integer>();
//            preorder(root,list);
//            return list;
//    }
//    public void preorder(Node root,List<Integer> list){
//
//        if(root==null)
//            return ;
//        list.add(root.val);
//        if(root.children.size()!=0){
//            for(Node node:root.children){
//                preorder(node,list);
//            }
//        }
//
//    }

    public List<Integer> preorder(Node root) {
        ArrayDeque<Node> stack=new ArrayDeque<>();
        List<Integer> list=new ArrayList<Integer>();
        stack.push(root);
        while(!stack.isEmpty())
        {
           Node node=stack.pop();
           list.add(node.val);
           if(node.children!=null){
               int size=node.children.size();
               for(int i=size-1;i>=0;i--){
                   stack.push(node.children.get(i));
               }
           }

        }
        return list;
    }
}
