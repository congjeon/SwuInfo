package app.swuinfo.guru.com.swuinfo;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;

import com.stanfy.gsonxml.GsonXml;
import com.stanfy.gsonxml.GsonXmlBuilder;
import com.stanfy.gsonxml.XmlParserCreator;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by xnote on 2017-07-28.
 */

public class NoticeTask extends AsyncTask<String, String, NoticeBean> {
    private Context context;
    private ListView listView;

    NoticeTask(Context context, ListView listView) {
        this.context = context;
        this.listView = listView;
    }

    @Override
    protected NoticeBean doInBackground(String... params) {
        StringBuilder output = new StringBuilder();
        NoticeBean Notice12 = new NoticeBean();

        try {
            URL url = new URL(params[0]);

            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            String line = null;

            while (true) {
                line = reader.readLine();
                if (line == null) break;
                output.append(line + "\n");
            }
            reader.close();

            String xmlData = output.toString();
            xmlData = xmlData.substring(39);
            //xmlData = xmlData.replaceAll("\\<!\\[CDATA\\[", "");
            //xmlData = xmlData.replaceAll("]]>", "");
            //xmlData = "<Notice12><items><Subject>2017학년도 하계방학 교내인턴장학생 의무상담 시행 안내</Subject><Text>이건 파싱이 되나</Text><Dates>날짜</Dates></items><items><Subject>2017학년도 하계방학 교내인턴장학생 의무상담 시행 안내</Subject><Text>이건 파싱이 되나</Text><Dates>날짜</Dates></items></Notice12>";

            GsonXml gsonXml = new GsonXmlBuilder().setXmlParserCreator(parserCreator).setSameNameLists(true).create();

            Notice12 = gsonXml.fromXml(xmlData, NoticeBean.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Notice12;
    }

    @Override
    protected void onPostExecute(NoticeBean noticeBean) {
        if(noticeBean != null) {
            NoticeListAdapter adapter = new NoticeListAdapter(context, noticeBean.getItems());
            listView.setAdapter(adapter);
        }
    }

    private XmlParserCreator parserCreator = new XmlParserCreator() {
        @Override
        public XmlPullParser createParser() {
            try {
                return XmlPullParserFactory.newInstance().newPullParser();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    };
}
