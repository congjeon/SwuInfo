package app.swuinfo.guru.com.swuinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by samsung on 2017-07-27.
 */

public class DateItemView extends RelativeLayout {

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    private TextView textView;
    //ImageView imageView;

    public DateItemView(Context context) {
        super (context);
        init(context);
    }

    public DateItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init (Context context){
        // month_item뷰 불러오기
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.month_view,this,true);
        textView = (TextView)findViewById(R.id.textView);
        //imageView=(ImageView)findViewById(R.id.imageView);
    }

    public void setDate(DateItem date){
        if(date.getDate()==0){
            textView.setText("");
        }
        else {
            // day를 문자로 바꿔서
            textView.setText(String.valueOf(date.getDate()));
        }
    }

}

