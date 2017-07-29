package app.swuinfo.guru.com.swuinfo;


import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class NotiFragment1 extends Fragment {

    public NotiFragment1() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final ListView noticeList;

        View view = inflater.inflate(R.layout.fragment_noti_fragment1, container, false);
        noticeList = (ListView)view.findViewById(R.id.noticeList);
        final EditText edtSearchKeyword = (EditText) view.findViewById(R.id.edtSearchKeyword);
        ImageView btnSearchCancel = (ImageView) view.findViewById(R.id.searchCancel);
        ImageView btnSearch = (ImageView) view.findViewById(R.id.imgSearch);
        final ProgressBar prd = (ProgressBar)view.findViewById(R.id.progressBar);

        new NoticeTask(getActivity(), noticeList, prd).execute("http://203.246.40.125/swu/bbs/notice11.php");

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String searchKeyword = edtSearchKeyword.getText().toString();
                new NoticeSearchTask(getActivity(), noticeList, prd, searchKeyword).execute("http://203.246.40.125/swu/bbs/notice11.php");
            }
        });

        btnSearchCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtSearchKeyword.setText("");
                new NoticeTask(getActivity(), noticeList, prd).execute("http://203.246.40.125/swu/bbs/notice11.php");
            }
        });

        return  view;
    }

}
