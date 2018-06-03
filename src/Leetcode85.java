import java.util.LinkedList;

public class Leetcode85 {
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

    public int maximalRectangle(char [][]matrix){
        if(matrix.length==0)
            return 0;
        int []heights=new int[matrix[0].length];
        int maxArea=-1;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='0')
                    heights[j]=0;
                else
                    heights[j]++;


            }
            maxArea=Math.max(largestRectangleArea(heights),maxArea);

        }
        return maxArea;
    }
}
