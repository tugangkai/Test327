package tree;

import Common.Commons;
import basic.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
//
//        Examples 1
//        Input:
//
//        5
//        /  \
//        2   -3
//        return [2, -3, 4], since all the values happen only once, return all of them in any order.
//        Examples 2
//        Input:
//
//        5
//        /  \
//        2   -5
//        return [2], since 2 happens twice, however -5 only occur once.
//        Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
public class Leetcode508 {
    public static void main(String[] args) {
        Leetcode508 ll=new Leetcode508();
        int []nums={5,-1,-1};
        TreeNode root= Commons.buildTree(nums);
        int []res=ll.findFrequentTreeSum(root);
        for(int i:res){
            System.out.println(i);
        }

    }
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root==null)
            return new int[0];
        find(root);
        int max=0;
        List<Integer> list=new ArrayList<Integer>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()>max){
                list.clear();
                list.add(entry.getKey());
                max=entry.getValue();
            }else if(entry.getValue()==max){
                list.add(entry.getKey());
            }

        }
        int []sz=new int[list.size()];
        for(int i=0;i<list.size();i++){
            sz[i]=list.get(i);
        }
        return sz;
    }
    private HashMap<Integer,Integer> map=new HashMap();

    public int  find(TreeNode root){
        if(root==null)
            return 0;
         int left=find(root.left);
         int right=find(root.right);

         int cur=left+right+root.val;
         if(map.containsKey(cur)){
             map.put(cur,map.get(cur)+1);
         }else{
             map.put(cur,1);
         }
         return cur;

    }


}
