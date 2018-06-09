import java.util.LinkedList;

public class Leetcode99 {

    public void recoverTree(TreeNode root) {
        if(root==null)
           return;
//        if (root == null) {
////            return true;
////        }
        LinkedList<TreeNode> list=new LinkedList<TreeNode>();
        list.push(root);
        boolean first=true;
        TreeNode prev=null;
        TreeNode[][] nodes=new TreeNode[2][2];
        int size=0;
        do{
            while(root.left!=null)
            {
                list.push(root.left);
                root=root.left;
            }
            while(!list.isEmpty()){
                TreeNode t=list.pop();
                if(!first){
                    if(t.val<=prev.val){
                        nodes[size][0]=prev;
                        nodes[size][1]=t;
                        size++;
                    }
                     //   System.out.println(size);

                      //  node[size++]
                }else{
                    first=false;
                }
                prev=t;
                if(t.right!=null){
                    list.push(t.right);
                    root=t.right;
                    break;
                }

            }



        }while(!list.isEmpty());

        if(size==1){
            int temp=nodes[0][0].val;
            nodes[0][0].val=nodes[0][1].val;
            nodes[0][1].val=temp;

        }else{
            int temp=nodes[0][0].val;
            nodes[0][0].val=nodes[1][1].val;
            nodes[1][1].val=temp;


        }


    }
    public void midOrder(TreeNode node){
        if(node!=null){
            midOrder(node.left);
            System.out.println(node.val);
            midOrder(node.right);

        }
    }
    public static void main(String[] args) {
//        TreeNode head=new TreeNode(1);
////        TreeNode t1=new TreeNode(3);
////        TreeNode t2=new TreeNode(2);
////        head.left=t1;
////        t1.right=t2;

        TreeNode head=new TreeNode(3);
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(4);
        TreeNode t3=new TreeNode(2);
        head.left=t1;
        head.right=t2;
        t2.left=t3;


        Leetcode99 l99=new Leetcode99();
        l99.recoverTree(head);
        l99.midOrder(head);


    }

//    TreeNode pr = null;
//    TreeNode first = null;
//    TreeNode second = null;
//    public void recoverTree(TreeNode root) {
//        myRecoverTree(root);
//        if(first != null && second != null){
//            int val = first.val;
//            first.val = second.val;
//            second.val = val;
//        }
//    }
//    public void myRecoverTree(TreeNode root){
//        if(root == null) return;
//        myRecoverTree(root.left);
//        if(pr != null){
//            if(pr.val >= root.val){
//                if(first == null) first = pr;
//                second = root;
//            }
//        }
//        pr = root;
//        myRecoverTree(root.right);
//    }

}
