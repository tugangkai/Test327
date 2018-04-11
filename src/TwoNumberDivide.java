public class TwoNumberDivide {


//    public int divide(int dividend, int divisor) {
//        if(divisor == 0) {
//            return Integer.MAX_VALUE;
//        }
//        int sign = 1;
//        if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
//            sign = -1;
//        }
//        if(divisor == -1) {
//            if(dividend > Integer.MIN_VALUE) {
//                return -1 * dividend;
//            }else {
//                return Integer.MAX_VALUE;
//            }
//        }
//        if(divisor == 1) {
//            return dividend;
//        }
//        long dd = Math.abs((long)dividend);
//        long dr = Math.abs((long)divisor);
//        if(dd == 0 || dd < dr) {
//            return 0;
//        }
//        int n = process(dd, dr);
//        if(n > Integer.MAX_VALUE) {
//            return sign > 0?Integer.MAX_VALUE:Integer.MIN_VALUE;
//        }
//        return sign * n;
//    }
//    private int process(long dd, long dr) {
//        if(dd < dr) {
//            return 0;
//        }
//        int n = 1;
//        long sum = dr;
//        while((sum+sum) <= dd) {
//            sum = sum<<1;
//            n = n<<1;
//        }
//        return n + process(dd-sum, dr);
//    }




    public int divide(int dividend, int divisor) {
            long divid=dividend;
            long divis=divisor;
            if(divis==0)
                return 0;

            boolean isPositive=true;
            isPositive=!((divis>0)^(divid>0));
            if(divis<0)
                divis=-divis;
            if(divid<0)
                divid=-divid;
            if(divid<divis)
                return 0;
        //System.out.println(divid);
        System.out.println(isPositive);
          //  int dis=highpos(divid)-highpos(divis);
         //   System.out.println(dis);
//            while(dis-->0){
//                divid>>=1;
//                sum=(sum+1)<<1;
//               //System.out.println(sum);
//            }
            long total=0;

            while(divid>=divis){

                long temp=divis;
                long cnt=1;
                while(temp<=divid){
                    temp<<=1;
                    cnt<<=1;
                }

                total+=(cnt>>1);
                divid-=(temp>>1);


            }

            if(!isPositive){
                total=-total;
            }

            if(total==2147483648l)
                total-=1;



            return (int)total;
    }

    public static void main(String[] args) {
//        int i=-2147483648;
//        //i=-i;
//        System.out.println(-i);
//        System.out.println(false^true);
        TwoNumberDivide s=new TwoNumberDivide();
       int res= s.divide(-2147483648
               ,-1);
        System.out.println(res);
    }
}
