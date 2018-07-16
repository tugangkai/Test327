import java.util.ArrayList;
import java.util.List;

public class BSTIterator1 {


        private TreeNode sroot = new TreeNode(0);
        private TreeNode nroot = new TreeNode(0);
        private List<Integer> vals = new ArrayList<Integer>();
        public BSTIterator1(TreeNode root) {
            nroot = sroot;
            doSort(root);
        }

        public void doSort(TreeNode node) {
            if(node == null)
                return;
            else {
                doSort(node.left);
                this.sroot.right = node;
                this.sroot = this.sroot.right;
                doSort(node.right);
            }
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            this.nroot = nroot.right;
            return (this.nroot == null)?false:true;
        }

        /** @return the next smallest number */
        public int next() {
            return this.nroot.val;
        }

}
