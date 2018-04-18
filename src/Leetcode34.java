public class Leetcode34 {


//    给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
//    你的算法时间复杂度必须是 O(log n) 级别。
//
//    如果数组中不存在目标值，返回 [-1, -1]。
//    public int[] searchRange(int[] nums, int target) {
//        if(nums == null || nums.length < 1)
//            return new int[]{-1,-1};
//        int h = 0, L = nums.length, t = L-1;
//        // 找到第一个与target相等的数字下标
//        while(t >= h){
//            int m = (t+h)/2;
//            if(nums[m] >= target)
//                t = m - 1;
//            else
//                h = m + 1;
//        }
//        int firstSame = -1;
//        if(h < L && nums[h]==target)
//            firstSame = h;
//        else
//            return new int[]{-1,-1};
//        // 找相等的结尾
//        int i = firstSame;
//        for(; i < L; i++){
//            if(nums[i] != target)
//                break;
//        }
//        return new int[]{firstSame, i-1};
//    }


    public int[] searchRange(int[] nums, int target) {
        int len=nums.length;
        int begin=0;
        int end=len-1;
        int index=0;
        while(begin<=end){
            int mid=begin+(end-begin)/2;
            if(target==nums[mid])
                index=mid;
            if(target>nums[mid])
                begin=mid+1;
            else
                end=mid-1;

        }
        int []indexs={-1,-1};
        int pre=index;
        int next=index;
        if(index!=-1){
            while(index>0&&nums[pre]==nums[pre-1])
                pre=pre-1;

            while(next<len-1&&nums[next]==nums[next+1])
                next=next+1;
        }
        indexs[0]=pre;
        indexs[1]=next;
        return indexs;
    }
    }

