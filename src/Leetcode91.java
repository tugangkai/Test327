public class Leetcode91 {

    public int numDecodings(String s){
        if(s==null||s.equals("")||s.charAt(0)=='0')
            return 0;
        if(s.length()==1)
            return 1;
        int len=s.length();
        int []dp=new int [len];
        char []cc=s.toCharArray();
        dp[0]=cc[0]>'0'?1:0;
        int k=cc[0]>'0'&&cc[1]>'0'?1:0;
        dp[1]=k+(cc[0]=='1'||cc[0]=='2'&&cc[1]<='6'?1:0);
        for(int i=2;i<len;i++){
            if(cc[i]>'0')
                dp[i]+=dp[i-1];
            if(cc[i-1]=='1'||cc[i-1]=='2'&&cc[i]<='6')
                dp[i]+=dp[i-2];

        }
        return dp[len-1];

    }

    public static void main(String[] args) {

        Leetcode91 l91=new Leetcode91();
        String s="112";
        int res=l91.numDecodings(s);
        System.out.println(res);
    }
}
