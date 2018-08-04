public class Leetcode209 {
//    给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
//
//    示例:
//
//    输入: s = 7, nums = [2,3,1,2,4,3]
//    输出: 2
//    解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
//    进阶:
//
//    如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
public int minSubArrayLen(int s, int[] nums) {
    if(nums==null)
        return 0;
    int start=0;int end=0;
    int sum=0;
    int len=nums.length;
    int min=Integer.MAX_VALUE;
    while(end<len){
        sum+=nums[end];
        if(sum>=s){
            while(sum>=s){
                min=Math.min(min,end-start+1);
                sum-=nums[start];
                if(start==end){
                    end++;
                }
                start++;
            }
            end++;
        }else{
            end++;
        }



    }


    return min;


}
//    public int minSubArrayLen(int s, int[] nums) {
//        if (nums == null || nums.length == 0) return 0;
//        int i=1, j=nums.length;
//        boolean found = false;
//        while (i<=j) {
//            int m = (i+j)/2;
//            if (window(s, nums, m)) {
//                j = m-1;
//                found = true;
//            } else {
//                i=m+1;
//            }
//        }
//        return found ? i : 0;
//    }
//    private boolean window(int s, int[] nums, int w) {
//        int sum = 0;
//        for(int i=0; i<nums.length; i++) {
//            if (i>=w) sum -= nums[i-w];
//            sum += nums[i];
//            if (sum>=s) return true;
//        }
//        return false;
//    }

    public static void main(String[] args) {
        Leetcode209 ll=new Leetcode209();
        int []nums={2,3,1,2,4,3};
        int res=ll.minSubArrayLen(7,nums);
        System.out.println(res);
    }
}
