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

        CallBean call1 = new CallBean("정보전산팀", "010-9999-9999");

        //ArrayList<String> m_List = new ArrayList<>();

        ArrayList<CallBean> list = new ArrayList<CallBean>();
        list.add(call1);

        /*m_List.add("건축팀");
        m_List.add("시설관재팀");
        m_List.add("재무팀");
        m_List.add("경영기획팀");
        m_List.add("전략평가팀");
        m_List.add("전략평가팀");
        m_List.add("전략평가팀");
        m_List.add("전략평가팀");
        m_List.add("전략평가팀");
        m_List.add("전략평가팀");
        m_List.add("전략평가팀");
        m_List.add("전략평가팀");
        m_List.add("전략평가팀");
        m_List.add("전략평가팀");
        */
        /*items.add(new CallBean.Item("정보전산팀", "010-9999-9999"));
        items.add(new CallBean.Item("건축팀", "010-9999-9999"));
        */// ListView에 아이템 추가
        /*m_List.add("정보전산팀");
        m_List.add("건축팀");
        m_List.add("시설관재팀");
        m_List.add("재무팀");
        m_List.add("경영기획팀");
        m_List.add("전략평가팀");
        m_List.add("전략평가팀");
        m_List.add("전략평가팀");
        m_List.add("전략평가팀");
        m_List.add("전략평가팀");
        m_List.add("전략평가팀");
        m_List.add("전략평가팀");
        m_List.add("전략평가팀");
        m_List.add("전략평가팀");
        m_List.add("전략평가팀");*/

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
