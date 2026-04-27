// Bubble Sort
// Each iteration, max value in the unsorted part
// will be moved to the end of unsorted part.

class Solution {
    public int[] sortArray(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            boolean swapped = false; 
            for(int j = 0; j < nums.length - i - 1; j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    swapped = true;
                }
            }

            if(!swapped) break; 
        }

        return nums;
    }
}