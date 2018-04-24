public class Leetcode43 {

    public String multiply(String num1, String num2) {
            if(num1.charAt(0)=='0'||num2.charAt(0)=='0')
                return "0";
            int []nums=new int[num1.length()+num2.length()];
            int len1=num1.length();
            int len2=num2.length();
            for(int i=len1-1;i>=0;i--){
                for(int j=len2-1;j>=0;j--){
                    int pos=len1-i-1+len2-j-1;
                    int li=num1.charAt(i)-'0';
                    int lj=num2.charAt(j)-'0';
                    int res=li*lj;
                    if(res>=10){
                        nums[pos+1]+=res/10;
                    }
                    nums[pos]+=res%10;
                    while(pos<nums.length){
                        if(nums[pos]>=10){
                            nums[pos+1]+=nums[pos]/10;
                            nums[pos]=nums[pos]%10;
                            pos++;
                        }else
                        {
                            break;
                        }

                    }



                }



            }
            StringBuilder sb=new StringBuilder();
            int k=nums.length-1;
            while(nums[k]==0){
                k--;
            }
            for(;k>=0;k--){

                    sb.append(nums[k]);

            }

            return sb.toString();

    }

    public static void main(String[] args) {
        Leetcode43 l43=new Leetcode43();
       String res=l43.multiply("456","456");
        System.out.println(res);
    }
}
