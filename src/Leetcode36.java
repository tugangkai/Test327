import java.util.HashMap;

public class Leetcode36 {
//    判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
//
//    数字 1-9 在每一行只能出现一次。
//    数字 1-9 在每一列只能出现一次。
//    数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
//
//    上图是一个部分填充的有效的数独。

    public static boolean isValidSudoku(char[][] board) {
        boolean[][][] has = new boolean[3][9][9];
        int tmp;
        for(int i = 0 ; i < 9 ; i++) {
            for(int j = 0 ; j < 9 ; j++) {
                if(board[i][j]=='.') {
                    continue;
                }else {
                    tmp = board[i][j] - '1';
                }
                if(has[0][i][tmp]||has[1][j][tmp]||has[2][3*(i/3)+j/3][tmp]){
                    return false;
                }else{
                    has[0][i][tmp] = true;
                    has[1][j][tmp] = true;
                    has[2][3*(i/3)+j/3][tmp] = true;
                }
            }
        }
        return true;
    }


//    private static HashMap<Character,Integer> map=new HashMap<Character,Integer>();
//    public static boolean isValidSudoku(char[][] board) {
//
//        for(int i=0;i<9;i++){
//            for(int j=0;j<9;j++){
//                if(board[i][j]=='.')
//                    continue;
//                if(map.get(board[i][j])==null)
//                    map.put(board[i][j],1);
//                else{
//
//                    return false;
//                }
//
//            }
//            map.clear();
//        }
//
//        for(int i=0;i<9;i++){
//            for(int j=0;j<9;j++){
//                if(board[j][i]=='.')
//                    continue;
//                if(map.get(board[j][i])==null)
//                    map.put(board[j][i],1);
//                else{
//                    return false;
//                }
//
//
//
//            }
//            map.clear();
//
//        }
//
//        for(int i=0;i<9;i+=3)
//            for(int j=0;j<9;j+=3){
//                for(int k=i;k<i+3;k++){
//                    for(int h=j;h<j+3;h++){
//                        if(board[k][h]=='.')
//                            continue;
//                        if(map.get(board[k][h])==null)
//                            map.put(board[k][h],1);
//                        else
//                            return false;
//
//
//
//
//
//                    }
//
//
//
//                }
//                map.clear();
//
//
//
//            }
//
//        return true;
//
//
//    }

    public static void main(String[] args) {
        char [][]chars={{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        boolean is=isValidSudoku(chars);
        System.out.println(is);
//        boolean bool[][]=new boolean[9][9];
//        System.out.println(bool[0][0]);
    }

}
