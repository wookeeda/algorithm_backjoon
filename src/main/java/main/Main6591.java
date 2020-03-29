package main;

import java.io.*;
import java.util.StringTokenizer;

public class Main6591 {

    static int n;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while( true ){
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            if("0 0".equals(str)) break;

            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            int [][] dp = new int[n+1][k+1];

            for(int i = 1; i <= n ; ++i){
                for (int j = 0; j <= Math.min(i, k); j++) {
                    if( j == 0 || j == i){
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                    }
                }
            }
//            for (int i = 0; i <= n; i++) {
//                for (int j = 0; j <= Math.min(i, k); j++) {
//                    System.out.printf("%5d ", dp[i][j]);
//                }
//                System.out.println();
//            }
//
//            System.out.println(dp[n][k]);
            bw.write(String.valueOf(dp[n][k]));
            bw.write("\n");

        }
        br.close();
        bw.close();
    }
}
