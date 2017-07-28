package app.swuinfo.guru.com.swuinfo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by samsung on 2017-07-27.
 */

public class ScheDuleAdapter extends BaseAdapter {

    ArrayList<ScheDuleItem> items = new ArrayList<ScheDuleItem>();
    Context context;

    public ScheDuleAdapter(Context context) {
        this.context = context;
    }

    public void addAdapter(ScheDuleItem item){
        items.add(item);
    }

    // 데이터 개수
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // position몇번째 뷰
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ScheDuleItemView view=new ScheDuleItemView(context.getApplicationContext());
        ScheDuleItem item =items.get(position);
        view.setmTxtDayList(item.getmDay());
        view.setmTxtTitleList(item.getmTitle());

        return view;
    }



}
