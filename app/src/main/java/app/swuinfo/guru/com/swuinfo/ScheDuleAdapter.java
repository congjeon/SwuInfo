package app.swuinfo.guru.com.swuinfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samsung on 2017-07-27.
 */

public class ScheDuleAdapter extends BaseAdapter {

    private Context mContext;
    private ScheduleBean mScheduleBean=new ScheduleBean();
    private ArrayList<ScheduleBean.ScheduleBeanSub> mScheduleItemList=new ArrayList<>();
    private ScheduleFragment scheduleFragment=new ScheduleFragment();

    public ScheDuleAdapter(Context context) {
        this.mContext = context;
    }

    // DATA에서 자료 개수 만큼
    @Override
    public int getCount() {
        return mScheduleItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return mScheduleItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // position몇번째 뷰
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //ScheDuleItemView view=new ScheDuleItemView(mContext.getApplicationContext());
        //new ScheduleTask().execute();
        //데이터를 가져온다
        LayoutInflater lf = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = lf.inflate(R.layout.schedule_view, null);

        final ScheduleBean.ScheduleBeanSub scheduleData = mScheduleItemList.get(position);
        TextView txtTitleList = (TextView) convertView.findViewById(R.id.txtTitleList);

        txtTitleList.setText(scheduleData.getData());

        return convertView;
    }

    /* Schedule을 가져오는 작업 */
    /*class ScheduleTask extends android.os.AsyncTask<String,Void,String>{

        private String URL_SCHEDULE_LIST= "http://172.16.15.204:8080/rest/ScheduleProc.do";
        String year,month;

        @Override
        protected void onPreExecute() {
          year=String.valueOf(scheduleFragment.getYear());
          month=String.valueOf(scheduleFragment.getMonth());
        }

        @Override
        protected String doInBackground(String... strings) {
            try{
                // gradle코드 추가가 요구됨
                RestTemplate restTemplate=new RestTemplate();
                // restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                restTemplate.getMessageConverters().add(new FormHttpMessageConverter());

                MultiValueMap<String, Object> map=new LinkedMultiValueMap<String,Object>();
                map.add("year",year);
                map.add("month",month);

                HttpHeaders headers= new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

                HttpEntity<MultiValueMap<String,Object>> request =new HttpEntity<>(map,headers);

                return  restTemplate.postForObject(URL_SCHEDULE_LIST,request,String.class);

            }
            catch(Exception e){
                e.printStackTrace();
            }
            return null;
        }

        *//* 받아온 json정보를 파싱*//*
        @Override
        protected void onPostExecute(String s) {
            Gson gson =new Gson();
            try{
                ScheduleBean bean=gson.fromJson(s,ScheduleBean.class);

                if(bean!=null) if (bean.getResult().equals("ok")) {

                    mScheduleBean = bean.getScheduleBean();
                    String data = mScheduleBean.getData();
                    String[] array = data.split("\n");
                    // 분할한 data 저장
                    for (int i = 0; i < array.length; i++) {
                        mScheduleItemList.get(i).setDevideData(array[i]);
                    }
                   *//* ScheDuleAdapter.this.notifyDataSetInvalidated(); *//*
                }
            }catch(Exception e){
                Toast.makeText(mContext, "파싱 실패", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }
    }; // end onPost*/

}
