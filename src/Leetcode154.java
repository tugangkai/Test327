public class Leetcode154 {
    public int search(int nums[]){
        int min=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<min){
                return nums[i];
            }
        }
        return min;
    }
    public int findMin(int []nums){
        int len=nums.length;
        int start=0;
        int end=len-1;
        if(nums[start]<nums[end])
            return nums[start];
        while(start<=end){
            int mid=(start+end)/2;
            if(nums[mid]==nums[start]&&nums[mid]==nums[end])
                search(nums);
            if(nums[mid]>nums[mid+1])
            return nums[mid+1];
            if(nums[mid]>=nums[start])
                start=mid;
            else
                end=mid;
        }
        return -1;
    }
}
