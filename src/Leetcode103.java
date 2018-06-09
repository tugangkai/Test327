import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Leetcode103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();

        LinkedList<TreeNode> list=new LinkedList<TreeNode>();
        int cur_index=1;
        int next_index=0;
        list.offer(root);
        boolean direction=false;
        while(!list.isEmpty())
        {
            List<Integer> sublist=new ArrayList<Integer>();
            while(cur_index>0){
                TreeNode node=list.pop();
                sublist.add(node.val);
                cur_index--;
                TreeNode left=node.left;
                TreeNode right=node.right;
                if(left!=null)
                {
                    list.offer(left);
                    next_index++;
                }
                if(right!=null){
                    list.offer(right);
                    next_index++;
                }

            }
            res.add(sublist);
            cur_index=next_index;
            next_index=0;
            direction=!direction;


        }
        //偶数洌倒序
        int size=res.size();
        for(int i=1;i<size;i=i+2){
            List<Integer> sub =res.get(i);

            Collections.reverse(sub);


        }

    return res;



    }

    public static void main(String[] args) {
        TreeNode head=new TreeNode(3);
        TreeNode t1=new TreeNode(8);
        TreeNode t2=new TreeNode(20);
        TreeNode t3=new TreeNode(15);
        TreeNode t4=new TreeNode(7);
        head.left=t1;
        head.right=t2;
        t2.left=t3;
        t2.right=t4;

        Leetcode103 l103=new Leetcode103();
        List<List<Integer>> list=l103.zigzagLevelOrder(head);
        // System.out.println(list.size());
        for(List<Integer> ll:list){
            for(int i:ll){
                System.out.print(i+"\t");
            }
            System.out.println();
        }

    }
}
