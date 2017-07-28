package app.swuinfo.guru.com.swuinfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by xnote on 2017-07-28.
 */

public class NoticeListAdapter extends BaseAdapter {

    private Context context;
    private List<NoticeBean.Item> dataList;

    public NoticeListAdapter(Context context, List<NoticeBean.Item> dataList) {
        this.context = context;
        this.dataList = dataList;
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
        LayoutInflater lf = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = lf.inflate(R.layout.lay_notice_list, null);
        NoticeBean.Item noticeData = dataList.get(i);
        TextView txtNoticeTitle = (TextView)view.findViewById(R.id.txtNoticeTitle);

        txtNoticeTitle.setText(noticeData.getSubject());

        return view;
    }
}
