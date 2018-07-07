public class Leetcode70 {
    public int climbStairs(int n) {
        // if(n==1)
        //     return 1;
        // if(n==0)
        //     return 1;
        // return climbStairs(n-1)+climbStairs(n-2);
        if(n==1||n==0)
            return 1;
        int f1=1;
        int f0=1;
        int f2=0;
        for(int i=2;i<=n;i++){
            f2=f1+f0;
            f0=f1;
            f1=f2;

        }
        return f2;



    }

}
