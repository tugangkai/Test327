package s2017;

import java.util.ArrayList;
import java.util.List;

public class PrintMatrixClockWise {

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int width=matrix[0].length;
        int height=matrix.length;
        int minLen=Math.min(width,height);
        int times=(minLen-1)/2+1;
        ArrayList<Integer> list=new ArrayList<Integer>();

        for(int i=0;i<times;i++){
            for(int j=i;j<width-i;j++){
                list.add(matrix[i][j]);
            }
            for(int j=i+1;j<height-1-i;j++){
                list.add(matrix[j][width-1-i]);
            }
            for(int j=width-i-1;j>=i&&(2*i+1!=height);j--){
                list.add(matrix[height-i-1][j]);
            }
            for(int j=height-2-i;j>=i+1&&(2*i+1!=width);j--){
                list.add(matrix[j][i]);
            }

        }



        return list;
//        if(minLen%2!=0){
//            int mid=minLen/2;
//            if(width>height){
//                for(int i=mid;i<width-mid;i++){
//                    list.add(matrix[mid][i]);
//                }
//
//
//            }else if(width<height){
//                for(int i=mid;i<height-mid;i++){
//                    list.add(matrix[i][mid]);
//                }
//            }else{
//                list.add(matrix[mid][mid]);
//            }
//        }



    }




}
