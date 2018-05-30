public class Leetcode69 {
    public int mySqrt(int x) {
        if(x==1)
            return 1;
        int start=0;
        int end=x;
        int mid=0;
        while(start<=end){
            mid=(start+end)/2;
            int tmp=mid*mid;
            int s1=(mid+1)*(mid+1);
            int s2=(mid-1)*(mid-1);
            if(tmp==x)
                return mid;
            else if(tmp>x&&s2<x)
                return mid-1;
            else if(tmp<x&&s1>x)
                return mid;
            if(x==s2)
                return mid-1;
            else if(x==s1)
                return mid+1;
            if(x<tmp)
                end=mid-1;
            else
                start=mid+1;





        }

        return -1;


    }

    public static void main(String[] args) {
        Leetcode69 l69=new Leetcode69();
        int res= l69.mySqrt(1);
       // System.out.println(46340*46340);
        System.out.println(res);

        Math.sqrt(100);
    }
}
