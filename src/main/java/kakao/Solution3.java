package kakao;

public class Solution3 {
    public static void main(String[] args) {
        Solution3 s = new Solution3();
        s.solution(new int[]{3, 1, 2}, 5);
        s.solution(new int[]{3, 1, 2, 4}, 8);
    }


    public int solution(int[] food_times, long k) {
        int answer = 0;
        int len = food_times.length;

        while (k >= len) {
            int zeroCnt = 0;
            for (int i = 0; i < food_times.length; ++i) {
                food_times[i]--;
                if (food_times[i] == 0) {
                    zeroCnt++;
                }
            }
            k -= len;
            len -= zeroCnt;
//            System.out.printf("%s, %d, %d, %d\n", Arrays.toString(food_times), len, zeroCnt, k);

            boolean allClear = true;
            for(int i = 0; i < food_times.length; ++i){
                if(food_times[i] > 0 ){
                    allClear = false;
                    break;
                }
            }
            if(allClear){
                return -1;
            }
        }

        answer = 0;
        for (int i = 0; i < k; ++i, answer++) {
            while (food_times[i] <= 0) {
                answer++;
                answer %= food_times.length;
            }
//            System.out.println(i + " / " + answer);
        }
        while (food_times[answer] <= 0) {
            answer++;
            answer %= food_times.length;

        }

//        System.out.println((answer+1));
        return (answer+1);
    }
}
