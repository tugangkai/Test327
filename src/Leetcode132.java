public class Leetcode132 {
//    给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
//
//    返回符合要求的最少分割次数。
//
//    示例:
//
//    输入: "aab"
//    输出: 1
//    解释: 进行一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
public static void main(String[] args) {
    Leetcode132 l132=new Leetcode132();
   int res=   l132.minCut("");
    System.out.println(res);
}
    public int minCut(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        int len=s.length();
        boolean dp[][]=new boolean[len][len];
        int []cut=new int[len+1];
        for(int i=len-1;i>=0;i--){
            cut[i]=Integer.MAX_VALUE;
            for(int j=i;j<len;j++){
                dp[i][j]=(s.charAt(i)==s.charAt(j))&&(j-i<2||dp[i+1][j-1]);
                if(dp[i][j]){
                    cut[i]=Math.min(cut[i],cut[j+1]+1);

                }


            }
        }


        return cut[0]-1;



    }

}
