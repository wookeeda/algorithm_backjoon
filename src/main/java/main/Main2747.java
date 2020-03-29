package main;

import java.io.*;

public class Main2747 {

    static int [] f;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        f = new int [n+1];

//        System.out.println(fibo(n));
        bw.write(String.valueOf(fibo(n)));
        br.close();
        bw.close();;
    }

    static int fibo(int n){
        if(n == 0) {
            return 0;
        }else if ( n == 1){
            return 1;
        }
        if (f[n] != 0){
            return f[n];
        }

        return f[n] = fibo(n-1) + fibo(n-2);
    }
}
