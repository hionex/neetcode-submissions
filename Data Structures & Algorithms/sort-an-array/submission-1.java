// Selection Sort
// Each iteration, min value in the unsorted part
// will be moved to the start of unsorted part.

class Solution {
    public int[] sortArray(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[index]) {
                    index = j;
                }
            }

            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
        }

        return nums;
    }
}