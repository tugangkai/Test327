//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//
//        示例 1:
//
//        输入: [3,2,1,5,6,4] 和 k = 2
//        输出: 5
//        示例 2:
//
//        输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//        输出: 4

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leetcode215 {

    public void swap(int []nums,int start,int end){
        int temp=nums[start];
        nums[start]=nums[end];
        nums[end]=temp;
    }
    public int partition(int []nums,int start,int end){
        int val=nums[end];
        int e=end;
        while(start<end){
            while(start<end){
                if(nums[start]>val){
                    break;
                }
                start++;
            }
            while(end>start){
                if(nums[end]<val){
                    break;
                }
                end--;
            }
            swap(nums,start,end);
        }
        swap(nums,start,e);
        return start;

    }


    public int findKthLargest(int[] nums, int k) {
       int start=0;
       int end=nums.length-1;
       k=end-k+1;
       int q=partition(nums,start,end);
       while(q!=k){
           if(q>k){
               q=partition(nums,start,q-1);
           }else{
               q=partition(nums,q+1,end);
           }



       }
       return nums[k];
    }

    public static void main(String[] args) {
        int []nums={3,2,1,5,6,4};
        Leetcode215 ll=new Leetcode215();
        int res=ll.findKthLargest(nums,4);
        System.out.println(res);
    }


}

//    public int findKthLargest(int[] nums, int k) {
//        if (nums.length == 1) {
//            return nums[0];
//        }
//
//        int max = nums[0];
//        int min = nums[0];
//        for (int i : nums) {
//            if (i > max) {
//                max = i;
//            } else if (i < min) {
//                min = i;
//            }
//        }
//
//        int[] array = new int[max - min + 1];
//        for (int i : nums) {
//            array[max - i]++;
//        }
//
//        int number = 0;
//        for (int i = 0; i < array.length; i++) {
//            number += array[i];
//            if (number >= k) {
//                return max - i;
//            }
//        }
//        return 0;
//    }