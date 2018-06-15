public class Leetcode134 {
//    在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
//
//    你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
//
//    如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
//
//    说明:
//
//    如果题目有解，该答案即为唯一答案。
//    输入数组均为非空数组，且长度相同。
//    输入数组中的元素均为非负数。
//    示例 1:
//
//    输入:
//    gas  = [1,2,3,4,5]
//    cost = [3,4,5,1,2]
//
//    输出: 3
//
//    解释:
//    从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
//    开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
//    开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
//    开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
//    开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
//    开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
//    因此，3 可为起始索引。
public int canCompleteCircuit(int[] gas, int[] cost) {
    int total=0;
    int len=gas.length;
    int []dif=new int[len];
    for(int i=0;i<len;i++){
        dif[i]=gas[i]-cost[i];
      total+=gas[i]-cost[i];
    }
    if(total<0)
        return -1;
    int i=0;
    while(i<len){
        for(;dif[i]<0;i++);
        int k=i;
        int temp=dif[k++];
        boolean flag=true;
        while(k%len!=i){
            temp+=dif[k++%len];
            if(temp<0){
                flag=false;
                break;
            }
        }
        if(flag)
            return i;
        i++;
    }
    return -1;
}

    public static void main(String[] args) {
        Leetcode134 l134=new Leetcode134();
        int []gas={4,5,2,6,5,3};
        int []cost={3,2,7,3,2,9};
        int res=l134.canCompleteCircuit(gas,cost);
        System.out.println(res);
    }
//    [4,5,2,6,5,3]
//            [3,2,7,3,2,9]
}
//（证明貌似不难，以后有时间再补）
//
//        有了这个定理，判断到底是否存在这样的解非常容易，只需要把全部的油耗情况计算出来看看是否大于等于0即可。
//
//        那么如何求开始位置在哪？
//
//        注意到这样一个现象：
//
//        1. 假如从位置i开始，i+1，i+2...，一路开过来一路油箱都没有空。说明什么？说明从i到i+1，i+2，...肯定是正积累。
//        2. 现在突然发现开往位置j时油箱空了。这说明什么？说明从位置i开始没法走完全程(废话)。那么，我们要从位置i+1开始重新尝试吗？不需要！为什么？因为前面已经知道，位置i肯定是正积累，那么，如果从位置i+1开始走更加没法走完全程了，因为没有位置i的正积累了。同理，也不用从i+2，i+3，...开始尝试。所以我们可以放心地从位置j+1开始尝试。
//    int canCompleteCircuit(vector<int> &gas, vector<int> &cost) {
//        int start = 0; // 起始位置
//        int remain = 0; // 当前剩余燃料
//        int debt = 0; // 前面没能走完的路上欠的债
//
//        for (int i = 0; i < gas.size(); i++) {
//            remain += gas[i] - cost[i];
//            if (remain < 0) {
//                debt += remain;
//                start = i + 1;
//                remain = 0;
//            }
//        }
//
//        return remain + debt >= 0 ? start : -1;
//    }