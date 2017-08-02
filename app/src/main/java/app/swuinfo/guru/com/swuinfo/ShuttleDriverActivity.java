package app.swuinfo.guru.com.swuinfo;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.stanfy.gsonxml.GsonXml;
import com.stanfy.gsonxml.GsonXmlBuilder;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class ShuttleDriverActivity extends CommonActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);

        new ShuttleLocationTask().execute();
    }

    public class ShuttleLocationTask extends AsyncTask<String, Void, String> {
        public static final String URL_SHUTTLE = "http://172.16.13.217:8080/rest/updateShuttleLocation.do";

        @Override
        protected String doInBackground(String... params) {
            try {
                RestTemplate restTemplate = new RestTemplate();
                //restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                restTemplate.getMessageConverters().add(new FormHttpMessageConverter());

                MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();/*
                map.add("year", currentYear);
                map.add("month", currentMonth);*/

                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

                HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(map, headers);

                return restTemplate.postForObject(URL_SHUTTLE,request,String.class);
            } catch (Exception e) {
                return null;
            } finally {
            }
        }

/*        @Override
        protected void onPostExecute(String s) {
            Gson gson = new Gson();
            try {
                ScheduleBean bean = gson.fromJson(s, ScheduleBean.class);
                if(bean!=null) {
                    //데이터가 있다
                    if(bean.getResult().equals("ok")) {
                        if(bean != null) {
                            ScheDuleAdapter adapter = new ScheDuleAdapter(getActivity(), bean.getScheduleBean());
                            listView.setAdapter(adapter);
                        }
                    } else {
                        Toast.makeText(getActivity(), "해당 월은 행사가 없습니다.", Toast.LENGTH_SHORT).show();
                    }
                }
            } catch (Exception e) {
                Toast.makeText(getActivity(), "파싱실패", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }*/
    }
}
