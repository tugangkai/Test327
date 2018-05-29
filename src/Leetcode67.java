public class Leetcode67 {

//    给定两个二进制字符串，返回他们的和（用二进制表示）。
//
//    输入为非空字符串且只包含数字 1 和 0。
//
//    示例 1:
//
//    输入: a = "11", b = "1"
//    输出: "100"
//    示例 2:
//
//    输入: a = "1010", b = "1011"
//    输出: "10101"
public String addBinary(String a, String b) {
   int lena=a.length();
   int lenb=b.length();
   char []ca=a.toCharArray();
   char []cb=b.toCharArray();

   //char []res=lena>=lenb?ca:cb;c
    char[] big;char []small;
    if(lena>=lenb){
        big=ca;
        small=cb;
    }else{
        big=cb;
        small=ca;
    }
    int sl=small.length-1;
    int bl=big.length-1;
    int slot=0;
    while(bl>=0&&sl>=0){

        char tp=(char)(big[bl]&small[sl]);
        if(tp=='1'){
            if(slot==0){
                big[bl]='0';
                slot=1;
            }else{
                big[bl]='1';
                slot=1;
            }
            bl--;
            sl--;
        }else{
            if(big[bl]!='0'||small[sl]!='0'){
                if(slot==1){
                    big[bl]='0';
                }else{
                    big[bl]='1';
                }

            }else{
                if(slot==1){
                    big[bl]='1';
                    slot=0;
                }else{
                    big[bl]='0';
                }

            }
            bl--;
            sl--;
        }
    }
    if(bl<0){
        if(slot==1){
            return new StringBuilder().append('1').append(big).toString();
        }
        return new String(big);
    }else{
        if(slot==1){
            while(bl>=0){
                if(big[bl]=='1')
                {
                    big[bl]='0';
                }else{
                    big[bl]='1';
                    slot=0;
                    break;
                }
                bl--;
            }
        }
        if(slot==1){
            StringBuilder sb=new StringBuilder();
            sb.append('1').append(big);
            return sb.toString();
        }else{
            return new String(big);
        }



    }


//    while(bl>=0&&sl>=0){
//        int tmp=(big[bl]-'0')+(small[sl]-'0');
//        if(tmp)
//        big[bl]=(char)((big[bl]-'0')+(small[sl]-'0')+'0');
//
//
//    }


   // lena>=lenb?(big=casmall=cb)
   //int x=lena<=lenb?lena:lenb;




}
    public static void main(String[] args) {
          //  char res=(char)(('1'-'0')+('2'-'0')+'0');
        Leetcode67 l67=new Leetcode67();
        String res=l67.addBinary("1010","1011");
        System.out.println(res);
       // System.out.println(res);
    }
    public String addBinary1(String a, String b) {
        if (a == null || b == null) {
            return a == null ? b : a;
        }
        int m = a.length();
        int n = b.length();
        int size = Math.max(m, n);
        char[] result = new char[size];
        char[] longArray = m > n ? a.toCharArray() : b.toCharArray();
        char[] shortArray = m > n ? b.toCharArray() : a.toCharArray();
        int diff = longArray.length - shortArray.length; // important
        int carry = 0;
        for (int i = size - 1; i >= 0; i--) {
            int sum = carry + (longArray[i] - '0');
            if (i - diff >= 0) {
                sum += (shortArray[i - diff] - '0');
            }
            carry = sum / 2;
            result[i] = (char)(sum % 2 + '0');
        }

        if (carry != 0) {
            return "1" + new String(result);
        }
        return new String(result);
    }

}
