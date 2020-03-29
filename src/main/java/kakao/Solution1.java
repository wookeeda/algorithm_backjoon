package kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution1 {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        String[] arr = new String[]
                {
                        "Enter uid1234 Muzi",
                        "Enter uid4567 Prodo",
                        "Leave uid1234",
                        "Enter uid1234 Prodo",
                        "Change uid4567 Ryan"
                };
        s.solution(new String[] {   });

    }

    public String[] solution(String[] record) {
//        System.out.println(Arrays.toString(record));

        String[] answer = {};
        int len = record.length;

        // user 정보
        HashMap<String, String> map = new HashMap<>();

        // 로그 정보
        ArrayList<Log> logs = new ArrayList<Log>();


        for(int i = 0; i < len; ++i){
            StringTokenizer st = new StringTokenizer(record[i]);
            String cmd = st.nextToken();
            String userId = st.nextToken();
            String userNick = "";
            if( !"Leave".equals(cmd)){
                userNick = st.nextToken();
            }
            if("Enter".equals(cmd)){
                // 들어오면 생성
                map.put(userId, userNick);
                logs.add(new Log(1, userId));
            }else if("Leave".equals(cmd)) {
                logs.add(new Log(2, userId));

            }else if("Change".equals(cmd)) {
                map.put(userId, userNick);
            }
        }

        answer = new String[logs.size()];
        for(int i = 0; i < logs.size(); ++i){
            Log l = logs.get(i);
            String nick = map.get(l.id);
            if(l.command == 1) {
                answer[i] = nick + "님이 들어왔습니다.";
            }else if ( l.command == 2){
                answer[i] = nick + "님이 나갔습니다.";
            }
        }
        return answer;
    }
}

class Log{
    int command;
    String id;

    public Log(int command, String userId ) {
        this.command = command;
        this.id = userId;
    }
}
