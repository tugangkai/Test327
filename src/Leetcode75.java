import java.util.Arrays;

public class Leetcode75 {

//    给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//
//    此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
//
//    注意:
//    不能使用代码库中的排序函数来解决这道题。
//
//    示例:
//
//    输入: [2,0,2,1,1,0]
//    输出: [0,0,1,1,2,2]
//    进阶：
//
//    一个直观的解决方案是使用计数排序的两趟扫描算法。
//    首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
//    你能想出一个仅使用常数空间的一趟扫描算法吗？
public void swap(int []nums,int i,int j){
    int temp=nums[i];
    nums[i]=nums[j];
    nums[j]=temp;
}
    public void sortColors(int[] nums) {
        int start=0;
        int end=nums.length-1;
        int i=0;
        while(i<=end){
            if(nums[i]<1){
                if(i!=start){
                    swap(nums,i,start);
                    if(nums[i]>1){
                        swap(nums,i,end);
                        end--;
                    }
                }

                i++;  start++;
            }
            else if(nums[i]>1){
                while(nums[end]>1&&end>0){
                    end--;
                }
                if(end<i)
                    break;
                swap(nums,i,end);
                if(nums[i]<1){
                    swap(nums,i,start);
                    start++;
                }
                i++;end--;
            }else{
                i++;
            }




        }

    }

    public static void main(String[] args) {
        Leetcode75 l75=new Leetcode75();
        int []colors={0,1,0};
        l75.sortColors(colors);
       // System.out.println(Arrays.asList(colors));
        for(int i:colors){
            System.out.print(i+"\t");
        }
    }

}
