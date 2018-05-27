import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode57 {

//    List<Interval> res = new ArrayList<>();
//        if(intervals.size() == 0) {
//        res.add(newInterval);
//        return res;
//    }
//    int len = intervals.size();
//    int l = newInterval.start ,r = newInterval.end;
//    boolean insert = false;
//        for(int t = 0; t < len; t++){
//        Interval temp = intervals.get(t);
//        if(temp.end >= newInterval.start && temp.start <= l){
//            l = temp.start;
//        }
//        if(temp.start <= newInterval.end && temp.end >= r){
//            r = temp.end;
//            continue;
//        }
//        if(temp.start > r && !insert) {
//            insert = true;
//            res.add(new Interval(l,r));
//        }
//        if(temp.start > newInterval.end || temp.end < newInterval.start) {
//            res.add(temp);
//        }
//    }
//        if(!insert)
//            res.add(new Interval(l, r));
//        return res;


//    给出一个无重叠的 ，按照区间起始端点排序的区间列表。
//
//    在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
//
//    示例 1:
//
//    输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
//    输出: [[1,5],[6,9]]
//    示例 2:
//
//    输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//    输出: [[1,2],[3,10],[12,16]]
//    解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> list = new ArrayList<Interval>();
        //边界情况
        if(intervals.size() == 0){
            list.add(newInterval);
            return list;
        }
        //循环判断
        for(int i = 0; i < intervals.size();i++){
            //如果新的区间结束值小于开始值，则直接插入前面，后面依次插入即可
            if(newInterval.end < intervals.get(i).start){
                list.add(newInterval);
                for(int j = i; j < intervals.size(); j++){
                    list.add(intervals.get(j));
                }
                break;
            }
            //新的区间开始点大于结束点，则当前点直接添加结果集
            else if(newInterval.start > intervals.get(i).end){
                list.add(intervals.get(i));
            }
            //需要合并的情况
            else{
                //合并区间
                newInterval.start = Math.min(newInterval.start,intervals.get(i).start);
                newInterval.end = Math.max(newInterval.end,intervals.get(i).end);
            }
            if(i == intervals.size() - 1){//如果是最后一个数据。也添加结果集中
                list.add(newInterval);
            }
        }
        return list;
    }



}
