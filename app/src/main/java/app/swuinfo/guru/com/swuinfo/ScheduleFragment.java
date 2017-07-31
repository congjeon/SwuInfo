package app.swuinfo.guru.com.swuinfo;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleFragment extends Fragment {

    private TextView mMonthText;
    private GridView mMonthView;
    private ListView mDailyAmountView;
    private MonthAdapter mMonthAdapter;
    private ScheDuleAdapter mScheDuleAdapter;
    private int year,month;

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }


    public ScheduleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_schedule, container, false);

        mMonthText = (TextView)view.findViewById(R.id.monthText);
        mMonthView = (GridView)view.findViewById(R.id.calendarView);
        mDailyAmountView = (ListView)view.findViewById(R.id.listView);

        mMonthAdapter = new MonthAdapter(getActivity());
        mScheDuleAdapter = new ScheDuleAdapter(getActivity());

        year=mMonthAdapter.getCurrentYear();
        month=mMonthAdapter.getCurrentMonth();

        mMonthView.setAdapter(mMonthAdapter);
        mDailyAmountView.setAdapter(mScheDuleAdapter);

        mMonthText.setText(mMonthAdapter.getCurrentYear() + "년" + mMonthAdapter.getCurrentMonth() + "월");


            /* monthPrevious버튼 클릭시 */
        ImageView monthPrevious = (ImageView)view.findViewById(R.id.monthPrevious);
        monthPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMonthAdapter.setPriviousMonth();
                mMonthAdapter.notifyDataSetChanged();
                mMonthText.setText(mMonthAdapter.getCurrentYear() + "년" + mMonthAdapter.getCurrentMonth() + "월");
            }
        });
           /* monthNext버튼 클릭시 */
        ImageView monthNext = (ImageView)view.findViewById(R.id.monthNext);
        monthNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMonthAdapter.setNextMonth();
                mMonthAdapter.notifyDataSetChanged();
                mMonthText.setText(mMonthAdapter.getCurrentYear() + "년" + mMonthAdapter.getCurrentMonth() + "월");
            }
        });

         return view;
    }

    /*public void showMessage(){
        AlertDialog.Builder builder= new AlertDialog.Builder(getActivity());
        builder.setTitle("요일");
        builder.setMessage("종료하시겠습니까?");
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        //"예"버튼을 눌렀을떄
        builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog dialog =builder.create();
        dialog.show();
    }*/

}
