public class Leetcode72 {

    public int minDistance(String word1, String word2) {
        int len1=word1.length();
        int len2=word2.length();

//
//        if(len1==0||len2==0){
//            return max;
//        }


        int dp[][]=new int [len1+1][len2+1];
        for(int i=0;i<=len1;i++){
            dp[i][0]=i;
        }
        for(int j=0;j<=len2;j++){
            dp[0][j]=j;
        }

        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(word1.charAt(i)==word2.charAt(j)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=mymin(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1;
                }

            }
        }

            return dp[len1][len2];




    }

    public int mymin(int x,int y,int z){
        int mid=0;
        if (x <= y) {
            mid=x;
        }else{
            mid=y;
        }
        if(mid<=z){
            return mid;
        }else{
            return z;
        }


    }
    public static void main(String[] args) {
        Leetcode72 l72=new Leetcode72();
        int res= l72.minDistance("","ros");
        System.out.println(res);

    }
}
