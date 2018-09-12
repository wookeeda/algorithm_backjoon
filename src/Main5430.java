import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main5430 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        testStart : for(int t = 1; t <= testCase ; ++t){
            String [] cmd = br.readLine().split("");
            int n = Integer.valueOf(br.readLine());
            String arrStr = br.readLine();
            if( n == 0){
                for(String c : cmd){
                    if( "D".equals(c)){
                        System.out.println("error");
                        continue testStart;
                    }
                }
                System.out.println("[]");
                continue testStart;
            }

            String [] arr = arrStr.substring(1, arrStr.length()-1).split(",");

            boolean front = true;
            int cnt = arr.length;
            int frontCnt = 0;
            int backCnt = cnt-1;
            for(String s:cmd){
                if("R".equals(s)){
                    front = (!front);
                }else {
                    if(frontCnt > backCnt){
                        System.out.println("error");
                        continue testStart;
                    }
                    if(front){
                        frontCnt++;
                    }else {
                        backCnt--;
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            ArrayList<String> l = new ArrayList<>(Arrays.asList(arr));

            List l2 = l.subList(frontCnt, backCnt+1);
            if(l2.size() == 0){
                System.out.println("[]");
                continue testStart;
            }

            if(!front) {
                Collections.reverse(l2);
            }
            int length = l2.size();
            for (int i = 0; i < length-1; i++) {
                sb.append(l2.get(i)).append(",");
            }
            sb.append(l2.get(length-1));
            sb.insert(0, "[");
            sb.append("]");

            System.out.println(sb);
        }

    }
}
