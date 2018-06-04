import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode90 {
    public static void main(String[] args) {
        Leetcode90 l90=new Leetcode90();
        int []nums={1};
        List<List<Integer>> list=l90.subsetsWithDup(nums);
        list.add(new ArrayList());
        for(List<Integer> l:list){
            for(int i:l){
                System.out.print(i+"\t");
            }
            System.out.println();
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> list=new ArrayList<List<Integer>>();
        List<Integer> sub=new ArrayList<Integer>();
        Arrays.sort(nums);
       // System.out.println(list.size());
        addsubsets(list,sub,0,nums);
        list.add(new ArrayList());
        return list;

    }
    public void addsubsets(List<List<Integer>> list,List<Integer> sub,int start,int []nums){
        int s=Integer.MIN_VALUE;
        for(int i=start;i<nums.length;i++){

            if(nums[i]==s)
                continue;
            sub.add(nums[i]);
            int last=sub.size()-1;
            list.add(new ArrayList(sub));
            addsubsets(list,sub,i+1,nums);
            s= sub.remove(last);
        }
    }




//    private List<List<Integer>> res = new ArrayList<>();
//    public List<List<Integer>> subsetsWithDup(int[] nums) {
//        Arrays.sort(nums);
//        dfs(new ArrayList(), nums, 0, 0);
//        return res;
//    }
//
//    private void dfs(List<Integer> list, int[] nums, int curLoc, int curValue) {
//        if (curLoc <= nums.length) {
//            res.add(new ArrayList(list));
//        }
//        for (int i = curValue; i < nums.length; i++)  {
//            if (i == curValue || nums[i] != nums[i-1]) {
//                list.add(nums[i]);
//                dfs(list, nums, curLoc + 1, i + 1);
//                list.remove(list.size()-1);
//            }
//        }
//    }
}
