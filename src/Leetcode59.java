public class Leetcode59 {






    public int[][] generateMatrix(int n) {
        int t=n/2;
        int [][]res=new int[n][n];
        int end=0;
        int j=0;
        for(int i=0;i<t;i++)//复制循环次数
        {
           // int start=end+1;
            end++;
          //  System.out.println(start);
            for(j=i;j<n-1-i;j++){//起始到结束点
                res[i][j]=end+j-i;
                res[j][n-1-i]=res[i][j]+n-1-i*2;
                res[n-1-i][n-1-j]=res[j][n-1-i]+n-1-i*2;
                res[n-1-j][i]=res[n-1-i][n-1-j]+n-1-i*2;

            }
            end= res[n-j][i];
            System.out.println(end);
            //end= res[n-1-j-1][i];
          //  System.out.println(end);

        }
        if(n%2!=0){
            res[n/2][n/2]=end+1;
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode59 l59=new Leetcode59();
        int [][]res=l59.generateMatrix(5);
        for(int []cur:res){
            for(int i:cur){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }



//    public int[][] generateMatrix(int n) {
//        int[][] result = new int[n][n];
//        generateMatrixRecursive(result, 0, n-1, 0, n-1, 1);
//        return result;
//    }

//    private void generateMatrixRecursive(int[][] result, int xfrom, int xto, int yfrom, int yto, int fromData) {
//        if(xfrom > xto) {
//            return;
//        }
//        if(xfrom == xto) {
//            result[xfrom][yfrom] = fromData;
//            return;
//        }
//        if(xfrom + 1 == xto) {
//            result[xfrom][yfrom] = fromData;
//            result[xfrom][yfrom+1] = fromData+1;
//            result[xfrom+1][yfrom+1] = fromData+2;
//            result[xfrom+1][yfrom] = fromData+3;
//            return;
//        }
//        for(int i = yfrom; i <= yto; i++) {
//            result[xfrom][i] = fromData++;
//        }
//        for(int i = xfrom+1; i < xto; i++) {
//            result[i][yto] = fromData++;
//        }
//        for(int i = yto; i >= yfrom; i--) {
//            result[xto][i] = fromData++;
//        }
//        for(int i = xto-1; i > xfrom; i--) {
//            result[i][yfrom] = fromData++;
//        }
//        generateMatrixRecursive(result, xfrom+1, xto-1, yfrom+1, yto-1, fromData);
//    }

//
//    public int[][] generateMatrix(int n) {
//        if(n == 0)
//            return null;
//        if(n == 1)
//            return new int[][]{{1}};
//        int[][] res = new int[n][n];
//        int acc = 1;
//        int l = 0, r = n - 1;
//        for(;;){
//            for(int t = l; t < r; t++)
//                res[l][t] = acc++;
//            for(int t = l; t < r; t++)
//                res[t][r] = acc++;
//            for(int t = r; t > l; t--)
//                res[r][t] = acc++;
//            for(int t = r; t > l; t--)
//                res[t][l] = acc++;
//            l++;r--;
//            if(l == r){
//                res[l][r] = acc;
//                break;
//            }
//            if(r - l < 1)
//                break;
//        }
//        return res;
//    }

}
