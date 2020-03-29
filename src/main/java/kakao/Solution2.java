package kakao;

import java.util.ArrayList;

public class Solution2 {


    static boolean[] checked;
    private int cnt;
    private int rowCnt;
    private int total;
    private String[][] arr;
    private ArrayList<boolean[]> answerList;

    public static void main(String[] args) {
        Solution2 s = new Solution2();
    }


    public int solution(String word, String[] pages) {
        int answer = 0;
        int len = pages.length;

        Page [] pageArr = new Page[len];

        for(int i = 0; i < len; ++i){
            String str = pages[i].toLowerCase();

            int metaIndex = str.indexOf("<meta");
            int urlIndex = str.indexOf("content=", metaIndex);
            int urlStartIndex = str.indexOf("https://", urlIndex);
            int urlEndIndex = str.indexOf("\"/>");
            String url = str.substring(urlStartIndex, urlEndIndex);
//            System.out.println(url);

            pageArr[i] = new Page();
            Page p = pageArr[i];
            p.url = url.toLowerCase();

            int bodyIndex = str.indexOf("<body>");
            int bodyEndIndex = str.indexOf("</body>");

            String body = str.substring(bodyIndex, bodyEndIndex);
//            System.out.println(body);
            String body2 = new String(body);


            int searchCnt = 0;
            while(true){
                int searchIndex = body.indexOf(word);
                if( searchIndex >= 0){
                    searchCnt++;
                    body = body.substring(searchIndex + word.length());
                }else {
                    break;
                }
            }
            p.point = searchCnt;
            p.links = new ArrayList<>();

            while(true){
                int aIndex = body2.indexOf("<a");
                if( aIndex >= 0 ){
                    body2 = body2.substring(aIndex);
                    int linkIndex = body2.indexOf("href=");
                    linkIndex += 5;
                    int linkEndindex = body2.indexOf("\">");
                    String linkUrl = body2.substring(linkIndex, linkEndindex);
                    p.links.add(linkUrl);
                    body2 = body2.substring(linkEndindex);
                }else{
                    break;
                }
            }
            p.linkCnt = p.links.size();

        }

        // linkPoint 계산하기
        for(int i = 0; i < len; ++i){
            Page t = pageArr[i];
            double linkP = t.linkPoint;

            for( String link :  t.links){
                for(int j = 0; j < len; ++j){
                    if( link.equals(pageArr[j].url)){
                        // 링크주소와 같다면
                        Page comp = pageArr[j];
                        int basePoint = comp.point;
                        int linkPoint = comp.linkCnt;
                        double bonusPoint = 0;
                        if(linkPoint == 0){
                            bonusPoint = 0;
                        }else{
                            bonusPoint = (double) basePoint / linkPoint;
                        }

                        linkP += bonusPoint;
                    }
                }
            }
        }

        int topPageIndex = 0;
        double topPoint = 0L;
        for( int i = 0; i < len ; ++i){
            double totalPoint = 0L;
            Page p = pageArr[i];
            totalPoint = p.point+ p.linkPoint;
            if( topPoint < totalPoint){
                topPageIndex = i;
                topPoint = totalPoint;
            }
        }

        answer = topPageIndex;


        return answer;
    }
}

class Page {
    String url;
    int point;
    double linkPoint;
    int linkCnt;
    ArrayList<String> links;
}