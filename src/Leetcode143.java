public class Leetcode143 {
//    给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
//    将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
//
//    你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//    示例 1:
//
//    给定链表 1->2->3->4, 重新排列为 1->4->2->3.
//    示例 2:
//
//    给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
    //获得倒数第二个节点
public static void main(String[] args) {
    ListNode n1=new ListNode(1);
    ListNode n2=new ListNode(2);
    ListNode n3=new ListNode(3);
    ListNode n4=new ListNode(4);
    ListNode n5=new ListNode(5);
    n1.next=n2;
    n2.next=n3;

    n3.next=n4;
    n4.next=n5;
    Leetcode143 l143=new Leetcode143();
  //  ListNode newHead=l143.reverseList(n1);
   // l143.printlist(newHead);
   l143.reorderList(n1);
   l143.printlist(n1);
}

    public ListNode reverseList(ListNode head){
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode op=head;
        while(op.next!=null){
            ListNode next=op.next;
            op.next=next.next;
            next.next=dummy.next;
            dummy.next=next;
        }
        return dummy.next;
    }
    public void reorderList(ListNode head) {
        if(head==null||head.next==null||head.next.next==null)
            return;
        ListNode fp=head;
        ListNode sp=head;
        ListNode newLast=null;
        while(fp!=null){
            newLast=sp;
            sp=sp.next;
            if(fp.next==null){
                break;
            }
            fp=fp.next.next;
        }
        newLast.next=null;

        ListNode rl=reverseList(sp);
//        printlist(rl);
//        System.out.println("-------");
        ListNode h1=head;
        while(h1!=null&&rl!=null){
            ListNode rp=rl;
            rl=rl.next;
            rp.next=h1.next;
            h1.next=rp;
            h1=rp.next;
        }




    }
//public ListNode lastNode(ListNode head){
//    ListNode op=head;
//    while(op.next.next!=null){
//       // System.out.println(op.val);
//        op=op.next;
//    }
//    return op;
//
//}
//
//public void reorderList(ListNode head) {
//        if(head==null||head.next==null)
//            return;
//
//        ListNode op=head;
//        while(op!=null&&op.next!=null&&op.next.next!=null){
//            ListNode lt=lastNode(head);
//            //System.out.println(lt.val);
//            ListNode last=lt.next;
//            last.next=op.next;
//            op.next=last;
//            op=last.next;
//          //  System.out.println("op:::::"+op.val);
//            lt.next=null;
//         //   printlist(head);
//       //     System.out.println("-------------------");
//        }
//
//
//
//}
public void printlist(ListNode node){
    while(node!=null){
        System.out.println(node.val);
        node=node.next;
    }
}

}
