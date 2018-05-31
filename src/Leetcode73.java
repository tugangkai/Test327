public class Leetcode73 {

    public void setZeroes(int[][] matrix) {
        int rawLength = matrix.length;
        int colLength = matrix[0].length;
        boolean[] rawFlags = new boolean[rawLength];
        boolean[] colFlags = new boolean[colLength];
        for (int i = 0; i < rawLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (matrix[i][j] == 0) {
                    rawFlags[i] = true;
                    colFlags[j] = true;
                }
            }
        }

        // 调整每一行置0
        for (int i = 0; i < rawLength; i++) {
            if (rawFlags[i]) {
                for (int j = 0; j < colLength; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 调整每一列置0
        for (int i = 0; i < colLength; i++) {
            if (colFlags[i]) {
                for (int j = 0; j < rawLength; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }


    public static void main(String[] args) {

    }

//    int noZeroRawIndex = -1;
//    int rawLength = matrix.length;
//    int colLength = matrix[0].length;
//        for (int i = 0; i < rawLength; i++) {
//        int index = 0;
//        for (index = 0; index < colLength; index++) {
//            if (matrix[i][index] == 0) {
//                break;
//            }
//        }
//        if (index == colLength) {
//            noZeroRawIndex = i;
//            break;
//        }
//    }
//
//        if (noZeroRawIndex == -1) {
//        for (int i = 0; i < rawLength; i++) {
//            for (int j = 0; j < colLength; j++) {
//                matrix[i][j] = 0;
//            }
//        }
//    } else {
//        for (int i = 0; i < rawLength; i++) {
//            for (int j = 0; j < colLength; j++) {
//                if (matrix[i][j] == 0) {
//                    matrix[noZeroRawIndex][j] = 0;
//                }
//            }
//        }
//
//        for (int i = 0; i < rawLength; i++) {
//            for (int j = 0; j < colLength; j++) {
//                if (i == noZeroRawIndex) {
//                    continue;
//                }
//                if (matrix[i][j] == 0) {
//                    for (int j2 = 0; j2 < colLength; j2++) {
//                        matrix[i][j2] = 0;
//                    }
//                }
//            }
//        }
//
//        for (int i = 0; i < colLength; i++) {
//            if (matrix[noZeroRawIndex][i] == 0) {
//                for (int j = 0; j < rawLength; j++) {
//                    matrix[j][i] = 0;
//                }
//            }
//        }
//    }
}
