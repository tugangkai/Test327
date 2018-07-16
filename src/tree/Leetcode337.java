package tree;

import Common.Commons;
import basic.TreeNode;

import java.util.ArrayDeque;

//小偷又发现一个新的可行窃的地点。 这个地区只有一个入口，称为“根”。 除了根部之外，每栋房子有且只有一个父房子。 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋形成了一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
//
//        在不触动警报的情况下，计算小偷一晚能盗取的最高金额。
//示例 1:
//
//        3
//        / \
//        2   3
//        \   \
//        3   1
//        能盗取的最高金额 = 3 + 3 + 1 = 7.
//
//        示例 2:
//
//        3
//        / \
//        4   5
//        / \   \
//        1   3   1
//        能盗取的最高金额 = 4 + 5 = 9.
//
//        致谢:
//        特别感谢 @dietpepsi 添加此题并创建所有测试用例。
public class Leetcode337 {
    /**
     * 先利用层次遍历来算一下 答案错误，因为这只是相隔1个节点的情况适用
     * @param root
     * @return
     */

    public int rob(TreeNode root) {
        return robDFS(root)[1];
    }

    private int[] robDFS(TreeNode node) {
        int[] res = new int[2];
        if (node == null) return res;
        int[] l = robDFS(node.left);
        int[] r = robDFS(node.right);
        res[1] = l[0] + r[0];
        res[0] = Math.max(res[1], l[1] + r[1] + node.val);
        return res;
    }
//    public int rob(TreeNode root){
//        if(root==null)
//            return 0;
//        int val=0;
//        if(root.left!=null){
//            val+=rob(root.left.left)+rob(root.left.right);
//        }
//        if(root.right!=null){
//            val+=rob(root.right.left)+rob(root.right.right);
//        }
//        return Math.max(val+root.val,rob(root.left)+rob(root.right));
//
//
//    }
//    public int getHeight(TreeNode root){
//        if(root==null){
//            return 0;
//        }
//        int left=getHeight(root.left);
//        int right=getHeight(root.right);
//        return left>right?left+1:right+1;
//    }
//    public int rob(TreeNode root) {
//        if(root==null)
//            return 0;
//        int []dp=new int [getHeight(root)];
//        ArrayDeque<TreeNode> queue=new ArrayDeque<TreeNode>();
//        queue.offer(root);
//        int odd=0;
//        int even=0;
//        boolean isOdd=true;
//        int level=0;
//        while(!queue.isEmpty())
//        {
//            int n=queue.size();
//            for(int i=0;i<n;i++){
//                TreeNode node=queue.poll();
//                if(isOdd){
//                    odd+=node.val;
//                }else{
//                    even+=node.val;
//                }
//                if(node.left!=null){
//                    queue.offer(node.left);
//                }
//                if(node.right!=null){
//                    queue.offer(node.right);
//                }
//            }
//            if(level==0){
//                dp[0]=odd;
//            }
//            else if(level==1){
//                dp[1]=even>dp[0]?even:dp[0];
//            }else{
//                int temp=level-3<=0?0:dp[level-3];
//                int cur=level%2==0?odd:even;
//                dp[level]=dp[level-2]>temp?cur+dp[level-2]:cur+temp;
//                dp[level]=dp[level]>dp[level-1]?dp[level]:dp[level-1];
//            }
//            odd=0;
//            even=0;
//            level++;
//            isOdd=!isOdd;
//
//        }
//
//        return dp[getHeight(root)-1];
//    }
//    public int rob(TreeNode root) {
//
//
//     return 0;
//    }
    public static void main(String[] args) {
       // int nums[]={3,2,-1,3,-1,-1,3,-1,1,-1,-1};
        int nums[]={2,1,-1,4,-1,-1,3,-1,-1};
        TreeNode root= Commons.buildTree(nums);
        Leetcode337 l337=new Leetcode337();
        int res=l337.rob(root);
        System.out.println(res);
    }


}
