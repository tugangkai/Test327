import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leetcode46Test {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i:nums){
            System.out.println(i);
        }
        permute(list,nums,0);
        return list;
    }
    public void swap(int []num,int start,int end){
        int temp=num[start];
        num[start]=num[end];
        num[end]=temp;

    }
    public void permute(List<List<Integer>> res,int []num,int level){
        if(level>=num.length){
            List<Integer> list=new ArrayList<Integer>();
            for(int i=0;i<num.length;i++){
                list.add(num[i]);
            }
            res.add(list);

        }else{
            for(int j=level;j<num.length;j++){
                if(j!=level){
                    if((j>=1&&num[j]==num[j-1])||num[j]==num[level]){
                        continue;
                    }
                }

                System.out.println("haha");
//                if((j>=1&&num[j]==num[j-1])){
//                    //j++;
//                    continue;
//                }
//                if(num[j]==num[level]&&j!=level){
//                    continue;
//                }
              //  System.out.println("res");
                swap(num,level,j);
                permute(res,num,level+1);
                swap(num,level,j);
            }

        }
    }
    public static void main(String[] args) {
       // List<List<Integer>> list=new ArrayList<List<Integer>>();
        Leetcode46Test test=new Leetcode46Test();
        int []sum={0,0,0,1,9};
       // test.permute(list,sum,0);
        List<List<Integer>> list=test.permuteUnique(sum);
        for(List<Integer> li:list){
            for(int i:li){
                System.out.print(i+"\t");
            }
            System.out.println();
        }
        System.out.println(list.size());
    }
}
