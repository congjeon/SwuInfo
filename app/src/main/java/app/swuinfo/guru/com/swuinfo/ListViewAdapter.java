package app.swuinfo.guru.com.swuinfo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 2017-07-27.
 */

public class ListViewAdapter extends BaseAdapter {

    private Context mContext;
    private List<ListItem> listItem = new ArrayList<ListItem>();

    public ListViewAdapter(Context context) {
        mContext=context;
    }

    public void addItem(ListItem item) {
        listItem.add(item);
    }


    @Override
    public int getCount() {
        return listItem.size();
    }

    @Override
    public Object getItem(int positon) {
        return listItem.get(positon);
    }

    @Override
    public long getItemId(int positon) {
        return positon;
    }

    @Override
    public View getView(int positon, View view, ViewGroup viewGroup) {

        ListViewLayout itemView;
        if(view == null) {
            itemView = new ListViewLayout(mContext,listItem.get(positon));
        } else {
            itemView = (ListViewLayout) view;
            itemView.setText(listItem.get(positon).getText());
        }
        return itemView;
    }
}
