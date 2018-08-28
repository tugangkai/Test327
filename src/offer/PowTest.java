package offer;

public class PowTest {
//    题目描述
//    给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
public static void main(String[] args) {
    PowTest pw=new PowTest();
    double res=pw.Power(2.0,-3);
    System.out.println(res);
}
    public double Power(double base, int exponent) {
        int e=Math.abs(exponent);
        if(e==0)
            return 1.0;
        if(e==1)
            return base;


        double total=1.0;
        double res=Power(base,exponent/2);
        total=res*res;
        if(exponent%2!=0) {
            total*=base;
        }

        if(exponent<0)
            total=1/total;
        return total;


    }
//    public double Power(double base, int exponent) {
//            boolean positive=true;
//            if(exponent%2!=0&&base<0){
//                positive=false;
//
//            }
//            if(base<0)
//                base=-base;
//
//            if(exponent<0){
//                base=1/base;
//                exponent=-exponent;
//            }
//
//            return positive?getResult(base,exponent):-getResult(base,exponent);
//
//    }
//    public double getResult(double base,int exponent){
//        if(exponent==0)
//            return 1.0;
//        if(exponent==1)
//            return base;
//        double res=getResult(base,exponent/2);
//        if(exponent%2!=0)
//        {
//            return base*res*res;
//        }else{
//            return res*res;
//        }


//        if(exponent%2==0)
//            return getResult(base,exponent/2)*getResult(base,exponent/2);
//        if(exponent%2==1)
//        {
//            return base*getResult(base,exponent/2)*getResult(base,exponent/2);
//        }



}
