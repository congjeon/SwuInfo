package app.swuinfo.guru.com.swuinfo;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.stanfy.gsonxml.GsonXml;
import com.stanfy.gsonxml.GsonXmlBuilder;
import com.stanfy.gsonxml.XmlParserCreator;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by xnote on 2017-07-29.
 */

public class NoticeSearchTask extends AsyncTask<String, String, NoticeBean> {
    private Context context;
    private ListView listView;
    private ProgressBar prd;
    private String searchKeyword;
    private ArrayList<NoticeBean.Item> arrayList = new ArrayList<NoticeBean.Item>();

    NoticeSearchTask(Context context, ListView listView, ProgressBar prd, String searchKeyword) {
        this.context = context;
        this.listView = listView;
        this.prd = prd;
        this.searchKeyword = searchKeyword;
    }

    @Override
    protected void onPreExecute() {
        prd.setVisibility(View.VISIBLE);
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

            GsonXml gsonXml = new GsonXmlBuilder().setXmlParserCreator(parserCreator).setSameNameLists(true).create();

            Notice12 = gsonXml.fromXml(xmlData, NoticeBean.class);
        } catch (Exception e ) {
            e.printStackTrace();
        }
        if(Notice12 != null) {
            return Notice12;
        } else {
            return null;
        }
    }

    @Override
    protected void onPostExecute(NoticeBean noticeBean) {
        for(int i = 0; i < noticeBean.getItems().size(); i++) {
            String data = noticeBean.getItems().get(i).getSubject();
            if (data.contains(searchKeyword)) {
                arrayList.add(noticeBean.getItems().get(i));
            }
        }

        prd.setVisibility(View.INVISIBLE);
        if(arrayList.size() != 0) {
            final NoticeListAdapter adapter = new NoticeListAdapter(context, arrayList);
            listView.setAdapter(adapter);
        } else {
            final AlertDialog builder = new AlertDialog.Builder(context)
                    .setMessage("검색결과가 없습니다").show();

            Handler handler = new Handler();
            handler.postDelayed(new Runnable(){
                public void run(){
                    builder.dismiss();
                }
            }, 1500);
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
