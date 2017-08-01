package app.swuinfo.guru.com.swuinfo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
        ImageView imgNotice;
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
            holder.imgNotice = (ImageView) view.findViewById(R.id.imgNotice);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        final NoticeBean.Item noticeData = dataList.get(i);
        holder.txtNoticeTitle.setText(noticeData.getSubject());

        //엊그제 날짜 구하기
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.add(cal.DATE, -2);
        String beforeYesterday = date.format(cal.getTime());

        //어제 날짜 구하기
        cal = Calendar.getInstance();
        cal.add(cal.DATE, -1);
        String yesterday = date.format(cal.getTime());

        //오늘 날짜 구하기
        Date currentTime = new Date ();
        String mTime = date.format (currentTime);

        String noticeDates = noticeData.getDates().substring(0, 10);

        //최신 공지 표시
        if(noticeDates.equals(mTime)) {
            holder.imgNotice.setImageResource(R.drawable.special_notice);
        } else if(noticeDates.equals(yesterday)) {
            holder.imgNotice.setImageResource(R.drawable.special_notice);
        } else if(noticeDates.equals(beforeYesterday)) {
            holder.imgNotice.setImageResource(R.drawable.special_notice);
        } else {
            holder.imgNotice.setImageResource(R.drawable.common_notice);
        }

        //공지 상세 페이지로
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
}
