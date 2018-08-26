import java.util.*;

 class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<String>();
        if(board==null || words==null || board.length==0 || words.length==0) return new ArrayList<String>(res);
        boolean[][] visited = new boolean[board.length][board[0].length];

        Trie trie = new Trie();
        for(String word : words) {
            trie.insert(word);
        }

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                search(board, visited, trie, i, j, new StringBuilder(), res);
            }
        }
        return new ArrayList<String>(res);
    }

    private void search(char[][] board,boolean[][] visited,Trie trie,int i,int j, StringBuilder sb, Set<String> res) {
        if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1 || visited[i][j])  return;
        sb.append(board[i][j]);
        String s = sb.toString();
        visited[i][j] = true;
        if(trie.startsWith(s)) {
            if(trie.search(s)) res.add(s);

            search(board, visited, trie, i-1, j, sb, res);
            search(board, visited, trie, i+1, j, sb, res);
            search(board, visited, trie, i, j-1, sb, res);
            search(board, visited, trie, i, j+1, sb, res);
        }
        sb.deleteCharAt(sb.length() - 1);
        visited[i][j] = false;
    }
}


public class Leetcode212 {
}


//
//class Solution {
//
//    public List<String> findWords(char[][] board, String[] words) {
//        // 对给定的单词构造一个前缀树
//        PrefixTreeNode root = new PrefixTreeNode();
//        for (String word : words) {
//            root.insert(word);
//        }
//        List<String> result = new ArrayList<>();
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                dfs(board, i, j, root, result);
//            }
//        }
//        return result;
//    }
//
//    class PrefixTreeNode {
//
//        /** 保存插入的字符串 */
//        String word = "";
//
//        /**
//         * 对于每一个节点来说，其可以与a-z中所有的其他节点相连，因此用数组来保存节点与其他节点间的联系
//         * 如对于wo单词来说，假设树根节点为root。'w' - 'a' = 22，root节点对应的数组root.links[22] = null
//         * 此时新建一个节点表示root节点和w所对应的节点相连。'o' - 'a' = 14，对于w所对应的节点有w.links[14] = null
//         * 同样新建一个节点来表示节点'w'和节点'o'相连
//         */
//        PrefixTreeNode[] links = new PrefixTreeNode[26];
//
//        /** 实现向前缀树中插入一个单词 */
//        public void insert(String s) {
//            char[] chs = s.toCharArray();
//            PrefixTreeNode curNode = this;
//            // 遍历当前单词中的每一个字符
//            for (int i = 0; i < chs.length; i++) {
//                // 判断当前字符对应的节点是否在curNode的索引数组中，不存在则加入该字符对应节点
//                int index = chs[i] - 'a';
//                if (curNode.links[index] == null) {
//                    curNode.links[index] = new PrefixTreeNode();
//                }
//                // 判断下一个字符
//                curNode = curNode.links[index];
//            }
//            // 当前节点对应的单词为s
//            curNode.word = s;
//        }
//    }
//
//    /**
//     * 利用dfs进行深度搜索
//     *
//     * @param board  保存所有字符的二维数组
//     * @param row    当前字符的行号
//     * @param column 当前字符的列号
//     * @param node   前缀树中节点
//     * @param result 最终结果
//     */
//    private void dfs(char[][] board, int row, int column, PrefixTreeNode node, List<String> result) {
//        // 判断当前下标是否合法
//        boolean validIndex = row >= 0 && column >= 0
//                && row < board.length && column < board[0].length;
//        if (!validIndex) {
//            return;
//        }
//
//        // 如果当前遍历的字符为'#'，则说明该字符已经被使用过，返回。
//        // 如果该字符在给定的所有单词构造的前缀树中不存在，则说明该字符不是任何单词的前缀，直接返回
//        char c = board[row][column];
//        if (c == '#' || node.links[c - 'a'] == null) {
//            return;
//        }
//
//        // 继续遍历前缀树的下一个节点。如果遍历到前缀树中一个节点对应的单词不为空，则说明该单词可以在
//        // 字符数组中查到，此时将该单词加入到结果中。为了避免重复，查到单词后，将节点中的单词置为空
//        node = node.links[c - 'a'];
//        if (node.word.length() != 0) {
//            result.add(node.word);
//            node.word = "";
//        }
//
//        // 标记字符被使用过
//        board[row][column] = '#';
//
//        // 进行上下左右搜索
//        dfs(board, row - 1, column, node, result);
//        dfs(board, row + 1, column, node, result);
//        dfs(board, row, column - 1, node, result);
//        dfs(board, row, column + 1, node, result);
//
//        // 还原字符
//        board[row][column] = c;
//    }
//}