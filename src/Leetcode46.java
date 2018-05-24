import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//给定一个没有重复数字的序列，返回其所有可能的全排列。
//
//        示例:
//
//        输入: [1,2,3]
//        输出:
//        [
//        [1,2,3],
//        [1,3,2],
//        [2,1,3],
//        [2,3,1],
//        [3,1,2],
//        [3,2,1]
//        ]
public class Leetcode46 {


    public List<List<Integer>> result = new ArrayList<>();

/** 解法为8ms的解法可以参考下*/
//    public List<List<Integer>> permute(int[] nums) {
//
//        if(nums.length == 0)
//            return result;
//        getList(nums, 0);
//        return result;
//    }
//
//    private void getList( int[] nums, int idx) {
//
//        if(idx == nums.length-1){
//            List<Integer> list = new ArrayList<>();
//            for (Integer integer : nums){
//                list.add(integer);
//            }
//            result.add(list);
//        }
//        int temp = 0;
//        for(int i = idx; i < nums.length; i++){
//            temp = nums[idx];
//            nums[idx] = nums[i];
//            nums[i] = temp;
//            getList(nums, idx+1);
//            temp = nums[idx];
//            nums[idx] = nums[i];
//            nums[i] = temp;
//        }
//    }



    public int[] next(int []nums){
        int len=nums.length;
        int k=0;
        for(int i=len-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                k=i-1;
                break;
//                int temp=nums[i];
//                nums[i]=nums[i-1];
//                nums[i-1]=temp;
//                break;
            }
        }
        //翻转
        int left=k;
        int right=len-1;
        if(left!=right){

            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
        }
        left++;
//        System.out.println(left);
//        System.out.println(right);
        while(left<right){
            System.out.println("ssss");
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
        System.out.println(nums[4]);
        for(int i:nums){
            System.out.println(i);
        }
        return nums;

    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> flist=new ArrayList<List<Integer>>();
        List<List<Integer>> nlist=new ArrayList<List<Integer>>();
       List<Integer> list=new ArrayList<Integer>();
       list.add(nums[0]);
       flist.add(list);
            //数组剩余元素（带插入)
        for(int j=1;j<nums.length;j++){
                int size=flist.size();
                //遍历总列表下main的所有列表
                for(int k=0;k<size;k++){
                 // List<Integer> li=new ArrayList<Integer>();
                    int ss=flist.get(k).size();
                    //插入位置，每插入一个生成一个列表
                    for(int i=0;i<=ss;i++){
                        List<Integer> li=flist.get(k);
                        List<Integer> anotherr= new ArrayList<Integer>();
                        anotherr.addAll(li);
                        anotherr.add(i,nums[j]);
                        nlist.add(anotherr);
                    }
                }
                flist.clear();
                flist.addAll(nlist);
                nlist.clear();
            System.out.println(flist);

        }
        return flist;


    }

    public static void main(String[] args) {
        Leetcode46 ll=new Leetcode46();
        int []values={1,2,3,4,5};
        List<List<Integer>> list=ll.permute(values);
        for(List<Integer> mlist:list){
            for(Integer i:mlist){
                System.out.print(i+" ");
            }
            System.out.println();
        }


//        int nums[]={1,2,3,4,5};
//        Leetcode46 l446=new Leetcode46();
//        int []nums2=l446.next(nums);
//       // nums2=l446.next(nums2);
//
//        for(int i:nums){
//            System.out.println(i);
//        }
    }
}
