package app.swuinfo.guru.com.swuinfo;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;


/**
 * A simple {@link Fragment} subclass.
 */
public class NoticeFragment extends Fragment {

    public NoticeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notice, container, false);

        ImageView imgSearch = (ImageView)view.findViewById(R.id.imgSearch);
        final TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabBar);
        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        final NoticeContentsAdapter adapter = new NoticeContentsAdapter(getChildFragmentManager());
        adapter.addFragment(new NotiFragment1(), "학사");
        adapter.addFragment(new NotiFragment2(), "장학");
        adapter.addFragment(new NotiFragment3(), "행사");
        adapter.addFragment(new NotiFragment4(), "일반");
        adapter.addFragment(new NotiFragment5(), "채용");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }
}
