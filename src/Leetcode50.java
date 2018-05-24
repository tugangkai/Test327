public class Leetcode50 {
//    实现 pow(x, n) ，即计算 x 的 n 次幂函数。
//
//    示例 1:
//
//    输入: 2.00000, 10
//    输出: 1024.00000
//    示例 2:
//
//    输入: 2.10000, 3
//    输出: 9.26100
//    示例 3:
//
//    输入: 2.00000, -2
//    输出: 0.25000
//    解释: 2-2 = 1/22 = 1/4 = 0.25
//    说明:
//
//            -100.0 < x < 100.0
//    n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
public double myPow(double x, int n) {
    if(n==0) return 1;
    if(n==1) return x;
    int t=n/2;
    if(n<0){
        t=-t;
        x=1/x;
    }
    double res=myPow(x,n/2);
    if(n%2==0)
        return res*res;
    else
    return res*res*x;
}

    public static void main(String[] args) {
    Leetcode50 l50=new Leetcode50();
    double res=l50.myPow(000.2000,3);
        System.out.println(res);

//        double x=0002.0000;
//        System.out.println();
//        System.out.println(x+"");
//        System.out.println(Math.pow(x,3));
    }



//    class Solution {
//        /**
//         *  example: 2^10
//         *
//         *  (10)10 = (1010)2
//         *  2^10 = 2^(2^0 * 0 + 2^1 * 1 + 2^2 * 0 + 2^3 * 1)
//         *       = 2^(0 + 2 + 0 + 8)
//         *       = 2^10
//         *
//         * @param x base
//         * @param n pow
//         * @return result
//         */
//        public double myPow(double x, int n) {
//            double pow = 1.0;
//            x = n >= 0 ? x : 1 / x;
//            n = (n >= 0) ? n : n * -1;
//            while (n != 0) {
//                if ((n&1) != 0) { // n % 2 != 0
//                    pow *= x;
//                }
//                x *= x;
//                n /= 2; // n /= 2
//            }
//            return pow;
//        }
//    }
}
