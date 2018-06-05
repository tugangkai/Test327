import java.util.ArrayList;
import java.util.List;

public class Leetcode93 {
    public List<String> restoreIpAddresses(String s) {

        List<String> list=new ArrayList<String>();
        String op="";
        findIpAddress(list,s,op,0,0);
        return list;

    }

    public void findIpAddress(List<String> list,String s,String op,int start,int depth){
        if((4-depth)*3<s.length()-start){
            return;
        }

        if(depth==3&&s.length()-start<=3){
            if(s.charAt(start)=='0'&&s.length()-start>1)
                return;
            String f=s.substring(start,s.length());
            if(Integer.parseInt(f)>255)
                return;
            op+=f;
            list.add(op);

            return ;
        }
        if(start>=s.length())
            return;
        int maxJump=3;
        if(s.charAt(start)=='0')
            maxJump=1;
        for(int i=1;i<=maxJump;i++){
            String tmp=op;
            if(start+i>s.length()||(start+i>=s.length()&&depth<3))
                return;
            if(i==3){
                int res=  Integer.parseInt(s.substring(start,start+i));
                if(res>255)
                    return ;
            }
            op+=(s.substring(start,start+i))+".";
            findIpAddress(list,s,op,start+i,depth+1);
            op=tmp;
        }


    }
    public static void main(String[] args) {
     Leetcode93 l93=new Leetcode93();
     List<String> res=l93.restoreIpAddresses("010010");
     for(String s:res){
         System.out.println(s);
     }
    }


/*
    可读性较高的代码

 */
//
//    vector<string> restoreIpAddresses(string s) {
//        vector<string> result;
//        string path;
//        helper(s,0,0,path,result);
//        return result;
//    }
//
//    void helper(string &s,int num,int pos,string &path,vector<string>& result)
//    {
//        //遍历完给定字符串，并且生成了个段时
//        if(pos==s.size()&&num==4)
//        {
//            //这里需要去除掉path最后的.
//            result.push_back(path.substr(0,path.size()-1));
//            return;
//        }
//
//        //如果该段包含的字符数大于规定的最大数目，那么直接退出，可以把这个判断放在下面的if中，
//        //但是三个if都需要加，所以放在这儿更简洁一些。
//        if(s.size()-pos>3*(4-num))
//            return;
//
//        //该段只含有一个字符
//        if(pos<s.size())
//        {
//            path+=s.substr(pos,1)+".";
//            helper(s,num+1,pos+1,path,result);
//            path=path.substr(0,path.size()-2);
//        }
//
//        //该段含有两个字符，并且第一个字符不能是'0'
//        if(pos<s.size()-1&&s[pos]!='0')
//        {
//            path+=s.substr(pos,2)+".";
//            helper(s,num+1,pos+2,path,result);
//            path=path.substr(0,path.size()-3);
//        }
//
//        //该段含有3个字符并且第一个字符不能是'0'，前三个字符串不能大于"255"
//        if(pos<s.size()-2&&s[pos]!='0'&&s.substr(pos,3)<="255")
//        {
//            path+=s.substr(pos,3)+".";
//            helper(s,num+1,pos+3,path,result);
//            path=path.substr(0,path.size()-4);
//        }
//
//    }
}
