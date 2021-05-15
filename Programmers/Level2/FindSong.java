class FindSong {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxTime = 0;
        m = replaceSharp(m);
        
        for(int i=0; i<musicinfos.length; i++) {
            String[] info = musicinfos[i].split(",");
            int time = getPlayTime(info[0], info[1]);
            
            if(maxTime < time) {
                String melody = makeMelody(replaceSharp(info[3]), time);
                if(melody.contains(m)) {
                    answer = info[2];
                    maxTime = time;
                }
            }
        }
        return answer;
    }
    
    public String replaceSharp(String m) {
        m = m.replace("C#", "c");
        m = m.replace("D#", "d");
        m = m.replace("F#", "f");
        m = m.replace("G#", "g");
        m = m.replace("A#", "a");
        return m;
    }
    
    public int getPlayTime(String start, String end) {
        String[] s = start.split(":");
        String[] e = end.split(":");
        
        return (Integer.parseInt(e[0])*60 + Integer.parseInt(e[1])) 
            - (Integer.parseInt(s[0])*60 + Integer.parseInt(s[1]));
    }
    
    public String makeMelody(String melody, int time) {
        String result = "";
        for(int i=0; i<time; i++) {
            result += melody.charAt(i%melody.length());
        }
        return result;
    }
}

/*
import java.util.*;

class FindSong {
    public String solution(String m, String[] musicinfos) {
        List<Music> list = new ArrayList<>();
        m = replaceSharp(m);
        
        for(int i=0; i<musicinfos.length; i++) {
            String[] info = musicinfos[i].split(",");
            int time = getPlayTime(info[0], info[1]);
            String melody = makeMelody(replaceSharp(info[3]), time);
            
            if(melody.contains(m))
                list.add(new Music(info[2], time));
        }
        if(list.isEmpty()) return "(None)";
        
        Collections.sort(list);
        return list.get(0).getName();
    }
    
    public String replaceSharp(String m) {
        m = m.replace("C#", "c");
        m = m.replace("D#", "d");
        m = m.replace("F#", "f");
        m = m.replace("G#", "g");
        m = m.replace("A#", "a");
        return m;
    }
    
    public int getPlayTime(String start, String end) {
        String[] s = start.split(":");
        String[] e = end.split(":");
        
        return (Integer.parseInt(e[0])*60 + Integer.parseInt(e[1])) 
            - (Integer.parseInt(s[0])*60 + Integer.parseInt(s[1]));
    }
    
    public String makeMelody(String melody, int time) {
        String result = "";
        for(int i=0; i<time; i++) {
            result += melody.charAt(i%melody.length());
        }
        return result;
    }
}

class Music implements Comparable<Music> {
    private String name;
    private int time;
    
    public Music(String name, int time) {
        this.name = name;
        this.time = time;
    }
    public String getName() { return this.name; }
    
    @Override
    public int compareTo(Music m) {
        if(this.time == m.time)
            return 0;
        else
            return m.time - this.time;
    }
}
*/
