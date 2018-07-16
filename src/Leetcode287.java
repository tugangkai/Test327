public class Leetcode287 {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        int nums[]={1,3,4,2,2};
        Leetcode287 l2=new Leetcode287();
        int res=l2.findDuplicate(nums);
        System.out.println(res);
    }
    public int findDuplicate(int[] nums) {
        int n=nums.length;
       int slow=n;
       int quick=n;
     do{
         slow=nums[slow-1];
         quick=nums[nums[quick-1]-1];
     }while(slow!=quick);
     slow=n;
     while(slow!=quick){
         slow=nums[slow-1];
         quick=nums[quick-1];
     }
     return slow;


    }


}
