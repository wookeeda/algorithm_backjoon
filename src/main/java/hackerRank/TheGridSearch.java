package hackerRank;

import java.io.IOException;
import java.util.Scanner;

public class TheGridSearch {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the gridSearch function below.
    static String gridSearch(String[] G, String[] P) {
        int rlen = G.length - P.length + 1;
        int clen = G[0].length() - P[0].length() + 1;

        int glen = G[0].length();
        int plen = P[0].length();

        for (int i = 0; i < rlen; i++) {
            int index = -1;
            int prow = 0;

            while (true) {
                index = G[i].indexOf(P[prow]);

                if (index >= 0 && index < clen) {
                    G[i] = G[i].substring(0, index)
                            + (G[i].charAt(index) + 1) % 10
                            + G[i].substring(index + 1);

                    // 다음 줄부터 맞는지 확인.
                    boolean wrong = false;
                    for (int j = 1; j < P.length; j++) {
                        if (G[i + j].substring(index, index + plen).equals(P[j])) {
                            continue;
                        } else {
                            wrong = true;
                            break;
                        }
                    }
                    if (!wrong) {
                        return "YES";
                    }
                } else {
                    break;
                }
            }

        }
        return "NO";
    }

    public static void main(String[] args) throws IOException {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] RC = scanner.nextLine().split(" ");

            int R = Integer.parseInt(RC[0]);

            int C = Integer.parseInt(RC[1]);

            String[] G = new String[R];

            for (int i = 0; i < R; i++) {
                String GItem = scanner.nextLine();
                G[i] = GItem;
            }

            String[] rc = scanner.nextLine().split(" ");

            int r = Integer.parseInt(rc[0]);

            int c = Integer.parseInt(rc[1]);

            String[] P = new String[r];

            for (int i = 0; i < r; i++) {
                String PItem = scanner.nextLine();
                P[i] = PItem;
            }

            String result = gridSearch(G, P);
            System.out.println(result);

        }

        scanner.close();
    }
}
