package tree;

import Common.Node;

//给定一个N叉树，找到其最大深度。
//
//        最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
public class Leetcode559 {


    public int maxDepth(Node root) {
        if(root.children==null)
            return 0;
        int max=0;
        for(int i=0;i<root.children.size();i++){

             max=Math.max(max,maxDepth(root.children.get(i)));
        }
        return max+1;


    }
}
