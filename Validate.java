public boolean checkBST(TreeNode root){
    if(root == null) return true;
    if(root.val >= root.left.val && root.right.val >= root.val) return true;
    else return false;
    return checkBST(root.left) && checkBST(root.right);
}