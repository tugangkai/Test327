public class Leetcode45 {
    private int s=Integer.MAX_VALUE;
//    给定一个非负整数数组，你最初位于数组的第一个位置。
//
//    数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
//    你的目标是使用最少的跳跃次数到达数组的最后一个位置。
//
//    示例:
//
//    输入: [2,3,1,1,4]
//    输出: 2
//    解释: 跳到最后一个位置的最小跳跃数是 2。
//    从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
//    说明:
//
//    假设你总是可以到达数组的最后一个位置。
    private int min=45;
    public int jump(int[] nums) {
        int level = 0;
        int start = 0,end = 0;
        int target = nums.length - 1;

        while(end<target){
            level++;
            int value = start;
            for(int i = start;i<=end;i++){
                value = Math.max(value,nums[i]+i);
            }
            if(value<=end)//never has chance to reach last
                return -1;

            start = end+1;
            end = value;
        }
        return level;
    }

    public static void main(String[] args) {
        Leetcode45 l45=new Leetcode45();
        int []sum={2,3,1,1,4};
        int res=l45.jump(sum);
        System.out.println(res);

    }
//    public static void main(String[] args) {
//        Leetcode45 l45=new Leetcode45();
//        int []sum={2,3,1,1,4};
//        l45.jump(sum);
//    }
//    public int jump(int[] nums) {
//
//        int minStep=minStep(nums,0,0);
//        System.out.println(minStep);
//        return 0;
//}
//    public int  minStep(int []nums,int cur,int time){
//
//        int maxstep=nums[cur];
//        for(int i=1;i<=maxstep;i++){
//            if(cur+i>=nums.length-1){
//                time++;
//                if(time<=min){
//                    min=time;
//                }
//            }else{
//                minStep(nums,cur+i,time+1);
//            }
////            if(reach)
////            if(cur+i>=nums.length){
////               // time++;
////                if(time<=min){
////                    min=time;
////                }
////            }else{
////                minStep(nums,cur+i,time+1);
////            }
//
//        }
//        return  min;
//
//    }





}
