package offer;

import java.util.Scanner;

public class SplitFarmLand {
        static  int sum[][]=new int[100][100];


        static  int n,m;

        public static  int  calc(int x1,int y1,int x2,int y2){
            return sum[x2][y2]-sum[x2][y1]-sum[x1][y2]+sum[x1][y1];
        }




        public static boolean ojbk(int k){
            for(int x1=1;x1<=n-3;x1++){
                for(int x2=x1+1;x2<=n-2;x2++){
                    for(int x3=x2+1;x3<=n-1;x3++){
                        int cnt=0;
                        int pos=0;
                        for(int y=1;y<=m;y++){
                            if(calc(0,pos,x1,y)>=k&&calc(x1,pos,x2,y)>=k
                                    &&calc(x2,pos,x3,y)>=k&&calc(x3,pos,n,y)>=k)
                            {
                                cnt++;
                                pos=y;
                            }
                        }
                        if(cnt>=4)
                            return true;




                    }



                }



            }


           return false;

        }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext())
        {
            n=sc.nextInt();
            m=sc.nextInt();
            int[][] matrix=new int[n][m];
            for (int i=0;i<n ;i++ )
            {
                String str=sc.next();
                for (int j=0;j<m ;j++ )
                {
                    matrix[i][j]=str.charAt(j)-'0';
                }
            }
            //sum[i][j]表示
            //左上顶点matrix[0][0]到右下顶点matrix[i-1][j-1]
            //确定的的矩阵元素的和
            //例如sum[1][1]就表示matrix[0][0];
           // sum=new int[n+1][m+1];
            for (int i=1;i<=n ;i++ )
            {
                for (int j=1;j<=m ;j++ )
                {
                    sum[i][j]=sum[i-1][j]+
                            sum[i][j-1]-sum[i-1][j-1]+matrix[i-1][j-1];
                }
            }
            int left=0,right=sum[n][m],res=0;
            while (left<=right)
            {
                int mid=(left+right)/2;
            /*对于题目输入示例中的情况
            输入示例
                4 4
                3332
                3233
                3332
                2323
                输出
                2
            sum矩阵为
            0 0  0  0  0
            0 3  6  9  11
            0 6  11 17 22
            0 9  17 26 33
            0 11 22 33 43
            mid依次为21->10->4->1->2
                            */
                if (ojbk(mid))
                {
                    left=mid+1;
                    res=mid;
                }
                else
                {
                    right=mid-1;
                }
            }
            System.out.println(res);
        }
        sc.close();
    }






}
