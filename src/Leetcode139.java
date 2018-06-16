import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode139 {

//    给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
//
//    说明：
//
//    拆分时可以重复使用字典中的单词。
//    你可以假设字典中没有重复的单词。
//    示例 1：
//
//    输入: s = "leetcode", wordDict = ["leet", "code"]
//    输出: true
//    解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
//    示例 2：
//
//    输入: s = "applepenapple", wordDict = ["apple", "pen"]
//    输出: true
//    解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//    注意你可以重复使用字典中的单词。
//    示例 3：
//f
//    输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//    输出: false
//    public boolean wordBreak(String s,List<String>wordDict)
//    {
//        int len=s.length();
//        boolean dp[][]=new boolean[len][len];
//        //dp[0][0]=true;
//
//        for(int i=0;i<len;i++){
//            for(int j=0;j<=i;j++){
//
//                String substr=s.substring(j,i+1);
//                if(i==3&&j==0)
//                    System.out.println(substr);
//                for(String str:wordDict){
//                    if(substr.equals(str)){
//                        dp[i][j]=true;
//                     //dp[i][j]=true&(j>1||dp[j-1][1]);
//                        if(dp[i][0]==false){
//                            dp[i][0]=j==0||dp[j-1][0];
//                        }
//
//                    }
//                }
//
//
//            }
//
//
//        }
//
//        return dp[len-1][0];
//
//
//    }




//    public boolean wordBreak(String s, List<String> wordDict) {
//        if(s.length()==0)
//            return true;
//        boolean flag=false;
//        for(String word:wordDict){
//            int index= s.indexOf(word);
//            if(index!=-1){
//               if(wordBreak(s.substring(0,index),wordDict)&&wordBreak(s.substring(index+word.length()),wordDict))
//               {
//                   flag=true;
//               }
//            }
//        }
//        if(flag)
//            return true;
//        else
//        return false;
//    }


    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int maxLength = 0;
        for (String word : wordDict) {
            maxLength = Math.max(word.length(), maxLength);
        }
        boolean[] canDivide = new boolean[s.length() + 1];
        canDivide[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            canDivide[i] = false;
            for (int lastWordLength = 1; lastWordLength <= maxLength && lastWordLength <= i; lastWordLength++) {
                if (!canDivide[i - lastWordLength]) {
                    continue;
                }
                String word = s.substring(i - lastWordLength, i);
                if (dict.contains(word)) {
                    canDivide[i] = true;
                    break;
                }
            }
        }
        return canDivide[s.length()];
    }


    Boolean dp[] ;

    /**
     * 精妙之处在于，利用数组来剪纸，对于已经回溯回来的字符串
     * @param s
     * @param wordDict
     * @return
     */
    public boolean func(String s, List<String> wordDict) {
        if(s.length() == 0) {
            return true;
        }
        for(String str : wordDict) {
            if(s.endsWith(str)) {
                if(dp[s.length() - str.length()] == null) {
                    dp[s.length() - str.length()] = func(s.substring(0, s.length() - str.length()), wordDict);
                    if(dp[s.length() - str.length()]) {return true;}
                }
            }
        }
        return false;
    }

    /*查找字典组成的单词*/
    public boolean wordBreak1(String s, List<String> wordDict) {
        dp = new Boolean[s.length() + 1];
        return func(s, wordDict);
    }



    public static void main(String[] args) {
            String s="baaaaaa";
            String []wordDict={"aaaa","aaa"};
            List<String> list= Arrays.asList(wordDict);
        Leetcode139 l139=new Leetcode139();
        boolean res=l139.wordBreak1(s,list);
        System.out.println(res);
 //       System.out.println(s.indexOf(word));
    }
}
