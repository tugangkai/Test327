import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode139_1 {
    public static void main(String[] args) {
        Leetcode139_1 l11=new Leetcode139_1();
        String s="pineapplepenapple";
        List<String> list=new ArrayList<String>();
        String []wordDict={"apple", "pen", "applepen", "pine", "pineapple"};
        list=Arrays.asList(wordDict);
        boolean res=l11.wordBreak1(s,list);
        System.out.println(res);
    }
//    public  boolean wordBreak(String s, List<String> wordDict) {
//
//        int len=s.length();
//        boolean dp[]=new boolean[len+1];
//        dp[0]=true;
//        for(int i=1;i<=len;i++){
//            for(int j=i-1;j>=0;j--){
//                dp[i]=wordDict.contains(s.substring(j,i))&&dp[j];
//                if(dp[i]){
//                    break;
//                }
//
//
//
//
//            }
//
//
//        }
//
//        return dp[len];
//
//
//    }


    Boolean dp[];

    /**
     * 精妙之处在于，利用数组来剪纸，对于已经回溯回来的字符串
     * @param s
     * @param wordDict
     * @return
     */
    public void func(List<String>path,List<String>res,String s, List<String> wordDict) {
        if(s.length() == 0) {
            StringBuilder sb=new StringBuilder();
            for(String str:path){
                sb.append(str).append("\t");

            }
            res.add(sb.toString());
            return ;
        }
        for(String str : wordDict) {

            if(s.startsWith(str)) {
                path.add(str);
                if(dp[str.length()] == null) {

                   func(path,res,s.substring(str.length()), wordDict);
                   // if(dp[str.length()]) {return true;}
                }
                path.remove(path.size()-1);
            }
        }
        return ;
    }

    /*查找字典组成的单词*/
    public boolean wordBreak1(String s, List<String> wordDict) {
        dp = new Boolean[s.length() + 1];
        List<String> path=new ArrayList();
        List<String> res=new ArrayList();


         func(path,res,s, wordDict);
        for(String str:res){
            System.out.println(str);
        }
        return true;
    }

}
