import java.util.ArrayList;
import java.util.List;



//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
//        说明：解集不能包含重复的子集。
//
//        示例:
//
//        输入: nums = [1,2,3]
//        输出:
//        [
//        [3],
//        [1],
//        [2],
//        [1,2,3],
//        [1,3],
//        [2,3],
//        [1,2],
//        []
//        ]
public class Leetcode78 {

    public List<List<Integer>> subsets(int[] nums) {
        //return null;
        List<List<Integer>> flist=new ArrayList<List<Integer>>();

        for(int i=0;i<=nums.length;i++){
            flist.addAll(combine(nums,i));
        }

       return flist;
    }

    public static void main(String[] args) {
        Leetcode78 l78=new Leetcode78();
        int n[]={1,4,2};
        l78.subsets(n);
//        List<List<Integer>> res =l78.combine(n,2);
//        for(List<Integer> sub:res){
//            for(int i:sub){
//                System.out.print(i+"\t");
//            }
//            System.out.println();
//        }

    }
//
        public List<List<Integer>> combine(int []n, int k) {
            List<List<Integer>>combines=new ArrayList<>();
            if(k<=0)return combines;

            combines=combineRecursive(n,k,0,new ArrayList<>(),combines);

            return combines;
        }

        public List<List<Integer>>combineRecursive(int []n,int k,int start,List<Integer>comb,List<List<Integer>>combs){
            if(k==0){
                combs.add(new ArrayList(comb));
                return combs;
            }

            for(int i=start;i<=n.length-k;i++){
                comb.add(n[i]);
                //combs.add(new ArrayList<Integer>(comb));
                combs=combineRecursive(n,k-1,i+1,comb,combs);
                comb.remove(comb.size()-1); //回溯
            }
            return combs;
        }


//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> results = new ArrayList<>();
//        results.add(new ArrayList<>());
//        backTrack(results, new ArrayList<>(), nums, 0);
//        return results;
//    }

//    public void backTrack(List<List<Integer>> results, List<Integer> result,
//                          int[] nums, int start) {
//        for (int i = start; i < nums.length; i ++) {
//            result.add(nums[i]);
//            results.add(new ArrayList<>(result));
//            backTrack(results, result, nums, i + 1);
//            result.remove(result.size() - 1);
//        }
//    }
}
