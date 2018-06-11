import java.util.ArrayList;
import java.util.List;

public class Leetcode113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> list=new ArrayList<List<Integer>>();
            List<Integer> sub=new ArrayList<Integer>();
            if(root==null){
                return null;
            }
             pathSum(list,sub,root,sum);
            return list;

    }
    public void pathSum(List<List<Integer>> list,List<Integer>sub,TreeNode root,int sum){
        if(root==null){
            return ;
        }
        if(root.left==null&&root.right==null){
            if(sum-root.val==0){
                sub.add(root.val);
                list.add(new ArrayList(sub));
                sub.remove(sub.size()-1);
            }
        }else{
            sub.add(root.val);
            pathSum(list,sub,root.left,sum-root.val);
            pathSum(list,sub,root.right,sum-root.val);
            sub.remove(sub.size()-1);
        }

    }
    public static void main(String[] args) {

    }
}
