package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2573 {

    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static int count;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] stArr = sc.nextLine().split(" ");
//        System.out.println(Arrays.toString(stArr));

        n = Integer.parseInt(stArr[0]);
        m = Integer.parseInt(stArr[1]);

        map = new int[n][m];
        for (int i = 0; i < n; ++i) {
            stArr = sc.nextLine().split(" ");
            for (int j = 0; j < m; ++j) {
                map[i][j] = Integer.parseInt(stArr[j]);
            }
        }

//        for(int i = 0; i < n ; ++i) {
//            for (int j = 0; j < m; ++j) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

        int turn = 0;
        while (true) {
            turn++;
            int initX = 0;
            int initY = 0;


            int[][] newMap = new int[n][m];

            ArrayList<Pos1> list = new ArrayList<>();

            // 1. 녹이고
            // 녹은 후 빙산 갯수
            int countMount = 0;
            Pos1 initPos = null;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    if (map[i][j] > 0) {
                        int count = map[i][j];

                        if (map[i - 1][j] <= 0) {
                            count--;
                        }
                        if (map[i + 1][j] <= 0) {
                            count--;
                        }
                        if (map[i][j - 1] <= 0) {
                            count--;
                        }
                        if (map[i][j + 1] <= 0) {
                            count--;
                        }

                        if (count < 0) {
                            count = 0;
                        }
                        newMap[i][j] = count;
                        if (newMap[i][j] > 0) {
                            countMount++;
                            if (initPos == null) {
                                initPos = new Pos1(i, j);
                            }
                        }
                    }
                }
            }
            if(countMount == 0){
                System.out.println(0);
                return;
            }
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    map[i][j] = newMap[i][j];
                }
            }

//            for (int i = 0; i < n; ++i) {
//                for (int j = 0; j < m; ++j) {
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }

            // 2. 섬의 갯수를 세알려라
            visited = new boolean[n][m];
            count = 0;
            // dfs 실패
//            recursive(initPos);
            // bfs로 풀자
            Queue<Pos1> q = new LinkedList<>();
            q.add(initPos);
            visited[initPos.x][initPos.y] = true;
            while (!q.isEmpty()) {
                Pos1 now = q.poll();
                int x = now.x;
                int y = now.y;
                count++;

                if (x - 1 >= 0 && map[x - 1][y] > 0 && !visited[x - 1][y]) {
                    visited[x - 1][y] = true;
                    q.add(new Pos1(x - 1, y));
                }
                if (x + 1 < n && map[x + 1][y] > 0 && !visited[x + 1][y]) {
                    visited[x + 1][y] = true;
                    q.add(new Pos1(x + 1, y));
                }
                if (y - 1 >= 0 && map[x][y - 1] > 0 && !visited[x][y - 1]) {
                    visited[x][y - 1] = true;
                    q.add(new Pos1(x, y - 1));
                }
                if (y + 1 < m && map[x][y + 1] > 0 && !visited[x][y + 1]) {
                    visited[x][y + 1] = true;
                    q.add(new Pos1(x, y + 1));
                }
            }


//            System.out.printf("countMount : %d / count : %d\n", countMount, count);

            if (countMount != count) {
                System.out.println(turn);
                return;
            }

        }
    }

    static void recursive(Pos1 p) {
        // 상하좌우에 빙산이 있으면 recur
        int x = p.x;
        int y = p.y;
        visited[x][y] = true;
        count++;

        if (x - 1 >= 0 && map[x - 1][y] > 0 && !visited[x - 1][y]) {
            recursive(new Pos1(x - 1, y));
        }
        if (x + 1 < n && map[x + 1][y] > 0 && !visited[x + 1][y]) {
            recursive(new Pos1(x + 1, y));
        }
        if (y - 1 >= 0 && map[x][y - 1] > 0 && !visited[x][y - 1]) {
            recursive(new Pos1(x, y - 1));
        }
        if (y + 1 < m && map[x][y + 1] > 0 && !visited[x][y + 1]) {
            recursive(new Pos1(x, y + 1));
        }
    }
}

class Pos1 {
    int x;
    int y;

    public Pos1(int i, int j) {
        x = i;
        y = j;
    }
}
