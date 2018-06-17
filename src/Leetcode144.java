import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Leetcode144 {

    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> list=new ArrayList<Integer>();
        ArrayDeque<TreeNode> stack=new ArrayDeque();
        TreeNode node=root;
        stack.push(node);
        while(!stack.isEmpty())
        {
           TreeNode cur= stack.pop();
           list.add(cur.val);
           if(cur.right!=null)
               stack.push(cur.right);
           if(cur.left!=null){
               stack.push(cur.left);
           }

        }
//
        return list;
    }
//
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> list=new ArrayList<Integer>();
//
//        preorderTraversal(root,list);
//        return list;
//
//
//    }
//    public void preorderTraversal(TreeNode rot,List<Integer>list){
//        if(rot!=null){
//            list.add(rot.val);
//            preorderTraversal(rot.left,list);
//            preorderTraversal(rot.right,list);
//        }
//    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        TreeNode t1=new TreeNode(2);
        TreeNode t2=new TreeNode(3);
        root.left=t1;
        root.right=t2;
        Leetcode144 l144=new Leetcode144();
       List<Integer> list= l144.preorderTraversal(root);
       for(int i:list)
           System.out.println(i);
    }
}
