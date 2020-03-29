package kakao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution3_2 {


    static boolean[] checked;
    private int cnt;
    private int rowCnt;
    private int total;
    private String[][] arr;
    private ArrayList<boolean[]> answerList;

    public static void main(String[] args) {
        Solution3_2 s = new Solution3_2();
        s.solution(new String[][]{
                {"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}});

        s.solution(new String[][]{
                {"1", "1", "1", "1"},
                {"1", "1", "1", "2"},
                {"1", "1", "1", "3"},
                {"1", "1", "1", "4"},
        });
    }


    public int solution(String[][] relation) {
        int answer = 0;
        arr = relation.clone();
        cnt = relation[0].length;
        rowCnt = relation.length;

        checked = new boolean[cnt];
        total = 0;

        Queue<boolean []> q = new LinkedList<>();


        answerList = new ArrayList<>();


        for(int i = 0; i < cnt; ++i){
            boolean [] tmp = new boolean[cnt];
            tmp[i] = true;
            q.add(tmp);
        }

        while( !q.isEmpty()){
            boolean [] now = q.poll();

            boolean allIncluded = true;
            // 기존에 답들에 현재 조합이 포함되어있는지 확인하는 부분
            for(int i = 0; i < answerList.size(); ++i) {
                boolean[] comp = answerList.get(i);

//                System.out.println("비교할 놈");
//                print(comp);
//                System.out.println("나");
//                print(now);

                allIncluded = true;

                for (int j = 0; j < cnt; ++j) {

                    if(  comp[j]   ){
                        if( now[j] ) {
                            // 모든 comp[j] 는 나한테도 다 있어야해
                        } else if (!now[j]) {
                            allIncluded = false;
                            break;
                        }
                    }
                }
                if (allIncluded) {
                    break;
                }
            }
            if (answerList.size() != 0 && allIncluded) {
                continue;
            }

            if(check(now)){
                total++;
                boolean [] checkedAnswer = now.clone();

                answerList.add(checkedAnswer);
//                print(now);
            }

            int idx = -1;

            for(int i = 0; i < cnt; ++i){
                if( now[i]){
                    idx = i;
                }
            }
            for(int i = idx+1; i < cnt; ++i){
                boolean [] next = now.clone();
                next[i] = true;
                q.add(next);
            }
        }


        answer = total;
        System.out.println(answer);

        return answer;
    }

    private boolean check(boolean [] target) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < rowCnt; ++i) {

            String str = "";
            for (int j = 0; j < cnt; ++j) {
                if (target[j]) {
                    str += arr[i][j] + "*";
                }
            }
            if(set.contains(str)){
                return false;
            }else{
                set.add(str);
            }
        }
        return true;
    }

    void print(boolean [] now) {
        for (int i = 0; i < cnt; ++i) {
            System.out.printf("\t%d : %s\n ", i, now[i] ? "O" : "X");
        }
        System.out.println("\ttotal : " + total);
    }
}
