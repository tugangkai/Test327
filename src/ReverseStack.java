import java.util.LinkedList;

public class ReverseStack {





    public static int getAndRemoveLast(LinkedList<Integer> list){
        int x=0;
        if(list.size()==1)
            return list.pop();
        int p=list.pop();
        x=getAndRemoveLast(list);
        list.push(p);
        return x;


    }

    public static  void reverseStack(LinkedList<Integer> list){

        if(list.isEmpty())
            return;
        int last=getAndRemoveLast(list);
        reverseStack(list);
        list.push(last);
        return ;

    }
    public static void main(String[] args) {
        LinkedList<Integer> list=new LinkedList();
        list.push(1);
        list.push(2);
        list.push(3);
        System.out.println(list);
       // int num=getAndRemoveLast(list);
//        System.out.println(num);
//        System.out.println(list);
        reverseStack(list);
        System.out.println(list);

    }

}
