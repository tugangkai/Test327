import java.util.HashMap;
import java.util.PriorityQueue;

class DoubleLinkedListNode{
    DoubleLinkedListNode pre;
    DoubleLinkedListNode next;
    int key;
    int val;
    public DoubleLinkedListNode(int key,int val){
        this.key=key;
        this.val=val;
    }
}

class LRUCache{
    private HashMap<Integer,DoubleLinkedListNode> map;
    private DoubleLinkedListNode head;
    private DoubleLinkedListNode tail;
    private int size=0;
    private int capacity;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap(capacity);
    }

    public int get(int key) {
        if(map.containsKey(key)){

            DoubleLinkedListNode node=map.get(key);

            if(node==head)
                return node.val;
            DoubleLinkedListNode prev=node.pre;
            prev.next=node.next;
            if(node!=tail)
                node.next.pre=prev;
            else{
                tail=prev;
            }
            node.pre=null;
            node.next=head;
            head.pre=node;
            head=node;
            return node.val;
        }else{
            return -1;
        }

    }

    public void put(int key, int value) {
        if(!map.containsKey(key)){
            if(size==capacity){
                //移除最后一个节点，并将新节点添加到双向链表头部；
                if(size==1){
                    map.clear();
                    head=tail=new DoubleLinkedListNode(key,value);
                    map.put(key,head);
                    return;
                }
                DoubleLinkedListNode prev=tail.pre;
                map.remove(tail.key);
                tail.pre=null;
                prev.next=null;
                tail=prev;
                DoubleLinkedListNode newNode=new DoubleLinkedListNode(key,value);
                head.pre=newNode;
                newNode.next=head;
                head=newNode;
                map.put(key,newNode);

            }else{
                if(head==null) {
                   tail= head = new DoubleLinkedListNode(key, value);
                   size++;
                    map.put(key,head);
                }else {
                    DoubleLinkedListNode newNode=new DoubleLinkedListNode(key,value);
                    head.pre=newNode;
                    newNode.next=head;
                    head=newNode;
                    map.put(key,newNode);
                    size++;
                }
            }
        }else{
            DoubleLinkedListNode node=map.get(key);
            node.val=value;
            if(node!=head)
            {
                node.pre.next=node.next;
                if(node!=tail)
                 node.next.pre=node.pre;
                else
                    tail=node.pre;
                node.next=head;
                head.pre=node;
                node.pre=null;
                head=node;
            }


        }
    }
}
public class Leetcode146 {
//    运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
//
//    获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
//    写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
//
//    进阶:
//
//    你是否可以在 O(1) 时间复杂度内完成这两种操作？
//
//    示例:
//
//    LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得密钥 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得密钥 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
public static void main(String[] args) {
  LRUCache cache=new LRUCache(2);
  cache.put(2,1);
  cache.put(1,1);
  //  System.out.println(cache.get(2));;
  cache.put(2,3);
 //   System.out.println(cache.get(2));;
   cache.put(4,1);
    System.out.println(cache.get(1));
    System.out.println(cache.get(2));
   // System.out.println(cache.get(3));
   //System.out.println(cache.get(4));


}
}
