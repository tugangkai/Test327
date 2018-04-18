import java.util.LinkedList;

public class Leetcode32 {


    public int longestValidParentheses(String s) {
        int len=s.length();
        LinkedList<Integer> list=new LinkedList<Integer>();
        for(int i=0;i<len;i++){
            char c=s.charAt(i);
            if(c==')'){
                if(!list.isEmpty()&&s.charAt(list.peek())=='('){
                    list.pop();
                    continue;
                }
            }
            list.push(i);
        }
        int max=0;
        int cur=0;
        int nextcur=len-1;
        while(!list.isEmpty()){
            cur=list.pop();
            int tmp=nextcur-cur-1;
            max=tmp>max?tmp:max;
            nextcur=cur;




        }
        System.out.println(max);
        return Math.max(nextcur,max);

    }

    /**
     *
     * 动态规划解法
     * @param s
     * @return
     */
    public int getLongestBracket(String s){
        int len=s.length();
        int dp[]=new int[len];
        int max=0;
        for(int i=1;i<len;i++){
            char c=s.charAt(i);
          if(c==')'&&i-dp[i-1]-1>=0&&s.charAt(i-dp[i-1]-1)=='('){
              dp[i]=dp[i-1]+2+(i-dp[i-1]-2>=0?dp[i-dp[i-1]-2]:0);
              max=Math.max(dp[i],max);

          }


        }

        return max;


    }




    public static void main(String[] args) {
        Leetcode32 l32=new Leetcode32();
        int s= l32.longestValidParentheses("()(()");
        System.out.println(s);
        int t=l32.getLongestBracket("()(()");
        System.out.println(t);
    }
}
