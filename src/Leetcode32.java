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

    public static void main(String[] args) {
        Leetcode32 l32=new Leetcode32();
        int s= l32.longestValidParentheses("()(()");
        System.out.println(s);
    }
}
