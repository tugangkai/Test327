import java.util.Arrays;

public class Leetcode135 {
//    老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
//
//    你需要按照以下要求，帮助老师给这些孩子分发糖果：
//
//    每个孩子至少分配到 1 个糖果。
//    相邻的孩子中，评分高的孩子必须获得更多的糖果。
//    那么这样下来，老师至少需要准备多少颗糖果呢？
//
//    示例 1:
//
//    输入: [1,0,2]
//    输出: 5
//    解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
//    示例 2:
//
//    输入: [1,2,2]
//    输出: 4
//    解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
//    第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
//    public int candy(int[] ratings) {
//        if(ratings==null)
//            return 0;
//        if(ratings.length==1)
//            return 1;
//        Arrays.sort(ratings);
//
//        int k=1;
//        int len=ratings.length;
//        int total=1;
//        for(int i=1;i<len;i++){
//            if(ratings[i]>ratings[i-1])
//            k++;
//            total+=k;
//        }
//        return total;
//    }
public int candy(int[] ratings) {
    int len=ratings.length;
    int a[]=new int[len];
    int sum=0;
    for(int i=0;i<len;i++){
        a[i]=1;
    }
    for(int i=1;i<len;i++){
        if(ratings[i]>ratings[i-1])
            a[i]=a[i-1]+1;
    }
    sum=a[len-1];
    for(int i=len-2;i>=0;i--){
        if(ratings[i]>ratings[i+1]&&a[i]<a[i+1]+1){
            a[i]=a[i+1]+1;
        }
        sum+=a[i];
    }
    return sum;















}
    public static void main(String[] args) {
        Leetcode135 l135=new Leetcode135();
        int []ratings={2,1,3};
        int res= l135.candy(ratings);
        System.out.println(res);
    }
}
