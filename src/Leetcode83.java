public class Leetcode83 {



    public ListNode deleteDuplicates(ListNode head) {

        ListNode start=head;
        ListNode end=head;
        ListNode cur=head;
        int count=1;
        while(cur.next!=null){
            start=cur;
            end=cur.next;
            count=1;
            while(end!=null&&start.val==end.val)
            {
                count++;
                end=end.next;
            }
            if(count!=1){
                start.next=end;
                cur=end;
            }else{
                cur=cur.next;
            }
        }

        return head;
    }


//    public ListNode deleteDuplicates(ListNode head) {
//        if (head == null) {
//            return head;
//        }
//        ListNode n = head.next;
//        ListNode m = head;
//
//        while (n != null) {
//            if(n.val == m.val) {
//                m.next = n.next;
//            } else {
//                m = n;
//            }
//            n = n.next;
//        }
//        return head;
//    }

}
