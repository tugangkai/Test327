import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Interval{
    int start;
    int end;
    Interval(){start=0;end=0;}
    Interval(int s,int e){
        start=s;
        end=e;
    }

}

public class Leetcode56 {
//
//    给出一个区间的集合，请合并所有重叠的区间。
//
//    示例 1:
//
//    输入: [[1,3],[2,6],[8,10],[15,18]]
//    输出: [[1,6],[8,10],[15,18]]
//    解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//    示例 2:
//
//    输入: [[1,4],[4,5]]
//    输出: [[1,5]]
//    解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
    public class MyComparator implements Comparator<Interval>{


    @Override
    public int compare(Interval o1, Interval o2) {

        return o1.start>o2.start?1:(o1.start==o2.start?0:-1);
    }
}

public List<Interval> merge(List<Interval> intervals) {
//        LinkedList<Interval> ll=new LinkedList<Interval>();
//        ll.addAll(intervals);
        Collections.sort(intervals,new MyComparator());

        int len=intervals.size();
        if(len==1){
            return intervals;
        }
        for(int i=0;i<intervals.size()-1;i++){
            Interval o1=intervals.get(i);
            Interval o2=intervals.get(i+1);
            if(o1.end>=o2.start){
                if(o2.end<=o1.end)
                    o2.end=o1.end;
                o2.start=o1.start;
                intervals.remove(o1);

                //ll.addFirst(o3);
                i--;
            }
            }
    return intervals;


        }







    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        Leetcode56 l56=new Leetcode56();
        List<Interval> intervals=new LinkedList<Interval>();
        Interval i1=new Interval(1,4);
        Interval i2=new Interval(4,5);
        intervals.add(i1);
        intervals.add(i2);
        List<Interval> res= l56.merge(intervals);
        for(Interval interval:res){
            System.out.println(interval.start+":"+interval.end);
        }
        long end=System.currentTimeMillis();
        System.out.println("所花時間為:----->"+(end-start));
    }
}
