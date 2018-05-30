import java.util.LinkedList;
import java.util.List;

public class Leetcode71 {

//    给定一个文档 (Unix-style) 的完全路径，请进行路径简化。
//
//    例如，
//    path = "/home/", => "/home"
//    path = "/a/./b/../../c/", => "/c"
//
//    边界情况:
//
//    你是否考虑了 路径 = "/../" 的情况？
//    在这种情况下，你需返回 "/" 。
//    此外，路径中也可能包含多个斜杠 '/' ，如 "/home//foo/" 。
//    在这种情况下，你可忽略多余的斜杠，返回 "/home/foo" 。


    public String simplifyPath(String path) {
       //path=path.replaceAll("//","/");

        int len=path.length();
        int []pos=new int[len];
        int ps=0;
        char[] pc=path.toCharArray();
        for(int i=0;i<len;i++){
            if(pc[i]=='/')
                pos[ps++]=i;
        }
        LinkedList<String> list=new LinkedList<String>();

        int p=0;
        while(p<=ps-1){
            String pathstr=null;
           if(p==ps-1){
               //不是最后一个字符
               if(pos[p]!=len-1){
                   pathstr=path.substring(pos[p],len);
               }else{
                   //break;

                   break;
               }
           }else{
               pathstr =path.substring(pos[p],pos[p+1]);
           }
            if(pathstr.equals("/.")){

            }else if(pathstr.equals("/..")){
                if(!list.isEmpty()){

                    list.removeLast();
                }
            }else if(pathstr.equals("/")){

            }
            else{
               list.add(pathstr);
            }
            p++;
        }
        if(list.isEmpty()){
            list.add("/");
        }
        StringBuilder sb=new StringBuilder();
        while(!list.isEmpty())
        {
            sb.append(list.poll());
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        Leetcode71 l71=new Leetcode71();
        String path="/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///";
        String res=l71.simplifyPath(path);
        System.out.println(res);
    }


    public String simplifyPath1(String path) {
        if(path==null||path.length()==0)return path;

        StringBuilder sb=new StringBuilder();
        char[] cs=path.toCharArray();
        int i=0;
        while(i<cs.length){
            while(i<cs.length&&cs[i]=='/'){
                i++;
            }

            int begin=i;

            while(i<cs.length&&cs[i]!='/'){
                i++;
            }

            int end=i;

            if(begin!=end){
                String s=path.substring(begin,end);
                if(!s.equals(".")){
                    if(s.equals("..")){
                        if(sb.length()!=0){
                            while(sb.charAt(sb.length()-1)!='/'){
                                sb.deleteCharAt(sb.length()-1);
                            }
                            sb.deleteCharAt(sb.length()-1);
                        }
                    }else{
                        sb.append("/"+s);
                    }
                }
            }
        }
        if(sb.length()==0)sb.append("/");

        return sb.toString();
    }
}
