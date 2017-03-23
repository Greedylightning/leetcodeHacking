public class Sort{

    public void selectSort(int[] nums){
        for(int i = 0; i < nums.length - 1; i++){
            int k = i;
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] < nums[k]) k = j;
            }
            if(k != i){
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
            }
        }
    }

    public void bubbleSort(int[] nums){
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = 0; j < nums.length - i - 1; j++){
                if(nums[j] > nums[j + 1]){
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    public void quickSort2(int[] nums, int low, int high){
        int key = nums[low];
        int left = low;
        int right = high;

        while(left < right){
            while(left < right && key < nums[right]) right--;
            nums[left] = nums[right];
            while(left < right && key > nums[left]) left++;
            nums[right] = nums[left];
        }

        nums[left] = key;
        quickSort2(nums, low, left - 1);
        quickSort2(nums, left + 1, high);
    }

    public void quickSort(int[] nums, int low, int high){
        int index = partition(nums, low, high);
        if(low < index - 1) quickSort(nums, low, index - 1);
        if(index < high) quickSort(nums, index, high);
    }

    public int partition(int[] nums, int left, int right){
        int pivot = nums[(left + right) >>> 1];
        while(left <= right){
            while(nums[left] < pivot) left++;
            while(nums[right] > pivot) right--;

            if(left <= right){
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    public void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
   }

    public static void main(String[] args){
        int[] nums = new int[]{3,2,5,6,7};
        Sort test = new Sort();
        test.selectSort(nums);
        for(int n : nums) System.out.println(n);
        System.out.println();

        int[] nums2 = new int[]{4,45,21,12,-1};
        test.bubbleSort(nums2);
        for(int n : nums2) System.out.println(n);
        System.out.println();

        int[] nums3 = new int[]{3,4,1,56,-100,235};
        test.mergeSort(nums3, 0, nums3.length - 1, new int[nums3.length]);
        for(int n : nums3) System.out.println(n);
        System.out.println();
    }

    public void mergeSort(int[] nums, int first, int last, int[] temp){
        if(first < last){
            int mid = (first + last) >>> 1;
            mergeSort(nums, first, mid, temp);
            mergeSort(nums, mid + 1, last, temp);
            mergearray(nums, first, mid, last, temp);
        }

    }

    public void mergearray(int[] nums, int first, int mid, int last, int[] temp){
        int i = first, j = mid + 1;
        //int m = mid, n = last;
        int k = 0;

        while(i <= mid && j <= last){
            if(nums[i] <= nums[j]) temp[k++] = nums[i++];
            else temp[k++] = nums[j++];
        }

        while(i <= mid) temp[k++] = nums[i++];
        while(j <= last) temp[k++] = nums[j++];

        for(i = 0; i < k; i++) nums[first + i] = temp[i];
    }
}