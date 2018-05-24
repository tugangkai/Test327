import java.util.ArrayList;
import java.util.List;

public class Leetcode51 {

//    n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
//
//
//    上图为 8 皇后问题的一种解法。
//
//    给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
//
//    每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
//
//    示例:
//
//    输入: 4
//    输出: [
//            [".Q..",  // 解法 1
//            "...Q",
//            "Q...",
//            "..Q."],
//
//            ["..Q.",  // 解法 2
//            "Q...",
//            "...Q",
//            ".Q.."]
//            ]
//    解释: 4 皇后问题存在两个不同的解法。
public List<List<String>> solveNQueens(int n) {

        List<List<String>> list=new ArrayList<List<String>>();

        int []s=new int[n];
        NQueen(list,s,0,n);


return list;

}


public void NQueen(List<List<String>> res,int []s,int n,int r){
    //到达终点站
    if(n>=r){

       List<String> list=new ArrayList<String>();
        for(int i=0;i<r;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<r;j++){
                /*list.add('.');add*/

                if(j==s[i])
                    sb.append("Q");
                else
                    sb.append(".");
            }
            list.add(sb.toString());
        }
        res.add(list);


    }else{
        while(s[n]<r){
            if(!isCollid(s,n)){
                NQueen(res,s,n+1,r);
            }
            s[n]++;
        }
       s[n]=0;
//        for(int i=0;i<r;i++){
//            if(!isCollid(s,n)){
//                NQueen(res,s,n+1,r);
//            }
//
//
//        }
//        while(isCollid(s,n)){
//            s[n]++;
//        }
//        if(s[n]==r){
//
//        }


    }



}
public boolean isCollid(int []s,int n){
    if(n==0)
        return false;
    for(int i=0;i<n;i++){
        if(s[i]==s[n]||Math.abs(s[n]-s[i])==Math.abs(n-i))
            return true;


    }
    return false;

}

    public static void main(String[] args) {
        Leetcode51 l51=new Leetcode51();
        List<List<String>> list=l51.solveNQueens(4);
        System.out.println(list);
    }

}
