public class Leetcode31 {
//    public int getFactorial(int n){
//        int sum=1;
//        for(int i=1;i<=n;i++){
//            sum*=i;
//
//        }
//        return sum;
//    }
//    public int dxnum(int i,String s){
//        int len=s.length();
//        int total=0;
//        for(int j=i+1;j<len;j++)
//        {
//            if(s.charAt(i)-s.charAt(j)>0)
//                total++;
//        }
//        return total;
//    }
//    public void nextPermutation(int []nums){
//            int len=nums.length;
//            int val=0;
//            for(int i=0;i<len-1;i++){
//                int gere=getFactorial(len-i-1);
//                val+=dxnum(i,s)*gere;
//            }
//            int[] bitmap=new int[len];
//            for(int i=0;i<len;i++){
//                bitmap[i]=i+1;
//            }
//            val=val+1;
//
//
//            int maxval=getFactorial(len)-1;
//            if(val>maxval)
//                val=0;
//            for(int i=0;i<len;i++){
//                int gere=getFactorial(len-i-1);
//                int t=0;
//                while(val-gere>=0){
//                    t++;
//                    val-=gere;
//                }
//
//
//
//            }
//
//
//
//    }



}
