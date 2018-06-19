import java.util.ArrayDeque;

class MinStack{
    private ArrayDeque<Integer> stack=new ArrayDeque();
    private ArrayDeque<Integer> minStack=new ArrayDeque();
    public MinStack(){

    }
    public void push(int x){
        stack.push(x);
        if(minStack.isEmpty())
            minStack.push(x);
        else{
            int top=minStack.peek();
            if(top<x){
                minStack.push(top);
            }else{
                minStack.push(x);
            }
        }
    }
    public void pop(){
        if(!stack.isEmpty()){
            minStack.pop();
            stack.pop();
        }
    }
    public int top() {
        return stack.peek();
    }
    public int getMin(){
       if(!minStack.isEmpty())
           return minStack.peek();
       else
           return -1;
    }
}
public class Leetcode155 {


}
