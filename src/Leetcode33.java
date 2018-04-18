public class Leetcode33 {
    public int search(int[] nums, int target) {
        int len=nums.length;
        int begin=0;
        int end=len-1;
        while(begin<=end){
            int mid=begin+(end-begin)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[mid]>=nums[begin]){
                if(target<nums[mid]&&target>=nums[begin])
                    end=mid-1;
                else
                    begin=mid+1;
            }else{
                if(target>nums[mid]&&target<=nums[end]){
                    begin=mid+1;
                }else{
                    end=mid-1;
                }

            }



        }

        return -1;

    }

    public static void main(String[] args) {
        Leetcode33 l3=new Leetcode33();
        int nums[]= {4,5,6,7,0,1,2};
        System.out.println( l3.search(nums,0));;

    }
}
