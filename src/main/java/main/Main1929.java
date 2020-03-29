package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        if (n == 1) {
            return;
        } else if (n == 2) {
            System.out.println(2);
            return;
        } else if ( n == m){
            System.out.println(n);
            return;
        }

        boolean[] prime = new boolean[n + 2];

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; ++i) {
            if(!prime[i]) {
                if( i >= m )
                    sb.append(i + "\n");
                for (int j = i + i; j <= n; j = j + i) {
//                    System.out.println(j);
                    prime[j] = true;
                }
            }
        }
        System.out.println(sb);
    }
}
