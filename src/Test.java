import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        System.out.println("hello world");
        LinkedList list =new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);


        //zhushi

        list.remove(3);


        for(Object o:list){
            System.out.println((Integer)o);
        }

    }
}
