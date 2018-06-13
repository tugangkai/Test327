import java.util.HashSet;
import java.util.Set;

public class Leetcode128 {
    public int longestConsecutive(int[] nums) {
        if(nums==null)
            return 0;
        Set<Integer> set=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int max=1;
        for(int i=0;i<nums.length;i++){
            int cur=1;
            int left=nums[i];
            int right=nums[i];
            while(set.contains(--left))
                cur++;
            while(set.contains(++right))
                cur++;
            if(cur>max)
                max=cur;


        }
        return max;

    }



//    public int longestConsecutive(int[] nums) {
//        if(nums == null || nums.length == 0) return 0;
//        Arrays.sort(nums);
//        int tmp = nums[0] - 1;
//        int resLen = 0, len = 0;
//        for(int i = 0 ; i < nums.length; i++){
//            if(nums[i] - tmp == 1) {len++; tmp = nums[i];}
//            else if(nums[i] == tmp){tmp = nums[i];}
//            else{
//                resLen = Math.max(resLen, len);
//                len = 0;
//                tmp = nums[i] - 1;
//                i--;
//            }
//        }
//        return Math.max(resLen, len);
//    }
}
