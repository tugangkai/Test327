import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
  class Point {
     int x;
     int y;
     Point() { x = 0; y = 0; }
     Point(int a, int b) { x = a; y = b; }
 }
public class Leetcode149 {
    public int maxPoints(Point[] points) {
        if (points.length < 3) return points.length;

        int max=Integer.MIN_VALUE;
        for(int i=0;i<points.length;i++){
            int samePoints=1;
            int sameSlope=0;
            for(int j=i+1;j<points.length;j++){//第二个点
                int  x_dis1=points[j].x-points[i].x;
                int y_dis1=points[j].y-points[i].y;
                if(x_dis1==0&&y_dis1==0){
                    samePoints++;
                }else{
                    sameSlope++;
                    for(int k=j+1;k<points.length;k++){
                        int x_dis2=points[k].x-points[i].x;
                        int y_dis2=points[k].y-points[i].y;
                        if((long)y_dis2*(long)x_dis1==(long)y_dis1*(long)x_dis2){
                            sameSlope++;
                        }
                    }

                }
                max=Math.max(max,sameSlope+samePoints);
                sameSlope=1;


            }



        }




        return max;
    }
//[[0,0],[94911151,94911150],[94911152,94911151]]
    public static void main(String[] args) {
        Point []points={
                new Point(1,1),
                new Point(3,2),
                new Point(5,3),
                new Point(4,1),
                new Point(2,3),
                new Point(1,4)
        };
        Leetcode149 l149=new Leetcode149();
        int res=l149.maxPoints(points);
        System.out.println(res);
    }
}
