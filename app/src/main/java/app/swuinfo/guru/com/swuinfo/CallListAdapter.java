package app.swuinfo.guru.com.swuinfo;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static app.swuinfo.guru.com.swuinfo.R.layout.lay_call_list;

/**
 * Created by pc on 2017-07-27.
 */

public class CallListAdapter extends BaseAdapter {

    private Context mContext;
    private List<CallListItem> callListItemList = new ArrayList<CallListItem>();

    public CallListAdapter(Context context) {
        mContext=context;
    }


    @Override
    public int getCount() {
        return callListItemList.size();
    }

    @Override
    public Object getItem(int positon) {
        return callListItemList.get(positon);
    }

    @Override
    public long getItemId(int positon) {
        return positon;
    }

    @Override
    public View getView(int positon, View convertview, ViewGroup viewGroup) {

        final Context context = viewGroup.getContext();

        if(convertview == null) {
            LayoutInflater li = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertview = li.inflate(R.layout.lay_call_list, null, false);
        }

        ImageView imgCallList = (ImageView)convertview.findViewById(R.id.imgCallList);
        TextView txtCallList = (TextView)convertview.findViewById(R.id.txtCallList);

        CallListItem callListItem = callListItemList.get(positon);

        imgCallList.setImageDrawable(callListItem.getImgCallList());
        txtCallList.setText(callListItem.getTxtCallList());

        return convertview;
    }

    public void addItem(Drawable icon, String txt) {
        CallListItem item = new CallListItem();

        item.setImgCallList(icon);
        item.setTxtCallList(txt);

        callListItemList.add(item);
    }

}
