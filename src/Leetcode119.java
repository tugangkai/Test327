import java.util.ArrayList;
import java.util.List;

public class Leetcode119 {

    public List<Integer> getRow(int rowIndex){
        List<Integer> list=new ArrayList<Integer>(rowIndex+1);
        list.add(1);
        if(rowIndex==0){
            return list;
        }
        list.add(1);
        if(rowIndex==1)
            return list;

        for(int i=2;i<=rowIndex;i++){
            list.add(1);
            for(int j=i-1;j>0;j--){
                list.set(j,list.get(j-1)+list.get(j));
            }


        }

        return list;

    }
//    public List<Integer> getRow(int rowIndex) {
//        Integer[] result = new Integer[rowIndex + 1];
//        Arrays.fill(result, 0);
//        result[0] = 1;
//        for (int i = 1; i < result.length; i++) {
//            for (int j = i; j > 0; j--) {
//                result[j] = result[j] + result[j - 1];
//            }
//        }
//        return Arrays.asList(result);
//    }

//    public List<Integer> getRow(int rowIndex) {
//        List<Integer> list=new ArrayList<Integer>();
//        list.add(1);
//        int temp=1;
//        int t=rowIndex;
//        for(int i=1;i<=rowIndex;i++){
//            temp=temp*(t--/i);
//            list.add(temp);
//        }
//        return list;
//    }

    public static void main(String[] args) {
        Leetcode119 l119=new Leetcode119();
        List<Integer> list=l119.getRow(30);
        int cur=0;
        for(int i:list){
            System.out.println("pos"+cur+++":"+i);
        }
    }
}
