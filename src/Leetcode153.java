public class Leetcode153 {
    public static void main(String[] args) {
        int []nums={3,4,1,2,2,2};
        Leetcode153 l153=new Leetcode153();
        int res=l153.findMin(nums);
        System.out.println(res);
    }

    public int findMin(int[] nums){
        int len=nums.length;
        int start=0;
        int end=len-1;
        if(nums[start]<nums[end])
            return nums[start];
        while(start<=end){
            int mid=(start+end)/2;
            if(nums[mid]>nums[mid+1])
                return nums[mid+1];
            if(nums[mid]>nums[start])
                start=mid;
            else{
                end=mid;
            }
        }
        return nums[start];
    }
}
