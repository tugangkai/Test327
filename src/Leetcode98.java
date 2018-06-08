import java.util.LinkedList;

public class Leetcode98 {

//    public boolean isValidBST(TreeNode root) {
//
//
//
//        //return null;
//    }
//    public boolean isValidBST(TreeNode root){
//        if(root.left==null&&root.right==null)
//            return true;
//        if(root!=null){
//            boolean left=isValidBST(root.left);
//            boolean right=isValidBST(root.right);
//
//            //boolean f2=root.val>root.left.val&&root.val<root.right.val;
//            boolean f2=false;
//            if(root.left==null&&root.right!=null){
//                f2=root.val<root.right.val;
//            }else if(root.left!=null&&root.right==null){
//                f2=root.val>root.left.val;
//            }else{
//                f2=(root.val>root.left.val&&root.val<root.right.val);
//            }
//            return left&&right&&f2;
//
//
//        }
//        return false;
//    }
//    public boolean isValidBST(TreeNode root){
////        TreeNode prev=new TreeNode(Integer.MIN_VALUE);
////        if(root==null)
////            return true;
////        if(root.left==null&&root.right==null)
////            return true;
////        return isValidBST(root,prev,true);
////    }
////
////    public boolean isValidBST(TreeNode root,TreeNode pre,Boolean first){
////
////
////        if(root!=null){
////            if(!isValidBST(root.left,pre,first)){
////                return false;
////            }
////
////
////            if(!first&&root.val<=pre.val)
////                return false;
////            if(first){
////                first=false;
////            }
////            pre.val=root.val;
////            if(!isValidBST(root.right,pre,first))
////                return false;
////        }
////
////        return true;
////    }


    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> list=new LinkedList<TreeNode>();
        list.push(root);
        boolean first=true;
        TreeNode prev=null;
        do{
            while(root.left!=null)
            {
                list.push(root.left);
                root=root.left;
            }
            while(!list.isEmpty()){
                TreeNode t=list.pop();
                if(!first){
                    if(t.val<=prev.val)
                        return false;
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

        return true;



    }



//    public boolean isValidBST(TreeNode root) {
//        if (root == null || root.left == null && root.right == null) {
//            return true;
//        }
//        return isValidBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
//    }
//
//    private boolean isValidBST(TreeNode root, long maxValue, long minValue) {
//        if (root == null) {
//            return true;
//        }
//        if (root.val <= minValue || root.val >= maxValue) {
//            return false;
//        }
//        return isValidBST(root.left, root.val, minValue) && isValidBST(root.right, maxValue, root.val);
//    }
//}

    public static void main(String[] args) {
        TreeNode head=new TreeNode(1);
        TreeNode left=new TreeNode(Integer.MIN_VALUE);
        TreeNode right=new TreeNode(3);
        head.left=left;
       head.right=right;
        Leetcode98 l98=new Leetcode98();
        boolean flag=l98.isValidBST(head);
        System.out.println(flag);
    }
}
