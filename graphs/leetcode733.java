import java.util.Stack;

/**
 * leetcode733
 */
public class leetcode733 {
  public static void dfs(int image[][], int i, int j, int color, int curr, boolean visited[][]) {
    if (i < 0 || j < 0 || i >= image.length || j >= image[0].length || image[i][j] != curr) {
      return;
    }
    if (!visited[i][j]) {
      image[i][j] = color;
      visited[i][j] = true;
      dfs(image, i - 1, j, color, curr, visited);
      dfs(image, i + 1, j, color, curr, visited);
      dfs(image, i, j + 1, color, curr, visited);
      dfs(image, i, j - 1, color, curr, visited);

    }
  }

  public static int[][] floodFill(int image[][], int sr, int sc, int color) {
    int currColor = image[sr][sc];
    boolean visited[][] = new boolean[image.length][image[0].length];
    dfs(image, sr, sc, color, currColor, visited);
    return image;
  }

  public static void main(String[] args) {
    // int image[][] = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
    int image[][] = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
    int sr = 0;
    int sc = 0;
    int color = 0;
    floodFill(image, sr, sc, color);
    for (int row[] : image) {
      for (int val : row) {
        System.out.print(val);
      }
      System.out.println();
    }
  }
}
