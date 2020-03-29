package main;

import java.util.LinkedList;
import java.util.Scanner;

public class Main1260 {


    static boolean [][] map;
    static boolean [] visited;
    static int n;
    static int m;
    static int v;
    static StringBuilder resultD;
    static StringBuilder resultB;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String [] stArr = sc.nextLine().split(" ");
//        System.out.println(Arrays.toString(stArr));

        n = Integer.parseInt(stArr[0]);
        m = Integer.parseInt(stArr[1]);
        v = Integer.parseInt(stArr[2]);

        map = new boolean[n+1][n+1];
        for(int i = 0; i < m ; ++i){
            stArr = sc.nextLine().split(" ");
            int a = Integer.parseInt(stArr[0]);
            int b = Integer.parseInt(stArr[1]);

            map[a][b] = true;
            map[b][a] = true;
        }

//        for(int i = 1; i<= n ; ++i){
//            System.out.print(i + " -> ");
//            for(int j : list[i]){
//                System.out.print(j + " ");
//            }
//            System.out.println();
//        }

        // dfs 부터 고고
        visited = new boolean[n+1];
        resultD = new StringBuilder();
        visited[v] = true;
        recursive(v);
        System.out.println(resultD);

        // bfs 도 고고
        visited = new boolean[n+1];
        resultB = new StringBuilder();
        LinkedList<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;

        while( !q.isEmpty()){
            int pos = q.pollFirst();
            resultB.append(pos + " ");

            for(int i = 1; i < n+1; ++i){
                if( map[pos][i] && !visited[i]){
                    visited[i] = true;
                    q.addLast(i);
                }
            }
        }

        System.out.println(resultB);


    }

    static void recursive(int pos){
        resultD.append(pos + " ");

        for(int i = 1; i < n+1; ++i){
            if(map[pos][i] && !visited[i]) {
                visited[i] = true;
                recursive(i);
            }
        }
    }
}
