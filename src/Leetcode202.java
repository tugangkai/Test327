import java.util.HashSet;
import java.util.Set;

public class Leetcode202 {
//    编写一个算法来判断一个数是不是“快乐数”。
//
//    一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
//
//    示例:
//
//    输入: 19
//    输出: true
//    解释:
//            12 + 92 = 82
//            82 + 22 = 68
//            62 + 82 = 100
//            12 + 02 + 02 = 1
//
    public boolean isHappy(int n) {
        Set<Integer> set=new HashSet<Integer>();
        while(true){
            int sum=0;

            while(n!=0){
                int end=n%10;
                sum+=end*end;
                n=n/10;
            }
            n=sum;

            if(set.contains(n))
                break;
            else{
                set.add(n);
            }
        }

        return n==1;


    }

}
