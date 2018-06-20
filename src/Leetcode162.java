public class Leetcode162 {
//    峰值元素是指其值大于左右相邻值的元素。
//
//    给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
//
//    数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
//
//    你可以假设 nums[-1] = nums[n] = -∞。
//
//    示例 1:
//
//    输入: nums = [1,2,3,1]
//    输出: 2
//    解释: 3 是峰值元素，你的函数应该返回其索引 2。
//    示例 2:
//
//    输入: nums = [1,2,1,3,5,6,4]
//    输出: 1 或 5
//    解释: 你的函数可以返回索引 1，其峰值元素为 2；
//    或者返回索引 5， 其峰值元素为 6。
public static void main(String[] args) {

}
    public int findPeakElement(int[] nums) {
            return findPeakElement(nums,0,nums.length-1);
    }
    public int findPeakElement(int []nums,int start,int end){

        if(start<=end){
         int mid=(start+end)/2;
         if((mid==0||nums[mid]>nums[mid-1])&&(mid==nums.length-1||nums[mid]>nums[mid+1]))
             return mid;
         if(mid>0&&nums[mid]<nums[mid-1])
             return findPeakElement(nums,start,mid-1);
         if(mid<nums.length-1&&nums[mid]<nums[mid+1])
             return findPeakElement(nums,mid+1,end);
        }
        return -1;

    }

//    public int findPeakElement(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return -1;
//        }
//        if (nums.length == 1) {
//            return 0;
//        }
//        if (nums[0] > nums[1]) {
//            return 0;
//        }
//        if (nums[nums.length - 1] > nums[nums.length - 2]) {
//            return nums.length - 1;
//        }
//        int l = 0, r = nums.length - 1;
//        while (true) {
//            int mid = (l + r) / 2;
//            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
//                return mid;
//            }
//            if (nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1]) {
//                l = mid;
//            } else {
//                r = mid;
//            }
//        }
//    }


}
