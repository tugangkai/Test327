public class Leetcode96 {
    public static void main(String[] args) {
        Leetcode96 l96=new Leetcode96();
        int res=l96.numTrees(3);
        System.out.println(res);
    }

    public int numTrees(int n) {
        int []nums=new int[n+1];
        nums[0]=1;
        nums[1]=1;
        for(int k=2;k<=n;k++){
            int res=0;
            for(int j=1;j<=k;j++){
                    res+=nums[j-1]*nums[k-j];

            }
            nums[k]=res;
        }


        return nums[n];
    }
}
