public class Leetcode37 {

    /**
     * 求解数独
     * @param board
     * @return
     */

    public boolean solve(char[][] board){

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){

                if(board[i][j]!='.')
                    continue;
                for(char k='1';k<='9';k++)
                {
                    if(isFit(board,i,j,k)){

                        board[i][j]=k;
                        if(solve(board))
                            return true;
                    }


                }
                board[i][j]='.';
                return false;







            }



        }


        return true;

    }
    public void solveSudoku(char[][] board) {
        solve(board);

        for(int i=0;i<9;i++){

            for(int j=0;j<9;j++)
                System.out.println(board[i][j]);
        }




    }

    public boolean isFit(char [][]board,int x,int y,char val){
        for(int i=0;i<9;i++){


            if((board[x][i]==val)||(board[i][y]==val)||(board[x/3*3+i/3][y/3*3+i%3]==val))
                return false;



        }
        return true;


    }

    public static void main(String[] args) {
        char [][]board={{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        Leetcode37 l3=new Leetcode37();
        l3.solveSudoku(board);

    }
}
