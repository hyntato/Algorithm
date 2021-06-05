// 모든 시작점, 끝점을 기준으로 검사
class Traffic {
    private int[] starts;
    private int[] ends;
    
    public int solution(String[] lines) {
        starts = new int[lines.length];
        ends = new int[lines.length];
        
        for(int i=0; i<starts.length; i++) {
            ends[i] = makeEndToMilli(lines[i].split(" ")[1]);
            starts[i] = ends[i] - makePcToMilli(lines[i].split(" ")[2]) + 1;
        }
        
        int answer = 0;
        for(int i=0; i<lines.length; i++) {
            int cnt1 = countTraffic(starts[i], 999);
            int cnt2 = countTraffic(ends[i], 999);
            answer = Math.max(answer, Math.max(cnt1, cnt2));
        }
        return answer;
    }
    
    public int makeEndToMilli(String str) {
        int end = 0;
        String[] split = str.split(":");
        end += Integer.parseInt(split[0]) * 60 * 60 * 1000;
        end += Integer.parseInt(split[1]) * 60 * 1000;
        end += (int)(Double.parseDouble(split[2]) * 1000);
        return end;
    }
    public int makePcToMilli(String str) {
        int pc = (int)(Double.parseDouble(str.replace("s", "")) * 1000);
        return pc;
    }
    
    public int countTraffic(int point, int len) {
        int cnt = 0;
        for(int i=0; i<starts.length; i++) {  
            if(point <= starts[i] && starts[i] <= point+len 
               || point <= ends[i] && ends[i] <= point+len
               || starts[i] < point && point+len < ends[i])
                cnt++;
        }
        return cnt;
    }
}
