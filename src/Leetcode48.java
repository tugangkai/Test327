public class Leetcode48 {
    public void rotate(int[][] matrix) {
        //矩阵的长度或者高度
        int len=matrix.length;

        //在矩阵中执行逆时针旋转次数
        int times=len/2;
        for(int i=0;i<=times;i++){
            for(int j=i;j<len-1-i;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[len-j-1][i];
                matrix[len-j-1][i]=matrix[len-i-1][len-1-j];
                matrix[len-i-1][len-1-j]=matrix[j][len-1-i];
                matrix[j][len-1-i]=temp;


            }



        }




    }

    public static void main(String[] args) {

    }
}
