public class Leetcode410 {


//    Split Array Largest Sum
    private boolean valid(int[] nums, int m, long max){
        int cur = 0;
        int count = 1;
        //是否有多余m个片段or区间，大于给定值的max的，如果有了，那么就不合法了，因为这样划分就不止m个，及max太小
        for(int num: nums){
            cur += num;
            if(cur > max){
                cur = num;
                count++;
                if(count > m){
                    return false;
                }
            }
        }
        return true;
    }

//    int splitArray(vector<int>& nums, int m) {
//        vector<vector<int>> dp(m,vector<int>(nums.size(),0));
//        for (int i=0;i<nums.size();i++) dp[0][i] = (!i) ? nums[0] : dp[0][i-1]+nums[i];
//        for (int j=1;j<m;j++){
//            for (int i=j;i<nums.size();i++){
//                int res = INT_MAX;
//                int sum = 0;
//                for (int k = i;k>=j;k--){
//                    sum += nums[k];
//                    res = std::min(res, std::max(dp[j-1][k-1],sum));
//                }
//                dp[j][i] = res;
//            }
//        }
//        return dp[m-1][nums.size()-1];
//    }


//    public boolean check(int []nums,int m,int x){
//        int sum=0;
//        int cnt=1;
//        for(int i=0;i<nums.length;i++){
//            if(sum+nums[i]<=x){
//                sum+=nums[i];
//            }else{
//                cnt+=1;
//                if(nums[i]>x){
//                    return  false;
//                }
//                sum=nums[i];
//                if(cnt>m)return false;
//            }
//
//
//        }
//        return cnt<=m;
//
//
//    }
    public int splitArray(int []nums,int m){
        int max=0;
        int total=0;
        for(int i=0;i<nums.length;i++){
            total+=nums[i];
            max=Math.max(max,nums[i]);
        }
        while(max<total){
            int mid=(max+total)/2;
            if(valid(nums,m,mid)){
                total=mid;
            }else{
                max=mid+1;
            }
        }
        return max;

    }
}
