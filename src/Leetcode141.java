public class Leetcode141 {
    public boolean hasCycle(ListNode head) {
        if(head==null)
            return false;

        ListNode op1=head;
        ListNode op2=head;
        boolean flag=false;
        while(op2!=null&&op2.next!=null){
            op1=op1.next;
            op2=op2.next.next;
            if(op1==op2)
            {
                flag=true;
                break;
            }

        }
        return flag;


    }


}
