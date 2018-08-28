package Common;

public class BubbleSor {

    public static void  bubbleSort(int []arr){
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }


        }




    }

    public static void main(String[] args) {
        int arr[]={2,1,3,5,4,8,7,9};
        bubbleSort(arr);
        for(int i:arr){
            System.out.println(i);
        }
    }

}
