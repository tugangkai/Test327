import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode151
{

    public String reverseWords(String s){
        int len=s.length();
        int start=0;
        int end=0;
        List<String> list=new ArrayList<String>();
        boolean first=false;
        for(int i=0;i<len;i++){
            if(!first&&s.charAt(i)!=' '){
                start=i;
                first=true;
            }
            if(s.charAt(i)!=' '&&(i==len-1||s.charAt(i+1)==' ')){
                end=i+1;
                list.add(s.substring(start,end));
                first=false;

            }
        }
        StringBuilder sb=new StringBuilder();
        Collections.reverse(list);
        for(int i=0;i<list.size()-1;i++){
            sb.append(list.get(i)+" ");
        }
        sb.append(list.get(list.size()-1));
        return sb.toString();
    }



//    public String reverseWords(String s) {
//        String[] array = s.split(" ");
//        StringBuilder sb = new StringBuilder();
//        for(int i = array.length - 1;i >= 0; --i) {
//            if(array[i].length() != 0)
//                sb.append(array[i]).append(" ");
//        }
//        if(sb.length() != 0)
//            sb.deleteCharAt(sb.length() - 1);
//        return sb.toString();
//    }

}
