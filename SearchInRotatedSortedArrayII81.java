public class SearchInRotatedSortedArrayII81 {
  public static boolean search(int nums[], int target) {
    int low = 0;
    int high = nums.length - 1;

    while (low <= high) {
      int mid = low + ((high - low) / 2);

      // target found
      if (target == nums[mid])
        return true;

      // low -> mid is sorted
      if (nums[low] < nums[mid]) {

        // target inside low -> mid
        if (nums[low] <= target && target < nums[mid]) {
          high = mid - 1;
        }
        // target outside low -> mid
        else {
          low = mid + 1;
        }

      }
      // mid -> high is sorted
      else if (nums[mid] < nums[high]) {

        // target inside mid -> high
        if (nums[mid] < target && target <= nums[high]) {
          low = mid + 1;
        }
        // target outside mid -> high
        else {
          high = mid - 1;
        }

      }

      // mid could be equal
      else {
        if (nums[low] == nums[mid])
          low++;
        if (nums[mid] == nums[high])
          high--;
      }

    }

    return false;
  }

  public static void main(String[] args) {
    int nums[] = { 2, 5, 6, 0, 0, 1, 2 };
    System.out.println(search(nums, 3));

  }
}
