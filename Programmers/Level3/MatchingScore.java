import java.util.*;

class MatchingScore {
    private Map<String, WebPage> map = new HashMap<>();
    
    public int solution(String word, String[] pages) {
        word = word.toLowerCase();
        
        for(int i=0; i<pages.length; i++) {
            String page = pages[i];
            String[] splits = page.split("<head>|</head>|<body>|</body>");
        
            String head = splits[1];
            String url = head.split("<meta")[2].split("https://|\"/>")[1];

            String body = splits[3];
            String[] a = body.split("<a href=\"https://|\">|</a>");
            int outLinkCnt = countOutLink(a, url);
            
            String origin = page.replaceAll("[^a-zA-Z]", " ").toLowerCase();
            int wordCnt = countWord(origin, word);
            
            if(map.containsKey(url)) {
                WebPage wp = map.get(url);
                wp.index = i;
                wp.basic = wordCnt;
                wp.outLink = outLinkCnt;
            } else {
                WebPage wp = new WebPage(i, wordCnt, outLinkCnt);
                map.put(url, wp);
            }
        }
        
        int answer = getMaxMatchIdx();
        return answer;
    }
    
    public int countOutLink(String[] a, String url) {
        int outLinkCnt = 0;
        for(int i=0; i<a.length; i++) {
            if((i-1)%3 == 0) {
                String outLinkUrl = a[i];
                outLinkCnt++;
                if(map.containsKey(outLinkUrl)) {
                    map.get(outLinkUrl).inLink.add(url);
                } else {
                    WebPage wp = new WebPage();
                    wp.inLink.add(url);
                    map.put(outLinkUrl, wp);
                }
            }
        }
        return outLinkCnt;
    }
    
    public int countWord(String origin, String word) {
        StringTokenizer st = new StringTokenizer(origin);
        int wordCnt = 0;
        while(st.hasMoreTokens()) {
            if(st.nextToken().equals(word.toLowerCase())) {
                wordCnt++;
            }
        }
        return wordCnt;
    }
    
    public int getMaxMatchIdx() {
        int idx = 0;
        double max = 0;
        for(String url: map.keySet()) {
            WebPage wp = map.get(url);
            if(wp.index != -1) {
                double link = 0;
                for(String inLink: wp.inLink) {
                    WebPage in_wp = map.get(inLink);
                    if(in_wp.index != -1) {
                        link += in_wp.basic/(double)in_wp.outLink;
                    }
                }
                double match = wp.basic + link;
                if(match > max) {
                    idx = wp.index;
                    max = match;
                }
            }
        }
        return idx;
    }
    
    class WebPage {
        int index, basic, outLink;
        List<String> inLink = new ArrayList<>();
        public WebPage() {
            this.index = -1;
            this.basic = 0;
            this.outLink = 0;
        }
        public WebPage(int index, int basic, int outLink) {
            this.index = index;
            this.basic = basic;
            this.outLink = outLink;
        }
    }
}
