package offer;

public class FindMinInRotatedArray {
    public int minNumberInRotateArray(int [] array) {

        int start=0;
        int end=array.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(array[mid]>array[mid+1])
                return  array[mid+1];
            else if(array[mid]>array[end])
                start=mid;
            else end=mid;


        }
        return -1;

    }


}
