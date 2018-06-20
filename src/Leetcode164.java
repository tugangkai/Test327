import java.util.Arrays;

public class Leetcode164 {
//    给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
//
//    如果数组元素个数小于 2，则返回 0。
//
//    示例 1:
//    输入: [3,6,9,1]
//    输出: 3
//    解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
//    示例 2:
//    输入: [10]
//    输出: 0
//    解释: 数组元素个数小于 2，因此返回 0。
//    说明:
//    你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
//    请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
public static void main(String[] args) {
    Leetcode164 l164=new Leetcode164();
    int []nums={1,3,5,7,10,14};
    int res=l164.maximumGap(nums);
    System.out.println(res);
}
    public int maximumGap(int[] nums) {
        int len=nums.length;

        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            min=Math.min(nums[i],min);
            max=Math.max(nums[i],max);
        }

        int dis=(int)Math.ceil(1.0*(max-min)/len-1);
        int n=(max-min)/dis;
        int []minBuk=new int[n+1];
        int []maxBuk=new int[n+1];

        Arrays.fill(minBuk,Integer.MAX_VALUE);
        Arrays.fill(maxBuk,Integer.MIN_VALUE);

        for(int i=0;i<nums.length;i++){
            int cur=(nums[i]-min)/dis;
            minBuk[cur]=Math.min(minBuk[cur],nums[i]);
            maxBuk[cur]=Math.max(maxBuk[cur],nums[i]);
        }
        int pre=maxBuk[0];
        int gap=0;
        for(int j=1;j<=nums.length;j++){
            if(minBuk[j]==Integer.MAX_VALUE&&maxBuk[j]==Integer.MIN_VALUE)
                continue;
            System.out.println("minBUk[j]-pre"+(minBuk[j]-pre));
            gap=Math.max(gap,minBuk[j]-pre);
            pre=maxBuk[j];
        }
        return gap;



    }


//    public int maximumGap(int[] nums) {
//        if(nums==null || nums.length<2){
//            return 0;
//        }
//        int max = 0;
//        Arrays.sort(nums);
//        for(int i=nums.length-1;i>=1;i--){
//            int temp = nums[i]-nums[i-1];
//            max = Math.max(max,temp);
//        }
//        return max;
//    }

}
