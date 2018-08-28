public class Leetcode74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0)
            return false;

        int rs=0,re=matrix.length-1,cs=0,ce=matrix[0].length;
        int clen=ce;
        int rlen=re;
        int cr=-1;
        while(rs<=re){
            int mid=(rs+re)/2;
            if(target>=matrix[mid][0]&&target<=matrix[mid][clen-1])
            {
                cr=mid;
                break;
            }

            else if(target<=matrix[mid][0])
                re=mid-1;
            else
                rs=mid+1;

        }

        if(cr==-1){
            return false;
        }

        while(cs<=ce){

            int cm=(cs+ce)/2;

            if(matrix[cr][cm]==target)
                return true;
            else if(matrix[cr][cm]<target){
                cs=cm+1;
            }else{
                ce=cm-1;
            }




        }

        return false;

    }

    public static void main(String[] args) {
        int [][]matrix={
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,50}
        };
        Leetcode74 l74=new Leetcode74();
        boolean res=l74.searchMatrix(matrix,3);
        System.out.println(res);
    }

    //more concise solutio
//    public boolean searchMatrix(int[][] matrix, int target) {
//        int m = matrix.length;
//        if(m == 0){
//            return false;
//        }
//        int n = matrix[0].length;
//        int i = m-1;
//        int j = 0;
//        while(i >= 0 && j < n){
//            if(matrix[i][j] == target){
//                return true;
//            }else if(matrix[i][j] < target){
//                j++;
//            }else{
//                i--;
//            }
//        }
//        return false;
//    }

}
