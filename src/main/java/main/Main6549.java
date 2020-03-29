package main;

import java.io.*;
import java.util.StringTokenizer;

public class Main6549 {

    private static int[] arr;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if(n == 0){
                break;
            }

            arr = new int[n+1];
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

//            System.out.println(Arrays.toString(arr));

            long result = div(1, n);
            System.out.println(result);
//            bw.write(String.valueOf(result));
//            bw.write("\n");

        }
        bw.close();
        br.close();

    }

    private static long div(int i, int j) {
        if( i == j){
            return arr[i];
        }
        int mid = (i + j ) / 2;

        long res = -1;

        // 왼쪽과 오른쪽
        res = Math.max( div(i, mid), div(mid+1, j));

        // 걸친놈은 어떻게 파악하지
        int left = mid;
        int right = mid+1;
        int top = Math.min(arr[left], arr[right]);
        res = Math.max( res, (long)top * 2);

        while( i < left || right < j){
            if( right < j && ( left == i || arr[left-1] < arr[right+1]) ){
                right++;
                top = Math.min(top, arr[right]);
            } else {
                left--;
                top = Math.min(top, arr[left]);
            }
            res = Math.max(res, ((long)top * (right - left + 1)));
        }

        return res;
    }
}
