public class Search2DMatrix74 {
  public static boolean searchMatrix(int mat[][], int target) {
    final int C = mat[0].length;
    final int R = mat.length;
    int left = 0;
    int right = R * C - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      int i = mid / C;
      int j = mid % C;
      int num = mat[i][j];
      if (target == num)
        return true;
      else if (target > num)
        left = mid + 1;
      else
        right = mid;
    }
    return false;
  }

  public static void main(String[] args) {

  }
}
