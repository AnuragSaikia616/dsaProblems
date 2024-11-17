import java.util.LinkedList;
import java.util.Queue;

public class leetcode130 {
  public static void dfs(char board[][], boolean visited[][], int i, int j) {
    if (i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] == 'X' || visited[i][j]) {
      return;
    }
    visited[i][j] = true;
    dfs(board, visited, i - 1, j);
    dfs(board, visited, i + 1, j);
    dfs(board, visited, i, j - 1);
    dfs(board, visited, i, j + 1);
  }

  public static void solve(char board[][]) {
    int nr = board.length;
    int nc = board[0].length;
    boolean visited[][] = new boolean[nr][nc];
    for (int i = 0; i < nr; i++) {
      if (board[i][0] == 'O')
        dfs(board, visited, i, 0);
    }
    for (int i = 0; i < nr; i++) {
      if (board[i][nc - 1] == 'O')
        dfs(board, visited, i, nc - 1);
    }
    for (int j = 0; j < nc; j++) {
      if (board[0][j] == 'O')
        dfs(board, visited, 0, j);
    }
    for (int j = 0; j < nc; j++) {
      if (board[nr - 1][j] == 'O')
        dfs(board, visited, nr - 1, j);
    }
    for (int i = 0; i < nr; i++) {
      for (int j = 0; j < nc; j++) {
        if (!visited[i][j] && board[i][j] == 'O') {
          visited[i][j] = true;
          board[i][j] = 'X';
        }
      }
    }
  }

  public static void main(String[] args) {
    // char board[][] = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X',
    // 'X', 'O', 'X' },
    // { 'X', 'O', 'X', 'X' }, };
    char board[][] = { { 'O', 'O' }, { 'O', 'O' } };
    solve(board);
    for (char row[] : board) {
      for (char val : row) {
        System.out.print(val);
      }
      System.out.println();
    }
  }
}
