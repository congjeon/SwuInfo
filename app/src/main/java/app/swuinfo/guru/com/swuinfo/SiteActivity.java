package app.swuinfo.guru.com.swuinfo;

        import android.app.AlertDialog;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.net.Uri;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.Button;

public class SiteActivity extends AppCompatActivity{

    private Button btn_eclass, btn_swis, btn_major, btn_swuman, btn_paper, btn_etc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_eclass = (Button)findViewById(R.id.btn_eclass);
        btn_swis = (Button)findViewById(R.id.btn_swis);
        btn_major = (Button)findViewById(R.id.btn_major);
        btn_swuman= (Button)findViewById(R.id.btn_swuman);
        btn_paper= (Button)findViewById(R.id.btn_paper);
        btn_etc= (Button)findViewById(R.id.btn_etc);

        btn_eclass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://cyber.swu.ac.kr"));
                startActivity(intent);
            }
        });

        btn_swis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://swis.swu.ac.kr/"));
                startActivity(intent);
            }
        });

        btn_major.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(SiteActivity.this);
                alertBuilder.setTitle("학과를 선택하세요.");

                // List Adapter 생성
                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(SiteActivity.this, android.R.layout.select_dialog_singlechoice);
                adapter.add("영어영문학과");
                adapter.add("독어독문학과");
                adapter.add("중어중문학과");
                adapter.add("일어일문학과");
                adapter.add("사학과");
                adapter.add("기독교학과");
                adapter.add("경제학과");
                adapter.add("문헌정보학과");
                adapter.add("사회복지학과");
                adapter.add("아동학과");
                adapter.add("행정학과");
                adapter.add("언론영상학부");
                adapter.add("교육심리학과");
                adapter.add("체육학과");
                adapter.add("화학생명환경과학과");
                adapter.add("원예생명조경과");
                adapter.add("식품공학과");
                adapter.add("식품영양학과");
                adapter.add("경영학과");
                adapter.add("디지털미디어학과");
                adapter.add("정보보호학과");
                adapter.add("소프트웨어융합학과");
                adapter.add("산업디자인학과");
                adapter.add("시각디자인학과");
                adapter.add("자율전공학부");

                // 취소 버튼
                alertBuilder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();}
                });

                // Adapter 셋팅
                alertBuilder.setAdapter(adapter, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // AlertDialog 안에 있는 AlertDialog
                        switch (id) {
                            //영문
                            case 0:
                                Intent intent0 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://english.swu.ac.kr/main/main.html"));
                                startActivity(intent0);
                                break;

                            //독문
                            case 1:
                                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://home.swu.ac.kr/german/"));
                                startActivity(intent1);
                                break;
                            //중문
                            case 2:
                                Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://home.swu.ac.kr/chinese/"));
                                startActivity(intent2);
                                break;
                            //일문
                            case 3:
                                Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dodogirls.kr/"));
                                startActivity(intent3);
                                break;
                            //사학
                            case 4:
                                Intent intent4 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://home.swu.ac.kr/history/"));
                                startActivity(intent4);
                                break;
                            //기독
                            case 5:
                                Intent intent5 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://swudcs.tistory.com/"));
                                startActivity(intent5);
                                break;
                            //경제
                            case 6:
                                Intent intent6 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://home.swu.ac.kr/smbfinance/"));
                                startActivity(intent6);
                                break;
                            //문헌정보
                            case 7:
                                Intent intent7 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.swulis.net/main/main.php"));
                                startActivity(intent7);
                                break;
                            //사회복지
                            case 8:
                                Intent intent8 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://home.swu.ac.kr/iswsw/"));
                                startActivity(intent8);
                                break;
                            //아동
                            case 9:
                                Intent intent9 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://home.swu.ac.kr/childstudy/"));
                                startActivity(intent9);
                                break;
                            //행정
                            case 10:
                                Intent intent10 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://home.swu.ac.kr/public/"));
                                startActivity(intent10);
                                break;
                            //언론영상
                            case 11:
                                Intent intent11 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.swumedia.com/"));
                                startActivity(intent11);
                                break;
                            //교육심리
                            case 12:
                                Intent intent12 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.swep.co.kr/"));
                                startActivity(intent12);
                                break;
                            //체육
                            case 13:
                                Intent intent13 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://home.swu.ac.kr/swuhms/"));
                                startActivity(intent13);
                                break;
                            //화생
                            case 14:
                                Intent intent14 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://swuchemistry.weebly.com/"));
                                startActivity(intent14);
                                break;
                            //원예
                            case 15:
                                Intent intent15 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://home.swu.ac.kr/swuhort/"));
                                startActivity(intent15);
                                break;
                            //식공
                            case 16:
                                Intent intent16 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://home.swu.ac.kr/swufood/"));
                                startActivity(intent16);
                                break;
                            //식영
                            case 17:
                                Intent intent17 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://home.swu.ac.kr/fnswu/"));
                                startActivity(intent17);
                                break;
                            //경영
                            case 18:
                                Intent intent18 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://home.swu.ac.kr/bizswu/"));
                                startActivity(intent18);
                                break;
                            //디미
                            case 19:
                                Intent intent19 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://dm.swu.ac.kr/"));
                                startActivity(intent19);
                                break;
                            //정보
                            case 20:
                                Intent intent20 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://security.swu.ac.kr/"));
                                startActivity(intent20);
                                break;
                            //소융
                            case 21:
                                Intent intent21 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://sw.swu.ac.kr/"));
                                startActivity(intent21);
                                break;
                            //산디
                            case 22:
                                Intent intent22 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://id.swu.ac.kr/"));
                                startActivity(intent22);
                                break;
                            //시디
                            case 23:
                                Intent intent23 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://swu-design.com/"));
                                startActivity(intent23);
                                break;
                            //자전
                            case 24:
                                Intent intent24 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://home.swu.ac.kr/premajors/"));
                                startActivity(intent24);
                                break;
                        }
                    }
                });
                alertBuilder.show();
            }

        });

        btn_swuman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://swuman.cafe24.com/xe/"));
                startActivity(intent);
            }
        });

        btn_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.add2paper.com/accounts/login/"));
                startActivity(intent);
            }
        });

        btn_etc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(SiteActivity.this);
                alertBuilder.setTitle("사이트를 선택하세요.");

                // List Adapter 생성
                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(SiteActivity.this, android.R.layout.select_dialog_singlechoice);
                adapter.add("바롬인성교육원");
                adapter.add("캣토익");
                adapter.add("도서관");
                adapter.add("표절검사 프로그램");
                adapter.add("취업경력센터");

                // 취소 버튼
                alertBuilder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();}
                });

                // Adapter 셋팅
                alertBuilder.setAdapter(adapter, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // AlertDialog 안에 있는 AlertDialog
                        switch (id) {
                            //바롬
                            case 0:
                                Intent intent0 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://home.swu.ac.kr/bahrom/"));
                                startActivity(intent0);
                                break;

                            //캣토익
                            case 1:
                                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cattoeic.com/eslscat/swu/"));
                                startActivity(intent1);
                                break;
                            //도서관
                            case 2:
                                Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://lib.swu.ac.kr/"));
                                startActivity(intent2);
                                break;
                            //표절검사
                            case 3:
                                Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.swu.ac.kr/etc/"));
                                startActivity(intent3);
                                break;
                            //취업경력개발팀
                            case 4:
                                Intent intent4 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://job.swu.ac.kr/"));
                                startActivity(intent4);
                                break;

                        }
                    }
                });
                alertBuilder.show();
            }

        });


    }
}
