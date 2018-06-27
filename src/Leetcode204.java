public class Leetcode204 {
//    统计所有小于非负整数 n 的质数的数量。
//
//    示例:
//
//    输入: 10
//    输出: 4
//    解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
public static void main(String[] args) {
    Leetcode204 l204=new Leetcode204();
    int res=l204.countPrimes(10);
    System.out.println(res);
}
    public int countPrimes(int n){
        boolean []a=new boolean[n];
        for(int i=2;i*i<n;i++) {
            if (!a[i]) {
                for (int j = i; j * i < n; j++) {
                    a[i * j] = true;
                }
            }
        }
        int c=0;
        for(int i=2;i<n;i++){
            if(!a[i])
                c++;
        }
        return c;
    }



}
