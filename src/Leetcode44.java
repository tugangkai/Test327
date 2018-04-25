public class Leetcode44 {
//    给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
//
//            '?' 可以匹配任何单个字符。
//            '*' 可以匹配任意字符串（包括空字符串）。
//
//    两个字符串完全匹配才算匹配成功。
//
//    说明:
//
//    s 可能为空，且只包含从 a-z 的小写字母。
//    p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
//
//    示例 1:
//
//    输入:
//    s = "aa"
//    p = "a"
//    输出: false
//    解释: "a" 无法匹配 "aa" 整个字符串。
//
//    示例 2:
//
//    输入:
//    s = "aa"
//    p = "*"
//    输出: true
//    解释: '*' 可以匹配任意字符串。
//
//    示例 3:
//
//    输入:
//    s = "cb"
//    p = "?a"
//    输出: false
//    解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
//
//    示例 4:
//
//    输入:
//    s = "adceb"
//    p = "*a*b"
//    输出: true
//    解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
//
//    示例 5:
//
//    输入:
//    s = "acdcb"
//    p = "a*c?b"
//    输入: false

    public boolean isMatch(String s,String p){
        int len=s.length();
        int plen=p.length();
        int i=0,ii=-1,j=0,jj=-1;
        char []ss=s.toCharArray();
        char []pp=p.toCharArray();
        while(i<len){
//            if(j==p.length())
//                return false;
           
          
            if(j<plen&&(ss[i]==pp[j]||pp[j]=='?'))
            {
                i++;j++;

            }else if(j<plen&&pp[j]=='*'){
                ii=i;jj=j++;

            }else if(jj!=-1){
                i=++ii;j=jj+1;
            }else{
                return false;
            }






        }
        System.out.println(j);
        if(i<len)
            return false;
        while(j<plen&&pp[j]=='*')
            j++;
        if(j==p.length())
            return true;
        return false;




    }


//    public boolean isMatch(String s, String p) {
//        int i = 0,j = 0,is=-1,ip=-1;
//        char[] ss = s.toCharArray();
//        char[] pp = p.toCharArray();
//        while (i<ss.length){
//            if (j<pp.length&&(ss[i]==pp[j]||pp[j]=='?')){
//                i++;j++;
//            }else if (j<pp.length&&pp[j]=='*'){
//                ip = j++;
//                is = i;
//            }else if (ip!=-1){
//                j = ip+1;
//                i = ++is;
//            }else return false;
//        }
//        if (i<ss.length){
//            return false;
//        }
//        while (j<pp.length&&pp[j]=='*') j++;
//
//        return j==p.length();
//    }

//    public boolean isMatch(String s, String p,int cur,int i) {
//
//        int slen=s.length();
//        int plen=p.length();
//        boolean flag=true;
//        for(;i<plen;i++){
////            if(cur==s.length())
////                return false;
//            char ch=p.charAt(i);
//            switch(ch){
//                case '?':
//                    cur++;
//                    break;
//                case '*':
//                    for(int j=0;cur+j<=slen-1;j++) {
//                        if (isMatch(s, p, cur + j, i+1)) {
//                            return true;
//                        }
//                    }
//                    return false;
//
//                default:
//
//                    if(cur>=slen)
//                        return false;
//                    if(s.charAt(cur++)==p.charAt(i))
//                        continue;
//                    else {
//                        flag = false;
//                        return false;
//                    }
//
//            }
//
//
//        }
//        System.out.println(cur);
//        if(i-1>=0&&p.charAt(i-1)!='*')
//            flag=false;
//
//        return flag;
//
//    }
        //字符串p的字符分为三种情况：
    /**
     *
     * 第一种是？，第二种是*，第三种是普通字符
     */
    public static void main(String[] args) {
        Leetcode44 l44=new Leetcode44();
        boolean flag=l44.isMatch("aa","*");
        System.out.println(flag);
    }

}
