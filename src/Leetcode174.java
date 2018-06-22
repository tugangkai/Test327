public class Leetcode174 {

    public static void main(String[] args) {
            int [][]dungeon={
                    {-2,-3,3},
                    {-5,-10,1},
                    {10,30,-5}
            };
            Leetcode174 l174=new Leetcode174();
            int min=l174.calculateMinimumHP(dungeon);
        System.out.println(min);
    }

    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon==null)
            return 0;
        int row=dungeon.length;
        int col=dungeon.length;
        int dp[][]=new int[row][col];
        dp[row-1][col-1]=dungeon[row-1][col-1]>0?0:-dungeon[row-1][col-1];
        for(int i=col-2;i>=0;i--){
            int need=dp[row-1][i+1]-dungeon[row-1][i];
            dp[row-1][i]=need>0?need:0;
        }
        for(int j=row-2;j>=0;j--){
            int need=dp[j+1][col-1]-dungeon[j][col-1];
            dp[j][col-1]=need>0?need:0;
        }
        for(int i=row-2;i>=0;i--){
            for(int j=col-2;j>=0;j--){
                int needR=dp[i][j+1]-dungeon[i][j];
                int needD=dp[i+1][j]-dungeon[i][j];
                int min=Math.min(needR,needD);
                dp[i][j]=min>0?min:0;
            }
        }
        return dp[0][0]+1;
    }


//    public int helper(int[][] dungeon, int i, int j) {
//        if (i>=dungeon.length || j>=dungeon[0].length)
//            return Integer.MAX_VALUE;
//        if (mem[i][j]>0)
//            return mem[i][j];
//        int health = Integer.MAX_VALUE;
//        health = Math.min(health, helper(dungeon, i+1, j));
//        health = Math.min(health, helper(dungeon, i, j+1));
//        health = (health == Integer.MAX_VALUE? 1: health);
//        int ret = (health > dungeon[i][j]? (health-dungeon[i][j]): 1);
//        mem[i][j] = ret;
//        return ret;
//    }

}
