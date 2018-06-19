import java.util.ArrayDeque;

public class Leetcode150 {

//    根据逆波兰表示法，求表达式的值。
//
//    有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
//
//    说明：
//
//    整数除法只保留整数部分。
//    给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
//    示例 1：
//
//    输入: ["2", "1", "+", "3", "*"]
//    输出: 9
//    解释: ((2 + 1) * 3) = 9
//    示例 2：
//
//    输入: ["4", "13", "5", "/", "+"]
//    输出: 6
//    解释: (4 + (13 / 5)) = 6
//    示例 3：
//
//    输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
//    输出: 22
//    解释:
//            ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
//            = ((10 * (6 / (12 * -11))) + 17) + 5
//            = ((10 * (6 / -132)) + 17) + 5
//            = ((10 * 0) + 17) + 5
//            = (0 + 17) + 5
//            = 17 + 5
//            = 22
//    private int curr = -1;
//    public int evalRPN(String[] tokens) {
//        if (curr == -1)
//            curr = tokens.length - 1;
//        String token = tokens[curr--];
//        char c = token.charAt(0);
//        if(token.length()==1 && "+-*/".indexOf(c)!=-1) {
//            int b = evalRPN(tokens);
//            int a = evalRPN(tokens);
//            switch (c) {
//                case '+': return a+b;
//                case '-': return a-b;
//                case '*': return a*b;
//                case '/': return a/b;
//                default:
//                    break;
//            }
//        }else {
//            return Integer.parseInt(token);
//        }
//        return curr;
//    }

    public int evalRPN(String []tokens){
        ArrayDeque<Integer> stack=new ArrayDeque();
        int len=tokens.length;
        int res=0;
        for(int i=0;i<len;i++){
            String s=tokens[i];
            switch(s){
                case "+":{
                    int op1=stack.pop();
                    int op2=stack.pop();
                    stack.push(op1+op2);
                }
                break;
                case "-":{
                    int op1=stack.pop();
                    int op2=stack.pop();
                    stack.push(op2-op1);
                }
                break;
                case "*":{
                    int op1=stack.pop();
                    int op2=stack.pop();
                    stack.push(op2*op1);
                }
                break;
                case "/":{
                    int op1=stack.pop();
                    int op2=stack.pop();
                    stack.push(op2/op1);
                }
                default:{
                    stack.push(Integer.parseInt(s));
                }
                break;

            }
        }
        return stack.pop();
    }
}
