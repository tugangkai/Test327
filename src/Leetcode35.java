public class Leetcode35 {


    public int searchInsert(int []nums,int target){
        int start=0;
        int end=nums.length;
        while(start<=end){
            int mid=(start+end)/2;
            if(nums[mid]==target)
                return mid;
            if(target>nums[mid])
                start=mid+1;
            else
                end=mid-1;

        }
        return start;

    }

//    public int searchInsert(int[] nums, int target) {
//        int len=nums.length;
//        int index=0;
//        if(target<nums[0])
//           return 0;
//        if(target>nums[len-1])
//            return len;
//        for(int i=0;i<len;i++){
//            if(target==nums[i])
//                return i;
//            if(target>nums[i]&&target<nums[i+1])
//                return i+1;
//        }
//        return 0;
//
//
//
//
//    }
    public static void main(String[] args) {

    }
}
