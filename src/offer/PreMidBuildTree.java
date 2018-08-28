package offer;

import Common.Commons;
import basic.TreeNode;

public class PreMidBuildTree {
    public static void main(String[] args) {
        int []pre={1,2,4,7,3,5,6,8};
        int []mid={4,7,2,1,5,3,8,6};
        PreMidBuildTree pb=new PreMidBuildTree();
        TreeNode root=pb.reConstructBinaryTree(pre,mid);
        Commons.postOrderSearch(root);
    }
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        int len=pre.length;
         return construct(pre,0,len-1,in,0,len-1);

    }
    public TreeNode construct(int []pre,int ps,int pe,int []in,int is,int ie){
        if(ps>pe)
            return null ;
        int k=is;
        while(in[k]!=pre[ps])
            k++;
        TreeNode root=new TreeNode(pre[ps]);
        root.left=construct(pre,ps+1,ps+k-is,in,is,k-1);
        root.right=construct(pre,ps+k-is+1,pe,in,k+1,ie);
        return root;




    }
}
