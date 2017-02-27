public int getMax(int nums[]){
    int result = Integer.MIN_VALUE;
    for(int i = 0; i < nums.length; i++){
        result = Math.max(result, nums[i]);
    }
    return result;
}