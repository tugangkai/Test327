import java.util.ArrayList;
import java.util.List;

public class Leetcode77 {
//    给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

//    示例:
//
//    输入: n = 4, k = 2
//    输出:
//            [
//            [2,4],
//            [3,4],
//            [2,3],
//            [1,2],
//            [1,3],
//            [1,4],
//            ]
public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> list=new ArrayList<List<Integer>>();
    List<Integer> sub=new ArrayList<Integer>();
    insert(list,sub,n,k,1);
    return list;

}
public void insert(List<List<Integer>> list,List<Integer> sub,int n,int k,int start) {
    if (sub.size() == k) {
        list.add(new ArrayList<Integer>(sub));
    } else {
        for (int i = start; i <= n; i++) {
            if (!sub.contains(i)) {
                sub.add(i);
                start=i;
                insert(list, sub, n, k,start+1);
                sub.remove(sub.size()-1);
            }

        }
    }
}



    public static void main(String[] args) {
        Leetcode77 l77=new Leetcode77();
        List<List<Integer>> res=l77.combine(4,2);
        for(List<Integer> sub:res){
            for(int i:sub){
                System.out.print(i+"\t");
            }
            System.out.println();
        }

    }

//    class Solution {
//        public List<List<Integer>> combine(int n, int k) {
//            List<List<Integer>>combines=new ArrayList<>();
//            if(n<=0||k<=0)return combines;
//            combines=combineRecursive(n,k,1,new ArrayList<>(),combines);
//            return combines;
//        }
//
//        public List<List<Integer>>combineRecursive(int n,int k,int start,List<Integer>comb,List<List<Integer>>combs){
//            if(k==0){
//                combs.add(new ArrayList(comb));
//                return combs;
//            }
//
//            for(int i=start;i<=n+1-k;i++){
//                comb.add(i);
//                combs=combineRecursive(n,k-1,i+1,comb,combs);
//                comb.remove(comb.size()-1); //回溯
//            }
//            return combs;
//        }
//    }

}
