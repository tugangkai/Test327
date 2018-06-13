import java.util.*;

public class Leetcode126 {
//    给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
//
//    每次转换只能改变一个字母。
//    转换过程中的中间单词必须是字典中的单词。
//    说明:
//
//    如果不存在这样的转换序列，返回一个空列表。
//    所有单词具有相同的长度。
//    所有单词只由小写字母组成。
//    字典中不存在重复的单词。
//    你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
//    示例 1:
public static void main(String[] args) {
    Leetcode126 l126=new Leetcode126();
    String []words={"hot","dot","dog","lot","log","cog"};
    List<String> wordList=Arrays.asList(words);
    List<List<String>> list=l126.findLadders("hit","cog",wordList);
    for(List<String> sub:list){
        for(String word:sub){
            System.out.print(word+"\t");
        }
        System.out.println();
    }
}
public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
   int len=wordList.size();
    List<List<String>> result=new ArrayList<List<String>>();
    Set<String> current=new HashSet<String>();
    Set<String> next=new HashSet<String>();
    Set<String> unvisited=new HashSet<String>(wordList);
    Map<String,Set<String>> map=new HashMap<String,Set<String>>();
    current.add(beginWord);
    while(!current.contains(endWord)&&unvisited.size()>0) {
        for (String word : current) {
            for (int i = 0; i < len; i++) {
                String cur = wordList.get(i);
                if (unvisited.contains(cur) && isOneDif(word, cur)) {
                    next.add(cur);
                    if (map.containsKey(cur)) {
                        map.get(cur).add(word);
                    } else {
                        Set<String> set = new HashSet<String>();
                        set.add(word);
                        map.put(cur, set);
                    }
                }
            }

        }
        unvisited.removeAll(next);
        current = new HashSet(next);
        next.clear();
    }
    findPath(map,endWord,beginWord,new ArrayList<String>(),result);
    return result;
}
public void findPath(Map<String,Set<String>>map, String beginWord,String endWord,List<String> sub,List<List<String>> list){
    sub.add(beginWord);
    if(beginWord.equals(endWord)){
        List<String> cur=new ArrayList<String>(sub);
        Collections.reverse(cur);
        list.add(cur);
        return ;
    }
   Set<String> set= map.get(beginWord);
   for(String s:set){
       findPath(map,s,endWord,sub,list);
       sub.remove(sub.size()-1);
   }
   return;
}

public boolean isOneDif(String a,String b){
    int len=a.length();
    int count=0;

    for(int i=0;i<len;i++){
        if(a.charAt(i)!=b.charAt(i))
            count++;


    }
    if(count==1)
        return true;
    return false;

}


}
