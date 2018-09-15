import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main1038 {

    static int cnt;
    static int[] made;
    static int n;
    static boolean found;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.valueOf(br.readLine());
        cnt = -1;
        found = false;
        made = new int[11];
        // 1 부터 ~ 10까지
        // 10억자리  1의자리


        // 차라리 수를 만들자
        make(0, 0, 0);

        if(!found){
            System.out.println(-1);
        }

    }

    static void make(int level, int now, int prev) {
        if (found) return;
        if (prev != 0 && now >= prev) {
            return;
        }
        boolean notZero = false;
        for(int i = 1; i <= 10; ++i){
            if(made[i] != 0){
                notZero = true;
                break;
            }
        }
        if( notZero){
            if( now >= prev){
                return;
            }
        }


        made[level] = now;

        if (level == 10) {
            cnt++;
            if (cnt == n) {
                found = true;
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i < 11; i++) {
                    sb.append(made[i]);
                }
                int res = Integer.parseInt(sb.toString());
                System.out.println(res);
            }
            return;
        }
        for (int next = 0; next < 10; ++next) {
            make(level + 1, next, now);
        }
    }
}

