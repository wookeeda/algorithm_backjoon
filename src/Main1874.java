import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> st = new Stack<>();

        int [] arr = new int[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.valueOf(br.readLine());
        }

//        System.out.println(Arrays.toString(arr));

        StringBuilder sb = new StringBuilder();

        int pos = 1;
        for (int i = 1; i <= n; i++) {
            // 일단 pos에 해당하는 숫자를 만날 때까지는 push
            if( i != arr[pos]){
                st.push(i);
                sb.append("+\n");
            }else{
                // 만나면 그때는 push & pop
                st.push(i);
                sb.append("+\n");
                st.pop();
                sb.append("-\n");
                pos++;
                if( pos > n ){
                    break;
                }

                // 그 다음에가 st에 맨 위에 있다면 pop
                while( !st.isEmpty() && arr[pos] == st.peek() ){
                    st.pop();
                    sb.append("-\n");
                    pos++;
                    if( pos > n ){
                        break;
                    }
                }
            }
        }
        if( pos != n+1){
            System.out.println("NO");
            return;
        }

        System.out.println(sb);

    }
}
