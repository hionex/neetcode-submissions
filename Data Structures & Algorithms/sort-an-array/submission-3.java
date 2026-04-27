/**
 * Merge Sort implementation using the Divide and Conquer strategy.
 * Time Complexity: O(n log n) in all cases (best, average, worst).
 * Space Complexity: O(n) due to auxiliary arrays used during merging.
 */
class Solution {

    /**
     * Merges two sorted sub-arrays into a single sorted range within the original array.
     */
    private void merge(int[] nums, int left, int mid, int right) {
        // Calculate sizes of two sub-arrays to be merged
        int nLeft = mid - left + 1;
        int nRight = right - mid;

        // Create temporary arrays to hold data
        int[] rLeft = new int[nLeft];
        int[] rRight = new int[nRight];

        // Copy data to temporary arrays
        for (int i = 0; i < nLeft; i++) {
            rLeft[i] = nums[left + i];
        }
        for (int j = 0; j < nRight; j++) {
            rRight[j] = nums[mid + 1 + j];
        }

        // Initial indexes for sub-arrays and the merged array
        int p1 = 0, p2 = 0;
        int index = left;

        // Compare elements from both sub-arrays and pick the smaller one
        // Using '<=' ensures the algorithm remains stable
        while (p1 < nLeft && p2 < nRight) {
            if (rLeft[p1] <= rRight[p2]) {
                nums[index++] = rLeft[p1++];
            } else {
                nums[index++] = rRight[p2++];
            }
        }

        // Copy remaining elements of rLeft[], if any
        while (p1 < nLeft) {
            nums[index++] = rLeft[p1++];
        }

        // Copy remaining elements of rRight[], if any
        while (p2 < nRight) {
            nums[index++] = rRight[p2++];
        }
    }

    /**
     * Recursive function that divides the array into halves.
     */
    private void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            // Find the middle point using a safer formula to avoid overflow
            int mid = left + (right - left) / 2;

            // Recursively sort the first and second halves
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);

            // Merge the sorted halves
            merge(nums, left, mid, right);
        }
    }

    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
}