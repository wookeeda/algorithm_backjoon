package kakao;

import java.util.HashSet;

public class Solution3_1 {


    static boolean[] checked;
    private int columnCnt;
    private int rowCnt;
    private int total;
    private String[][] arr;

    public static void main(String[] args) {
        Solution3_1 s = new Solution3_1();
//        s.solution(new String[][]{
//                {"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}});

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

        columnCnt = relation[0].length;
        rowCnt = relation.length;

//        System.out.println(columnCnt);
//        System.out.println(rowCnt);

        checked = new boolean[columnCnt];
        total = 0;

        for(int i = 0; i < columnCnt; ++i){
            dfs(i, 0);
        }

        answer = total;
        System.out.println(answer);

        return answer;
    }

    public void dfs(int checkedNo, int level) {
        checked[checkedNo] = true;
        if (check()) {
            total++;
        } else {
            for (int i = checkedNo + 1; i < columnCnt; ++i) {
                dfs(i, level+1);
            }
        }
        print();
        checked[checkedNo] = false;
    }

    private boolean check() {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < rowCnt; ++i) {
            String[] now = arr[i];
            String str = "";
            for (int j = 0; j < columnCnt; ++j) {
                if (checked[j]) {
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

    void print() {
        for (int i = 0; i < columnCnt; ++i) {
            System.out.printf("\t%d : %s\n ", i, checked[i] ? "O" : "X");
        }
        System.out.println("\ttotal : " + total);
    }
}
