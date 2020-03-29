package googleKickStart;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_kickstart_2019_3 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCnt = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCaseCnt; t++) {

            // 1. input
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            int[][] bookings = new int[q][3];

            for (int i = 0; i < q; i++) {
                st = new StringTokenizer(br.readLine());
                bookings[i][0] = Integer.parseInt(st.nextToken());
                bookings[i][1] = Integer.parseInt(st.nextToken());

                bookings[i][2] = bookings[i][1] - bookings[i][0];
            }

            // 2. sort
            Arrays.sort(bookings, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return (o1[2] == o2[2]) ? o1[0] - o2[0] : o1[2] - o2[2];
                }
            });

//            for (int i = 0; i < bookings.length; i++) System.out.println(bookings[i][0] + "/" + bookings[i][1] + "/" + bookings[i][2]);


            // 3. calculate
            int k = n;
            boolean[] seats = new boolean[n + 1];

            int l = 0;
            int r = 0;

            for (int i = 0; i < bookings.length; i++) {
                l = bookings[i][0];
                r = bookings[i][1];


                int seatedCnt = 0;

                for (int j = l; j <= r; j++) {
                    if (!seats[j]) {
                        seats[j] = true;
                        seatedCnt++;
                    }
                }

                if (k > seatedCnt) {
                    k = seatedCnt;
                    if (k == 0) {
                        break;
                    }
                }

            }

            System.out.printf("Case #%d: %d\n", t, k);

        }

        bw.close();
        br.close();
    }
}
