import java.util.ArrayDeque;

public class Leetcode200 {
//    给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
//
//    示例 1:
//
//    输入:
//            11110
//            11010
//            11000
//            00000
//
//    输出: 1
//    示例 2:
//
//    输入:
//            11000
//            11000
//            00100
//            00011
//
//    输出: 3

    class Point{
        int x;
        int y;
        public Point(){

        }
        public Point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public int numIslands(char[][] grid) {
        if(grid==null)
            return 0;

        int row=grid.length;
        int col=grid[0].length;
        int res=0;
        boolean visited[][]=new boolean[row][col];
        ArrayDeque<Point> queue=new ArrayDeque();

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++){
                char cur=grid[i][j];
                if(visited[i][j]||cur=='0'){
                    continue;
                }
                queue.offer(new Point(i,j));
                visited[i][j]=true;
                while(!queue.isEmpty())
                {
                    Point p=queue.poll();
                    if(p.x>0&&!visited[p.x-1][p.y]&&grid[p.x-1][p.y]=='1')
                    {
                        visited[p.x-1][p.y]=true;
                        queue.offer(new Point(p.x-1,p.y));
                    }

                    if(p.x<row-1&&!visited[p.x+1][p.y]&&(grid[p.x+1][p.y]=='1'))
                    {
                        visited[p.x+1][p.y]=true;
                        queue.offer(new Point(p.x+1,p.y));
                    }
                    if(p.y>0&&!visited[p.x][p.y-1]&&grid[p.x][p.y-1]=='1'){
                        visited[p.x][p.y-1]=true;
                        queue.offer(new Point(p.x,p.y-1));
                    }
                    if(p.y<col-1&&!visited[p.x][p.y+1]&&grid[p.x][p.y+1]=='1'){
                        visited[p.y][p.y+1]=true;
                        queue.offer(new Point(p.x,p.y+1));
                    }

                }
                res+=1;

            }
        }
        return res;
    }

//    11000
//            11000
//            00100
//            00011

    public static void main(String[] args) {
        char array[][]={
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        Leetcode200 l200=new Leetcode200();
        int res=l200.numIslands(array);
        System.out.println(res);
    }

//
//    public int numIslands(char[][] grid) {
//
//        if(null==grid||0==grid.length)
//            return 0;
//
//        int m = grid.length;
//        int n = grid[0].length;
//        /*
//         *用bfs,当找到一个(i,j)为'1'时，count++，从这个点开始上下左右进行bfs，将所有连通的部分置为'2'（除'1'的
//         *其他值即可），然后找到下一个为'1'的点
//         */
//        int count = 0;
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                if(grid[i][j]=='1'){
//                    count++;
//                    bfs(grid,i,j);
//                }
//            }
//        }
//        return count;
//    }
//
//    public void bfs(char[][] grid,int i,int j){
//        grid[i][j]='2';
//        int m = grid.length;
//        int n = grid[0].length;
//        //上
//        if(i>0&&grid[i-1][j]=='1'){
//            bfs(grid,i-1,j);
//        }
//        //下
//        if(i<m-1&&grid[i+1][j]=='1'){
//            bfs(grid,i+1,j);
//        }
//        //左
//        if(j>0&&grid[i][j-1]=='1'){
//            bfs(grid,i,j-1);
//        }
//        //右
//        if(j<n-1&&grid[i][j+1]=='1'){
//            bfs(grid,i,j+1);
//        }
//    }
//

}
