public int getHeight(TreeNode root){
    if(root == null) return 0;
    return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
}

public int checkBalanced(TreeNode root){
    if(root == null) return true;
    int diff = Math.abs(getHeight(root.left) - getHeight(root.right));
    if(diff > 1){
        return false;
    }
    else{
        return checkBalanced(root.left) && checkBalanced(root.right);
    }
}
    
