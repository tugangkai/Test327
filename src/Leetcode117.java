import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;

public class Leetcode117 {
    public void connect(TreeLinkNode root) {
        LinkedList<TreeLinkNode> list=new LinkedList<TreeLinkNode>();
        if(root==null)
            return;
        list.offer(root);
        int cur_index=1;
        int next_index=0;

        TreeLinkNode cur=null;
        TreeLinkNode prev=null;
        while(!list.isEmpty())
        {
            boolean isFirst=true;
            while(cur_index>0){
                cur=list.poll();
                if(cur.left!=null){
                    list.offer(cur.left);
                    next_index++;
                }
                if(cur.right!=null){
                    list.offer(cur.right);
                    next_index++;
                }
                if(!isFirst){
                    prev.next=cur;

                }else{

                    isFirst=false;
                }
                prev=cur;
                cur_index--;
            }
            cur_index=next_index;
            next_index=0;

            cur.next=null;



        }



    }

    public static void main(String[] args) {
        TreeLinkNode head=new TreeLinkNode(1);
        TreeLinkNode t1=new TreeLinkNode(2);
        head.left=t1;
        Leetcode117 l117=new Leetcode117();
        l117.connect(head);
    }

    /**
     * 链接当前层次的节点的时候，遍历上层节点元素，定义一个下层指向
     * 第一个节点的指针，如果上层元素有左孩子，右孩子，逐一链接
     * 直至上层遍历完全，将上层节点指针指向下层节点第一个元素。重复
     * 上述过程。
     */


//    public void connect(TreeLinkNode root) {
//        TreeLinkNode lastNode = root;
//        while (lastNode != null) {
//            TreeLinkNode cur = new TreeLinkNode(0);
//            TreeLinkNode curHead = cur;
//            while (lastNode != null) {
//                if (lastNode.left != null) {
//                    cur.next = lastNode.left;
//                    cur = cur.next;
//                }
//                if (lastNode.right != null) {
//                    cur.next = lastNode.right;
//                    cur = cur.next;
//                }
//                lastNode = lastNode.next;
//            }
//            lastNode = curHead.next;
//        }
//    }

}
