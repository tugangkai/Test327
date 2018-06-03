

public class Leetcode82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode h=new ListNode();
        h.next=head;
        ListNode start=null;
        ListNode end=null;
        ListNode cur=head;
        ListNode temp=h;
        while(cur.next!=null){
            start=cur;
            end=cur.next;

            while(end.val==start.val&&cur.next!=null){
                end=end.next;
            }
            cur=end;
            if(start.next!=end){
                temp.next=end;
            }else{
                temp=start;
            }
        }
        return h.next;
    }

    // 1->2->3->3->4->4->5
    public static void main(String[] args) {
        Leetcode82 l82=new Leetcode82();
        ListNode head=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(3);
        ListNode l5=new ListNode(4);
        ListNode l6=new ListNode(4);
        ListNode l7=new ListNode(5);
        head.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        l5.next=l6;
        l6.next=l7;
   //     System.out.println(head.next.next.next.next.val);
        head=l82.deleteDuplicates(head);
        while(head!=null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}
