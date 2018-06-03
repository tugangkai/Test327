public class Leetcode86 {
//
//    给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
//
//    你应当保留两个分区中每个节点的初始相对位置。

//    示例:
////
////    输入: head = 1->4->3->2->5->2, x = 3
////    输出: 1->2->2->4->3->5
public ListNode partition(ListNode head, int x) {
    if(head==null){
        return null;
    }
    ListNode dummy=new ListNode(0);
    dummy.next=head;
    ListNode largerPre=dummy;
    ListNode op=null;
 //   ListNode tail=null;
    ListNode cur=head;
    //找到第一个大于等于x的节点
    while(cur!=null) {
        if (cur.val >= x) {
         //   tail = cur;
            break;
        }
        largerPre = cur;
        cur = cur.next;
    }
    if(cur==null)
        return head;
    op=cur;
    while(cur!=null&&cur.next!=null){
        if(cur.next.val<x){
            ListNode tmp=cur.next;
            op.next=tmp.next;
            tmp.next=largerPre.next;
            largerPre.next=tmp;
            largerPre=tmp;
        }else{
            op=cur.next;
            cur=cur.next;
        }
    }


    return head;


}


    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode l2=new ListNode(4);
//        ListNode l3=new ListNode(3);
//        ListNode l4=new ListNode(2);
//        ListNode l5=new ListNode(5);
//        ListNode l6=new ListNode(2);
        head.next=l2;
//        l2.next=l3;
//        l3.next=l4;
//        l4.next=l5;
//        l5.next=l6;
        Leetcode86 l86=new Leetcode86();
        ListNode newh=l86.partition(head,3);
        System.out.println(head.next.val);
        //System.out.println(newh.next.next.next.next.next.next.val);

    }

    /**
     * 将链表中的元素分为两条链，一条链表上元素比x大，一条上元素比x小
     * 最后链接两个链表。
     */

//    public ListNode partition(ListNode head, int x) {
//        if(head==null)return head;
//        ListNode small=new ListNode(0);
//        ListNode s=small;
//        ListNode large=new ListNode(0);
//        ListNode l=large;
//        while(head!=null){
//            if(head.val<x){
//                s.next=head;
//                s=s.next;
//            }else{
//                l.next=head;
//                l=l.next;
//            }
//            head=head.next;
//        }
//        l.next=null;
//        s.next=large.next;
//        return small.next;
//    }


}
