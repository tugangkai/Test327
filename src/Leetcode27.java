public class Leetcode27 {

//    public int removeElement(int[] nums, int val) {
//        int index=0;
//
//        for(int i=0;i<nums.length;i++){
//            if(nums[i] != val){
//                nums[index]=nums[i];
//                index++;
//            }
//
//        }
//        return index;
//    }

    public int removeElement(int[] nums, int val) {
        //计算问题
        int toremove=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val)
                toremove++;
            else
                nums[i-toremove]=nums[i];
        }
        return nums.length-toremove;

    }
}
