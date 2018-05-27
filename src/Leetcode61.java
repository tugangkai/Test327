import java.util.LinkedList;

public class Leetcode61 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val=x;}


    }
//    给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
//
//    示例 1:
//
//    输入: 1->2->3->4->5->NULL, k = 2
//    输出: 4->5->1->2->3->NULL
//    解释:
//    向右旋转 1 步: 5->1->2->3->4->NULL
//    向右旋转 2 步: 4->5->1->2->3->NULL
//    示例 2:
//
//    输入: 0->1->2->NULL, k = 4
//    输出: 2->0->1->NULL
//    解释:
//    向右旋转 1 步: 2->0->1->NULL
//    向右旋转 2 步: 1->2->0->NULL
//    向右旋转 3 步: 0->1->2->NULL
//    向右旋转 4 步: 2->0->1->NULL

    public ListNode rotateRight(ListNode head, int k) {
        if(head==null)
            return null;
        if(k==0)
            return head;
        //计算链表的长度
        int len=0;
        ListNode tmp=head;
        while(tmp!=null){
            len++;
            tmp=tmp.next;
        }
        if(len==1||k%len==0)
            return head;
        int real=k%len;
        //求倒数第k个节点
        ListNode r1=head;
        ListNode r2=head;
        ListNode pre=null;
        for(int i=0;i<real-1;i++){

            r1=r1.next;
        }
        //r2指向倒数第n个节点
        while(r1.next!=null){
            pre=r2;
            r1=r1.next;
            r2=r2.next;
        }
//        System.out.println("r1的值为:"+r1.val);
//        System.out.println("r2的值为:"+r2.val);
        r1.next=head;
        head=r2;
        pre.next=null;
        return head;

    }


    public static void main(String[] args) {
        Leetcode61 l61=new Leetcode61();

        //ListNode head=new ListNode(4);
        ListNode head=l61.new ListNode(1);
        ListNode h2=l61.new ListNode(2);
        ListNode h3=l61.new ListNode(3);
        ListNode h4=l61.new ListNode(4);
        head.next=h2;
//        h2.next=h3;
//        h3.next=h4;
//        h4.next=null;



        ListNode newHead=l61.rotateRight(head,2);
        while(newHead!=null){
            System.out.println(newHead.val);
            newHead=newHead.next;
        }

    }


//    public ListNode rotateRight(ListNode head, int k) {
//        if (head == null || k <= 0) {
//            return head;
//        }
//        ListNode current = head;
//        int n = 1;
//        //O(n)
//        while (current.next != null) {
//            n++;
//            current = current.next;
//        }
//
//        current.next = head;
//
//        int count = n - k % n;
//        ListNode result = null;
//        for (int i = 0; i < count; i++) {
//            current = current.next;
//        }
//        result = current.next;
//        current.next = null;
//        return result;
//    }
}
