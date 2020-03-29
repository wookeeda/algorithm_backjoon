package main;

import java.io.*;
import java.util.Iterator;
import java.util.TreeSet;

public class Main2981 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        TreeSet<Integer> set = new TreeSet<>(Integer::compareTo);
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(br.readLine()));
        }

        Iterator<Integer> it = set.iterator();
//        while(it.hasNext()) System.out.println(it.next());

        int firstNo = it.next();
        int secondNo = it.next();
        for (int i = 2; i <= secondNo; i++) {
            Iterator<Integer> itr = set.iterator();
            int remain = firstNo % i;
            int divider = i;
            while( itr.hasNext()){
                int target = itr.next();
                if( remain != target % divider){
                    remain = -1;
                    break;
                }
            }
            if( remain != -1){
                bw.write(String.valueOf(divider));
                bw.write("\n");
            }
        }

        bw.close();
        br.close();

    }
}
