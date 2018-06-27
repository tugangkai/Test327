public class Leetcode203 {
//    删除链表中等于给定值 val 的所有节点。
//
//    示例:
//
//    输入: 1->2->6->3->4->5->6, val = 6
//    输出: 1->2->3->4->5
public static void main(String[] args) {
    Leetcode203 l203=new Leetcode203();
    ListNode head=new ListNode(1);
    ListNode l1=new ListNode(2);
    ListNode l2=new ListNode(3);
    head.next=l1;
    l1.next=l2;

   ListNode newHead= l203.removeElements(head,1);
   while(newHead!=null){
       System.out.println(newHead.val);
       newHead=newHead.next;
   }
}
public ListNode removeElements(ListNode head, int val) {
    if(head==null)
        return null;
    ListNode dummy=new ListNode();
    dummy.next=head;

    ListNode prev=dummy;
  //  ListNode op=head;
    while(prev.next!=null){
        if(prev.next.val==val)
        {
            prev.next=prev.next.next;
        }else{

            prev=prev.next;
        }
    }
    return dummy.next;



}


}
