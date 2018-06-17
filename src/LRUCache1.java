import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache1 extends LinkedHashMap<Integer,Integer> {
    private int capacity;
    public LRUCache1(int capacity) {
        super(capacity,1,true);
        this.capacity=capacity;
    }
    public int get(int key) {
        Integer res=super.get(key);
        if(res==null) return -1;
        return res;
    }
    public void put(int key, int value) {
        super.put(key,value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return this.size() > capacity;
    }
}