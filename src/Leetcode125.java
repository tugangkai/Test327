public class Leetcode125 {
//    给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
//    说明：本题中，我们将空字符串定义为有效的回文串。
//
//    示例 1:
//
//    输入: "A man, a plan, a canal: Panama"
//    输出: true
//    示例 2:
//
//    输入: "race a car"
//    输出: false

    //回文串变种方式
    //定义状态转移方程
    //
    //
public boolean isPalindrome(String s){
    if(s==null)
        return false;
    int len=s.length();
    int start=0;
    int end=len-1;
    while(start<end){
        char beg='a';char ed= 'a';
        for(int i=start;i<=end;i++)
        {
            beg=s.charAt(i);
            if(beg>='A'&&beg<='Z'){
                beg=Character.toLowerCase(beg);
                start=i;
                break;
            }else if((beg>='a'&&beg<='z')||(beg>='0'&&beg<='9'))
            {
                start=i;
                break;
            }

        }
        for(int j=end;j>=start;j--){
            ed=s.charAt(j);
            if(ed>='A'&&ed<='Z'){
                ed=Character.toLowerCase(ed);
                end=j;
                break;
            }else if((ed>='a'&&ed<='z')||(ed>='0'&&ed<='9'))
            {
                end=j;
                break;
            }

        }
        if(start<end){
            if(beg!=ed&&check(beg)&&check(ed))
                return false;
            start++;
            end--;
        }








    }

    return true;


}
public boolean check(char c){
    if(c>='0'&&c<='9') return true;
    if(c>='A'&&c<='Z') return true;
    if(c>='a'&&c<='z') return true;
    return false;
}
//    public boolean isPalindrome(String s) {
//        if(s==null)
//            return false;
//        int len=s.length();
//        StringBuilder sb=new StringBuilder();
//        for(int i=0;i<len;i++){
//            char c=s.charAt(i);
//            if(c>='A'&&c<='Z'){
//                sb.append(Character.toLowerCase(c));
//            }else if((c>='a'&&c<='z')||c>='0'&&c<='9')
//                sb.append(c);
//        }
//        String str=sb.toString();
//        if(str.length()==0)
//            return true;
//      System.out.println(str);
//        len=str.length();
//        boolean [][]dp=new boolean[len][len];
//        for(int i=0;i<len;i++){
//            for(int j=0;j<=i;j++){
//                dp[i][j]=(str.charAt(i)==str.charAt(j))&&(i-j<2||dp[i-1][j+1]);
//
//
//
//            }
//
//        }
//        return dp[len-1][0];
//
//
//    }

    public static void main(String[] args) {
        String s="A man, a plan, a canal: Panama";
        Leetcode125 l125=new Leetcode125();
        boolean flag=l125.isPalindrome(s);
        System.out.println(flag);
//        char a='a';
//        System.out.println((int)a);
//        System.out.println((char)(a-32));
//        char A=(char)((int)a-32);
//        System.out.println(A);
    }
}
