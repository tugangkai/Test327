public class Leetcode147 {

    public ListNode insertionSortList(ListNode head){
        if(head==null)
            return null;
        if(head.next==null)
            return head;
        ListNode op=head.next;
        ListNode pre=head;
        while(op!=null){
            ListNode cur=op;
            op=op.next;
            int val=cur.val;
            ListNode sp=head.next;
            ListNode fp=head;
            boolean flag=false;
            if(head.val>val){
                pre.next=cur.next;
                cur.next=head;
                head=cur;
                flag=true;
            }else{
                while(sp!=cur){
                    if(sp.val>val){
                        pre.next=cur.next;
                        cur.next=sp;
                        fp.next=cur;
                        flag=true;
                        break;
                    }
                    fp=sp;
                    sp=sp.next;
                }
            }
            if(!flag){
                pre=pre.next;
            }


        }
        return head;

    }

    public static void main(String[] args) {
        ListNode head=new ListNode(5);
        ListNode n1=new ListNode(2);
        ListNode n2=new ListNode(4);
        head.next=n1;
        n1.next=n2;

        Leetcode147 l147=new Leetcode147();
        ListNode newHead=l147.insertionSortList(head);
        while(newHead!=null){
            System.out.println(newHead.val);
            newHead=newHead.next;
        }

    }
}
