package tree;

//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//
//        百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
//
//        例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
//
//        _______3______
//        /              \
//        ___5__          ___1__
//        /      \        /      \
//        6      _2       0       8
//        /  \
//        7   4
//        示例 1:
//
//        输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//        输出: 3
//        解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
//        示例 2:
//
//        输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//        输出: 5
//        解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
//        说明:
//
//        所有节点的值都是唯一的。
//        p、q 为不同节点且均存在于给定的二叉树中。


import Common.Commons;
import basic.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode236 {
    public static void main(String[] args) {
        int nums[]={1,2,3,-1,-1,4,-1,-1,5,-1,-1};
        TreeNode root= Commons.buildTree(nums);
        Leetcode236 ll=new Leetcode236();

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathp=new ArrayList<TreeNode>();
        List<TreeNode> pathq=new ArrayList<TreeNode>();
        findPath(root,p,pathp);
        findPath(root,q,pathq);
        int large=Math.max(pathp.size(),pathq.size());
        TreeNode last=null;
        for(int i=0;i<large;i++){
            if(i<pathp.size()&&i<pathq.size()&&pathp.get(i)==pathq.get(i)){
                last=pathp.get(i);
            }else{
                break;
            }
        }

        return last;

    }

    public boolean findPath(TreeNode root,TreeNode target,List<TreeNode> paths){

        if(root==null)
            return false;
        if(root==target){
            paths.add(root);
            return true;
        }
        paths.add(root);
        if(findPath(root.left,target,paths)){
            return true;
        }
        if(findPath(root.right,target,paths))return  true;
        paths.remove(paths.size()-1);
        return false;
    }
}
