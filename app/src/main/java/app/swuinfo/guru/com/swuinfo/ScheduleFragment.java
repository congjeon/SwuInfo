package app.swuinfo.guru.com.swuinfo;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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

/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleFragment extends Fragment {

    private TextView mMonthText;
    private GridView mMonthView;
    private ListView mDailyAmountView;
    private MonthAdapter mMonthAdapter;
    private ScheDuleAdapter mScheDuleAdapter;
    private int year,month;

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }


    public ScheduleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_schedule, container, false);

        mMonthText = (TextView)view.findViewById(R.id.monthText);
        mMonthView = (GridView)view.findViewById(R.id.calendarView);
        mDailyAmountView = (ListView)view.findViewById(R.id.listView);

        mMonthAdapter = new MonthAdapter(getActivity());

        year=mMonthAdapter.getCurrentYear();
        month=mMonthAdapter.getCurrentMonth();

        mMonthView.setAdapter(mMonthAdapter);

        mMonthText.setText(mMonthAdapter.getCurrentYear() + "년" + mMonthAdapter.getCurrentMonth() + "월");

        new ScheduleListTask(mDailyAmountView).execute();

            /* monthPrevious버튼 클릭시 */
        ImageView monthPrevious = (ImageView)view.findViewById(R.id.monthPrevious);
        monthPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMonthAdapter.setPriviousMonth();
                mMonthAdapter.notifyDataSetChanged();
                mMonthText.setText(mMonthAdapter.getCurrentYear() + "년" + mMonthAdapter.getCurrentMonth() + "월");
            }
        });
           /* monthNext버튼 클릭시 */
        ImageView monthNext = (ImageView)view.findViewById(R.id.monthNext);
        monthNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMonthAdapter.setNextMonth();
                mMonthAdapter.notifyDataSetChanged();
                mMonthText.setText(mMonthAdapter.getCurrentYear() + "년" + mMonthAdapter.getCurrentMonth() + "월");
            }
        });

         return view;
    }

    public class ScheduleListTask extends AsyncTask<String, Void, String> {

        public static final String URL_SCHEDULE = "http://172.16.13.217:8080/rest/ScheduleProc.do";
        private String currentYear, currentMonth;

        public ListView listView;

        ScheduleListTask(ListView listView) {
            this.listView = listView;
        }

        @Override
        protected void onPreExecute() {
            currentYear = String.valueOf(mMonthAdapter.getCurrentYear());
            currentMonth = String.valueOf(mMonthAdapter.getCurrentMonth());
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                RestTemplate restTemplate = new RestTemplate();
                //restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                restTemplate.getMessageConverters().add(new FormHttpMessageConverter());

                MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
                map.add("year", currentYear);
                map.add("month", currentMonth);

                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

                HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(map, headers);

                return restTemplate.postForObject(URL_SCHEDULE,request,String.class);
            } catch (Exception e) {
                return null;
            } finally {
            }
        }

        @Override
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
        }
    }
}

    /*public void showMessage(){
        AlertDialog.Builder builder= new AlertDialog.Builder(getActivity());
        builder.setTitle("요일");
        builder.setMessage("종료하시겠습니까?");
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        //"예"버튼을 눌렀을떄
        builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog dialog =builder.create();
        dialog.show();
    }*/
