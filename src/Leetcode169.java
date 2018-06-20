public class Leetcode169 {
//    给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
//
//    你可以假设数组是非空的，并且给定的数组总是存在众数。
//
//    示例 1:
//
//    输入: [3,2,3]
//    输出: 3
//    示例 2:
//
//    输入: [2,2,1,1,1,2,2]
//    输出: 2
public static void main(String[] args) {
    Leetcode169 l169 =new Leetcode169();
    int nums[]={1,1,1,1,4,4,4};
    int res=l169.majorityElement(nums);
    System.out.println(res);
}
    public int majorityElement(int[] nums) {
         return   majorityElement(nums,0,nums.length-1);
    }
    public int majorityElement(int []nums,int start,int end){
        if(start==end)
            return nums[start];
        if(start<end){
            int mid=(start+end)/2;
            int left=majorityElement(nums,start,mid);
            int right=majorityElement(nums,mid+1,end);

            if(left==right)
                return left;
            else{
                int lc=0;
                int rc=0;
                for(int i=start;i<=end;i++)
                {
                    if(nums[i]==left)
                        lc++;
                    if(nums[i]==right)
                        rc++;
                }
                if(lc<rc)
                    return right;
                else if(lc>rc)
                    return left;
            }
        }
        return nums[end];
    }


}
