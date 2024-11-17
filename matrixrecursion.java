public class matrixrecursion {

  public static int matTrav(int mat[][], int i, int j) {
    int sum = 0;
    if (i == mat.length) {
      return 0;
    }
    if (j == mat[0].length) {
      return matTrav(mat, i + 1, 0);
    }
    if (mat[i][j] % 2 == 0)
      sum += mat[i][j];
    return sum + matTrav(mat, i, j + 1);
  }

  public static void main(String[] args) {
    // int mat[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    // int mat[][] = { { 1, 2 }, { 2, 1 } };
    int mat[][] = { { 2 } };
    int ans = matTrav(mat, 0, 0);
    System.out.println(ans);
  }
}
