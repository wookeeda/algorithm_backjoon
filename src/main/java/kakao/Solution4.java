package kakao;

import java.util.Arrays;

public class Solution4 {

    public int solution(int[] ranks) {
        // write your code in Java SE 8

        Arrays.sort(ranks);

        int length = ranks.length;
        int total = 0;

        int previousValue = ranks[0];
        int count = 1;

        for (int i = 1; i < length; ++i) {
            // 이전 값이 현재 값과 같으면 count + 1
            if (previousValue == ranks[i]) {
                count++;
            } else {
                // 이전값과 현재값이 rank 1 차이면
                // report에 이전값을 가진 병사 수 더함
                if (previousValue + 1 == ranks[i]) {
                    total += count;
                }
                // 이전값과 현재값이 달라지면 초기화
                count = 1;
                previousValue = ranks[i];
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Solution4 s = new Solution4();
        System.out.println(s.solution(new int[]{3, 4, 3, 0, 2, 2, 3, 0, 0}));
    }
}
