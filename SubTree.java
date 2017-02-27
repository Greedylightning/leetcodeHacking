public boolean isSubTree(TreeNode p, TreeNode q){
    if(p == null || q == null) return true;
    return (p.val == q.val) && (isSubTree(p.left, q.left)) &&(isSubTree(p.right,q.right));
}