import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode40 {


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
            flag=backtrack(list,objects,candidates,target-candidates[j],j+1);
            objects.remove(objects.size()-1);
            while(j < candidates.length-1 && candidates[j] == candidates[j+1]){
                j++;
            }

            if(!flag)
                break;


        }
        return true;


    }

    public static void main(String[] args) {
        Leetcode40 l40=new Leetcode40();
        int []sum={2,4,6};
        int candidates[]={10,1,2,7,6,1,5};
        List<List<Integer>>res = l40.combinationSum(candidates,8);
        for(List<Integer> r1:res){
            System.out.println(r1);
        }
    }

    //11ms解法
    class Solution {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            recursion(candidates, target, 0);
            return lists;
        }

        public void recursion(int[] candidates, int target, int pos) {
            if (target == 0) lists.add(new ArrayList<Integer>(list));
            if (target > 0)
                for (int i = pos; i < candidates.length; i++) {
                    Integer candidate = candidates[i];
                    if (target - candidate < 0)
                        break;
                    if (i > pos && candidate == candidates[i - 1])
                        continue;
                    list.add(candidate);
                    recursion(candidates, target - candidate, i + 1);
                    list.remove(list.size() - 1);
                }
        }
    }

}
