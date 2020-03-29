package googleCodeJam;

import java.io.*;
import java.util.Arrays;

public class Solution_codejam_2019_qualification_round_1 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCnt = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCaseCnt; t++) {

            // 1. input
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int r = Integer.parseInt(st.nextToken());
//            int c = Integer.parseInt(st.nextToken());

//            int n = Integer.parseInt(br.readLine());
            String [] nStr = br.readLine().split("");
            String [] nStr2 = new String[nStr.length];
            Arrays.fill(nStr2, "0");
//            System.out.println(nStr.length);

            for (int i = 0; i < nStr.length; i++) {
                if("4".equals(nStr[i]) ){
                    nStr[i] = "3";
                    nStr2[i] = "1";
                }
            }

//            String a = Arrays.toString(nStr);
//            String b = Arrays.toString(nStr2);

            StringBuilder builder = new StringBuilder();
            StringBuilder builder2 = new StringBuilder();
            for (int i = 0; i < nStr.length; i++) {
                builder.append(nStr[i]);
                builder2.append(nStr2[i]);
            }

            int a = Integer.parseInt(builder.toString());
            int b = Integer.parseInt(builder2.toString());


            System.out.printf("Case #%d: %d %d\n", t, a, b);

        }

        bw.close();
        br.close();
    }


}
