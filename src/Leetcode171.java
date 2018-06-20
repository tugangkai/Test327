public class Leetcode171 {
//    给定一个Excel表格中的列名称，返回其相应的列序号。
//
//    例如，
//
//    A -> 1
//    B -> 2
//    C -> 3
//            ...
//    Z -> 26
//    AA -> 27
//    AB -> 28
//            ...
//    示例 1:
//
//    输入: "A"
//    输出: 1
//    示例 2:
//
//    输入: "AB"
//    输出: 28
//    示例 3:
//
//    输入: "ZY"
//    输出: 701
//    致谢：
//    特别感谢 @ts 添加此问题并创建所有测试用例。
    public static void main(String[] args) {
        Leetcode171 l171 =new Leetcode171();
        int res=l171.titleToNumber("ZY");
        System.out.println(res);
    }
    public int titleToNumber(String s) {
        if(s==null)
            return 0;
        int len=s.length();
        int res=0;
        int mul=1;
        for(int i=len-1;i>=0;i--){
            res+=(s.charAt(i)-'A'+1)*mul;
            mul*=26;
        }
        return res;
    }
//    public int titleToNumber(String s) {
//        if (s == null || s.length() == 0) {
//            return 0;
//        }
//        int ret = 0;
//        for (int i = 0; i < s.length(); ++i) {
//            ret = ret * 26 + (s.charAt(i) - 'A' + 1);
//        }
//        return ret;
//    }


}
