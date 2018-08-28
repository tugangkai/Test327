import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class BSTIterator {
    private List<TreeNode> list=new ArrayList<TreeNode>();
    private int index=-1;
    public BSTIterator(TreeNode root) {
        if(root==null)
            return ;
        ArrayDeque<TreeNode> stack=new ArrayDeque<TreeNode>();

        stack.push(root);
        while(!stack.isEmpty())
        {
            while(root.left!=null){
                stack.push(root.left);
                root=root.left;
            }
            TreeNode node=stack.pop();
            list.add(node);
            if(node.right!=null){
                stack.push(node.right);
                root=node.right;
            }
        }

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return index<list.size()-1;
    }

    /** @return the next smallest number */
    public int next() {
            index++;
          return list.get(index).val;
    }
}

public class Leetcode173 {
//    实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
//
//    调用 next() 将返回二叉搜索树中的下一个最小的数。
//
//    注意: next() 和hasNext() 操作的时间复杂度是O(1)，并使用 O(h) 内存，其中 h 是树的高度。
public static void main(String[] args) {
    TreeNode root=new TreeNode(1);
    TreeNode r1=new TreeNode(2);
    TreeNode r2=new TreeNode(3);
    TreeNode r3=new TreeNode(4);
    r2.left=r1;
    r1.left=root;
    r2.right=r3;

    BSTIterator iterator=new BSTIterator(null);
    boolean res=iterator.hasNext();
    System.out.println(res);
   // System.out.println(iterator.next()); ;
    while(iterator.hasNext()){
        System.out.println(iterator.next());

    }

}



}
