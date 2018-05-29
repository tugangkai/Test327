public class Leetcode66 {

//    给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组。
//
//    最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
//
//    你可以假设除了整数 0 之外，这个整数不会以零开头。
//
//    示例 1:
//
//    输入: [1,2,3]
//    输出: [1,2,4]
//    解释: 输入数组表示数字 123。
//    示例 2:
//
//    输入: [4,3,2,1]
//    输出: [4,3,2,2]
//    解释: 输入数组表示数字 4321。
    public int[] plusOne(int[] digits) {
        int len=digits.length;
        digits[len-1]++;
        boolean flag=false;
        for(int j=len-1;j>=0;j--){
            if(digits[j]>=10){
                digits[j]-=10;

                if(j-1<0){
                    flag=true;
                }else{
                    digits[j-1]+=1;
                }

            }else{
                break;
            }

        }
        if(flag){
            int []res=new int[len+1];
            int i=0;
            res[i++]=1;
            while(i<len+1){
                res[i]=digits[i-1];
                i++;
            }
            return res;
        }



        return digits;
    }

    public static void main(String[] args) {
        Leetcode66 l66=new Leetcode66();
        int []digits=new int []{

                1,2,3,4
        };
        l66.plusOne(digits);
        for(int i:digits){
            System.out.println(i);
        }
    }
}
