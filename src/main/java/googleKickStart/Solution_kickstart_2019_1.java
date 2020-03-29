package googleKickStart;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_kickstart_2019_1 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCnt = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCaseCnt; t++) {

            // 1. input
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            int[] s = new int[n];
            int[] skillCnt = new int[10001];
            boolean[] checked = new boolean[10001];

            int maxSameSkillCnt = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                s[i] = Integer.parseInt(st.nextToken());
                skillCnt[s[i]]++;
                if (maxSameSkillCnt < skillCnt[s[i]]) {
                    maxSameSkillCnt = skillCnt[s[i]];
                }
            }

            if (maxSameSkillCnt >= p) {
                System.out.printf("Case #%d: 0\n", t);
                continue;
            }


            // 2. sort
            Arrays.sort(s);


            // 3. calculate
            int minCoachingTime = Integer.MAX_VALUE;
            for (int i = n - 1; i >= p - 1; i--) {

                int coachingTime = 0;
                int targetPoint = s[i];
                int movedCnt = 1;

                if (checked[targetPoint]) {
                    continue;
                }

                int l = i - 1;
                while (movedCnt < p) {
                    coachingTime += targetPoint - s[l];
                    l--;
                    movedCnt++;
                }

                if (minCoachingTime > coachingTime) {
                    minCoachingTime = coachingTime;
                }

                checked[targetPoint] = true;
            }


            System.out.printf("Case #%d: %d\n", t, minCoachingTime);

        }

        bw.close();
        br.close();
    }
}
