package app.swuinfo.guru.com.swuinfo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by seonmi on 2017-07-27.
 */

public class ScheDuleItemView extends LinearLayout {

    private TextView mTxtDayList;
    private TextView mTxtTitleList;

    public ScheDuleItemView(Context context) {
        super(context);
        init(context);
    }

    /* 생성자 */
    public ScheDuleItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    /* 초기화 */
    private void init(Context context) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.schedule_view,this,true);
        mTxtDayList=(TextView)findViewById(R.id.txtDayList);
        mTxtTitleList=(TextView)findViewById(R.id.txtTitleList);
    }

    public void setmTxtDayList(String dayList){
        mTxtDayList.setText(dayList);
    }
    public void setmTxtTitleList(String titleList){
        mTxtTitleList.setText(String.valueOf(titleList));
    }



}
