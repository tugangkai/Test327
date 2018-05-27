import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode60 {

    /**
     *
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
           //确定了到底是在哪个位数之后的排列
        StringBuilder sb=new StringBuilder();
         int p=1;
         List<Integer> list=new ArrayList<Integer>();
          for(int i=1;i<=n;i++){
              p*=i;
              list.add(i);
          }
          do{
              int s=p/n;
              p=p/n;
              n--;
              if(k<=s){
                  sb.append(list.get(0));
                  list.remove(0);
              }else{
                  int ps=k/s;
                  k=k%s;
                  if(k==0){
                      sb.append(list.get(ps-1));
                      list.remove(ps-1);
                  }else{
                      sb.append(list.get(ps));
                      list.remove(ps);
                  }
              }
          }while(k!=1&&k!=0&&n>1);

          while(!list.isEmpty())
          {
              if(k==1){
                  sb.append(list.get(0));
                  list.remove(0);
              }else{
                  int s=list.size()-1;
                  sb.append(list.get(s));
                  list.remove(s);
              }

          }
          return sb.toString();
          /*
          let list 1 to n
          do
          s=p/n
                  n--;
          if k<=s
                sb add list(0)
                list ->pop(0)
           else
                ps = k/s
                sb add list(p)
                list -> pop(p)
                ps=k%s
           while ps!=1]]]]]]
          */

//            int cur=1;
//            int w=1;
//            while(k>cur){
//                w++;
//                cur*=w;
//            }



    }
    public String getPermutation1(int n, int k) {
        if(n<=0||k<=0)return "";
        List<Integer>nums;
        nums = new LinkedList<>();
        int factorial=1;
        for(int i=1;i<=n;i++){
            factorial*=i;
            nums.add(i);
        }

        StringBuilder sb=new StringBuilder();
        k--;
        while(n>0){
            factorial/=n;  //(n-1)!
            sb.append(nums.remove(k/factorial));
            k%=factorial;
            n--;
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        Leetcode60 l60=new Leetcode60();
       String res=l60.getPermutation1(3,4);
//        for(int i=1;i<=24;i++){
//            System.out.println(l60.getPermutation(3,4));
//        }
   System.out.println(res);

    }

}
