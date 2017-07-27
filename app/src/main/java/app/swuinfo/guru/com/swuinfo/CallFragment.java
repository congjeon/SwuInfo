package app.swuinfo.guru.com.swuinfo;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CallFragment extends Fragment {

    private EditText editText;
    private Button btn1, btn2, btn3;
    private ListView listView;
    private CallListAdapter adapter;


    public CallFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //현재 view에서 find view by id하기 위한 뷰 지정
        View view = inflater.inflate(R.layout.fragment_call, container, false);

        editText = (EditText) view.findViewById(R.id.fragEdtFilter);
        btn1 = (Button) view.findViewById(R.id.fragBtn1);
        btn2 = (Button) view.findViewById(R.id.fragBtn2);
        btn3 = (Button) view.findViewById(R.id.fragBtn3);

        listView = (ListView) view.findViewById(R.id.fragListView);

        //adapter = new CallListAdapter(this);
        //listView.setAdapter(adapter);

        //adapter.addItem(ContextCompat.getDrawable(CallFragment.this, R.drawable.telephone),"학생지원팀");
        //adapter.addItem(ContextCompat.getDrawable(CallActivity.this, R.drawable.telephone),"정보전산팀");


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int position, long id) {

                CallListItem item = (CallListItem) adapterView.getItemAtPosition(position);

                Drawable imgCallList = item.getImgCallList();
                String txtCallList = item.getTxtCallList();
            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:010-0000-0000"));
                try {
                    startActivity(i);
                } catch (Exception e ) {
                    e.printStackTrace();
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:010-1111-1111"));
                try {
                    startActivity(i);
                } catch (Exception e ) {
                    e.printStackTrace();
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:010-2222-2222"));
                try {
                    startActivity(i);
                } catch (Exception e ) {
                    e.printStackTrace();
                }
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                String strText = (String) adapterView.getItemAtPosition(i);
            }
        });


        return view;
    }

}
