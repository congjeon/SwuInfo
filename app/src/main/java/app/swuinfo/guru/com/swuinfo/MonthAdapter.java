package app.swuinfo.guru.com.swuinfo;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by seonmi 2017-07-27.
 */
public class MonthAdapter extends BaseAdapter {

    private Context mContext;
    private DateItem[] mItems;
    private Calendar mCalendar;

    private int countColumn = 7;

    private int mFirstDay;
    private int mLastDay;
    private int mCurYear;
    private int mCurMonth;
    private ScheduleBean scheduleBean;


    /* 생성자 */
    public MonthAdapter(Context context) {
        super();
        this.mContext = context;
        init();
    }

    public MonthAdapter(Context context, ScheduleBean scheduleBean) {
        super();
        this.mContext = context;
        this.scheduleBean = scheduleBean;
        init();
    }

    public MonthAdapter(Context context, AttributeSet attrs) {
        super();
        this.mContext = context;
        init();
    }

    /* 초기화 */
    private void init()  {
        mItems = new DateItem[7 * 6];

        Date date = new Date();
        /* calendar에 현재 시간 설정 */
        mCalendar = Calendar.getInstance();
        mCalendar.setTime(date);

        recalculate();
        resetDayNumbers();
    }

    /* 이전 월로 설정 */
    public void setPriviousMonth() {
        mCalendar.add(Calendar.MONTH, -1);
        recalculate();
        resetDayNumbers();

    }

    /* 다음 월로 설정 */
    public void setNextMonth() {
        mCalendar.add(Calendar.MONTH, 1);
        recalculate();
        resetDayNumbers();
    }

    public int getCurrentYear() {
        return mCurYear;
    }

    public int getCurrentMonth() {
        return mCurMonth + 1;
    }


    /* 달력 데이터 다시 setting */
    public void recalculate() {
        // 현재 월에 1일설정
        mCalendar.set(Calendar.DAY_OF_MONTH, 1);
        // 해당되는 주의 몇번째 index인가
        int dayOfWeek = mCalendar.get(Calendar.DAY_OF_WEEK);
        mFirstDay = getFistDay(dayOfWeek);

        mCurYear = mCalendar.get(Calendar.YEAR);
        mCurMonth = mCalendar.get(Calendar.MONTH);
        mLastDay = getLastDay(mCurYear,mCurMonth);
    }

    /* dateitem에 날짜 설정 */
    public void resetDayNumbers() {
        for (int i = 0; i < 42; i++) {
            int dayNumber = (i + 1) - mFirstDay;
            if (dayNumber < 1 || dayNumber > mLastDay) {
                dayNumber = 0;
            }
            // date를 설정
            mItems[i] = new DateItem(dayNumber);
        }
    }

    public int getFistDay(int dayOfWeek) {
        int result = 0;
        if (dayOfWeek == Calendar.SUNDAY) {
            result = 0;
        } else if (dayOfWeek == Calendar.MONDAY) {
            result = 1;
        } else if (dayOfWeek == Calendar.TUESDAY) {
            result = 2;
        } else if (dayOfWeek == Calendar.WEDNESDAY) {
            result = 3;
        } else if (dayOfWeek == Calendar.THURSDAY) {
            result = 4;
        } else if (dayOfWeek == Calendar.FRIDAY) {
            result = 5;
        } else if (dayOfWeek == Calendar.SATURDAY) {
            result = 6;
        }
        return result;
    }

    public int getLastDay(int curYear, int curMonth) {
        switch (curMonth) {
            case 0:
            case 2:
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
                return 31;
            case 3:
            case 5:
            case 8:
            case 10:
                return 30;
            default:
                //윤달
                if ((curYear % 4 == 0) && (curYear % 100 != 0) || (curYear % 400 == 0)) {
                    return 29;
                } else {
                    return 28;
                }
        }
    }

    @Override
    public int getCount() {
        return 42;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        DateItemView view = null;

        int columnIndex = position % countColumn;

        if (convertView == null) {
            view = new DateItemView(mContext.getApplicationContext());
        } else {
            view = (DateItemView) convertView;
        }

        /* 레이아웃 파라미터 width, height */
        GridView.LayoutParams params = new GridView.LayoutParams(
                GridView.LayoutParams.MATCH_PARENT,
                180);

        /* 일요일에 빨간표시 */
        if (columnIndex == 0) {
            view.getTextView().setTextColor(Color.RED);
        } else {
            view.getTextView().setTextColor(Color.BLACK);
        }

        /* 화면에 설정 */
        view.setLayoutParams(params);
        view.setDate(mItems[position]);

        return view;
    }

}
