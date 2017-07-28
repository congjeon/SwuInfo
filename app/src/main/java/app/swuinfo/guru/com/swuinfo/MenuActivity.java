package app.swuinfo.guru.com.swuinfo;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MenuActivity extends CommonActivity {

    ImageView tabNotice, tabSchedule, tabCall, tabSite, tabShuttle;
    private final int FRAGMENT_NOTICE = 1;
    private final int FRAGMENT_SCHEDULE = 2;
    private final int FRAGMENT_SITE = 3;
    private final int FRAGMENT_CALL = 4;
    private final int FRAGMENT_SHUTTLE = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        tabNotice = (ImageView)findViewById(R.id.tabNotice);
        tabSchedule = (ImageView)findViewById(R.id.tabSchedule);
        tabCall = (ImageView)findViewById(R.id.tabCall);
        tabSite = (ImageView)findViewById(R.id.tabSite);
        tabShuttle = (ImageView)findViewById(R.id.tabShuttle);

        switch (getIntent().getExtras().getInt("where")) {
            case 1:
                callFragment(FRAGMENT_NOTICE);
                break;
            case 2:
                callFragment(FRAGMENT_SCHEDULE);
                break;
            case 3:
                callFragment(FRAGMENT_SITE);
                break;
            case 4:
                callFragment(FRAGMENT_CALL);
                break;
            case 5:
                callFragment(FRAGMENT_SHUTTLE);
                break;
        }

        tabNotice.setOnClickListener(tabClick);
        tabSchedule.setOnClickListener(tabClick);
        tabCall.setOnClickListener(tabClick);
        tabSite.setOnClickListener(tabClick);
        tabShuttle.setOnClickListener(tabClick);
    }

    //클릭 이벤트
    private View.OnClickListener tabClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.tabNotice:
                    callFragment(FRAGMENT_NOTICE);
                    break;
                case R.id.tabSchedule:
                    callFragment(FRAGMENT_SCHEDULE);
                    break;
                case R.id.tabCall:
                    callFragment(FRAGMENT_CALL);
                    break;
                case R.id.tabSite:
                    callFragment(FRAGMENT_SITE);
                    break;
                case R.id.tabShuttle:
                    callFragment(FRAGMENT_SHUTTLE);
                    break;
            }
        }
    };

    //프래그먼트 호출 함수
    private void callFragment(int FragmentNo) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (FragmentNo) {
            case FRAGMENT_NOTICE:
                tabSchedule.setImageResource(R.drawable.tab_icon_schedule);
                tabCall.setImageResource(R.drawable.tab_icon_call);
                tabSite.setImageResource(R.drawable.tab_icon_site);
                tabShuttle.setImageResource(R.drawable.tab_icon_shuttle);
                tabNotice.setImageResource(R.drawable.tab_icon_notice_click);
                NoticeFragment fragmentNotice = new NoticeFragment();
                transaction.replace(R.id.fragment_container, fragmentNotice);
                transaction.commit();
                break;
            case FRAGMENT_SCHEDULE:
                tabSchedule.setImageResource(R.drawable.tab_icon_schedule_click);
                tabCall.setImageResource(R.drawable.tab_icon_call);
                tabSite.setImageResource(R.drawable.tab_icon_site);
                tabShuttle.setImageResource(R.drawable.tab_icon_shuttle);
                tabNotice.setImageResource(R.drawable.tab_icon_notice);
                ScheduleFragment fragmentSchedule = new ScheduleFragment();
                transaction.replace(R.id.fragment_container, fragmentSchedule);
                transaction.commit();
                break;
            case FRAGMENT_SITE:
                tabSchedule.setImageResource(R.drawable.tab_icon_schedule);
                tabCall.setImageResource(R.drawable.tab_icon_call);
                tabSite.setImageResource(R.drawable.tab_icon_site_click);
                tabShuttle.setImageResource(R.drawable.tab_icon_shuttle);
                tabNotice.setImageResource(R.drawable.tab_icon_notice);
                SiteFragment fragmentSite = new SiteFragment();
                transaction.replace(R.id.fragment_container, fragmentSite);
                transaction.commit();
                break;
            case FRAGMENT_CALL:
                tabSchedule.setImageResource(R.drawable.tab_icon_schedule);
                tabCall.setImageResource(R.drawable.tab_icon_call_click);
                tabSite.setImageResource(R.drawable.tab_icon_site);
                tabShuttle.setImageResource(R.drawable.tab_icon_shuttle);
                tabNotice.setImageResource(R.drawable.tab_icon_notice);
                CallFragment fragmentCall = new CallFragment();
                transaction.replace(R.id.fragment_container, fragmentCall);
                transaction.commit();
                break;
            case FRAGMENT_SHUTTLE:
                tabSchedule.setImageResource(R.drawable.tab_icon_schedule);
                tabCall.setImageResource(R.drawable.tab_icon_call);
                tabSite.setImageResource(R.drawable.tab_icon_site);
                tabShuttle.setImageResource(R.drawable.tab_icon_shuttle_click);
                tabNotice.setImageResource(R.drawable.tab_icon_notice);
                ShuttleFragment fragmentShuttle = new ShuttleFragment();
                transaction.replace(R.id.fragment_container, fragmentShuttle);
                transaction.commit();
                break;
        }
    }
}