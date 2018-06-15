import java.util.ArrayList;
import java.util.List;

public class Leetcode260 {
//    给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
//
//    示例 :
//
//    输入: [1,2,1,3,2,5]
//    输出: [3,5]
//    注意：
//
//    结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
//    你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
public static void main(String[] args) {
//    Leetcode260 l260=new Leetcode260();
//    int []nums={1,2,3,3,5,5,8,8};
//    int res[]=l260.singleNumber(nums);
//    System.out.println(res[0]);
//    System.out.println(res[1]);


    int i=1;
    i=~i;
    System.out.println(i);
}
    public int[] singleNumber(int[] nums) {
        int k=0;
        for(int i=0;i<nums.length;i++)
            k^=nums[i];
        int l=1;
        while((l&k)==0){
            l<<=1;
        }
        List<Integer> left=new ArrayList<Integer>();
        List<Integer> right=new ArrayList<Integer>();

        for(int i=0;i<nums.length;i++){
            if((l&nums[i])==0)
                left.add(nums[i]);
            else
                right.add(nums[i]);


        }

        int lr=0;
        int rr=0;
        int rlen=right.size();
        int llen=left.size();
        for(int i=0;i<llen;i++)
            lr^=left.get(i);
        for(int j=0;j<rlen;j++){
            rr^=right.get(j);
        }

        int []res=new int[2];
        res[0]=lr;
        res[1]=rr;
        return res;


    }

    /**
     * 对所有数组中的数进行异或操作后，那么就会剩下两个只出现一次的数
     * 可以对结果数取最后一个二进制，作为区分这两个数的标准
     */
//    public int[] singleNumber(int[] nums) {
//        int sum = 0;
//        for(int tmp:nums){
//            sum ^= tmp;
//        }
//        int loc = sum&(~(sum-1));
//        int[] res = new int[2];
//        for(int tmp:nums){
//            if((tmp&loc) == 0) res[0] ^= tmp;
//            else res[1] ^= tmp;
//        }
//        return res;
//    }


}
