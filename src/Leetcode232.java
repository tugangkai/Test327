import java.util.LinkedList;

//使用栈实现队列的下列操作：
//
//        push(x) -- 将一个元素放入队列的尾部。
//        pop() -- 从队列首部移除元素。
//        peek() -- 返回队列首部的元素。
//        empty() -- 返回队列是否为空。
//        示例:
//
//        MyQueue queue = new MyQueue();
//
//        queue.push(1);
//        queue.push(2);
//        queue.peek();  // 返回 1
//        queue.pop();   // 返回 1
//        queue.empty(); // 返回 false
//        说明:
//
//        你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
//        你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
//        假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
//        在真实的面试中遇到过这道题？
public class Leetcode232 {
    /** Initialize your data structure here. */
    private LinkedList<Integer> stack1;
    private LinkedList<Integer> stack2;

    public Leetcode232() {
        stack1=new LinkedList();
        stack2=new LinkedList();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
       // return stack2.pop();
        if(stack2.isEmpty()) return -1;
        else return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty()&&stack2.isEmpty();
    }
}