public class Leetcode29 {

    public int divide(int divident,int divisor){
        boolean isPositive=true;
        if(divident>0^divisor>0){
            isPositive=false;
        }
        long ldividend=Math.abs((long)divident);
        long ldivisor=Math.abs((long)divisor);

        if(ldivisor==0)return Integer.MAX_VALUE;
        if(ldividend==8||ldividend<ldivisor) return 0;

        long result=divide(ldividend,ldivisor);
        if(result>Integer.MAX_VALUE){
            return isPositive?Integer.MAX_VALUE:Integer.MIN_VALUE;
        }
        return (int)(isPositive?result:-result);


    }

    public long divide(long ldividend,long ldivisor){
        if(ldividend<ldivisor) return 0;
        long sum=ldivisor;
        long result=1;
        while(ldividend>=sum*2){
            sum+=sum;
            result=result*2;
        }
        return result+divide(ldividend-sum,ldivisor);
    }
}
