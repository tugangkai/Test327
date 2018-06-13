public class Leetcode129 {
//    给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
//
//    例如，从根到叶子节点路径 1->2->3 代表数字 123。
//
//    计算从根到叶子节点生成的所有数字之和。
//
//    说明: 叶子节点是指没有子节点的节点。
//
//    示例 1:
//
//    输入: [1,2,3]
//            1
//            / \
//            2   3
//    输出: 25
//    解释:
//    从根到叶子节点路径 1->2 代表数字 12.
//    从根到叶子节点路径 1->3 代表数字 13.
//    因此，数字总和 = 12 + 13 = 25.
public static void main(String[] args) {
    Leetcode129 l129=new Leetcode129();
    TreeNode root=new TreeNode(1);
    TreeNode t1=new TreeNode(2);
    TreeNode t2=new TreeNode(3);
    root.left=t1;
    root.right=t2;
    int res=l129.sumNumbers(root);
    System.out.println(res);
}
public int sumNumbers(TreeNode root) {
   return sumNumbers(root,0);
}
public int sumNumbers(TreeNode root,int cur){
    if(root==null)
        return 0;
    cur=cur*10+root.val;
    if(root.left==null&&root.right==null){
        return cur;
    }
    int left=sumNumbers(root.left,cur);
    int right=sumNumbers(root.right,cur);
    return left+right;

}

}
