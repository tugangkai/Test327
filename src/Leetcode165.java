import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode165 {
//    比较两个版本号 version1 和 version2。
//    如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。
//
//    你可以假设版本字符串非空，并且只包含数字和 . 字符。
//
//            . 字符不代表小数点，而是用于分隔数字序列。
//
//    例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。
//
//    示例 1:
//
//    输入: version1 = "0.1", version2 = "1.1"
//    输出: -1
//    示例 2:
//
//    输入: version1 = "1.0.1", version2 = "1"
//    输出: 1
//    示例 3:
//
//    输入: version1 = "7.5.2.4", version2 = "7.5.3"
//    输出: -1
public static void main(String[] args) {
    Leetcode165 l165=new Leetcode165();
    int res=l165.compareVersion("1.1","1");
    System.out.println(res);

}
    public int compareVersion(String version1, String version2) {
        String []t1=version1.split("\\.");

        String []t2=version2.split("\\.");
        List<String> l1= Arrays.asList(t1);

        List<String> l2=Arrays.asList(t2);

        int len1=l1.size();
        int len2=l2.size();
        int i=0;
        for(;i<len1&&i<len2;i++){
            int v1=Integer.parseInt(l1.get(i));
            int v2=Integer.parseInt(l2.get(i));
            if(v1>v2)
                return 1;
            else if(v1<v2)
                return -1;
        }

        if(i==len1&&i==len2)
            return 0;

        if(i==len1)
        {
            int k=i;
            while(k<len2){
                if(Integer.parseInt(l2.get(k++))!=0)
                    return -1;
            }
            return 0;
        }

        if(i==len2){
            int k=i;
            while(k<len1){
                if(Integer.parseInt(l1.get(k++))!=0)
                    return 1;
            }
            return 0;
        }

        return -1;
    }


    public int compareVersion1(String version1, String version2) {
        int indexA = 0; // 记录version1处理的位置
        int indexB = 0; // 记录version2处理的位置
        int countA = 0; // 记录version1的.号之的字符数
        int countB = 0; // 记录version2的.号之的字符数
        int max; // 记录countA和countB之间的较大者
        int a;
        int b;

        while (indexA < version1.length() || indexA < version2.length()) {
            while (indexA < version1.length() && version1.charAt(indexA) != '.') {
                countA++;
                indexA++;
            }
            while (indexB < version2.length() && version2.charAt(indexB) != '.') {
                countB++;
                indexB++;
            }
            max = countA > countB ? countA : countB;
            for (int i = max; i >= 1; i--) { // 从左向右比较
                a = countA - i >= 0 ? version1.charAt(indexA - i) - '0' : 0;
                b = countB - i >= 0 ? version2.charAt(indexB - i) - '0' : 0;
                if (a > b) {
                    return 1;
                } else if (a < b) {
                    return -1;
                }
            }

            countA = 0;
            countB = 0;
            indexA++;
            indexB++;
        }
        return 0;
    }


}
