package Common;

public class HeapSort {

    public void siftdown(int []arr,int n,int end){
        int len=end;
        while(n<len){
            int left=2*n;
            int right=2*n+1;
            if(left>=len)
                break;
            int max=0;
            if(right>=len||arr[left]>arr[right])
                max=left;
            else max=right;
            if(arr[n]>arr[max])
                break;
            int temp=arr[n];
            arr[n]=arr[max];
            arr[max]=temp;

            n=max;

        }



    }

    public void heapSort(int []arr){
        int len=arr.length;
        int end=len-1;
        for(int i=end/2;i>=1;i--){
            siftdown(arr,i,len-1);
        }
        for(int j=end;j>=1;j--){
            int temp=arr[j];
            arr[j]=arr[1];
            arr[1]=temp;
            siftdown(arr,1,j);
        }

    }
    public static void main(String[] args) {
        int arr[]={5,2,1,3,5,4,8,7};
        HeapSort hs=new HeapSort();
        hs.heapSort(arr);
        for(int i=0;i<=arr.length-1;i++)
        {
            System.out.println(arr[i]);
        }
    }
}
