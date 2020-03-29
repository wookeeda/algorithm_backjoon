package googleKickStart;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_kickstart_2019_B_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCnt = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCaseCnt; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            final int N = Integer.parseInt(st.nextToken());
            final int Q = Integer.parseInt(st.nextToken());

            char[] arr = br.readLine().toCharArray();

            int l = 0;
            int r = 0;

            int cnt = 0;

            for (int i = 0; i < Q; i++) {
                // init
                st = new StringTokenizer(br.readLine());
                l = Integer.parseInt(st.nextToken()) - 1;
                r = Integer.parseInt(st.nextToken()) - 1;

                if (l == r) {
                    cnt++;
                    continue;
                }

                int[] abc = new int[26];

                for (int j = l; j <= r; j++) {
                    abc[arr[j] - 'A']++;
                }

                boolean found = true;
                if ((r - l) % 2 == 0) {
                    // odd
                    // all letter have to be even.
                    // only one letter can odd
                    boolean oddFounded = false;

                    for (int j = 0; j < 26; j++) {
                        if (abc[j] % 2 == 1) {
                            if (!oddFounded) {
                                oddFounded = true;
                            } else {
                                found = false;
                                break;
                            }
                        }
                    }
                } else {
                    // even
                    // all letter have to be even.
                    for (int j = 0; j < 26; j++) {
                        if (abc[j] % 2 == 1) {
                            found = false;
                            break;
                        }
                    }
                }
                if (found) {
                    cnt++;
                }

            }
            System.out.printf("Case #%d: %s\n", t, cnt);
        }
        bw.close();
        br.close();
    }

}
