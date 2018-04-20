public class Leetcode38 {


//    报数序列是指一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
//
//            1.     1
//            2.     11
//            3.     21
//            4.     1211
//            5.     111221
//            1 被读作  "one 1"  ("一个一") , 即 11。
//            11 被读作 "two 1s" ("两个一"）, 即 21。
//            21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
//
//    给定一个正整数 n ，输出报数序列的第 n 项。
//
//    注意：整数顺序将表示为一个字符串。

//    public String countAndSay(int n) {
//        if(n==1) return "1";
//        String s = getString("1");
//        for(int i = 0; i < n-2; ++i){
//            s = getString(s);
//        }
//        return s;
//    }
//    private String getString(String s){
//        StringBuilder sb = new StringBuilder();
//        char[] chars = s.toCharArray();
//        int num;
//        for(int i = 0; i < chars.length;){
//            num = 1;
//            for(int j = i+1; j < chars.length; j++){
//                if(chars[j] == chars[i]) ++num;
//                else break;
//            }
//            sb.append(num).append(chars[i]);
//            i+=num;
//        }
//        return sb.toString();
//    }



    public String countAndSay(int n) {
            int len=1;

            if(n==1)
                return "1";
            if(n==2)
                return "11";
            String str="11";
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<n-2;i++){
                int length=str.length();
                int j=1;
                for(;j<length;j++){
                    if(str.charAt(j)==str.charAt(j-1)){
                        len++;
                    }else{
                        sb.append(len).append(str.charAt(j-1));
                        len=1;
                    }

                }
                sb.append(len).append(str.charAt(j-1));

                len=1;
                str=sb.toString();
                sb.setLength(0);




            }

            return str;

    }

    public static void main(String[] args) {
        Leetcode38 l3=new Leetcode38();
        String res=l3.countAndSay(5);
        System.out.println(res);
    }
}
