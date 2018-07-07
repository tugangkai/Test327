public class Leetcode62 {

    public int uniquePaths(int m, int n) {
        int [][]res=new int [n][m];
        for(int i=0;i<m;i++){
            res[0][i]=1;
        }
        for(int j=0;j<n;j++){
            res[j][0]=1;
        }
        for(int j=1;j<n;j++){
        for(int i=1;i<m;i++){

                res[j][i]=res[j][i-1]+res[j-1][i];


            }


        }
        return res[n-1][m-1];



    }
    public static void main(String[] args) {

        Leetcode62 l62=new Leetcode62();
        int res=l62.uniquePaths(7,3);
        System.out.println(res);


    }

}
