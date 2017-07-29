package app.swuinfo.guru.com.swuinfo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by xnote on 2017-07-28.
 */

public class NoticeListAdapter extends BaseAdapter {

    private Context context;
    private List<NoticeBean.Item> dataList;
    private ArrayList<NoticeBean.Item> arraylist;

    public NoticeListAdapter(Context context, List<NoticeBean.Item> dataList) {
        this.context = context;
        this.dataList = dataList;
        this.arraylist = new ArrayList<NoticeBean.Item>();
        this.arraylist.addAll(dataList);
    }

    public class ViewHolder {
        TextView txtNoticeTitle;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return dataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder holder;
        if(view == null) {
            holder = new ViewHolder();
            LayoutInflater lf = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = lf.inflate(R.layout.lay_notice_list, null);

            holder.txtNoticeTitle = (TextView) view.findViewById(R.id.txtNoticeTitle);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        final NoticeBean.Item noticeData = dataList.get(i);
        holder.txtNoticeTitle.setText(noticeData.getSubject());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, NoticeDetail.class);
                intent.putExtra("noticeData", noticeData);

                context.startActivity(intent);
            }
        });

        return view;
    }

    public void filter(String charText) {
        dataList.clear();
        if (charText.length() == 0) {
            dataList.addAll(arraylist);
        } else {
            for (NoticeBean.Item nb : arraylist) {
                if (nb.getSubject().contains(charText)) {
                    dataList.add(nb);
                }
            }
        }
        notifyDataSetChanged();
    }
}
