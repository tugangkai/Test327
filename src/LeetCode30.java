import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode30 {
//    给定一个字符串 s 和一些长度相同的单词 words，找出 s 与 words 中所有单词（words 每个单词只出现一次）串联一起（words中组成串联串的单词的顺序随意）的字符串匹配的所有起始索引，子串要与串联串完全匹配，中间不能有其他字符。
//
//    举个例子，给定：
//    s："barfoothefoobarman"
//    words：["foo", "bar"]
//
//    你应该返回的索引: [0,9]

    /**
     * 滑动窗口解法
     * 匹配是否有记忆性，如果只是一味的从字符串s匹配完全words中内容，每次从s的新的
     * 索引处从头到尾匹配，那么会有很多重复的匹配过程，考虑到这种匹配可以用滑动窗口来
     * 模拟，固定左边界，逐步增大右边界。如果过程中有不匹配的，那么左边界应该直接滑动
     * 到右边界。如果匹配，那么计数，如果计数值达到了字符串数组长度，那么直接输出，如果
     *考虑到了字符串中数据可能会重复，那么这样会干扰判断，那么需要一个map来保存当前匹配的情况
     * 如果一个字符串出现的次数超过了字符串数组中该字符串的累积次数，那么应该让左边界往右移
     * 直至让字符串出现次数等于字符串数组中该字符串的累积次数。
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[]words){
        List<Integer> list=new ArrayList<Integer>();
        HashMap<String,Integer> smap=new HashMap<>();


        HashMap<String,Integer> tmap=new HashMap<>();
        int slen=s.length();
        int wlen=words[0].length();
        if(slen==0||words==null||words.length==0){
            return list;
        }

        for(String word:words){
            smap.put(word,smap.containsKey(word)?smap.get(word)+1:1);
        }
        for(int i=0;i<wlen;i++){
            int left=i;
            int count=0;
            for(int j=i;j<slen-wlen;j+=wlen){
                String substr=s.substring(j,j+wlen);
                if(smap.containsKey(substr)) {
                    tmap.put(substr,tmap.containsKey(substr)?tmap.get(substr)+1:1);
                    if(tmap.get(substr)<=smap.get(substr))
                        count++;
                    else{
                        while(tmap.get(substr)>smap.get(substr)){
                            String str1=s.substring(left,left+wlen);
                            tmap.put(str1,tmap.get(str1)-1);
                            if(tmap.get(str1)<smap.get(str1)) count--;
                            left+=wlen;
                        }


                    }
                    if(count==words.length){
                        list.add(left);
                        String val=s.substring(left,left+wlen);
                        tmap.put(val,tmap.get(val)-1);
                        count--;
                        left=left+wlen;
                    }


                }
                else{
                    tmap.clear();
                    count=0;
                    left=j+wlen;

                }

            }




        }


        return list;


    }

    public static void main(String[] args) {
        LeetCode30 l30=new LeetCode30();
        String []words={"foo","bar"};
        List<Integer> list= l30.findSubstring("barfoothefoobarman",words);
        for(Integer i:list){
            System.out.println(i);
        }
    }


}
