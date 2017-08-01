package app.swuinfo.guru.com.swuinfo;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.Fragment;

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

        final CallBean bean = m_List.get(position);

        TextView text = (TextView) convertView.findViewById(R.id.txtCallList);
        text.setText(bean.getTeam());

        // 버튼을 터치 했을 때 이벤트 발생
        ImageButton btn = (ImageButton) convertView.findViewById(R.id.btnCallList);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*if (bean.getTeam().toString().equals("취업상담")) {
                    AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
                    alertBuilder.setTitle("번호를 선택하세요.");

                    final ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.select_dialog_singlechoice);
                    adapter.add("02-970-5081");
                    adapter.add("02-970-5082");
                    adapter.add("02-970-5083");
                    adapter.add("02-970-5084");
                    adapter.add("02-970-5085");

                    alertBuilder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });

                    // Adapter 셋팅
                    alertBuilder.setAdapter(adapter, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // AlertDialog 안에 있는 AlertDialog
                            switch (id) {
                                //영문
                                case 0:
                                    Intent i0 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:02-970-5081"));
                                    try {
                                        context.startActivity(i0);
                                    } catch (Exception e) {}
                                    break;
                                case 1:
                                    Intent i1 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:02-970-5082"));
                                    try {
                                        context.startActivity(i1);
                                    } catch (Exception e) {}
                                    break;
                                case 2:
                                    Intent i2 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:02-970-5082"));
                                    try {
                                        context.startActivity(i2);
                                    } catch (Exception e) {}
                                    break;
                                case 3:
                                    Intent i3 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:02-970-5082"));
                                    try {
                                        context.startActivity(i3);
                                    } catch (Exception e) {}
                                    break;

                                case 4:
                                    Intent i4 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:02-970-5082"));
                                    try {
                                        context.startActivity(i4);
                                    } catch (Exception e) {}
                                    break;

                            } // end swtich
                        }
                    });

            } //end if

                else if (bean.getTeam().toString().equals("경비실")) {
                    AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
                    alertBuilder.setTitle("번호를 선택하세요.");

                    final ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.select_dialog_singlechoice);
                    adapter.add("종합상황실");
                    adapter.add("행정관-주관");
                    adapter.add("정문");
                    adapter.add("남문");
                    adapter.add("도서관");
                    adapter.add("바롬관1층");
                    adapter.add("샬롬하우스");
                    adapter.add("국제교육관");
                    adapter.add("50주년기념관");
                    adapter.add("아름관,다움관");

                    alertBuilder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });

                    // Adapter 셋팅
                    alertBuilder.setAdapter(adapter, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // AlertDialog 안에 있는 AlertDialog
                            switch (id) {
                                //종합상황실
                                case 0:
                                    Intent i0 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:02-970-1000"));
                                    try {
                                        context.startActivity(i0);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                //행정관-주관
                                case 1:
                                    Intent i1 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:02-970-5181"));
                                    try {
                                        context.startActivity(i1);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                //정문
                                case 3:
                                    Intent i3 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:02-970-5183"));
                                    try {
                                        context.startActivity(i3);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                //남문
                                case 4:
                                    Intent i4 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:02-970-5185"));
                                    try {
                                        context.startActivity(i4);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                //도서관
                                case 5:
                                    Intent i5 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:02-970-5191"));
                                    try {
                                        context.startActivity(i5);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                //바롬관1층
                                case 6:
                                    Intent i6 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:02-970-5193"));
                                    try {
                                        context.startActivity(i6);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                //샬롬하우스
                                case 7:
                                    Intent i7 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:02-970-5194"));
                                    try {
                                        context.startActivity(i7);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                //국제교육관
                                case 8:
                                    Intent i8 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:02-970-5198"));
                                    try {
                                        context.startActivity(i8);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                //50주년기념관
                                case 9:
                                    Intent i9 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:02-970-7560"));
                                    try {
                                        context.startActivity(i9);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                //아름관,다움관
                                case 10:
                                    Intent i10 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:02-970-7950"));
                                    try {
                                        context.startActivity(i10);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    break;
                            } // end swtich
                        }
                    });

                } // end else if*/

                    {
                    Toast.makeText(context, "전화 거는 중 : " + bean.getTeam(), Toast.LENGTH_SHORT).show();
                    Intent i1 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + bean.getTeam_Tel()));
                    try {
                        context.startActivity(i1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } // end else



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
