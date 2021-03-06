public class Leetcode152 {
//    给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
////
////    示例 1:
////
////    输入: [2,3,-2,4]
////    输出: 6
////    解释: 子数组 [2,3] 有最大乘积 6。
////    示例 2:
////
////    输入: [-2,0,-1]
////    输出: 0
////    解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。

    public int maxProduct(int[] nums) {
        if(nums==null)
            return 0;
        int []dp=new int[nums.length];
        dp[0]=nums[0];
        for(int i=0;i<nums.length;i++){
            int cur=dp[i-1]*nums[i];
            dp[i]=cur>nums[i]?cur:nums[i];

        }
        int max=0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,dp[i]);
        }
        return max;
    }

    public int maxProduct1(int[] nums) {

        int r = nums[0];

        for(int i = 1, imax = r, imin = r; i < nums.length; i++){

            if(nums[i] < 0){
                int temp = imax;
                imax = imin;
                imin = temp;
            }

            imax = Math.max(nums[i], nums[i] * imax);
            imin = Math.min(nums[i], nums[i] * imin);

            r = Math.max(r, imax);

        }
        return r;
    }
}
