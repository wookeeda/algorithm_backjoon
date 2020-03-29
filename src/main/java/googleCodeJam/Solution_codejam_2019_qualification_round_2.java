package googleCodeJam;

import java.io.*;
import java.util.Arrays;

public class Solution_codejam_2019_qualification_round_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCnt = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCaseCnt; t++) {

            int n = Integer.parseInt(br.readLine());

            String [] s = br.readLine().split("");
            String [] r = new String[s.length];
            Arrays.fill(r, "");

            Point sp = new Point();
            Point rp = new Point();
            for (int i = 0; i < s.length; i++) {
                boolean samePoint = false;
                if(sp.x == rp.x && sp.y == rp.y){
                    samePoint = true;
                }
                if("E".equals(s[i])){
                    sp.x++;
                    if(samePoint){
                        rp.y++;
                        r[i] = "S";
                    }else{
                        if("E".equals(r[i-1])){
                            rp.y++;
                            r[i] = "S";
                        }else{
                            rp.x++;
                            r[i] = "E";
                        }
                    }
                }else{
                    sp.y++;
                    if(samePoint){
                        rp.x++;
                        r[i] = "E";
                    }else{
                        if("E".equals(r[i-1])){
                            rp.y++;
                            r[i] = "S";
                        }else{
                            rp.x++;
                            r[i] = "E";
                        }
                    }
                }
            }

//            System.out.println(Arrays.toString(s));
//            System.out.println(Arrays.toString(r));

            StringBuilder builder = new StringBuilder();
            StringBuilder builder2 = new StringBuilder();
            for (int i = 0; i < s.length; i++) {
                builder.append(s[i]);
                builder2.append(r[i]);
            }

            String a = builder.toString();
            String b = builder2.toString();

//            System.out.println(a);
//            System.out.println(b);

            System.out.printf("Case #%d: %s\n", t, b);

        }

        bw.close();
        br.close();
    }

    static class Point{
        int x = 0;
        int y = 0;
    }
}
