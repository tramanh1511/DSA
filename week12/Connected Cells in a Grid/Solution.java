import java.util.*;

public class Solution {
    public static int N;
    public static int M;
    public static int[][] grid;
    public static boolean[][] visited;

    public static int count_connected(int row, int col) {
        int cnt = 1;
        // Viết chương trình vào đây
        if (row >= N || col >= M || row < 0 || col < 0
                || grid[row][col] == 0 || visited[row][col]) return 0;
        visited[row][col] = true;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                cnt += count_connected(row + i, col + j);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        grid = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                grid[i][j] = scanner.nextInt();
                visited[i][j] = false;
            }
        }

        int max = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                max = Math.max(max, count_connected(i, j));
            }
        }

        System.out.println(max);

    }
}