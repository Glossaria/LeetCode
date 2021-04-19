package KMP;

public class subTree {
    public static class Node {
        Node left;
        Node right;
        int val;
        public Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    public static Boolean containsTree(Node big, Node small) {
        if (small == null) return true;
        if (big == null) return false;
        if (big == small) return true;

        if(isSameTree(big, small)){
            return true;
        }
        return containsTree(big.left, small) || containsTree(big.right, small);
    }

    private static boolean isSameTree(Node head1, Node head2) {
        if(head1 == null && head2 != null){
            return false;
        }
        if(head1 != null && head2 == null){
            return false;
        }
        if(head1 == null){
            return true;
        }
        if(head1.val != head2.val){
            return false;
        }
        return isSameTree(head1.left, head2.left)
                && isSameTree(head1.right, head2.right);
    }


}
