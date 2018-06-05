public class Leetcode92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n)
            return head;
        ListNode dummy=new ListNode();

        dummy.next=head;
        ListNode  pre=dummy;
        ListNode  op=dummy;
        for(int i=0;i<m;i++){
            pre=op;
            op=op.next;
        }
        for(int j=0;j<n-m;j++){
            ListNode cur=op.next;
            op.next=cur.next;
            cur.next=pre.next;
            pre.next=cur;
        }


        return dummy.next;
    }
    public static void main(String[] args) {
    Leetcode92 l92=new Leetcode92();
    ListNode head=new ListNode(1);
    ListNode l2=new ListNode(2);
    ListNode l3=new ListNode(3);
    ListNode l4=new ListNode(4);
    ListNode l5=new ListNode(5);
    head.next=l2;
    l2.next=l3;
    l3.next=l4;
    l4.next=l5;
    ListNode hi=l92.reverseBetween(head,1,4);
    while(hi!=null){
        System.out.println(hi.val);
        hi=hi.next;
    }


    }
}
