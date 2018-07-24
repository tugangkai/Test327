package offer;

import java.util.Stack;

public class TwoStackToRealizeQueue {

    public static void main(String[] args) {
        TwoStackToRealizeQueue ll=new TwoStackToRealizeQueue();
        ll.push(11);
        ll.push(22);
        System.out.println(ll.pop());
        System.out.println(ll.pop());
        System.out.println(ll.pop());
    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.isEmpty()){
            if(stack1.isEmpty()){
                return -1;
            }
            while(!stack1.isEmpty())
            {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }else{
          return    stack2.pop();
        }

    }

}
