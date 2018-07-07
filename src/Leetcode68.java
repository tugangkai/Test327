import java.util.ArrayList;
import java.util.List;

public class Leetcode68 {

    public List<String> fullJustify(String[] words, int maxWidth) {

        int len=words.length;
        int i=0;
        List<String> list=new ArrayList<String>();
        if(words==null){
            return list;
        }
        while(i<len){
            String str="";
            int cum=0;
            int start=i;
            int end=i;
            int wordsLen=0;
            while(cum<maxWidth){
                if(end<len&&wordsLen+words[end].length()+end-start<=maxWidth){
                    wordsLen+=words[end].length();
                   // cum+=words[end].length()+end-start;
                    end++;
                }else{
                    break;
                }

            }
            if(end==len){
                System.out.println("最後一行"+words[end-1]);
                if(end-start==1){
                    str+=words[len-1];
                    for(int j=0;j<maxWidth-wordsLen;j++){
                        str+=" ";
                    }
                }else{
                    for(int j=start;j<end-1;j++){
                        str+=words[j]+" ";
                    }
                    str+=words[end-1];
                    for(int j=0;j<maxWidth-wordsLen-(end-start-1);j++){
                        str+=" ";
                    }
                }


            }else{


           if(end-start==1){
               str+=words[start];
                for(int j=0;j<maxWidth-wordsLen;j++){
                    str+=" ";
                }
           }else{
                int avgdot=(maxWidth-wordsLen)/(end-start-1);
                int prevdot=(maxWidth-wordsLen)%(end-start-1);
                int j=start;

                for(int k=0;k<prevdot;k++){
                    str+=words[j];
                    for(int l=0;l<avgdot+1;l++){
                        str+=" ";
                    }
                    j++;
                }
                while(j<end-1){
                    str+=words[j];
                    for(int l=0;l<avgdot;l++){
                        str+=" ";
                    }
                    j++;
                }
                str+=words[end-1];
            }
            }
            list.add(str);

            i=end;


        }

    return list;

    }




    public static void main(String[] args) {
        String []words={"Science","is","what","we","understand","well","enough"
        ,"to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        String []words2={
                "What","must","be","acknowledgment","shall","be"
        };
        Leetcode68 l68=new Leetcode68();
        List<String> res=l68.fullJustify(words2,16);
        System.out.println(res.size());
        for(String str:res){
            System.out.println(str);
        }


//        List<String> list=new ArrayList<String>();
//        String str="abc";
//        list.add(str);
//        str="ss";
//        System.out.println(list.get(0));
    }

//
//    public List<String> fullJustify(String[] words, int maxWidth) {
//        List<String> ans = new ArrayList<>();
//        int i = 0;
//        int len = 0;
//        int start = 0;
//        while(i<words.length){
//            len += words[i].length();
//            if(len>maxWidth){
//                ans.add(construct(words, start, i, maxWidth));
//                start = i;
//                len = words[i].length();
//            }
//            len += 1;
//            i++;
//        }
//        ans.add(construct(words, start, words.length, maxWidth));
//        return ans;
//    }
//    public String construct(String[] words, int start, int end, int maxWidth){
//        StringBuilder sb = new StringBuilder();
//        if(end==words.length || end-start==1){
//            for(int i=start;i<end-1;i++){
//                sb.append(words[i]);
//                sb.append(" ");
//            }
//            sb.append(words[end-1]);
//            while(sb.length()<maxWidth)
//                sb.append(" ");
//        }
//        else{
//            int len = 0;
//            for(int i=start;i<end;i++)
//                len += words[i].length();
//
//            int space = (maxWidth-len)/(end-start-1);
//            String s = "";
//            for(int i=0;i<space;i++)
//                s += " ";
//
//            int extra_space = (maxWidth - len)%(end-start-1);
//
//            for(int i=start;i<end-1;i++){
//                sb.append(words[i]);
//                sb.append(s);
//                if(i-start<extra_space)
//                    sb.append(" ");
//            }
//            sb.append(words[end-1]);
//        }
//        return sb.toString();
//    }

}
