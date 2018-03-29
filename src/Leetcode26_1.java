import java.util.Scanner;


public class Leetcode26_1 {
    public  ListNode head;

    public ListNode getHead(){
        return head;
    }
    public ListNode buildList(){
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        ListNode pre=null;
        while(x!=-1){
            if(head==null){
                head=new ListNode(x,null);
                pre=head;
            }else {
//                ListNode node = new ListNode(x, null);
//                node.next = head.next;
//                head.next = node;
                    ListNode node=new ListNode(x,null);
                    pre.next=node;
                    pre=node;

            }
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
        if(head==null)

            return null;
        if(k==1)
            return head;
        ListNode newHead=head;
        ListNode finalNode=head;
        if(k==1)
            return head;
        if(hasEnoughNode(newHead,k)){
            for(int i=0;i<k-1;i++){
                finalNode=finalNode.next;
            }
        }
       // boolean isFirst=false;
        ListNode prevTail=null;
        int j=0;
        ListNode ever=null;
        while(hasEnoughNode(newHead,k)) {
            j++;
            ListNode cur=newHead;
            ListNode op=null;
            for(int i=0;i<k-1;i++) {


                op= cur.next;

                cur.next = op.next;
               op.next = newHead;
               newHead=op;
//                newHead=op;

                if(j!=1)
                {
                    prevTail.next=op;
                }


            }

            if(j!=1){
                prevTail.next=op;
            }
            prevTail=cur;
            newHead=cur.next;


        }

        return finalNode;



    }
    public void printList(){
        ListNode tmp=head;
        while(tmp!=null){
            System.out.println(tmp.val);
            tmp=tmp.next;

        }


    }

    public static void main(String[] args) {

        Leetcode26_1 l2=new  Leetcode26_1();
        l2.buildList();

        l2.printList();
        System.out.println("----------------------------");
        ListNode ss=l2.reverseKGroup(l2.getHead(),3);
        l2.head=ss;
        l2.printList();


    }


}
