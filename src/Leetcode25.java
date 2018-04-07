public class Leetcode25 {


    //无需移动数组元素的操作

//    public int removeDuplicates(int[] nums) {
//        if( nums.length == 0 )
//            return 0;
//        int n = 0;
//        int count = 1;
//        for(int i = 1; i < nums.length; i++){
//            if(nums[i] != nums[n]){
//                nums[++n] = nums[i];
//                count++;
//            }
//
//        }
//        return count;
//    }

    public int removeDuplicates(int []nums){
        if(nums==null){
            return 0;
        }
        if(nums.length==1)
            return 1;
        //当前数组的长度
        int tempSize=nums.length;
        int start=0,end=0;

        for(int i=1;i<tempSize;i++){
            if(nums[i]==nums[i-1]) {
                if(i==tempSize-1){
                    //无需移动只需要将tempSize减小到一定程度
                    tempSize=tempSize-(end-start+1);
                }else {
                    end = i;
                }
            }
            else{
                if(end==start)
                {
                    start=end=i;
                }else{//后面的元素往前移动
                    int len=end-start;
                    for(int j=end;j<tempSize;j++){
                        nums[j-len]=nums[j];
                    }
                    i=start+1;
                    tempSize=tempSize-len;
                    start=end=i;

                }
            }


        }

        return tempSize;
    }

    public static void main(String[] args) {
        int []nums={1,1};
        Leetcode25 l25=new Leetcode25();
        int size=l25.removeDuplicates(nums);
        System.out.println(size);
    }
}
