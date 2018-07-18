package tree;

import java.util.*;

public class Leetcode582 {
    public static void main(String[] args) {
        Integer []pid={1,3,10,5};
        Integer []ppid={3,0,5,3};
        Leetcode582 ll=new Leetcode582();
        List<Integer> res=ll.killProcess(Arrays.asList(pid),Arrays.asList(ppid),5);
        for(Integer ss:res){
            System.out.println(ss);
        }
    }

    public void dfs(HashMap<Integer,List<Integer>> map,List<Integer> list,int kill){
        list.add(kill);
        if(map.containsKey(kill)){
            for(int ss:map.get(kill)){
                dfs(map,list,ss);
            }
        }
        return;

    }



    public List<Integer> killProcess(List<Integer> pid,List<Integer> ppid,int kill){
        HashMap<Integer,List<Integer>> map=new HashMap<Integer,List<Integer>>();
        int ps=pid.size();
        for(int i=0;i<ps;i++){
            int parent =ppid.get(i);
            int children=pid.get(i);
            if(map.containsKey(parent)){
                map.get(parent).add(children);
            }else{
                List<Integer> list=new ArrayList<Integer>();
                list.add(children);
                map.put(parent,list);
            }
        }
        List<Integer> killList=new ArrayList<>();
        dfs(map,killList,kill);
        // System.out.println(map.size());
        return killList;

    }
//    public List<Integer> killProcess2(List<Integer> pid,List<Integer> ppid,int kill){
//        HashMap<Integer,List<Integer>> map=new HashMap<Integer,List<Integer>>();
//        int ps=pid.size();
//        for(int i=0;i<ps;i++){
//            int parent =ppid.get(i);
//            int children=pid.get(i);
//            if(map.containsKey(parent)){
//                map.get(parent).add(children);
//            }else{
//                List<Integer> list=new ArrayList<Integer>();
//                list.add(children);
//                map.put(parent,list);
//            }
//        }
//       // System.out.println(map.size());
//        ArrayDeque<Integer> queue=new ArrayDeque();
//        List<Integer> killlist=new ArrayList<>();
//        queue.push(kill);
//        while(!queue.isEmpty())
//        {
//            int parent=queue.poll();
//            killlist.add(parent);
//            if(map.containsKey(parent)){
//                for(int children:map.get(parent))
//                {
//                    queue.offer(children);
//                }
//            }
//
//        }
//      //  System.out.println(killlist.size());
//        return killlist;
//
//    }
    public List<Integer> killProcess1(List<Integer> pid, List<Integer> ppid, int kill){
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans.add(kill);
        for (int i = 0; i < ppid.size(); i++) {
            if (ppid.get(i) == kill) {
                ans.addAll(killProcess(pid, ppid, pid.get(i)));
            }
        }
        return ans;

    }
}
