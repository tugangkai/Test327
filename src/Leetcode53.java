public class Leetcode53 {
    /**
     * 最大连续子数组和，
     *
     *  int []array={-1,-1,-2,-2};
     * @param array
     * @param start
     * @param end
     * @return
     */
    public int findMaxNumArray(int []array,int start,int end){
        if(start==end)
            return array[start];
        int mid=(start+end)/2;
        int l_max=Integer.MIN_VALUE,r_max=Integer.MIN_VALUE;
        int l=findMaxNumArray(array,start,mid);
        int sum=0;
        for(int i=mid;i>=start;i--)
        {
            sum+=array[i];
            if(sum>l_max){
                l_max=sum;
            }
        }
        int r=findMaxNumArray(array,mid+1,end);
        int total=0;
        for(int j=mid+1;j<=end;j++){
            total+=array[j];
            r_max=total>r_max?total:r_max;
        }
        if(l>=r&&l>=(r_max+l_max)) return l;
        else if(r>=l&&r>=(r_max+l_max)) return r;
        else return r_max+l_max;





    }

    public static void main(String[] args) {
        Leetcode53 l53=new Leetcode53();
        int []array={-1,-1,-2,-2};
       int max=l53.findMaxNumArray(array,0,array.length-1);
        System.out.println(max);
    }
}
