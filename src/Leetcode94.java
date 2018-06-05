
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class Leetcode94 {

    /**
     * 非递归遍历二叉树
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<Integer>();
        LinkedList<TreeNode> list=new LinkedList<TreeNode>();
        TreeNode cur=root;
        list.push(root);
        do{
            while(cur.left!=null)
            {
                list.push(cur.left);
                cur=cur.left;
            }
            TreeNode t=list.pop();
            res.add(t.val);
            if(t.right!=null){
                list.push(t.right);
                cur=t.right;
            }

        }while(!list.isEmpty());
        return res;

    }

    public static void main(String[] args) {
        Leetcode94 l94=new Leetcode94();
        TreeNode t=new TreeNode(1);
        TreeNode c1=new TreeNode(2);
        TreeNode c2=new TreeNode(3);
        t.right=c1;
        c1.left=c2;
        List<Integer> list=l94.inorderTraversal(t);
        for(int i:list){
            System.out.println(i);
        }
    }
}
