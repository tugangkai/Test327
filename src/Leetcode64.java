public class Leetcode64 {
    public int minPathSum1(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[]=new int[n];
        dp[0]=grid[0][0];
        for(int j=1;j<n;j++){
            dp[j]=dp[j-1]+grid[0][j];
        }
        for(int i=1;i<m;i++){
            dp[0]=dp[0]+grid[i][0];

            for(int j=1;j<n;j++){
                int min=Math.min(dp[j],dp[j-1]);
                dp[j]=min+grid[i][j];
            }


        }
        return dp[n-1];
    }
//    给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
//    说明：每次只能向下或者向右移动一步。
//
//    示例:
//
//    输入:
//            [
//            [1,3,1],
//            [1,5,1],
//            [4,2,1]
//            ]
//    输出: 7
//    解释: 因为路径 1→3→1→1→1 的总和最小

    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int [][]res=new int[m][n];
        res[0][0]=grid[0][0];
        for(int i=1;i<m;i++){
            res[i][0]=res[i-1][0]+grid[i][0];
        }
        for(int j=1;j<n;j++){
            res[0][j]=res[0][j-1]+grid[0][j];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n; j++){
                res[i][j]=Math.min(res[i][j-1]+grid[i][j],res[i-1][j]+grid[i][j]);
            }

        }
        return res[m-1][n-1];

    }

    public static void main(String[] args) {
        Leetcode64 l64=new Leetcode64();
        int [][]grid=new int [][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        int min=l64.minPathSum1(grid);
        System.out.println(min);
    }
}
