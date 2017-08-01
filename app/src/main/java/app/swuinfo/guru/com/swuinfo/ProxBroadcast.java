package app.swuinfo.guru.com.swuinfo;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/**
 * Created by pc on 2017-08-01.
 */

public class ProxBroadcast extends BroadcastReceiver {
    private String mActionName;
    private Intent mLastReceivedIntent;
    public ProxBroadcast(){};

    public ProxBroadcast(String actionName){
        mActionName=actionName;
        mLastReceivedIntent=null;

    }
    public IntentFilter getFilter(){
        IntentFilter filter=new IntentFilter(mActionName);
        return filter;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent!=null){
            mLastReceivedIntent=intent;
            int id=intent.getIntExtra("id",0);
            double lat=intent.getDoubleExtra("latitude",0.0);
            double lng=intent.getDoubleExtra("longitude",0.0);

            AlertDialog.Builder builder=new AlertDialog.Builder(context);
            builder.setTitle("근접경보");
            builder.setMessage("지금 현재 등록된 위치 근처에 도달 하였습니다.");
            builder.create().show();
        }

    }
}
