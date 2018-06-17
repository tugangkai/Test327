import java.util.*;

public class Leetcode140 {

//    给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
//
//    说明：
//
//    分隔时可以重复使用字典中的单词。
//    你可以假设字典中没有重复的单词。
//    示例 1：
//
//    输入:
//    s = "catsanddog"
//    wordDict = ["cat", "cats", "and", "sand", "dog"]
//    输出:
//            [
//            "cats and dog",
//            "cat sand dog"
//            ]
//    示例 2：
//
//    输入:
//    s = "pineapplepenapple"
//    wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
//    输出:
//            [
//            "pine apple pen apple",
//            "pineapple pen apple",
//            "pine applepen apple"
//            ]
//    解释: 注意你可以重复使用字典中的单词。
//    示例 3：
//
//    输入:
//    s = "catsandog"
//    wordDict = ["cats", "dog", "sand", "and", "cat"]
//    输出:
//            []
public static void main(String[] args) {
    Leetcode140 l140=new Leetcode140();
    String s="catsanddog";
    String []wordDict={"cat", "cats", "and", "sand", "dog"};
    List<String> words= Arrays.asList(wordDict);
    List<String> res=l140.wordBreak(s,words);
    for(String str:res){
        System.out.println(str);
    }
}
   // Boolean dp[];
//public List<String> wordBreak(String s, List<String> wordDict) {
// //  dp=new Boolean[2*s.length()];
//    List<String> res=new ArrayList<String>();
//    wordBreak(s,wordDict,res,"");
//    return res;
//
//}
//Set<String> set=new HashSet<String>();
//public void wordBreak(String s,List<String> wordDict,List<String> res,String op){
//    if(s.length()==0){
//       String str= op.substring(0,op.length()-1);
//       res.add(str);
//       return;
//    }
//    for(String str:wordDict){
//        if(s.startsWith(str)){
//                if(!set.contains(op+str+" ")){
//                    String tmp=op;
//                    wordBreak(s.substring(str.length(),s.length()),wordDict,res,op+str+" ");
//                    op=tmp;
//                }
//
//
//        }
//
//    }

//
//}
public List<String> wordBreak(String s, List<String> wordDict) {
    if (s == null || s.length() == 0 || wordDict == null) {
        return null;
    }
    List<String> ret = new ArrayList<String>();
    List<String> path = new ArrayList<String>();
    int len = s.length();
    // i: 表示从i索引开始的字串可以word break.
    boolean[] D = new boolean[len + 1];
    D[len] = true;
    for (int i = len - 1; i >= 0; i--) {
        for (int j = i; j <= len - 1; j++) {
            // 左边从i 到 j
            D[i] = false;
            if (D[j + 1] && wordDict.contains(s.substring(i, j + 1))) {
                D[i] = true;
                break;
            }
        }
    }

    dfs4(s, wordDict, path, ret, 0, D);

    return ret;
}
    public static void dfs4(String s, List<String> wordDict, List<String> path, List<String> ret, int index,boolean canBreak[]) {
        int len = s.length();
        if (index == len) {
            // 结束了。index到了末尾
            StringBuilder sb = new StringBuilder();
            for (String str : path) {
                sb.append(str);
                sb.append(" ");
            }
            // remove the last " "
            sb.deleteCharAt(sb.length() - 1);
            ret.add(sb.toString());
            return;
        }

        // if can't break, we exit directly.
        if (!canBreak[index]) {
            return;
        }

//        for(String str:wordDict){
//            if(s.startsWith(str)){
//                path.add(str);
//                dfs4(s.substring(str.length()),wordDict,path,ret,i+str);
//
//            }
//
//        }
        for (int i = index; i < len; i++) {
            // 注意这些索引的取值。左字符串的长度从0到len
            String left = s.substring(index, i + 1);
//            if (!wordDict.contains(left)) {
//                // 如果左字符串不在字典中，不需要继续递归
//                continue;
//            }

            // if can't find any solution, return false, other set it
            // to be true;
            if (wordDict.contains(left)) {
                path.add(left);
                dfs4(s, wordDict, path, ret, i + 1, canBreak);
                path.remove(path.size() - 1);
            }

        }

    }



//    public List<String> wordBreak(String s, List<String> wordDict) {
//        return DFS(s,wordDict,new HashMap<String,ArrayList<String>>());
//    }
//    public ArrayList<String> DFS(String s,List<String> wordDict,HashMap<String,ArrayList<String>> map){
//        if(map.containsKey(s))
//            return map.get(s);
//        ArrayList<String> res=new ArrayList<String>();
//        if(s.length()==0){
//            res.add("");
//            return res;
//        }
//        for(String substr:wordDict){
//            if(s.startsWith(substr)){
//                for(String str:DFS(s.substring(substr.length()),wordDict,map))
//                    res.add(substr+(str==""?"":" ")+str);
//            }
//        }
//        map.put(s,res);
//        return res;
//    }
}
