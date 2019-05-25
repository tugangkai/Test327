public class Leetcode328 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode oddEvenList(ListNode head) {
        if(head==null)
            return null;
        ListNode evenHead=head;
        ListNode oddHead=head.next;
        if(oddHead==null)
            return evenHead;

        ListNode evenCur=head;
        ListNode oddCur=oddHead;
        ListNode evenTemp=oddHead.next;
        ListNode oddTemp=null;
        while(true){

            if(evenTemp==null)
                break;
            oddTemp=evenTemp.next;
            evenCur.next=evenTemp;
            oddCur.next=null;
            evenCur=evenTemp;

            if(oddTemp==null)
                break;
            oddCur.next=oddTemp;
            evenCur.next=null;
            oddCur=oddTemp;
            evenTemp=oddCur.next;
        }
        evenCur.next=oddHead;
        return evenHead;


    }

    public static void main(String[] args) {
        ListNode h1=new ListNode(1);

        h1.next=new ListNode(2);
        h1.next.next=new ListNode(3);
        h1.next.next.next=new ListNode(4);
        h1.next.next.next.next=new ListNode(5);

        ListNode res=oddEvenList(h1);
        while(res!=null){
            System.out.println(res.val);
            res=res.next;
        }
    }
}
