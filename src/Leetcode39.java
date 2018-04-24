import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode39 {
//
//    给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
//    candidates 中的数字可以无限制重复被选取。
//
//    说明：
//
//    所有数字（包括 target）都是正整数。
//    解集不能包含重复的组合。
//    示例 1:
//

    public List<List<Integer>> combinationSum(int[] candidates, int target)
     {
               List<List<Integer>> list = new ArrayList<>();
               Arrays.sort(candidates);
                backtrack(list, new ArrayList<>(), candidates, target, 0);

                return list; }

    private boolean backtrack(List<List<Integer>> list, ArrayList<Object> objects, int[] candidates, int target, int i) {

            if(target<0)
                return false;
            if(target==0)
            {
                list.add(new ArrayList(objects));
                return false;
            }

            for(int j=i;j<candidates.length;j++){
                boolean flag;
                objects.add(candidates[j]);
                flag=backtrack(list,objects,candidates,target-candidates[j],j);
                objects.remove(objects.size()-1);


                if(!flag)
                    break;

            }
            return true;
    }
    public static void main(String[] args) {
        Leetcode39 l39=new Leetcode39();
        int []sum={2,4,6};
        int candidates[]={10,1,2,7,6,1,5};
        List<List<Integer>>res = l39.combinationSum(candidates,8);
        for(List<Integer> r1:res){
            System.out.println(r1);
        }
    }


//
//    List<List<Integer>> ans = new ArrayList<List<Integer>>();
//    int path[] = new int[1000];
//    int len = 0;
//
//    public void DFS(int index, int[] c, int target){
//        if(target == 0){
//            //ans记录
//            List<Integer> tmp = new ArrayList<Integer>();
//            for(int i=0; i<len; i++){
//                tmp.add(path[i]);
//            }
//            ans.add(tmp);
//            return ;
//        }
//
//        if(target < 0 || index >= c.length){
//            return;
//        }
//
//        //use c[index]
//        path[len] = c[index];
//        len++;
//        DFS(index, c, target - c[index]);
//        //not use c[index]
//        len--;
//        DFS(index + 1, c, target);
//    }
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        DFS(0, candidates, target);
//        return ans;
//    }

}
