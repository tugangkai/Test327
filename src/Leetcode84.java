import java.util.LinkedList;

public class Leetcode84 {
//    给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//
//    求在该柱状图中，能够勾勒出来的矩形的最大面积。
//
//
//
//    以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
//
//
//
//    图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
//
//
//
//    示例:
//
//    输入: [2,1,5,6,2,3]
//    输出: 10

    /**
     *
     * 暂时可以使用两种方法来实现这道题目。一种是用栈的方法来维护一个递增栈，对于
     * 那些不符合递增的元素进行弹出，计算弹出元素的局部解后，在将其更改为将要入栈的元素的值
     * 在逐一压入栈，最后元素全部压入栈后，从栈顶逐一弹出栈元素，然后计算其到最右边数组元素
     * 矩形面积，最后可以得到一个最大的矩形面积
     *
     * 第二种做法就比较简单
     * 利用两个数组，一个数组是保存数组元素向左最大能够扩展到哪个数组的位置，
     * 一个数组是保存数组元素向右最大能够扩展到哪个数组的位置。最后针对每个
     * 数组元素，矩形的面积等于(向右最大位置-向左最大位置+1)*数组元素的值。
     *
     *
     * @param heights
     * @return
     */



    //使用栈来维护一个递增的栈，如果不满要求，将元素逐一弹出，计算局部的解，最后计算全局解
    public int largestRectangleArea(int[] heights) {


        LinkedList<Integer> list=new LinkedList<Integer>();
        int max=0;
        int len=heights.length;
        for(int i=0;i<len;i++){
            if(list.isEmpty()||list.peek()<=heights[i]){
                list.push(heights[i]);
            }else{
                int count=0;
                while(!list.isEmpty()&&list.peek()>heights[i]){
                    count++;
                    int cur=list.pop();
                    max=Math.max(max,cur*count);
                }
                while(count>=0){
                    count--;
                    list.push(heights[i]);
                }

            }



        }

        int count=0;
        while(!list.isEmpty())
        {
          count++;
          max=Math.max(list.pop()*count,max);
        }
        return max;



    }

    public static void main(String[] args) {
        Leetcode84 l84=new Leetcode84();
        int []array={2,1,5,6,2,3};
        int max=l84.largestRectangleArea(array);
        System.out.println(max);
    }
//    public int largestRectangleArea(int[] heights) {
//        int[] left = new int[heights.length];
//        int[] right = new int[heights.length];
//        for (int i = 0; i < heights.length; i++) {
//            if (i == 0) {
//                left[0] = 0;
//            }
//            else {
//                int k;
//                for (k = i; k > 0 && heights[k-1] >= heights[i]; k = left[k-1])
//                    ;
//                left[i] = k;
//            }
//        }
//
//        for (int i = heights.length - 1; i >= 0; i--) {
//            if (i == heights.length-1) {
//                right[i] = i;
//            }
//            else {
//                int k;
//                for (k = i; k < heights.length - 1 && heights[k+1] >= heights[i]; k = right[k+1])
//                    ;
//                right[i] = k;
//            }
//        }
//
//        int res = 0;
//
//        for (int i = 0; i < heights.length; i++) {
//            res = Math.max(res, heights[i] * (right[i] - left[i] + 1));
//        }
//
//        return res;
//    }
//}
}
