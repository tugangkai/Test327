public class Leetcode142 {
    public ListNode detectCycle(ListNode head) {
        if(head==null)
            return null;

        ListNode op1=head;
        ListNode op2=head;
      //  boolean flag=false;
        while(op2!=null&&op2.next!=null){
            op1=op1.next;
            op2=op2.next.next;
            if(op1==op2)
            {
                break;
            }

        }
      //  return flag;
        if(op2==null||op2.next==null)
            return null;
        op1=head;
        while(op1!=op2){
            op1=op1.next;
            op2=op2.next;

        }
        return op1;



    }
//    public ListNode detectCycle(ListNode head) {
//
//        ListNode dummy=new ListNode();
//        dummy.next=head;
//        if(!hasCycle(dummy))
//            return null;
//
//        ListNode op=dummy;
//        ListNode next=dummy.next;
//        while(true){
//            op.next=next.next;
//            next.next=null;
//            if(!hasCycle(dummy))
//                return next;
//            next.next=op.next;
//            op.next=next;
//
//            op=op.next;
//            next=next.next;
//        }
//
//
//
//    }

    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
//        ListNode n3=new ListNode(0);
//        ListNode n4=new ListNode(-4);
        n1.next=n2;
        n2.next=n1;
//        n3.next=n4;
//        n4.next=n2;
        Leetcode142 l142=new Leetcode142();
        ListNode node=l142.detectCycle(n1);
        System.out.println(node.val);


    }
}
