package app.swuinfo.guru.com.swuinfo;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static app.swuinfo.guru.com.swuinfo.R.layout.lay_call_list;

/**
 * Created by pc on 2017-07-27.
 */

public class CallListAdapter extends BaseAdapter {

    // 문자열을 보관 할 ArrayList
    private List<CallBean> m_List;
    private CallBean callBean;

    // 생성자
    public CallListAdapter(ArrayList<CallBean> list) {
        this.m_List = list;
    }

    // 현재 아이템의 수를 리턴
    @Override
    public int getCount() {
        return m_List.size();
    }

    // 현재 아이템의 오브젝트를 리턴, Object를 상황에 맞게 변경하거나 리턴받은 오브젝트를 캐스팅해서 사용
    @Override
    public Object getItem(int position) {
        return m_List.get(position);
    }

    // 아이템 position의 ID 값 리턴
    @Override
    public long getItemId(int position) {
        return position;
    }

    // 출력 될 아이템 관리
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // view가 null일 경우 커스텀 레이아웃을 얻어 옴
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.lay_call_list, parent, false);

        final CallBean  bean = m_List.get(position);

        TextView text = (TextView) convertView.findViewById(R.id.txtCallList);
        text.setText( bean.getTeam() );

        // 버튼을 터치 했을 때 이벤트 발생
        ImageButton btn = (ImageButton) convertView.findViewById(R.id.btnCallList);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, "전화 거는 중 : "+ bean.getTeam(), Toast.LENGTH_SHORT).show();
                Intent i1 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + bean.getTeam_Tel()));
                try {
                    context.startActivity(i1);
                } catch (Exception e ) {
                    e.printStackTrace();
                }

            }
        });

   /*     // 리스트 아이템을 터치 했을 때 이벤트 발생
        convertView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 터치 시 해당 아이템 이름 출력
                Toast.makeText(context, "전화 거는 중 : " + m_List.get(pos), Toast.LENGTH_SHORT).show();
                Intent i1 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + m_List.get(pos)));
                try {
                    context.startActivity(i1);
                } catch (Exception e ) {
                    e.printStackTrace();
                }
            }
        });*/


        return convertView;
    }
/*
    // 외부에서 아이템 추가 요청 시 사용
    public void add(String _msg) {
        m_List.add(_msg);
    }*/

    // 외부에서 아이템 삭제 요청 시 사용
    public void remove(int _position) {
        m_List.remove(_position);
    }
}
