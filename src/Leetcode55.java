public class Leetcode55 {
//
//    给定一个非负整数数组，你最初位于数组的第一个位置。
//
//    数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
//    判断你是否能够到达最后一个位置。
//
//    示例 1:
//
//    输入: [2,3,1,1,4]
//    输出: true
//    解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
//    示例 2:
//
//    输入: [3,2,1,0,4]
//    输出: false
//    解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
//    public boolean canJump(int []num){
//
////        boolean res=Jump(num,0,num.length-1);
////        return res;
//
//
//
//
//
//    }
    public boolean canJum(int []num){

        int end=0;
        int len=num.length;
        while(end<len){
            if(num[end]+end>=len-1){
                return true;
            }
            int max=0;
            int temp=0;
            for(int i=1;i<=num[end];i++){

                int cur=end+i;
                if(num[cur]+cur>=max){
                    max=num[cur]+cur;
                    temp=cur;
                }
            }
            end=temp;
            if(num[temp]==0){
                return false;
            }
        }
        return false;
    }
    /**
     * 当输入数组的数量比较大的时候，会出现数组溢出异常
     * @param num
     * @param n
     * @param f
     * @return
     */
    public boolean Jump(int []num,int n,int f){
        if(n==f){
            return true;
        }
        for(int i=1;i<=num[n];i++){
            if(Jump(num,n+i,f)){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Leetcode55 l55=new Leetcode55();
        int []num={2,3,1,1,4};
        int []nums={3,2,1,0,5};
        System.out.println(l55.canJum(nums));;
//        int []nums={3,2,1,0,4};
//        System.out.println(l55.canJump(nums));
//        System.out.println(l55.canJump(num));;
    }
}
