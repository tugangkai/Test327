public class Leetcode852 {

//    我们把符合下列属性的数组 A 称作山脉：
//
//    A.length >= 3
//    存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
//    给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
//
//
//
//    示例 1：
//
//    输入：[0,1,0]
//    输出：1
//    示例 2：
//
//    输入：[0,2,1,0]
//    输出：1
//
//
//    提示：
//
//            3 <= A.length <= 10000
//            0 <= A[i] <= 10^6
//    A 是如上定义的山脉

    public static void main(String[] args) {
        Leetcode852 l3=new Leetcode852();
        int []nums={3,4,5,1};
        int res=l3.peakIndexInMountainArray(nums);
        System.out.println(res);
    }
    public int peakIndexInMountainArray(int[] A) {
        int start=0;
        int end=A.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if((mid>0&&A[mid]>A[mid-1])&&(mid<A.length-1&&A[mid]>A[mid+1])){
                return mid;
            }
            if(mid>0&&A[mid]<A[mid-1])
                end=mid-1;
            else start=mid+1;


        }
        return -1;


    }


}
