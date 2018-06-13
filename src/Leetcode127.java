import java.util.*;

public class Leetcode127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        wordSet.addAll(wordList);
        if (!wordSet.contains(endWord))
            return 0;
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);

        int dist = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (endSet.size() < beginSet.size()) {
                if (helper(endSet, beginSet, wordSet))
                    return dist + 1;
            } else {
                if (helper(beginSet, endSet, wordSet))
                    return dist + 1;
            }
            dist++;
        }
        return 0;
    }

    private boolean helper(Set<String> curr, Set<String> next, Set<String> wordSet) {
        Set<String> temp = new HashSet<>();
        for (String s : curr) {
            char[] charArray = s.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                char origin = charArray[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    charArray[i] = j;
                    String newStr = new String(charArray);
                    if (next.contains(newStr))
                        return true;
                    if (wordSet.contains(newStr)) {
                        temp.add(newStr);
                        wordSet.remove(newStr);
                    }
                }
                charArray[i] = origin;
            }
        }
        curr.clear();
        curr.addAll(temp);
        return false;
    }
    public static void main(String[] args) {
        Leetcode127 l127=new Leetcode127();
        String []words={"hot","cot","dog","lot","log","cog"};
        int res=l127.ladderLength("hit","cog",Arrays.asList(words));
        System.out.println(res);
    }
}
