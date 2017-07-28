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
public class NotiFragment1 extends Fragment {


    public NotiFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ListView noticeList;

        View view = inflater.inflate(R.layout.fragment_noti_fragment1, container, false);
        noticeList = (ListView)view.findViewById(R.id.noticeList);

        new NoticeTask(getActivity(), noticeList).execute("http://203.246.40.125/swu/bbs/notice12.php");

        return  view;
    }

}
