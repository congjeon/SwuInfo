package app.swuinfo.guru.com.swuinfo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class NotiFragment4 extends Fragment {


    public NotiFragment4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ListView noticeList;

        View view = inflater.inflate(R.layout.fragment_noti_fragment4, container, false);
        noticeList = (ListView)view.findViewById(R.id.noticeList);

        new NoticeTask(getActivity(), noticeList).execute("http://203.246.40.125/swu/bbs/notice12.php");

        return  view;
    }

}
