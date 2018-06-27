public class Leetcode201 {
//    给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
//
//    示例 1:
//
//    输入: [5,7]
//    输出: 4
//    示例 2:
//
//    输入: [0,1]
//    输出: 0

    public static void main(String[] args) {
        Leetcode201 l201=new Leetcode201();
       // int res=l201.highbit(5);
      //  System.out.println(res);
    }
//    public int highbit(int n){
//        for(int i=31;i>=0;i--){
//            int m=(n>>i)&1;
//            if(m==1){
//                return m<<i;
//            }
//        }
//        return 0;
//    }


    public int rangeBitwiseAnd(int m, int n) {
       int count=0;
        while(m!=n){
            m>>=1;
            n>>=1;
            count++;

        }
        return m<<count;
    }


}
