//
//给出一个链表，一次翻转 k 个指针节点，并返回修改后的链表。
//
//        k 是一个正整数，并且小于等于链表的长度。如果指针节点的数量不是 k 的整数倍，那么最后剩余的节点应当保持原来的样子。
//
//        你不应该改变节点的值，只有节点位置本身可能会改变。
//
//        题目应当保证，仅使用恒定的内存。
//
//        例如，
//
//        给定这个链表：1->2->3->4->5
//
//        当 k = 2时，应当返回: 2->1->4->3->5
//
//        当 k = 3时，应当返回: 3->2->1->4->5
//

import java.util.Scanner;

class ListNode{
    int val;
    ListNode next;
    public ListNode(){

    }
    public ListNode(int val,ListNode next){
        this.val=val;
        this.next=next;
    }

}
public class Leetcode26 {
    private  ListNode head=new ListNode();

    public ListNode getHead(){
        return head;
    }
    public ListNode buildList(){
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        while(x!=-1){
            ListNode node=new ListNode(x,null);
            node.next=head.next;
            head.next=node;
            x=sc.nextInt();



        }
        return head;



    }


    public boolean hasEnoughNode(ListNode node,int n){
        boolean isEnough=true;
        for(int i=0;i<n-1;i++){
            node=node.next;
            if(node==null){
                isEnough=false;
                break;
            }
        }
        return isEnough;

    }


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead=head;

        while(hasEnoughNode(newHead.next,k)) {

            ListNode cur=null;

            for(int i=0;i<k-1;i++) {

                cur= newHead.next;
                ListNode op = cur.next;
                cur.next = op.next;
                op.next = newHead.next;
                newHead.next = op;
            }
            newHead=cur;
        }
        return head;



    }
    public void printList(){
        ListNode tmp=head;
        while(tmp.next!=null){
            System.out.println(tmp.next.val);
            tmp=tmp.next;

        }


    }

    public static void main(String[] args) {

        Leetcode26 l2=new  Leetcode26();
        l2.buildList();

        l2.printList();
        System.out.println("----------------------------");
       l2.reverseKGroup(l2.getHead(),2);
        l2.printList();


    }


}
