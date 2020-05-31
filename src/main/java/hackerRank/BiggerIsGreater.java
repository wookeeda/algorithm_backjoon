package hackerRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BiggerIsGreater {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {

        char[] arr = w.toCharArray();
        int length = arr.length;


        // 기본적인 컨셉은 1의 자리부터 확인을 하는데,
        // 큰 자리보다 작은 자리의 수가 더 크면, 두 개를 바꾼다. (디테일은 뒤에서 상세히..)
        int now = length - 1;

        // 아래 자리 수들을 담을 tong 만들자.
        List<Character> tong = new ArrayList<>();


        // now 자리의 수보다 아래 자리 수들 중에 now보다 더 큰 수가 있는지 확인한다.
        boolean found = false;
        while (now >= 0) {
            Collections.sort(tong);
            for (Character c : tong) {
                if (arr[now] < c) {
                    // 발견하면,

                    // 그 수와 now자리 수를 바꾸고,
                    tong.add(arr[now]);
                    tong.remove(c);
                    arr[now] = c;

                    // basket에 남아있는 수들을 오름차순 정렬해서 붙이면 된다.
                    Collections.sort(tong);
                    StringBuilder sb = new StringBuilder();
                    sb.append(arr, 0, now + 1);
                    // sb.append(tong.stream().map(String::valueOf).collect(Collectors.joining()));
                    for (Character ch : tong) {
                        sb.append(ch);
                    }
                    return sb.toString();
                }
            }
            // 발견 못하면,
            // 현재 char 통에 넣고, 윗 자리수를 대상으로 다시 진
            tong.add(arr[now]);
            now--;
        }
        return "no answer";
    }

    public static void main(String[] args) {

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();
            String result = biggerIsGreater(w);
            System.out.println(result);
        }


        scanner.close();
    }
}
