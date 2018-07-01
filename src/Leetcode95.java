import java.util.ArrayList;
import java.util.List;

public class Leetcode95 {
//    public static void main(String[] args) {
//        GenerateTree g=new GenerateTree();
//        List<TreeNode> flist=g.generateTree(1,4,10);
//       /// System.out.println(flist.size());
//        for(TreeNode head:flist){
//            g.prevSearch(head);
//            System.out.println();
//        }
//
//    }
//    public void prevSearch(TreeNode head){
//        if(head!=null){
//            System.out.print(head.val+"\t");
//            prevSearch(head.left);
//            prevSearch(head.right);
//
//        }
//    }
public List<TreeNode> generateTrees(int n) {
    return generateTrees(1,n,n);
}
    public List<TreeNode> generateTrees(int start,int end,int n){
        List<TreeNode> subList=new ArrayList<TreeNode>();
        if(start==end){
            subList.add(new TreeNode(start));
            return subList;
        }
        if(start>end){
            subList.add(null);
            return subList;
        }
        for(int i=start;i<=end;i++){
            List<TreeNode> left=generateTrees(start,i-1,n);
            List<TreeNode> right=generateTrees(i+1,end,n);
            for(TreeNode l:left){
                for(TreeNode r:right){
                    TreeNode root=new TreeNode(i);
                    root.left=l;
                    root.right=r;
                    subList.add(root);
                }
            }

        }
        return subList;


    }
}
