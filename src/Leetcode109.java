import java.util.ArrayList;

public class Leetcode109 {
//    给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
//
//    本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
//
//    示例:
//
//    给定的有序链表： [-10, -3, 0, 5, 9],
//
//    一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
//
//            0
//            / \
//            -3   9
//            /   /
//            -10  5

    public TreeNode sortedListToBST(ListNode head) {
            ArrayList<Integer> list=new ArrayList<Integer>();

            while(head!=null){
                list.add(head.val);
                head=head.next;
            }
            int len=list.size();
           int nums[]=new int[len];
            for(int i=0;i<list.size();i++){
            nums[i]=list.get(i);
        }
            return sortedArrayToBST(nums,0,len-1);
    }
    public TreeNode sortedArrayToBST(int []nums,int start,int end){

        if(start>end)
            return null;

        int mid=(start+end)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=sortedArrayToBST(nums,start,mid-1);
        root.right=sortedArrayToBST(nums,mid+1,end);
        return root;

    }


//    public TreeNode sortedListToBST(ListNode head) {
//        // 使用递归构造的方式
//        if (head == null) {
//            return null;
//        }
//        // 记录链表的长度
//        int size = 0;
//        ListNode node = head;
//        while (node != null) {
//            size++;
//            node = node.next;
//        }
//        ListNode pre = null;
//        node = head;
//        // 根的值就是链表中间的值
//        for (int i = 0; i < size / 2 ; i++) {
//            pre = node;
//            node = node.next;
//        }
//
//        TreeNode root = new TreeNode(node.val);
//        if(pre != null){
//            pre.next = null;
//            root.left = sortedListToBST(head);
//        }
//        root.right = sortedListToBST(node.next);
//
//        return root;
//    }

}
