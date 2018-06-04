public class Leetcode88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //nums1中元素都往右移动n个位置
        for(int i=m-1;i>=0;i--){
            nums1[i+n]=nums1[i];

        }
        //数组s1的起点
        int s1=n;
        //数组s2的起点
        int s2=0;
        int cur=0;
        while(s2<n&&s1<nums1.length){
            if(nums1[s1]>nums2[s2]){
                nums1[cur++]=nums2[s2++];
            }else{
                nums1[cur++]=nums1[s1++];
            }

        }
        if(s2!=n){
            while(s2<n){
                nums1[cur++]=nums2[s2++];
            }


        }





    }
    public static void main(String[] args) {
            int []num1={1,2,8,0,0,0};
            int []num2={2,5,6};
            Leetcode88 l88=new Leetcode88();
            l88.merge(num1,3,num2,3);
            for(int i=0;i<num1.length;i++){
                System.out.println(num1[i]);
            }
    }

//从尾巴开始比较
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int index = m+n-1;
//        int index1 = m-1;
//        int index2 = n-1;
//        while(index1>=0&&index2>=0){
//            if(nums1[index1]<nums2[index2]){
//                nums1[index--] = nums2[index2--];
//
//            }else{
//                nums1[index--] = nums1[index1--];
//            }
//        }
//        while(index1>=0){
//            nums1[index--] = nums1[index1--];
//        }
//        while(index2>=0){
//            nums1[index--] = nums2[index2--];
//        }
//    }
}
