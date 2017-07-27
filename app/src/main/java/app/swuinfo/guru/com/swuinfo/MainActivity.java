package app.swuinfo.guru.com.swuinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends CommonActivity  {
    ImageView tabNotice, tabSchedule, tabCall, tabSite, tabShuttle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabNotice = (ImageView)findViewById(R.id.tabNotice);
        tabSchedule = (ImageView)findViewById(R.id.tabSchedule);
        tabCall = (ImageView)findViewById(R.id.tabCall);
        tabSite = (ImageView)findViewById(R.id.tabSite);
        tabShuttle = (ImageView)findViewById(R.id.tabShuttle);

        tabNotice.setOnClickListener(tabClick);
        tabSchedule.setOnClickListener(tabClick);
        tabCall.setOnClickListener(tabClick);
        tabSite.setOnClickListener(tabClick);
        tabShuttle.setOnClickListener(tabClick);

        startActivity(new Intent(MainActivity.this, SplashActivity.class));
    }

    private View.OnClickListener tabClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.tabNotice:
                    tabSchedule.setImageResource(R.drawable.tab_icon_schedule);
                    tabCall.setImageResource(R.drawable.tab_icon_call);
                    tabSite.setImageResource(R.drawable.tab_icon_site);
                    tabShuttle.setImageResource(R.drawable.tab_icon_shuttle);
                    tabNotice.setImageResource(R.drawable.tab_icon_notice_click);
                    break;
                case R.id.tabSchedule:
                    tabSchedule.setImageResource(R.drawable.tab_icon_schedule_click);
                    tabCall.setImageResource(R.drawable.tab_icon_call);
                    tabSite.setImageResource(R.drawable.tab_icon_site);
                    tabShuttle.setImageResource(R.drawable.tab_icon_shuttle);
                    tabNotice.setImageResource(R.drawable.tab_icon_notice);
                    break;
                case R.id.tabCall:
                    tabSchedule.setImageResource(R.drawable.tab_icon_schedule);
                    tabCall.setImageResource(R.drawable.tab_icon_call_click);
                    tabSite.setImageResource(R.drawable.tab_icon_site);
                    tabShuttle.setImageResource(R.drawable.tab_icon_shuttle);
                    tabNotice.setImageResource(R.drawable.tab_icon_notice);
                    break;
                case R.id.tabSite:
                    tabSchedule.setImageResource(R.drawable.tab_icon_schedule);
                    tabCall.setImageResource(R.drawable.tab_icon_call);
                    tabSite.setImageResource(R.drawable.tab_icon_site_click);
                    tabShuttle.setImageResource(R.drawable.tab_icon_shuttle);
                    tabNotice.setImageResource(R.drawable.tab_icon_notice);
                    break;
                case R.id.tabShuttle:
                    tabSchedule.setImageResource(R.drawable.tab_icon_schedule);
                    tabCall.setImageResource(R.drawable.tab_icon_call);
                    tabSite.setImageResource(R.drawable.tab_icon_site);
                    tabShuttle.setImageResource(R.drawable.tab_icon_shuttle_click);
                    tabNotice.setImageResource(R.drawable.tab_icon_notice);
                    break;
            }
        }
    };

}
