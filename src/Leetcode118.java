import java.util.ArrayList;
import java.util.List;

public class Leetcode118 {
//    给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
//
//
//
//    在杨辉三角中，每个数是它左上方和右上方的数的和。
//
//    示例:
//
//    输入: 5
//    输出:
//            [
//            [1],
//            [1,1],
//            [1,2,1],
//            [1,3,3,1],
//            [1,4,6,4,1]
//            ]

    public List<List<Integer>> generate(int numRows) {
            if(numRows<=0)
                return null;
            List<List<Integer>> list=new ArrayList<List<Integer>>();
            List<Integer> h1=new ArrayList<Integer>();
            h1.add(1);
            list.add(h1);
            if(numRows==1)
                return list;
            List<Integer> h2=new ArrayList<Integer>();
            h2.add(1);h2.add(1);
            list.add(h2);
            if(numRows==2)
                return list;
            for(int i=3;i<=numRows;i++){
                List<Integer> sub=new ArrayList<Integer>();
                sub.add(1);
                for(int j=1;j<i-1;j++){
                    int cur=list.get(i-2).get(j-1)+list.get(i-2).get(j);
                    sub.add(cur);
                }
                sub.add(1);
                list.add(sub);
            }

            return list;




    }

//    public List<List<Integer>> generate(int numRows) {
//        List<List<Integer>> result = new ArrayList<List<Integer>>(numRows);
//        for (int i = 0; i < numRows; i++) {
//            List<Integer> thisRow = new ArrayList<Integer>(i);
//            thisRow.add(1);
//            int temp = 1;
//            int row = i;
//            for (int j = 1; j <= i; j++) {
//                temp = temp * row-- / j ;
//                thisRow.add(temp);
//            }
//            result.add(thisRow);
//        }
//        return result;
//    }


}
