// 공백 주의, 공백 수 유지
class JadenCase {
    public String solution(String s) {
        String answer = "";
        String pre = " ";
        
        for(String str: s.split("")) {
            if(str.equals(" "))
                answer += str;
            else if(pre.equals(" "))
                answer += str.toUpperCase();
            else
                answer += str.toLowerCase();
            pre = str;
        }
        return answer;
    }
}
