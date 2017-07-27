package app.swuinfo.guru.com.swuinfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by pc on 2017-07-27.
 */

public class ListViewLayout extends LinearLayout {

    private TextView btn;
    public ListViewLayout(Context context, ListItem item) {
        super(context);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.lay_list,this,true);

        btn = (TextView)findViewById(R.id.btn);
        btn.setText(item.getText());
    }

    public void setText(String text) {
        btn.setText(text);
    }
}
