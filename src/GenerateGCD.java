public class GenerateGCD {


    public static void main(String[] args) {
        GenerateGCD gd=new GenerateGCD();
        int res=gd.GCD(8,6);
        System.out.println(res);
    }


    public int GCD(int a,int b){
        while(b!=0){
            int remain=a%b;
            a=b;
            b=remain;

        }
        return a;

    }

    public int generateGCD(int a,int b){
        if(b==0) return a;
        else return generateGCD(b,a%b);


    }
}
