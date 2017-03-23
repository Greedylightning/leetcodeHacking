public class InsertSort{

    public void insertSort(int[] nums){
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] < nums[i]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args){
        int[] nums = new int[]{3,2,5,6,7};
        InsertSort test = new InsertSort();
        test.insertSort(nums);
        for(int n : nums) System.out.println(n);
    }
}