import java.util.ArrayList;
import java.util.List;

public class Leetcode89 {

//    格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
//
//    给定一个代表编码总位数的非负整数 n，打印格雷码序列。格雷码序列必须以 0 开头。
//
//    例如，给定 n = 2，返回 [0,1,3,2]。其格雷编码是：
//
//            00 - 0
//            01 - 1
//            11 - 3
//            10 - 2
//    说明:
//
//    对于给定的 n，其格雷编码的顺序并不唯一。
//
//    例如 [0,2,3,1] 也是一个有效的格雷编码顺序。

    /**
     * 格雷码的排列数i 第i个数的大小为: i^i>>1
     * @param n
     * @return
     */

    public List<Integer> grayCode(int n) {
        List<Integer> list=new ArrayList<Integer>();
        list.add(0);
        list.add(1);
        if(n==1)
            return  list;


        for(int i=1;i<n;i++){
            for(int j=list.size()-1;j>=0;j--){
                System.out.println("res"+(1<<i));
                list.add((1<<i)+list.get(j));
            }
        }
        return list;

    }

    public static void main(String[] args) {
        Leetcode89 l89=new Leetcode89();
        List<Integer> list=l89.grayCode(3);
        for(int i:list){
            System.out.println(i);
        }

    }
}
