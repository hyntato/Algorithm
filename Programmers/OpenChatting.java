import java.util.*;

class OpenChatting {
    public String[] solution(String[] record) {
        Map<String, String> actions = new HashMap<>();
        actions.put("Enter", "님이 들어왔습니다.");
        actions.put("Leave", "님이 나갔습니다.");
        
        int len = record.length;
        
        Map<String, String> users = new HashMap<>();
        for(String r: record) {
            String[] split = r.split(" ");
          
            if(split[0].equals("Enter"))
                users.put(split[1], split[2]);
            else if(split[0].equals("Change")) {
                users.put(split[1], split[2]);
                len--;
            }
        }
        
        String[] answer = new String[len];
        int idx = 0;
        
        for(String r: record) {
            String message = "";
            String[] split = r.split(" ");
            
            if(split[0].equals("Enter") || split[0].equals("Leave")) {
                message = users.get(split[1]) + actions.get(split[0]);
                answer[idx++] = message;
            }
        }
        return answer;
    }
}
