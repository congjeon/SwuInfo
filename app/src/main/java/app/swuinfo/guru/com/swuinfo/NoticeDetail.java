package app.swuinfo.guru.com.swuinfo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import org.w3c.dom.Text;

public class NoticeDetail extends CommonActivity {

    TextView txtNotiTitle, txtNotiContents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_detail);

        txtNotiTitle = (TextView)findViewById(R.id.txtNotiTitle);
        txtNotiContents = (TextView)findViewById(R.id.txtNotiContents);

        NoticeBean.Item noticeData= (NoticeBean.Item)getIntent().getSerializableExtra("noticeData");


        txtNotiContents.setText("\n" + Html.fromHtml(noticeData.getText()));
        txtNotiTitle.setText(noticeData.getSubject());
    }
}
