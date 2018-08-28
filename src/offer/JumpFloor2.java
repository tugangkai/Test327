package offer;

public class JumpFloor2 {
    public int JumpFloorII(int target) {
        int a[]=new int[target+1];
        a[0]=1;
        a[1]=1;
        for(int i=1;i<=target;i++)
        {
            for(int j=0;j<i;j++){
                a[i]+=a[j];
            }
        }
        return  a[target];

    }


}
