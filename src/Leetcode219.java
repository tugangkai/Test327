import java.util.HashMap;
import java.util.Map;

public class Leetcode219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();

        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],i);
            }else{
                int old=map.get(nums[i]);
                if(i-old==k){
                    return true;
                }
                map.put(nums[i],i);
            }

        }
        return false;
    }
}
