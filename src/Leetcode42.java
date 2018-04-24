import java.util.HashSet;
import java.util.LinkedList;

public class Leetcode42 {

//    给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//    上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
//
//    示例:
//
//    输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//    输出: 6


//
//
// 1 class Solution
// 2 {
//        3 public:
//        4     int trap(int A[], int n)
//        5     {
//            6         int res = 0, l = 0, r = n - 1;
//            7
//            8         while(l < r)
//                9         {
//                10             int minh = min(A[l], A[r]);
//                11             if(A[l] == minh)
//                    12                 while(++ l < r && A[l] < minh)
//                    13                     res += minh - A[l];
//                14             else
//                15                 while(l < -- r && A[r] < minh)
//                    16                     res += minh - A[r];
//                17         }
//            18
//            19         return res;
//            20     }
//        21 };





    public int trap(int[] height) {
        int len=height.length;
        if(len<=2)
            return 0;
       // int []indexes=new int [len/2+1];
       // int size=0;


       // HashSet<Integer> set=new HashSet<Integer>();
        LinkedList<Integer> list=new LinkedList<Integer>();
        int []maxs=new int[len];
        int max=0;
        for(int k=len-1;k>=0;k--) {
            if (height[k] > max) {
                max=height[k];
                maxs[k] = max;
            }
            maxs[k]=max;
        }


        for(int i=0;i<len-2;i++){

            //如果元素比之后的元素还要小，那么不符合凹型
            if(height[i]<=height[i+1])
                continue;
            for(int j=i+2;j<len;j++){
                if(height[j]==height[j-1])
                    continue;
                if(height[j]>=height[i+1]&&(height[j]>=height[i]||height[j]==maxs[j])){

                    list.add(i);
                    list.add(j);
                    i=j-1;
                    break;
                }


            }



        }
        System.out.println(list);
        int sum=0;
        while(!list.isEmpty()){
            int first=list.pollFirst();
            int second=list.pollFirst();
            int low=height[first]>height[second]?height[second]:height[first];
            sum+=low*(second-first-1);
         //   System.out.println(sum);
            for(int i=first+1;i<second;i++){
                sum-=height[i];
            }
        //    System.out.println(sum);

        }

        return sum;
        // Object []points=set.toArray();
//        for(int i=0;i<points.length-1;i++){
//
//            int height=points[i+1]>points[i]?(points[i]):points[i+1];
//
//
//
//        }
//        for(int i:set){
//
//
//
//        }



    }

    public static void main(String[] args) {
        int[] height={4,2,3};
        Leetcode42 l42=new Leetcode42();
        System.out.println(l42.trap(height));;;
//        int len=height.length;
//        int []maxs=new int[len];
//        int max=0;
//        for(int k=len-1;k>=0;k--) {
//            if (height[k] > max) {
//                max=height[k];
//                maxs[k] = max;
//            }
//            maxs[k]=max;
//        }
//        for(int k:maxs )
//            System.out.println(k);
    }

}
