public class Leetcode87 {

//    //扰乱字符串
//    public boolean isScramble(String s1, String s2) {
//        if(s1.length()!=s2.length())
//            return false;
//        if(s1.equals(s2)){
//            return true;
//        }
//        int len=s1.length();
//        for(int i=1;i<len;i++){
//            if((isScramble(s1.substring(0,i),s2.substring(0,i))&&
//            isScramble(s1.substring(i,len),s2.substring(i,len)))||(isScramble(
//             s1.substring(0,i),s2.substring(len-i,len))&&
//            isScramble(s1.substring(i,len),s2.substring(0,len-i)))){
//                return true;
//
//            }
//
//        }
//        return false;
//
//    }
//动态规划解法

    /**
     * 令s[k][j][i]表示s1从k开始，s2从j开始，长度为i的两个字符串互为扰乱字符串
     * 那么从1-i-1分割两个字符串，s[k][j][i]为true的条件可能有两种
     * 一种是两个字符串分割点相同，他们两个的两个子串都相同
     * 第二种是两个字符串分割点不相同，但是分割出来的两个子串与对方的两个子串形成互补关系
     * 即s11=s22,s12=s21.
     * 则可以写出状态转移矩阵为:
     * s[k][j][i]=s[k][j][l]&&s[k+l][j+l][i-l] ||  s[k][j+l][i-l]&&s[k+i-l][j][l]
     * @param s1
     * @param s2
     * @return
     */
    public boolean isScramble(String s1, String s2) {
        if(s1.length()!=s2.length())
            return false;
        int len=s1.length();
        boolean dp[][][]=new boolean[len][len][len+1];
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(s1.charAt(i)==s2.charAt(j))
                    dp[i][j][1]=true;
            }

        }
        for(int i=2;i<len+1;i++){
            for(int k=0;k<len-i+1;k++){
                for(int j=0;j<len-i+1;j++){
                    for(int l=1;l<i;l++){

                        dp[k][j][i]|=(dp[k][j][l]&&dp[k+l][j+l][i-l] )|| (dp[k][j+i-l][l]&&dp[k+l][j][i-l]);
                    }



                }
            }
        }
        return dp[0][0][len];



    }
    public static void main(String[] args) {
        Leetcode87 l87=new Leetcode87();
        boolean res=l87.isScramble("abc","acb");
        System.out.println(res);


    }

}
