public class Leetcode65 {


//    验证给定的字符串是否为数字。
//
//    例如:
//            "0" => true
//            " 0.1 " => true
//            "abc" => false
//            "1 a" => false
//            "2e10" => true
//
//    说明: 我们有意将问题陈述地比较模糊。在实现代码之前，你应当事先思考所有可能的情况。
//
  /*
   数字中可能包含的字符为：数字、e、+号和-号、小数点
   可能会出现的情况
   1.数字能够有前导和后导空格、数字中间不允许有空格
   2.小数点最多出现一次，前面能够没有数字但是后面必须有数字
   3.对于e,最多只能出现一次，前后必须多有数字，但后面必须是整数，后面不能出现'.'。
   4.对于+和-，e前后只能最多出现一次，切一定要在数字最前面出现
   5.对于其他字符，仅仅同意是数字

   */


    public boolean isNumber(String s) {

        char[] c=s.toCharArray();
        int i=0;
        for(;i<c.length&&c[i]==' ';i++);
        if(i==c.length)
            return false;
        if(c[i]=='+'||c[i]=='-')
            i++;
        boolean digit=false;
        boolean dot=false;
        boolean exp=false;
        for(;i<c.length;i++){
            if(c[i]>='0'&&c[i]<='9')
                digit=true;
            else if(c[i]=='.'&&!dot){
                dot=true;
            }else if(c[i]=='e'&&!exp&&digit){
                //e的后面不允许出现小数点，额的后面必须是整数
                dot=exp=true;
                if(i+1<c.length&&(c[i+1]=='+'||c[i+1]=='-')){
                    i++;
                }
                if(i+1>=c.length||!(c[i+1]>='0'&&c[i+1]<='9'))
                    return false;


            }else
                 break;




        }
        for(;i<c.length&&c[i]==' ';i++){

        }
        return digit&&c.length==i;




    }

    public static void main(String[] args) {
        Leetcode65 l65=new Leetcode65();
        boolean res=l65.isNumber("0e ");
        System.out.println(res);
    }
}
