import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode107 {

   public List<List<Integer>>  levelOrderBottom(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int cur_count=1;
        int next_count=0;
        while(!queue.isEmpty()){
            List<Integer> child=new ArrayList<>();
            while(cur_count!=0){
                TreeNode qNode=queue.poll();
                cur_count--;
                child.add(qNode.val);
                if(qNode.left!=null){
                    queue.offer(qNode.left);
                    next_count++;
                }
                if(qNode.right!=null){
                    queue.offer(qNode.right);
                    next_count++;
                }
            }
            cur_count=next_count;
            next_count=0;
            list.add(child);
        }
        List<List<Integer>> flist=new ArrayList<List<Integer>>();
        for(int k=list.size()-1;k>=0;k--)
        {
            flist.add(list.get(k));
        }
        return flist;
    }

    /**
     *
     * 前序遍历配合层次号码，先构造列表后下列表中添加元素
     */
//    class Solution {
//        public List<List<Integer>> levelOrderBottom(TreeNode root) {
//
//            List<List<Integer>> ls = new ArrayList<>();
//            func(ls, root, 0);
//            Collections.reverse(ls);
//            return ls;
//        }
//
//        void func(List<List<Integer>> ls, TreeNode root, int level) {
//            if(root == null) return;
//            if(level == ls.size()) {
//                List<Integer> temp = new ArrayList<>();
//                ls.add(temp);
//            }
//            ls.get(level).add(root.val);
//            func(ls, root.left, level+1);
//            func(ls, root.right, level+1 );
//        }
//    }
}
