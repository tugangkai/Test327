import java.util.Arrays;

public class Leetcode136 {
//    给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
//
//    说明：
//
//    你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
//
//    示例 1:
//
//    输入: [2,2,1]
//    输出: 1
//    示例 2:
//
//    输入: [4,1,2,1,2]
//    输出: 4
    public int singleNumber(int[] nums) {
//        Arrays.sort(nums);
//
//        int len=nums.length;
//        for(int i=0;i<len;i++){
//            if((i==0||nums[i]!=nums[i-1])&&(i==len-1||nums[i]!=nums[i+1]))
//                return nums[i];
//        }
//        return -1;
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int res = 0;
        for (int i = 0; i < length; i++) {
            res = res ^ nums[i];
        }
        return res;


    }

    public static void main(String[] args) {
        Leetcode136 l136=new Leetcode136();
        int []nums={2,1,2};
        int res=l136.singleNumber(nums);
        System.out.println(res);
    }
}
