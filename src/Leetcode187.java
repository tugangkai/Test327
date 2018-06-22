import java.util.*;

public class Leetcode187 {

    public static void main(String[] args) {
        Leetcode187 l187=new Leetcode187();
        List<String> list=l187.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        for(String s:list)
            System.out.println(s);
    }
    public List<String> findRepeatedDnaSequences(String s){
        List<String > res=new ArrayList<String>();
        if(s==null||s.length()<11)
            return res;
        int hash=0;
        Map<Character,Integer> map=new HashMap<Character,Integer>();
        map.put('A',0);
        map.put('C',1);
        map.put('G',2);
        map.put('T',3);
        Set<Integer>  dic=new HashSet<Integer>();
        Set<Integer>  unique=new HashSet<Integer>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(i<9){
                hash=(hash<<2)+map.get(c);
            }else{
                hash=(hash<<2)+map.get(c);
                hash&=(1<<20)-1;
                if(dic.contains(hash)&&!unique.contains(hash)){
                    res.add(s.substring(i-9,i+1));
                    unique.add(hash);
                }else{
                    dic.add(hash);
                }
            }
        }
        return res;
    }


}
