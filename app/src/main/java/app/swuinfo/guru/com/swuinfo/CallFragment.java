package app.swuinfo.guru.com.swuinfo;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CallFragment extends Fragment {

    private EditText editText;
    private Button btn1, btn2, btn3;
    private ListView listView;
    private CallListAdapter adapter;
    private CallBean callBean;


    public CallFragment() {
        // Required empty public constructor
    }


    private ListView m_ListView;
    private CallListAdapter m_Adapter;
    private List<CallBean> items;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_call, container, false);


        view.findViewById(R.id.fragBtn1).setOnClickListener(CallClick);
        view.findViewById(R.id.fragBtn2).setOnClickListener(CallClick);
        view.findViewById(R.id.fragBtn3).setOnClickListener(CallClick);

        CallBean call1 = new CallBean("교과/강의실지원", "02-970-5020");
        CallBean call2 = new CallBean("수업/수강신청(전공)", "02-970-5022");
        CallBean call3 = new CallBean("수업/수강신청(교양)", "02-970-5032");
        CallBean call4 = new CallBean("계절학기/강의실지원", "02-970-5023");
        CallBean call5 = new CallBean("학적/졸업/강의평가", "02-970-5021");
        CallBean call6 = new CallBean("휴복학/복수부전공/전과/성적", "02-970-5025");
        CallBean call7 = new CallBean("강사료/전자출결/e-class", "02-970-5024");
        CallBean call8 = new CallBean("학력조회/결강사유서", "02-970-5026");
        CallBean call9 = new CallBean("학점교류", "02-970-5023");
        CallBean call10 = new CallBean("ACE사업", "02-970-5028");
        CallBean call11 = new CallBean("SWU119(학사상담)", "02-970-1119");
        CallBean call12 = new CallBean("장학/국가근로", "02-970-5062");
        CallBean call13 = new CallBean("장학", "02-970-5063");
        CallBean call14 = new CallBean("증명서발급", "02-970-5064");
        CallBean call15 = new CallBean("국가근로", "02-970-5066");
        CallBean call16 = new CallBean("학생지원", "02-970-5068");
        CallBean call17 = new CallBean("보건실", "02-970-5075");
        CallBean call18 = new CallBean("진로상담", "02-970-7888");

        CallBean call19 = new CallBean("경비실-종합상황실", "02-970-1000");
        CallBean call20 = new CallBean("경비실-행정관(주관)", "02-970-5181");
        CallBean call21 = new CallBean("경비실-정문", "02-970-5183");
        CallBean call22 = new CallBean("경비실-남문", "02-970-5185");
        CallBean call23 = new CallBean("경비실-바롬관1층", "02-970-5193");
        CallBean call24 = new CallBean("경비실-샬롬하우스", "02-970-5194");
        CallBean call25 = new CallBean("경비실-국제교육관", "02-970-5198");
        CallBean call26 = new CallBean("경비실-50주년기념관(주관)", "02-970-7560");
        CallBean call27 = new CallBean("경비실-아름관,다움관", "02-970-7950");
        CallBean call28 = new CallBean("학력조회/결강사유서", "02-970-5026");
        CallBean call29 = new CallBean("학력조회/결강사유서", "02-970-5026");
        CallBean call30 = new CallBean("학력조회/결강사유서", "02-970-5026");
        CallBean call31 = new CallBean("학력조회/결강사유서", "02-970-5026");
        CallBean call32 = new CallBean("학력조회/결강사유서", "02-970-5026");
        CallBean call33 = new CallBean("학력조회/결강사유서", "02-970-5026");
        CallBean call34 = new CallBean("학력조회/결강사유서", "02-970-5026");
        CallBean call35 = new CallBean("학력조회/결강사유서", "02-970-5026");
        CallBean call36 = new CallBean("학력조회/결강사유서", "02-970-5026");
        CallBean call37 = new CallBean("학력조회/결강사유서", "02-970-5026");
        CallBean call38 = new CallBean("학력조회/결강사유서", "02-970-5026");
        CallBean call39 = new CallBean("학력조회/결강사유서", "02-970-5026");
        CallBean call40 = new CallBean("학력조회/결강사유서", "02-970-5026");





        //ArrayList<String> m_List = new ArrayList<>();

        ArrayList<CallBean> list = new ArrayList<CallBean>();
        list.add(call1);
        list.add(call2);
        list.add(call3);
        list.add(call4);
        list.add(call5);
        list.add(call6);
        list.add(call7);
        list.add(call8);
        list.add(call9);
        list.add(call10);
        list.add(call11);
        list.add(call12);
        list.add(call13);
        list.add(call14);
        list.add(call15);
        list.add(call16);
        list.add(call17);
        list.add(call18);
        list.add(call19);
        list.add(call20);
        list.add(call21);
        list.add(call22);
        list.add(call23);
        list.add(call24);
        list.add(call25);





        //어댑터 생성
        m_Adapter = new CallListAdapter(list);

        // Xml에서 추가한 ListView 연결
        m_ListView = (ListView) view.findViewById(R.id.fragListView);

        // ListView에 어댑터 연결
        m_ListView.setAdapter(m_Adapter);





        /*
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int position, long id) {

                CallListItem item = (CallListItem) adapterView.getItemAtPosition(position);

                Drawable imgCallList = item.getImgCallList();
                String txtCallList = item.getTxtCallList();
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                String strText = (String) adapterView.getItemAtPosition(i);
            }
        });
        */


        return view;


    } // end OnCreate

    private View.OnClickListener CallClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.fragBtn1:
                    Intent i1 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:010-0000-0000"));
                    try {
                        startActivity(i1);
                    } catch (Exception e ) {
                        e.printStackTrace();
                    }
                    break;
                case R.id.fragBtn2:
                    Intent i2 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:010-1111-1111"));
                    try {
                        startActivity(i2);
                    } catch (Exception e ) {
                        e.printStackTrace();
                    }
                    break;
                case R.id.fragBtn3:
                    Intent i3 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:010-2222-2222"));
                    try {
                        startActivity(i3);
                    } catch (Exception e ) {
                        e.printStackTrace();
                    }

            } // end switch

        }

    }; //end CallClick

}
