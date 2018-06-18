public class Leetcode148 {

//    在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
//
//    示例 1:
//
//    输入: 4->2->1->3
//    输出: 1->2->3->4
//    示例 2:
//
//    输入: -1->5->3->4->0
//    输出: -1->0->3->4->5
public static void main(String[] args) {
    ListNode head=new ListNode(5);
//    ListNode n1=new ListNode(7);
//    ListNode n2=new ListNode(4);
//    head.next=n1;
//    n1.next=n2;

    Leetcode148 l148=new Leetcode148();
    ListNode newHead=l148.sortList(head);
   // System.out.println(newHead.val);
    while(newHead!=null){
        System.out.println(newHead.val);
        newHead=newHead.next;
    }
}
public ListNode sortList(ListNode head) {
    if(head==null)
        return null;
    ListNode op=head;
    while(op.next!=null){
        op=op.next;
    }
    ListNode newHead=mergeSort(head,head,op);

    return newHead;
}
public ListNode mergeSort(ListNode head,ListNode start,ListNode end){
    if(start!=end){
        ListNode sp=start;
        ListNode fp=start;
        while(fp!=end&&fp.next!=end){
            sp=sp.next;
            fp=fp.next.next;
        }
        ListNode next=sp.next;
        sp.next=null;
        end.next=null;
        ListNode left=mergeSort(head,start,sp);
        ListNode right=mergeSort(head,next,end);
        head=merge(left,sp,right,end);
      //  System.out.println(head.val);
        return head;

    }
    return start;
}
public ListNode merge(ListNode s1,ListNode e1,ListNode s2,ListNode e2){
    ListNode op=new ListNode(0);
    ListNode cur=op;
    while(s1!=null&&s2!=null){
        if(s1.val<s2.val){
            op.next=s1;
            op=op.next;
            s1=s1.next;
        }else{
            op.next=s2;
            op=op.next;
            s2=s2.next;
        }


    }
    if(s1==null){
        while(s2!=null){
            op.next=s2;
            op=op.next;
            s2=s2.next;
        }

    }else{
        while(s1!=null){
            op.next=s1;
            op=op.next;
            s1=s1.next;
        }
    }
    op.next=null;
    //System.out.println("cur.next:"+cur.next.val);
//    System.out.println("-----------");
//    ListNode oo=cur.next;
//    while(oo!=null){
//        System.out.println(oo.val);
//        oo=oo.next;
//    }
//    System.out.println("----------");
    return cur.next;
}



}
