package app.swuinfo.guru.com.swuinfo;


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.icu.util.VersionInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CallFragment extends Fragment {

    private CallBean callBean;
    private ProgressBar prd;
    private ArrayList<CallBean> arrayList = new ArrayList<CallBean>();


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
        View view1 = inflater.inflate(R.layout.fragment_call, container, false);

        ImageView imgSearch = (ImageView)view1.findViewById(R.id.imgSearch);
        final TabLayout tabLayout = (TabLayout) view1.findViewById(R.id.tabBar);
        final EditText searchKeyword = (EditText) view1.findViewById(R.id.edtSearchKeyword2);
        prd = (ProgressBar) view1.findViewById(R.id.progressBar2);


        view1.findViewById(R.id.fragBtn1).setOnClickListener(CallClick);
        view1.findViewById(R.id.fragBtn2).setOnClickListener(CallClick);
        view1.findViewById(R.id.fragBtn3).setOnClickListener(CallClick);

        CallBean call1 = new CallBean("교과/강의실지원", "02-970-5020");
        CallBean call2 = new CallBean("수업/수강신청(전공)문의", "02-970-5022");
        CallBean call3 = new CallBean("수업/수강신청(교양)문의", "02-970-5032");
        CallBean call4 = new CallBean("계절학기/강의실지원문의", "02-970-5023");
        CallBean call5 = new CallBean("학적/졸업/강의평가문의", "02-970-5021");
        CallBean call6 = new CallBean("휴복학/복수부전공/전과/성적문의", "02-970-5025");
        CallBean call7 = new CallBean("강사료/전자출결/e-class문의", "02-970-5024");
        CallBean call8 = new CallBean("학력조회/결강사유서문의", "02-970-5026");
        CallBean call9 = new CallBean("학점교류문의", "02-970-5023");
        CallBean call10 = new CallBean("ACE사업", "02-970-5028");
        CallBean call11 = new CallBean("SWU119(학사상담)", "02-970-1119");
        CallBean call12 = new CallBean("장학/국가근로문의", "02-970-5062");
        CallBean call13 = new CallBean("장학문의", "02-970-5063");
        CallBean call14 = new CallBean("증명서발급문의", "02-970-5064");
        CallBean call15 = new CallBean("국가근로문의", "02-970-5066");
        CallBean call16 = new CallBean("학생지원문의", "02-970-5068");
        CallBean call17 = new CallBean("보건실", "02-970-5075");
        CallBean call18 = new CallBean("진로상담문의", "02-970-7888");
        CallBean call19 = new CallBean("경비실-종합상황실", "02-970-1000");
        CallBean call20 = new CallBean("경비실-행정관(주관)", "02-970-5181");
        CallBean call21 = new CallBean("경비실-정문", "02-970-5183");
        CallBean call22 = new CallBean("경비실-남문", "02-970-5185");
        CallBean call23 = new CallBean("경비실-바롬관1층", "02-970-5193");
        CallBean call24 = new CallBean("경비실-샬롬하우스", "02-970-5194");
        CallBean call25 = new CallBean("경비실-국제교육관", "02-970-5198");
        CallBean call26 = new CallBean("경비실-50주년기념관(주관)", "02-970-7560");
        CallBean call27 = new CallBean("경비실-아름관,다움관", "02-970-7950");
        CallBean call28 = new CallBean("입학관련문의", "02-970-5055");
        CallBean call29 = new CallBean("ACE 사업문의", "02-970-7958");
        CallBean call30 = new CallBean("교환학생(Inbound)문의", "02-970-5142");
        CallBean call31 = new CallBean("국제교류/교환학생(Outbound)문의", "02-970-5143");
        CallBean call32 = new CallBean("교환학생(일본In/Out)문의", "02-970-5144");
        CallBean call33 = new CallBean("누리관우체국", "02-970-5381");
        CallBean call34 = new CallBean("우리은행", "02-970-5382");
        CallBean call35 = new CallBean("교직원식당", "02-970-6897");
        CallBean call36 = new CallBean("하나식당", "02-970-5384");
        CallBean call37 = new CallBean("샬롬하우스식당", "02-970-5385");
        CallBean call38 = new CallBean("서점", "02-970-5386");
        CallBean call39 = new CallBean("선물의집", "02-970-5387");
        CallBean call40 = new CallBean("카피윅스-50주년기념관", "02-970-5389");
        CallBean call41 = new CallBean("카피윅스-2과학관", "02-970-5796");
        CallBean call42 = new CallBean("가은", "02-970-5390");
        CallBean call43 = new CallBean("화방", "02-970-5391");
        CallBean call44 = new CallBean("안경점", "02-970-5377");
        CallBean call45 = new CallBean("에땅", "02-970-5388");
        CallBean call46 = new CallBean("인사대1층매점", "02-970-5392");
        CallBean call47 = new CallBean("미니슈퍼", "02-970-5394");
        CallBean call48 = new CallBean("팬도로시", "02-970-5395");
        CallBean call49 = new CallBean("구두방", "02-970-5396");
        CallBean call50 = new CallBean("스타벅스", "02-758-8647");
        CallBean call51 = new CallBean("뚜레쥬르", "02-978-9776");
        CallBean call52 = new CallBean("봉구스밥버거", "02-977-5094");
        CallBean call53 = new CallBean("아딸", "02-3296-5889");
        CallBean call54 = new CallBean("퀴즈노스", "02-977-7923");
        CallBean call55 = new CallBean("비틀주스", "02-979-1002");
        CallBean call56 = new CallBean("다독임", "02-949-6451");









        //ArrayList<String> m_List = new ArrayList<>();

        final ArrayList<CallBean> list = new ArrayList<CallBean>();
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
        list.add(call26);
        list.add(call27);
        list.add(call28);
        list.add(call29);
        list.add(call30);
        list.add(call31);
        list.add(call32);
        list.add(call33);
        list.add(call34);
        list.add(call35);
        list.add(call36);
        list.add(call37);
        list.add(call38);
        list.add(call39);
        list.add(call40);
        list.add(call41);
        list.add(call42);
        list.add(call43);
        list.add(call44);
        list.add(call45);
        list.add(call46);
        list.add(call47);
        list.add(call48);
        list.add(call49);
        list.add(call50);
        list.add(call51);
        list.add(call52);
        list.add(call53);
        list.add(call54);
        list.add(call55);
        list.add(call56);


        imgSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String keyword = searchKeyword.getText().toString();
                for(int i = 0; i < list.size(); i++) {
                    String data = list.get(i).getTeam();
                    if (data.contains(keyword)) {
                        arrayList.add(list.get(i));
                        m_Adapter = new CallListAdapter(arrayList);
                        m_ListView.setAdapter(m_Adapter);
                    }
                } if(arrayList.size() == 0) {
                    final AlertDialog builder = new AlertDialog.Builder(getActivity())
                            .setMessage("검색결과가 없습니다").show();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable(){
                        public void run(){
                            builder.dismiss();
                        }
                    }, 1500);
                }
            }
        });

        view1.findViewById(R.id.searchCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m_Adapter = new CallListAdapter(list);
                m_ListView.setAdapter(m_Adapter);
                searchKeyword.setText("");
            }
        });


        //어댑터 생성
        m_Adapter = new CallListAdapter(list);

        // Xml에서 추가한 ListView 연결
        m_ListView = (ListView) view1.findViewById(R.id.fragListView);

        // ListView에 어댑터 연결
        m_ListView.setAdapter(m_Adapter);



        return view1;


    } // end OnCreate

    private View.OnClickListener CallClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                //e-class, 종정시 안될때
                case R.id.fragBtn1:
                    Intent i1 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:02-970-5119"));
                    try {
                        startActivity(i1);
                    } catch (Exception e ) {
                        e.printStackTrace();
                    }
                    break;
                //냉난방문의
                case R.id.fragBtn2:
                    Intent i2 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:02-970-5176"));
                    try {
                        startActivity(i2);
                    } catch (Exception e ) {
                        e.printStackTrace();
                    }
                    break;
                //강의실 사용문의
                case R.id.fragBtn3:
                    Intent i3 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:02-970-5023"));
                    try {
                        startActivity(i3);
                    } catch (Exception e ) {
                        e.printStackTrace();
                    }

            } // end switch

        }

    }; //end CallClick

}
