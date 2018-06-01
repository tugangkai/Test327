import java.util.HashMap;
import java.util.Map;

public class Leetcode76 {
//    给定一个字符串 S 和一个字符串 T，请在 S 中找出包含 T 所有字母的最小子串。
//
//    示例：
//
//    输入: S = "ADOBECODEBANC", T = "ABC"
//    输出: "BANC"
//    说明：
//
//    如果 S 中不存这样的子串，则返回空字符串 ""。
//    如果 S 中存在这样的子串，我们保证它是唯一的答案。
public String minWindow(String s, String t) {
    //int st[]=new int[3];

    Map<Character,Integer> map=new HashMap<Character,Integer>();
    int minlen=Integer.MAX_VALUE;
    for(int i=0;i<t.length();i++){
        char c=t.charAt(i);
        if(map.containsKey(c)){
            map.put(c,map.get(c)+1);
        }else{
            map.put(c,1);
        }
    }
    int count=0;
    int tlen=t.length();
    int slen=s.length();
   char []ss=s.toCharArray();
    int start=0;
    int end=0;
    int mlen=map.size();
    String minLenStr="";
     while(end<slen) {
       char cur = s.charAt(end);
       if (t.contains(cur + "")) {
           int res = map.get(cur) - 1;
           map.put(cur, res);
           if (res == 0) {
               count++;
           }
           if (count == mlen) {
               //更新start到倒数第二个包含t中字符的位置

               boolean flag = false;
               while ((!(flag = map.containsKey(ss[start]))) || map.get(ss[start]) < 0) {
                   if (flag) {
                       map.put(ss[start], map.get(ss[start]) + 1);
                   }
                   start++;
               }
               System.out.println(s.substring(start, end + 1));
               if (end - start + 1 <= minlen) {
                   minlen=end - start + 1;
                   minLenStr = s.substring(start, end + 1);
               }
               if(end==slen)
                   break;
               end++;

           } else {
               end++;
           }


       }else{
           end++;
       }
   }
   return minLenStr;
   }


    public static void main(String[] args) {
        Leetcode76 l76=new Leetcode76();
        String res=l76.minWindow("cabwefgewcwaefgcf",
                "cae");
        System.out.println(res);
    }


    //高手的程序，简练通达。
//
//    public String minWindow(String s, String t) {
//        if(s.length() < t.length() || s.length() == 0 || s == null || t.length() == 0 || t == null){
//            return "";
//        }else{
//            int length = Integer.MAX_VALUE;
//            int[] map = new int[256];
//            int start = 0,end = 0;
//            int found = t.length();
//            int head = 0;
//            for(int i = 0;i<t.length();i++){
//                map[t.charAt(i)]++;
//            }
//            while(end < s.length()){
//                if(map[s.charAt(end++)]-- > 0){
//                    found--;
//                }
//                while(found == 0){
//                    if(end - start < length){
//                        length = end - (head = start);
//                    }
//                    if(map[s.charAt(start++)]++ == 0){
//                        found++;
//                    }
//                }
//            }
//            return length == Integer.MAX_VALUE ? "" : s.substring(head, head + length);
//        }
//    }
//

}
