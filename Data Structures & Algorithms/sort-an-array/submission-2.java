// Insertion Sort
// Insertion sort is a sorting algorithm
// that places an unsorted element at its suitable place in each iteration.

class Solution {
    public int[] sortArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;

            // Compare key with each element on the left of it until an element smaller than
            // it is found.
            while (j >= 0 && key < nums[j]) {
                nums[j + 1] = nums[j];
                j--;
            }

            // Place key at after the element just smaller than it.
            nums[j + 1] = key;
        }

        return nums;
    }
}

//  7 9 10 8