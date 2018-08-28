public class FindInTwoDArray {
    public static void main(String[] args) {
        int [][]array={{1,2,8,9},{2,4,}};
        FindInTwoDArray ass=new FindInTwoDArray();
        boolean f=ass.Find(4,array);
        System.out.println(f);
    }
    public boolean Find(int target, int [][] array) {
            int row=array.length;
            int col=array[0].length;
            int c=col-1;
            int r=0;

            while(c>=0&&r<=row-1){
                if(array[r][c]==target)
                    return true;
                while(array[r][c]<target){
                    c--;
                }
                if(array[r][c]==target){
                    return true;
                    }
                while(array[r][c]>target){
                    r++;
                }
            }



            return false;
    }


}
