import java.util.ArrayList;
import java.util.List;

public class Leetcode79 {
//    给定一个二维网格和一个单词，找出该单词是否存在于网格中。
//
//    单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
//
//    示例:
//
//    board =
//            [
//            ['A','B','C','E'],
//            ['S','F','C','S'],
//            ['A','D','E','E']
//            ]
//
//    给定 word = "ABCCED", 返回 true.
//    给定 word = "SEE", 返回 true.
//    给定 word = "ABCB", 返回 false.
//    board =
//            [
//            ['A','B','C','E'],
//            ['S','F','C','S'],
//            ['A','D','E','E']
//            ]

    public static void main(String[] args) {
        Leetcode79 l79=new Leetcode79();
        char [][]board={
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}
        };
        char [][]board1={
                {'a','b'},
                {'c','d'}
        };
        boolean res=l79.exist(board,"ABCESEEEFS");
        System.out.println(res);
    }
    public boolean exist(char[][] board, String word) {
        Direction[] d=new Direction[4];
        boolean [][]visit=new boolean[board.length][board[0].length];
        System.out.println(visit[0][0]);
        d[0]=new Direction(0,-1);
        d[1]=new Direction(1,0);
        d[2]=new Direction(0,1);
        d[3]=new Direction(-1,0);

        //find the first char
        char firstc=word.charAt(0);
        class Position{
            int x;
            int y;
        }
        List<Position> list=new ArrayList<Position>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==firstc){
                    Position p=new Position();
                    p.x=i;p.y=j;
                    list.add(p);
                }

            }
        }
        for(Position p:list){
            System.out.println(p.x+":"+p.y);
            boolean res=isexist(board,new boolean[board.length][board[0].length],d,p.x,p.y,word.substring(1));
           System.out.println(res);
            if(res)
                return true;

        }
        return false;





    }
    class Direction{
        int offsetX;
        int offsetY;

        public Direction(int offsetX, int offsetY) {
            this.offsetX = offsetX;
            this.offsetY = offsetY;
        }
    }

    public boolean isexist(char[][] borad,boolean visit[][],Direction []d,int x,int y,String word){
        if(word.equals("")){
            return true;
        }
        for(int i=0;i<4;i++){
            visit[x][y]=true;
            int tempx=x+d[i].offsetX;
            int tempy=y+d[i].offsetY;
            if(tempx<0||tempy<0||tempx>borad.length-1||tempy>borad[0].length-1||visit[tempx][tempy])
                continue;

            if(word.charAt(0)==borad[tempx][tempy])
            {
                String temp=word;
                word= word.substring(1);
                if(isexist(borad,visit,d,tempx,tempy,word)){
                    return true;
                }
                word=temp;
            }
        }
        visit[x][y]=false;
        return false;
    }

}

//    int m, n;
//    public boolean exist(char[][] board, String word) {
//        m = board.length;
//        int len = word.length();
//        if( len == 0 )
//            return true;
//        n = board[0].length;
//        char[] Word = word.toCharArray();
//
//        for( int i = 0;i<m;i++){
//            for( int j = 0;j<n;j++){
//                boolean isExist = backTrack(board, i, j, Word, 0);
//                if(isExist){
//                    return true;
//                }
//            }
//        }
//        return false;
//
//    }
//    public boolean backTrack(char[][] board,int i,int j, char[] Word, int index){
//        if(index == Word.length){
//            return true;
//        }
//        if(i < 0 || i >= m || j < 0 || j >= n || Word[index] != board[i][j]){
//            return false;
//        }
//        board[i][j] ^= 255;
//        boolean hasWord = (backTrack(board, i - 1, j, Word, index + 1) || backTrack(board, i, j - 1, Word, index + 1) || backTrack(board, i + 1, j, Word, index + 1) || backTrack(board, i, j + 1, Word, index + 1));
//        board[i][j] ^= 255;
//        return hasWord;
//    }