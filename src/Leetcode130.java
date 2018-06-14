import java.util.LinkedList;

public class Leetcode130 {

//    给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
//
//    找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
//
//    示例:
//
//    X X X X
//    X O O X
//    X X O X
//    X O X X
//    运行你的函数后，矩阵变为：
//
//    X X X X
//    X X X X
//    X X X X
//    X O X X
//    解释:
//
//    被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
//    任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
//    如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
class Position{
        int x;
        int y;
        public Position(int x,int y){
            this.x=x;
            this.y=y;
        }
}
public void solve(char[][] board) {
    int  row=board.length;
    int col=board[0].length;
    boolean [][]flag=new boolean[row][col];
    boolean [][]visited=new boolean[row][col];
    //上下两条边
    LinkedList<Position> queue=new LinkedList<Position>();
    for(int i=0;i<col;i++)
    {
        if(!visited[0][i]&&board[0][i]=='O'){
            visited[0][i]=true;
            flag[0][i]=true;
            operate(0,i,queue,visited,flag,board,row,col);
        }
//        System.out.println(!visited[row-1][i]);
//        System.out.println(board[row-1][i]=='O');
        if(!visited[row-1][i]&&board[row-1][i]=='O')
        {
            visited[row-1][i]=true;
            flag[row-1][i]=true;
            operate(row-1,i,queue,visited,flag,board,row,col);
        }

    }
    for(int j=0;j<row;j++){
        if(!visited[j][0]&&board[j][0]=='O'){
            visited[j][0]=true;
            flag[j][0]=true;
            operate(j,0,queue,visited,flag,board,row,col);
        }

        if(!visited[j][col-1]&&board[j][col-1]=='O')
        {
            visited[j][col-1]=true;
            flag[j][col-1]=true;
            operate(j,col-1,queue,visited,flag,board,row,col);
        }
    }
//    for(boolean[] sub:flag){
//        for(boolean b:sub){
//            System.out.print(b+"\t");
//        }
//        System.out.println();
//    }
    for(int i=0;i<row;i++){
        for(int j=0;j<col;j++){
            if(board[i][j]=='O'&&!flag[i][j])
                board[i][j]='X';
        }
    }





}
public void operate(int x,int y,LinkedList<Position> queue,boolean [][]visited,boolean [][]flag,char[][] board,int row,int col){
    queue.offer(new Position(x,y));
    while(!queue.isEmpty())
    {
        Position position=queue.poll();
        //将上下左右四个方向，没有访问过的并且字符是o的加入到队列中
        if(position.x>0&&!visited[position.x-1][position.y]&&board[position.x-1][position.y]=='O')
        {
            queue.offer(new Position(position.x-1,position.y));
            visited[position.x-1][position.y]=true;
            flag[position.x-1][position.y]=true;
        }
        if(position.y>0&&!visited[position.x][position.y-1]&&board[position.x][position.y-1]=='O')
        {
            queue.offer(new Position(position.x,position.y-1));
            visited[position.x][position.y-1]=true;
            flag[position.x][position.y-1]=true;
        }
        if(position.x<row-1&&!visited[position.x+1][position.y]&&board[position.x+1][position.y]=='O')
        {
            queue.offer(new Position(position.x+1,position.y));
            visited[position.x+1][position.y]=true;
            flag[position.x+1][position.y]=true;
        }
        if(position.y<col-1&&!visited[position.x][position.y+1]&&board[position.x][position.y+1]=='O')
        {
            queue.offer(new Position(position.x,position.y+1));
            visited[position.x][position.y+1]=true;
            flag[position.x][position.y+1]=true;
        }
    }


}
    public static void main(String[] args) {
    char [][]board={
            {'X','O','X'},
            {'O','X','O'},
            {'X','O','X'}


    };

    Leetcode130 l130=new Leetcode130();
    l130.solve(board);
    for(char []row:board){
        for(char col:row){
            System.out.print(col+"\t");
        }
        System.out.println();
    }
    }



//    public void solve(char[][] board) {
//        if(board.length<=0 ||board[0].length<=0){
//            return;
//        }
//
//        int m = board.length;
//        int n = board[0].length;
//        for(int j = 0;j<n;j++){
//            if(board[0][j]=='O'){
//                dfs(board, 0,j);
//            }
//        }
//        for(int j = 0;j<n;j++){
//            if(board[m-1][j]=='O'){
//                dfs(board, m-1,j);
//            }
//        }
//
//        for(int i = 0;i<m;i++){
//            if(board[i][0]=='O'){
//                dfs(board,i,0);
//            }
//        }
//
//        for(int i = 0;i<m;i++){
//            if(board[i][n-1]=='O'){
//                dfs(board,i,n-1);
//            }
//        }
//
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                if(board[i][j]=='O'){
//                    board[i][j]='X';
//                }
//            }
//        }
//
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                if(board[i][j]=='+'){
//                    board[i][j]='O';
//                }
//            }
//        }
//
//
//    }
//
//    private void dfs(char [][] board, int i, int j){
//        if(i<0||i>=board.length||j<0||j>=board[0].length){
//            return;
//        }
//        if(board[i][j]!='O'){
//            return;
//        }
//
//        board[i][j] = '+';
//        dfs(board, i-1,j);
//        dfs(board,i+1,j);
//        dfs(board, i, j-1);
//        dfs(board, i, j+1);
//    }
}
