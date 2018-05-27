public class Leetcode58 {
    public int lengthOfLastWord(String s) {
        int len=s.length();
       // int end=len-1;
        int end=0;
        int start=0;
        boolean flag=true;
        for(int i=len-1;i>=0;i--){
            char tmp=s.charAt(i);
            if(tmp!=' '&&flag){
                end=i;
                flag=false;
            }
            if(!flag&&tmp==' ')
                break;
            start=i;


        }
        System.out.println("start"+start);
        System.out.println("end"+end);
        return end-start+1;
    }

    public static void main(String[] args) {
        String str="a ";
        Leetcode58 l58=new Leetcode58();
        int res=l58.lengthOfLastWord(str);
        System.out.println(res);
    }

}
