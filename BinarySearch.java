public class BinarySearch{
    
    public int searchBinary(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        int mid = -1;

        while(low <= high){
            mid = (low + high) >>> 1;
            if(nums[mid] > target) high = mid - 1;
            else if(nums[mid] < target) low = mid + 1;
            else return mid;
        }

        return -1;
    }

    public int searchBinary(int[] nums, int low, int high, int target){
        int low = 0;
        int high = nums.length - 1;
        int mid = -1;

        while(low <= high){
            if(nums[mid] > target) return searchBinary(nums, low, mid - 1, target);
            else if(nums[mid] < target) return searchBinary(nums, mid + 1, high, target);
            else return mid;
        }

        return -1;
    }
}