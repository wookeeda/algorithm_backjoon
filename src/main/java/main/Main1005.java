package main;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main1005 {

    private static ArrayList<Integer>[] list;
    private static int[] cTime;
    private static int[] dpTime;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tCnt = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tCnt; ++t) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            cTime = new int[n + 1];
            dpTime = new int[n + 1];
            visited = new boolean[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; ++i) {
                cTime[i] = Integer.parseInt(st.nextToken());
            }

            list = new ArrayList[n + 1];
            for (int i = 0; i < n + 1; i++) {
                list[i] = new ArrayList<>();
            }
            for (int i = 1; i <= k; ++i) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[b].add(a);
            }
            st = new StringTokenizer(br.readLine());
            int dest = Integer.parseInt(st.nextToken());


//            System.out.printf("n : %d, k : %d\nn -> %s\ndest : %d", n, k, Arrays.toString(ctime), dest);

            bw.write(String.valueOf(build(dest)));
            bw.write("\n");


            // 자 시작해볼까
            /*
            a <- b
              <- c
              <- d
              이면
            build(a) 지어지는데 까지 걸리는 총 시간은 Math.max( build(b),build(c),build(d) ) + ctime[a]
             */


        }
        bw.close();
        br.close();
    }

    static int build(int now) {
        if( visited[now]){
            return dpTime[now];
//            return 0;
        }
        visited[now] = true;

        if (dpTime[now] != 0) {
            return dpTime[now];
        }
        int time = 0;

        for (int next : list[now]) {
            time = Math.max(time, build(next));
//            visited[next] = false;
        }
        time += cTime[now];
//        System.out.printf("%d] build time : %d\n", now, time);
        return dpTime[now] = time;
    }
}
