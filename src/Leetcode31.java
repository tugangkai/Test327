public class Leetcode31 {
//    public int getFactorial(int n){
//        int sum=1;
//        for(int i=1;i<=n;i++){
//            sum*=i;
//
//        }
//        return sum;
//    }
//    public int dxnum(int i,String s){
//        int len=s.length();
//        int total=0;
//        for(int j=i+1;j<len;j++)
//        {
//            if(s.charAt(i)-s.charAt(j)>0)
//                total++;
//        }
//        return total;
//    }
//    public void nextPermutation(int []nums){
//            int len=nums.length;
//            int val=0;
//            for(int i=0;i<len-1;i++){
//                int gere=getFactorial(len-i-1);
//                val+=dxnum(i,s)*gere;
//            }
//            int[] bitmap=new int[len];
//            for(int i=0;i<len;i++){
//                bitmap[i]=i+1;
//            }
//            val=val+1;
//
//
//            int maxval=getFactorial(len)-1;
//            if(val>maxval)
//                val=0;
//            for(int i=0;i<len;i++){
//                int gere=getFactorial(len-i-1);
//                int t=0;
//                while(val-gere>=0){
//                    t++;
//                    val-=gere;
//                }
//
//
//
//            }
//
//
//
//    }
public void nextPermutation(int[] nums) {
    int len = nums.length;
    int i = 0;
    for(i = len - 1; i > 0; i--){
        if(nums[i-1] >= nums[i]){
            continue;
        }else{
            for(int j = len - 1; j >= i ; j--){
                if(nums[j] <= nums[i-1]){
                    continue;
                }else{
                    int a = nums[i-1];
                    nums[i-1] = nums[j];
                    nums[j] = a;
                }
                break;
            }
            break;
        }
    }
    swap(nums,i,len-1);
}

    private void swap(int[] nums, int left, int right) {
        // TODO Auto-generated method stub
        int temp = 0;
        while(left < right){
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }


}
