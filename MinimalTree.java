TreeNode createMinimalBST(int[] nums){
    return getTree(nums, 0, nums.length - 1);
}

TreeNode getTree(int[] nums, int low, int high){
    if(start > end) return null;
    int mid = (low + high) / 2;
    TreeNode node = new TreeNode(nums[mid]);
    node.left = getTree(nums, low, mid - 1);
    node.right = getTree(nums, mid + 1, high);
    return node;
}