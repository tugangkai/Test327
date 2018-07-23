package tree;

import Common.Commons;
import basic.TreeNode;

import java.util.*;

//给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
//
//        返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
//
//
//
//        示例 1：
//
//        输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
//
//        输出：[7,4,1]
//
//        解释：
//        所求结点为与目标结点（值为 5）距离为 2 的结点，
//        值分别为 7，4，以及 1
//
//
//
//        注意，输入的 "root" 和 "target" 实际上是树上的结点。
//        上面的输入仅仅是对这些对象进行了序列化描述。
//
//
//        提示：
//
//        给定的树是非空的，且最多有 K 个结点。
//        树上的每个结点都具有唯一的值 0 <= node.val <= 500 。
//        目标结点 target 是树上的结点。
//        0 <= K <= 1000.
public class Leetcode863 {


    private HashMap<TreeNode,TreeNode> parent=new HashMap<>();
    private Set<TreeNode> visited=new HashSet<TreeNode>();
    private List<Integer> list=new ArrayList<Integer>();

    public static void main(String[] args) {
        int  []nums={3,5,6,-1,-1,2,7,-1,-1,4,-1,-1,1,0,-1,-1,8,-1,-1};
        TreeNode root= Commons.buildTree(nums);
        Leetcode863 ll=new Leetcode863();
        List<Integer> res=ll.distanceK(root,root.left,2);
        for(int i:res){
            System.out.println(i);
        }
    }


    public void set_parent(TreeNode root){
        if(root==null)
            return ;
        if(root.left!=null)
        {
            parent.put(root.left,root);
            set_parent(root.left);
        }
        if(root.right!=null){
            parent.put(root.right,root);
            set_parent(root.right);
        }



    }
    public void dfs(TreeNode root,int k){
        if(visited.contains(root))
            return ;
        visited.add(root);
        if(k==0){
            list.add(root.val);
        }
        else{
            if(root.left!=null) dfs(root.left,k-1);
            if(root.right!=null)dfs(root.right,k-1);
        }
        TreeNode p=parent.get(root);
        if(p!=null){
            dfs(p,k-1);
        }
        return;


    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        if(root==null)
            return new ArrayList<Integer>();
        set_parent(root);
        dfs(target,K);
        return list;
    }







//
//    private List<Integer> ans = new ArrayList<>();
//    private Map<TreeNode, TreeNode> map = new HashMap<>();
//
//    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
//        dfs(root, null); // map里面存储了所有节点的父节点
//        biDfs(target, K, null);
//        return ans;
//    }
//
//    private void dfs(TreeNode x, TreeNode parent) {
//        if (x == null)
//            return;
//        map.put(x, parent);
//        dfs(x.left, x);
//        dfs(x.right, x);
//    }
//
//    private void biDfs(TreeNode target, int k, TreeNode pre) {
//        if (target == null)
//            return;
//        if (k == 0)
//            ans.add(target.val);
//        if (target.left != pre)
//            biDfs(target.left, k - 1, target);
//        if (target.right != pre)
//            biDfs(target.right, k - 1, target);
//        if (map.get(target) != pre)
//            biDfs(map.get(target), k - 1, target);
//    }
//
//




}
