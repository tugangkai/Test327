public class Leetcode168 {
    public static void main(String[] args) {
        Leetcode168 l168=new Leetcode168();
        String res=l168.convertToTitle(701);
        System.out.println(res);
    }
    public String convertToTitle(int n) {
        StringBuilder sb=new StringBuilder();
        while(n!=0){
            int tmp=(n-1)%26;
            sb.append((char)('A'+tmp));
            n=(n-1)/26;
        }
        return sb.reverse().toString();

    }
}
