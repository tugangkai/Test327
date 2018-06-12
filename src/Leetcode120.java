import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null)
            return 0;
        int len=triangle.size();
        int []dp=new int[len];

        List<Integer> last=triangle.get(len-1);
        for(int i=0;i<len;i++){
            dp[i]=last.get(i);
        }


        for(int j=len-2;j>=0;j--){
            List<Integer> sub=triangle.get(j);
            for(int k=j,i=0;k>=0;k--,i++){
                int cur=dp[len-1-i]>dp[len-i-2]?dp[len-i-2]:dp[len-1-i];
                dp[len-1-i]=cur+sub.get(k);
            }
        }
        return dp[len-1];






    }

    public static void main(String[] args) {
        Leetcode120 l120=new Leetcode120();
        Integer s1[]={2};
        Integer s2[]={3,4};
        Integer s3[]={6,5,7};
        Integer s4[]={4,1,8,3};
        List<List<Integer>>list=new ArrayList<List<Integer>>();
        list.add(Arrays.asList(s1));
        list.add(Arrays.asList(s2));
        list.add(Arrays.asList(s3));
        list.add(Arrays.asList(s4));
       int res= l120.minimumTotal(list);
        System.out.println(res);


       // list.add(Arrays.asList(s1));



    }
}
