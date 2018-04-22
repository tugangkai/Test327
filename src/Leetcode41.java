public class Leetcode41 {


//    给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
//
//    示例 1:
//
//    输入: [1,2,0]
//    输出: 3
//    示例 2:
//
//    输入: [3,4,-1,1]
//    输出: 2
//    示例 3:
//
//    输入: [7,8,9,11,12]
//    输出: 1
//    说明:
//
//    你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。

    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0)
            return 1;
        //第i位存放i+1的数值
        for(int i = 0; i < nums.length;i++){
            if(nums[i] > 0){//nums[i]为正数，放在i+1位置
                //如果交换的数据还是大于0且<i+1，则放在合适的位置,且数据不相等，避免死循环
                //这个while是关键，其他都是没有难度的
                while(nums[i] > 0 && nums[i] < i+1 && nums[i] != nums[nums[i] -1]){
                    int temp = nums[nums[i]-1];//交换数据
                    nums[nums[i]-1] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        //循环寻找不符合要求的数据，返回
        for(int i = 0; i < nums.length;i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        //如果都符合要求，则返回长度+1的值
        return nums.length + 1;
    }


    /**8ms解法*/
    class Solution {
        public int firstMissingPositive(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 1;
            }
            //记录当前找到的连续的最小的数字
            int i = 0;
            int len = nums.length;
            while (i < len) {
                //当前位置数
                int currentNum = nums[i];
                int pos = currentNum - 1;
                //1.负数
                //2.大于数组长度的数
                //3.当前就处于正确的位置
                //4.目标位置已经是正确的数，继续往下寻找
                if (currentNum <= 0 || currentNum > len || currentNum == i + 1 || nums[pos] == currentNum) {
                    i++;
                    continue;
                }

                nums[i] = nums[pos];
                nums[pos] = currentNum;
            }

            for (int j = 0; j<len; j++) {
                if(nums[j] != j+1) {
                    return j+1;
                }
            }
            return len+1;

        }


    }
}
