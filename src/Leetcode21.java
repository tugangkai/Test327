public class Leetcode21 {
//    将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//    示例：
//
//    输入：1->2->4, 1->3->4
//    输出：1->1->2->3->4->4
//
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if(l1==null){
//            return l2;
//        }
//        if(l2==null){
//            return l1;
//        }
//        ListNode head = null;
//        if(l1.val<l2.val){
//            head = l1;
//            head.next = mergeTwoLists(l1.next, l2);
//        }else{
//            head = l2;
//            head.next = mergeTwoLists(l1, l2.next);
//        }
//        return head;
//    }

    public ListNode buildList(int []array){
        ListNode head=new ListNode(array[0]);
        ListNode op=head;
        for(int i=1;i<array.length;i++){
            op.next=new ListNode(array[i]);
            op=op.next;
        }
        return head;
    }
public static void main(String[] args) {
        Leetcode21 l21=new Leetcode21();
        int []arr1={1,2,4};
        int []arr2={1,3,4};
    ListNode h1=l21.buildList(arr1);
    ListNode h2=l21.buildList(arr2);
    ListNode newHead=l21.mergeTwoLists(h1,h2);
    while(newHead!=null){
        System.out.println(newHead.val);
        newHead=newHead.next;
    }



}


public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode dummy=new ListNode(0);
    ListNode op=dummy;
    ListNode op1=l1;
    ListNode op2=l2;
    while(op1!=null&&op2!=null){
        if(op1.val<op2.val){
            op.next=op1;
            op1=op1.next;
        }else{
            op.next=op2;
            op2=op2.next;
        }
        op.next.next=null;
        op=op.next;

    }
    if(op1==null){
        while(op2!=null){
            op.next=op2;
            op2=op2.next;
            op=op.next;

        }
    }
    if(op2==null){
        while(op1!=null){
            op.next=op1;
            op1=op1.next;
            op=op.next;
        }
    }

    return dummy.next;

}

}
