package app.swuinfo.guru.com.swuinfo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;


/**
 * A simple {@link Fragment} subclass.
 */
public class NotiFragment4 extends Fragment {

    public NotiFragment4() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final ListView noticeList;

        View view = inflater.inflate(R.layout.fragment_noti_fragment4, container, false);
        noticeList = (ListView)view.findViewById(R.id.noticeList);
        final EditText edtSearchKeyword = (EditText) view.findViewById(R.id.edtSearchKeyword);
        ImageView btnSearchCancel = (ImageView) view.findViewById(R.id.searchCancel);
        ImageView btnSearch = (ImageView) view.findViewById(R.id.imgSearch);
        final ProgressBar prd = (ProgressBar)view.findViewById(R.id.progressBar);

        new NoticeTask(getActivity(), noticeList, prd).execute("http://203.246.40.125/swu/bbs/notice15.php");

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String searchKeyword = edtSearchKeyword.getText().toString();
                new NoticeSearchTask(getActivity(), noticeList, prd, searchKeyword).execute("http://203.246.40.125/swu/bbs/notice15.php");
            }
        });

        btnSearchCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtSearchKeyword.setText("");
                new NoticeTask(getActivity(), noticeList, prd).execute("http://203.246.40.125/swu/bbs/notice15.php");
            }
        });

        return  view;
    }

}
