package googleKickStart;

import java.io.*;
import java.util.*;

public class Solution_kickstart_2019_2_2 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCnt = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCaseCnt; t++) {

            // 1. input
            StringTokenizer st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if ( r * c >= 10000){
                System.out.printf("Case #%d: %d\n", t, 0);
                continue;
            }

            int[][] map = new int[r][c];

            List<Pos3> list = new ArrayList<>();

            boolean isAll0 = true;
            boolean isAll1 = true;
            for (int i = 0; i < r; i++) {
                String[] str = br.readLine().split("");
                for (int j = 0; j < c; j++) {
                    int office = Integer.parseInt(str[j]);
                    map[i][j] = office;
                    if (office == 1) {
                        list.add(new Pos3(i, j));
                        isAll0 = false;
                    }
                    if (office == 0){
                        isAll1 = false;
                    }
                }
            }


            int[][] distMap = new int[r][c];

            // 2. calculate dist
//            int maxDist = calculateDist(r, c, list);
            Map initMap = calculateDist(r, c, list, distMap);
            int maxDist = (int) initMap.get("maxDist");
            int [][] initDistMap = (int [][]) initMap.get("distMap");

            if( isAll1 || !isAll0 && maxDist == 0){
                System.out.printf("Case #%d: %d\n", t, maxDist);
                continue;
            }

//            for (int i = 0; i < r; i++) System.out.println(Arrays.toString(initDistMap[i]));

            // all -> TLE

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if(map[i][j] != 1){
                        List<Pos3> tmpList = new ArrayList<>();
                        tmpList.addAll(list);
                        tmpList.add(new Pos3(i, j, 0));
//                        int tmpMaxDist = calculateDist(r, c, tmpList);
                        Map tmpMap = calculateDist(r, c, tmpList, distMap);
                        int tmpMaxDist = (int) tmpMap.get("maxDist");
                        int [][] tmpDistMap = (int[][]) tmpMap.get("distMap");
                        if(maxDist > tmpMaxDist){
                            maxDist = tmpMaxDist;
//                            System.out.println("got it");
//                            for (int k = 0; k < r; k++) System.out.println(Arrays.toString(tmpDistMap[k]));
                        }
                    }
                }
            }


            // 2nd strategy
            /*
            List<googleKickStart.Pos3> maxList = new ArrayList<>();
            for (int i = 0; i < r; i++) {
                int maxValue = 0;

                for (int j = 0; j < c; j++) {
                    if( maxValue < initDistMap[i][j]) {
                        maxValue = initDistMap[i][j];
                    }
                }

                for (int j = 0; j < c; j++) {
                    if(initDistMap[i][j] == maxValue){
                        maxList.add(new googleKickStart.Pos3(i, j));
                    }
                }
            }
            for (int i = 0; i < c; i++) {
                int maxValue = 0;

                for (int j = 0; j < r; j++) {
                    if (maxValue < initDistMap[j][i]) {
                        maxValue = initDistMap[j][i];
                    }
                }

                for (int j = 0; j < r; j++) {
                    if(initDistMap[j][i] == maxValue){
                        maxList.add(new googleKickStart.Pos3(j, i));
                    }
                }
            }

//            for (int i = 0; i < maxList.size(); i++) System.out.println(maxList.get(i));


            for (int i = 0; i < maxList.size(); i++) {
                List<googleKickStart.Pos3> tmpList = new ArrayList<>();
                tmpList.addAll(list);
                googleKickStart.Pos3 tmpPos = maxList.get(i);

                tmpList.add(tmpPos);

//                        int tmpMaxDist = calculateDist(r, c, tmpList);
                Map tmpMap = calculateDist(r, c, tmpList);
                int tmpMaxDist = (int) tmpMap.get("maxDist");
                int [][] tmpDistMap = (int[][]) tmpMap.get("distMap");
                if(maxDist > tmpMaxDist){
                    maxDist = tmpMaxDist;
//                    System.out.println("got it");
//                    for (int k = 0; k < r; k++) System.out.println(Arrays.toString(tmpDistMap[k]));
                }
            }
*/
            System.out.printf("Case #%d: %d\n", t, maxDist);

        }

        bw.close();
        br.close();
    }

    private static Map<String, Object> calculateDist(int r, int c, List<Pos3> list, int [][] distMap) {
        for (int i = 0; i < r; i++) {
            Arrays.fill(distMap[i], 500);
        }

        Queue<Pos3> q = new LinkedList<>();
        q.addAll(list);

//        for (googleKickStart.Pos3 p: list) System.out.println(p);


        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            Pos3 now = q.poll();
            int x = now.x;
            int y = now.y;
            int dist = now.dist;

            if(distMap[x][y] == 0 || distMap[x][y] < dist){
                continue;
            }

            distMap[x][y] = dist;

            for (int i = 0; i < 4; i++) {
                if (x + dx[i] >= 0 && x + dx[i] < r && y + dy[i] >= 0 && y + dy[i] < c) {
                    if (distMap[x + dx[i]][y + dy[i]] != 0 && distMap[x + dx[i]][y + dy[i]] > dist + 1) {
                        q.add(new Pos3(x + dx[i], y + dy[i], dist + 1));
                    }
                }
            }
        }

//        for (int i = 0; i < r; i++) System.out.println(Arrays.toString(distMap[i]));

        int maxDist = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(maxDist < distMap[i][j]){
                    maxDist = distMap[i][j];
                }
            }
        }
//        System.out.printf("max dist : %d\n",maxDist);
        Map<String, Object> map = new HashMap<>();
        map.put("maxDist", maxDist);
        map.put("distMap", distMap);
        return map;

    }

    static int distance(int x1, int y1, int x2, int y2) {
        return (x1 - x2 > 0 ? x1 - x2 : x2 - x1)
                + (y1 - y2 > 0 ? y1 - y2 : y2 - y1);
    }

}

class Pos3 {
    int x;
    int y;
    int dist;

    Pos3(int x, int y) {
        this.x = x;
        this.y = y;
        this.dist = 0;
    }

    Pos3(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    @Override
    public String toString() {
        return "googleKickStart.Pos3{" +
                "x=" + x +
                ", y=" + y +
                ", dist=" + dist +
                '}';
    }
}
