package Common;

public class SelectSort {//选择排序
    public static  void selectSort(int []arr){

        int len=arr.length;
        for(int i=0;i<len-1;i++){
            int max=0;
            for(int j=0;j<len-i;j++){
                if(arr[j]>arr[max]){
                    max=j;
                }
            }
            int temp=arr[max];
            arr[max]=arr[len-i-1];
            arr[len-i-1]=temp;

        }


    }

    public static void main(String[] args) {
        int []arr={1,3,2,4,6,5,9,8};
        selectSort(arr);
        for(int i:arr){
            System.out.println(i);
        }
    }
}
