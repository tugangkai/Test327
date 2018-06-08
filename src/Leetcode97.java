import java.util.LinkedList;

public class Leetcode97 {

    public boolean isInterleave(String s1, String s2, String s3) {
        char[] cc1 = s1.toCharArray();
        char[] cc2 = s2.toCharArray();
        int len1 = cc1.length;
        int len2 = cc2.length;
        char[] cc3 = s3.toCharArray();
        int len3 = cc3.length;
        if (len1 + len2 != len3) {
            return false;
        }
        int i = 0;
        int j = 0;
        int k = 0;
        class Position {
            int x;
            int y;
            int k;

            public Position(int x, int y,int k) {
                this.x = x;
                this.y = y;
                this.k=k;
            }
        }
        LinkedList<Position> list = new LinkedList<Position>();
        while (k < len3) {
            boolean b1 = false;
            if (i < len1 && cc1[i] == cc3[k])
                b1 = true;

            boolean b2 = false;
            if (j < len2 && cc2[j] == cc3[k])
                b2 = true;

//            =(cc1[i]==cc3[k]);

            if (!b1 && !b2) {
                if (list.isEmpty())
                    return false;
                else {
                    Position pos = list.pop();
                    i = pos.x;
                    j = pos.y;
                    k=pos.k;

                }
                continue;
            }
            if (!b1 && b2) {
                j++;
                k++;
            } else if (b1 && !b2) {
                i++;
                k++;
            } else {
                list.push(new Position(i, j + 1,k+1));
                i++;
                k++;

            }


        }
        return true;
//        if(i<len1){
//            while(i<len1){
//                if(cc1[i++]!=cc3[k++])
//                {
//
//                    return false;
//                }
//            }
//            return true;
//
//        }else{
//            while(j<len2){
//                if(cc1[j++]!=cc3[k++])
//                {
//                    return false;
//                }
//            }
//            return true;
//        }


    }

    public boolean isInterleave1(String s1, String s2, String s3) {
        int len1=s1.length();
        int len2=s2.length();
        int len3=s3.length();
        if(len1+len2!=len3)
            return false;
        char[] cc1=s1.toCharArray();
        char[] cc2=s2.toCharArray();
        char[] cc3=s3.toCharArray();
        boolean dp[][]=new boolean[len1+1][len2+1];
        dp[0][0]=true;
        for(int i=1;i<=len1;i++){
            if(dp[i-1][0]&&cc1[i-1]==cc3[i-1])
                dp[i][0]=true;

        }
        for(int j=1;j<=len2;j++){
            if(dp[0][j-1]&&cc2[j-1]==cc3[j-1])
                dp[0][j]=true;
        }

        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                dp[i][j]=(dp[i-1][j]&&cc1[i-1]==cc3[i+j-1])||(dp[i][j-1]&&cc2[j-1]==cc3[i+j-1]);
            }

        }

        return dp[len1][len2];

    }

    public static void main(String[] args) {
      Leetcode97 l97=new Leetcode97();
      String s1="a";
      String s2="";
      String s3="a";
      boolean b=l97.isInterleave1(s1,s2,s3);
        System.out.println(b);
    }
}
