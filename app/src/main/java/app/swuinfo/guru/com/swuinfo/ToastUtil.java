package app.swuinfo.guru.com.swuinfo;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by pc on 2017-08-01.
 */

public class ToastUtil {
    private static Toast mToast;
    public static void showToast(Context context, String msg){
        if(mToast!=null){
            mToast.cancel();

        } mToast=Toast.makeText(context,msg, Toast.LENGTH_LONG);

        // mToast.setText(msg);
        mToast.show();
    }
}

