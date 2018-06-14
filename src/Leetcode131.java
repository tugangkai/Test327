import java.util.ArrayList;
import java.util.List;

public class Leetcode131 {

//    给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
//
//    返回 s 所有可能的分割方案。
//
//    示例:
//
//    输入: "aab"
//    输出:
//            [
//            ["aa","b"],
//            ["a","a","b"]
//            ]
public static void main(String[] args) {
    Leetcode131 l131=new Leetcode131();
    List<List<String>> res=l131.partition("");
    for(List<String> list:res){
        for(String str:list){
            System.out.print(str+"\t");
        }
        System.out.println();
    }
}
    public List<List<String>> partition(String s) {

        List<String> sub=new ArrayList<String>();
        List<List<String>> list=new ArrayList<List<String>>();
        if(s==null)
            return list;
        partition(s,list,sub);

        return list;


    }
    public void partition(String s,List<List<String>>list,List<String> sub){

        if(s.length()<1){
            list.add(new ArrayList<>(sub));
            return;
        }
        for(int i=1;i<=s.length();i++){
            String str=s.substring(0,i);
            if(isPalindrome(str)){
                sub.add(str);
                partition(s.substring(i),list,sub);
                sub.remove(sub.size()-1);
            }
        }
    }
    public boolean isPalindrome(String str){
        int len=str.length();
        int start=0;
        int end=len-1;
        while(start<end){
            if(str.charAt(start++)!=str.charAt(end--))
                return false;
        }
        return true;

    }

}
//    void part(List<List<String>> res,String s,int l,List<String>list){
//        if(l==s.length()&&list.size()!=0){
//            res.add(new ArrayList<>(list));
//            return;
//        }
//
//        for(int i=l;i<s.length();i++){
//            if(isP(s,l,i)){
//                if(i==l){
//                    list.add(Character.toString(s.charAt(i)));
//                }else{
//                    list.add(s.substring(l,i+1));
//                }
//                part(res,s,i+1,list);
//                list.remove(list.size()-1);
//            }
//        }
//    }