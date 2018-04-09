public class Leetcode28 {

    public static int[] getp(String str){
        int len=str.length();
        int []p=new int[len];
        p[0]=p[1]=0;
        int j=0;
        for(int i=1;i<len;i++){
            while(j>0&&str.charAt(i)!=str.charAt(j)) j=p[j-1];
            if(str.charAt(i)==str.charAt(j)) j++;
            p[i]=j;


        }


        return p;

    }
    public int strStr(String haystack, String needle) {




            if(haystack==null||needle==null||haystack.trim().equals("")||needle.trim().equals(""))
                return -1;

        int lens=needle.length();
        int []p=new int[lens];
        p[0]=p[1]=0;
        int j=0;
      //  needle.index
        for(int i=1;i<lens;i++){
            while(j>0&&needle.charAt(i)!=needle.charAt(j)) j=p[j-1];
            if(needle.charAt(i)==needle.charAt(j)) j++;
            p[i]=j;


        }
            j=0;
            int len=haystack.length();
            for(int i=0;i<len-needle.length()+1;i++){
                while(j>0&&haystack.charAt(i)!=needle.charAt(j)) j=p[j];
                if(haystack.charAt(i)==needle.charAt(j))j++;
                if(j==lens)
                {
                    return (i-lens+1);
                }





            }
            return  -1;






    }

    public static void main(String[] args) {
        String str="aaa";
        int p[]=getp(str);
        for(int i:p){
            System.out.println(i);
        }
    }



}
