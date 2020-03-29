package main;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1520 {


    private static int[][] board;
    private static int[][] dp;
    private static int m;
    private static int n;
    private static int[] x;
    private static int[] y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        board = new int[m][n];
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        x = new int[]{1, 0, 0, -1};
        y = new int[]{0, 1, -1, 0};

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        for (int i = 0; i < m; i++) { for (int j = 0; j < n; j++) System.out.print(board[i][j] + " ");System.out.println(); }

        dp[m - 1][n - 1] = 1;
        int cnt = climb(0, 0);

        bw.write(String.valueOf(cnt));
        bw.close();
        br.close();
    }

    private static int climb(int a, int b) {
        if (dp[a][b] > -1) {
            return dp[a][b];
        }
        int cnt = 0;
        for (int i = 0; i < 4; ++i) {
            int a2 = a + x[i];
            int b2 = b + y[i];

            if (a2 >= 0 && a2 < m && b2 >= 0 && b2 < n && board[a][b] > board[a2][b2]) {
                cnt += climb(a2, b2);
            }
        }
        return dp[a][b] = cnt;
    }
}
