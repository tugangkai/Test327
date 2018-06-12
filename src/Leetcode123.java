public class Leetcode123 {

    public static int solution(int []prices){
        if(prices==null||prices.length<2)
            return 0;
        int len=prices.length;
        int []firstProfits=new int[len];
        int []secondProfit=new int [len];
        int min=prices[0];
        for(int i=1;i<len;i++){
            min=Math.min(min,prices[i]);
            firstProfits[i]=Math.max(firstProfits[i-1],prices[i]-min);
        }
        int max=prices[len-1];
        for(int i=len-2;i>=0;i--){
            max=Math.max(max,prices[i]);
            secondProfit[i]=Math.max(secondProfit[i+1],max-prices[i]);
        }
        int res=0;
        for(int i=0;i<len;i++){
            res=Math.max(res,firstProfits[i]+secondProfit[i]);
        }
        return res;



    }

    public static void main(String[] args) {
        Leetcode123 l123=new Leetcode123();
        int []sol={3,3,5,0,0,3,1,4};
       int res= l123.solution(sol);
        System.out.println(res);

    }
}
