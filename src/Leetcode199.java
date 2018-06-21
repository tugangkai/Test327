import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Leetcode199 {
    public static void main(String[] args) {
        Leetcode199 l199=new Leetcode199();
        TreeNode root=new TreeNode(1);
        TreeNode left=new TreeNode(2);
        root.left=left;

        List<Integer> list=l199.rightSideView(root);
        for(int i:list){
            System.out.println(i);
        }

    }
    public List<Integer> rightSideView(TreeNode root) {
            List<Integer> list=new ArrayList<Integer>();
            ArrayDeque<TreeNode> queue=new ArrayDeque();
            queue.offer(root);
            int cur_index=1;
            int next_index=0;
            while(!queue.isEmpty())
            {
                TreeNode node=queue.peekLast();
                list.add(node.val);
                while(cur_index>0){
                    TreeNode cur=queue.poll();
                    cur_index--;
                    if(cur.left!=null)
                    {
                        queue.offer(cur.left);
                        next_index++;
                    }
                    if(cur.right!=null){
                        queue.offer(cur.right);
                        next_index++;
                    }
                }
                cur_index=next_index;
                next_index=0;
            }
          //  preOrderTraverse(root,list);
            return list;
    }
//    public void preOrderTraverse(TreeNode root,List<Integer> list){
//        if(root!=null){
//            list.add(root.val);
//            preOrderTraverse(root.left,list);
//            preOrderTraverse(root.right,list);
//        }
//    }

    public void depthFirst(TreeNode root,int f, List<Integer> l){
        if(f == l.size()){
            l.add(root.val);
            //f;
        }
        if(root.right !=null)
            depthFirst(root.right, f+1,l);
        if(root.left !=null)
            depthFirst(root.left, f+1,l);
    }

}
