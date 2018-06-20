import java.util.*;

public class Leetcode166 {
//    给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
//
//    如果小数部分为循环小数，则将循环的部分括在括号内。
//
//    示例 1:
//
//    输入: numerator = 1, denominator = 2
//    输出: "0.5"
//    示例 2:
//
//    输入: numerator = 2, denominator = 1
//    输出: "2"
//    示例 3:
//
//    输入: numerator = 2, denominator = 3
//    输出: "0.(6)"
    public static void main(String[] args) {
        Leetcode166 l166=new Leetcode166();
        String res=l166.fractionToDecimal(-50,8);
        System.out.println(res);
    }
    public String fractionToDecimal(int numerator, int denominator) {
        if(denominator==0)
            return null;
        StringBuilder sb=new StringBuilder();
        Map<Long,Integer> map=new HashMap<Long,Integer>();
        List<Long> list=new ArrayList<Long>();
        long nume=numerator;
        long deno=denominator;
        if(nume<0&&deno<0)
        {
            nume=-nume;
            deno=-deno;
        }
        if(nume<0&&deno>0)
        {
            sb.append("-");
            nume=-nume;
        }
        if(nume>0&&deno<0)
        {
            sb.append("-");
            deno=-deno;
        }

        long pre=nume/deno;
        sb.append(pre);
        long remain=(nume%deno)*10;
        boolean flag=false;
        int index=0;
        if(remain==0)
            return sb.toString();
        while(remain!=0){
            if (map.containsKey(remain)) {
                index=map.get(remain);
                flag=true;
                break;
            }else{
                long cur=remain/deno;
                list.add(cur);
                map.put(remain,index);
                index++;
                remain=(remain%deno)*10;
            }
        }
        sb.append(".");
        int k=0;
        for(;k<index;k++)
            sb.append(list.get(k));

        if(flag)
            sb.append("(");
        for(;k<list.size();k++){
            sb.append(list.get(k));
        }
        if(flag)
            sb.append(")");



//        for(long num:list){
//            sb.append(num);
//        }

        return sb.toString();
    }


}
