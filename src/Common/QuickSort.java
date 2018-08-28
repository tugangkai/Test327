package Common;

public class QuickSort {
    public int pivot(int arr[],int start,int end){
        int r=arr[end];
        int rr=end;
        while(start<end){

            while(start<end){
                if(arr[start]<=r){
                    start++;
                }else{
                    break;
                }
            }
            while(end>start){
                if(arr[end]>=r){
                    end--;
                }else{
                    break;
                }
            }
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;




        }
        int temp=arr[end];
        arr[end]=r;
        arr[rr]=temp;
        return end;

    }
    public void quickSort(int []arr,int start,int end){


        //int end=arr.length-1;
        if(start<end){
            int pivot=pivot(arr,start,end);
            quickSort(arr,start,pivot-1);
            quickSort(arr,pivot+1,end);
        }


    }

    public static void main(String[] args) {
        QuickSort qs=new QuickSort();
        int arr[]={1,3,2,5,4,6,5};
        qs.quickSort(arr,0,arr.length-1);
        for(int i:arr){
            System.out.println(i);
        }
    }
}
