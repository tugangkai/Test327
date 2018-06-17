import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode145 {
//    给定一个二叉树，返回它的 后序 遍历。
//
//    示例:
//
//    输入: [1,null,2,3]
//            1
//            \
//            2
//            /
//            3
//
//    输出: [3,2,1]
//    进阶: 递归算法很简单，你可以通过迭代算法完成吗？
    class WNode{
        TreeNode node;
        int tag;
        public WNode(){

        }
        public WNode(TreeNode node,int tag){
            this.node=node;
            this.tag=tag;
        }
}

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList();
        LinkedList<WNode> stack=new LinkedList<WNode>();
        stack.push(new WNode(root,1));
        TreeNode op=root;
        do{
            while(op.left!=null){
                stack.push(new WNode(op.left,1));
                op =op.left;
            }
            while(!stack.isEmpty())
            {
                WNode cur=stack.peek();
                if(cur.tag==2){
                    list.add(cur.node.val);
                    stack.pop();
                }
                if(cur.tag==1){
                    cur.tag=2;
                    if(cur.node.right!=null){
                        stack.push(new WNode(cur.node.right,1));
                        op=cur.node.right;
                        break;
                    }
                }
            }

        }while(!stack.isEmpty());


        return list;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        TreeNode t1=new TreeNode(2);
        TreeNode t2=new TreeNode(3);
        root.left=t1;
        root.right=t2;
        Leetcode145 l145=new Leetcode145();
        List<Integer> list= l145.postorderTraversal(root);
        for(int i:list)
            System.out.println(i);
    }


}
