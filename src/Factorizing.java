import java.util.ArrayList;

public class Factorizing {

    public static boolean isFactorizingEqualsSum(int s){
        ArrayList<Integer> list=new ArrayList();
        int temp=s;
        int j=2;
        while(temp!=1){

            while(temp%j!=0){
                j++;

            }
            list.add(j);
            temp=temp/j;
            j=2;

        }
        //list.add(temp);
        list.add(1);
        int sum=0;
        for(int t:list){
            sum+=t;
        }
        System.out.println(sum);
        if(sum==s)
            return true;
        else return false;

    }

    public static void main(String[] args) {
        boolean flag=isFactorizingEqualsSum(9);
        System.out.println(flag);


    }


}
