package main;

import java.io.*;

public class Main1003 {

    static int [][] f;
    static boolean [] cached;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        f = new int[41][2];
        cached = new boolean[41];
        fibo(41);

        for (int testCase = 1; testCase <= t; testCase++) {
            int n = Integer.parseInt(br.readLine());

            int [] res = fibo(n);
            bw.write(String.valueOf(res[0])+" "+String.valueOf(res[1]) +"\n" );
        }
        br.close();
        bw.close();
    }

    static int[] fibo(int n){
        if(n == 0) {
            return new int[]{1, 0};
        }else if ( n == 1){
            return new int[]{0, 1};
        }
        if (cached[n]){
            return f[n];
        }

        int [] a = fibo(n-1);
        int [] b = fibo(n-2);
        cached[n] = true;
        return f[n] = new int[]{ a[0]+b[0] ,a[1] + b[1]};
    }
}
