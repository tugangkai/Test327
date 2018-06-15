public class Leetcode137 {

//    给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
//
//    说明：
//
//    你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
//
//    示例 1:
//
//    输入: [2,2,3,2]
//    输出: 3
//    示例 2:
//
//    输入: [0,1,0,1,0,1,99]
//    输出: 99
public static void main(String[] args) {
    Leetcode137 l137=new Leetcode137();
    int []nums={0,1,0,1,0,1,99};
    int res=l137.singleNumber(nums);
    System.out.println(res);
}
    public int singleNumber(int[] nums) {
        if(nums==null)
            return 0;
        int res=0;
        for(int i=0;i<32;i++){
            int k=1<<i;
            int count=0;
            for(int j=0;j<nums.length;j++){
                if((nums[j]&k)!=0)
                    count++;

            }
            if(count%3!=0)
                res|=k;

        }
        return  res;

    }


}
