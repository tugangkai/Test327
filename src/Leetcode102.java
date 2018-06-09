import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode102 {
//    给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
//
//    例如:
//    给定二叉树: [3,9,20,null,null,15,7],
//
//            3
//            / \
//            9  20
//            /  \
//            15   7
//    返回其层次遍历结果：
//
//            [
//            [3],
//            [9,20],
//            [15,7]
//            ]

    /**
     * 这道题目主要是要弄清楚树节点到底处于哪一层，
     * 将对应层键入到对应链表是本体的关键
     * 我的第一解法是将树节点的层次记录下来，然后加入到对应层次链表当中
     *
     * 别人解法主要是将当前层能够遍历的元素都加入到新链表中，并记录下一层所能
     * 遍历的树节点数量。
     *
     */
    class NodeWithHeight{
        TreeNode node;
        int height;
        public NodeWithHeight(TreeNode node,int height){
            this.node=node;
            this.height=height;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<NodeWithHeight> list=new LinkedList<NodeWithHeight>();
        list.push(new NodeWithHeight(root,0));
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        while(!list.isEmpty())
        {
            NodeWithHeight node=list.pollFirst();
            if(res.size()<=node.height){
                ArrayList<Integer> sub=new ArrayList<Integer>();
                sub.add(node.node.val);
                res.add(sub);
            }else{
                res.get(node.height).add(node.node.val);
            }
            if(node.node.left!=null){
                list.addLast(new NodeWithHeight(node.node.left,node.height+1));
            }
            if(node.node.right!=null){
                list.addLast(new NodeWithHeight(node.node.right,node.height+1));
            }

        }
        return res;


    }


//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> list=new ArrayList<>();
//        if(root==null){
//            return list;
//        }
//        LinkedList<TreeNode> queue=new LinkedList<>();
//        queue.offer(root);
//        int cur_count=1;
//        int next_count=0;
//        while(!queue.isEmpty()){
//            List<Integer> child=new ArrayList<>();
//            while(cur_count!=0){
//                TreeNode qNode=queue.poll();
//                cur_count--;
//                child.add(qNode.val);
//                if(qNode.left!=null){
//                    queue.offer(qNode.left);
//                    next_count++;
//                }
//                if(qNode.right!=null){
//                    queue.offer(qNode.right);
//                    next_count++;
//                }
//            }
//            cur_count=next_count;
//            next_count=0;
//            list.add(child);
//        }
//        return list;
//    }

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

        Leetcode102 l102=new Leetcode102();
        List<List<Integer>> list=l102.levelOrder(head);
      // System.out.println(list.size());
        for(List<Integer> ll:list){
            for(int i:ll){
                System.out.print(i+"\t");
            }
            System.out.println();
        }




    }
}
