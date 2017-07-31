package app.swuinfo.guru.com.swuinfo;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import org.w3c.dom.Text;

public class NoticeDetail extends CommonActivity {

    TextView txtNotiTitle, txtNotiContents;

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_detail);

        txtNotiTitle = (TextView)findViewById(R.id.txtNotiTitle);
        txtNotiContents = (TextView)findViewById(R.id.txtNotiContents);

        NoticeBean.Item noticeData= (NoticeBean.Item)getIntent().getSerializableExtra("noticeData");

        //txtNotiContents.setText("\n" + Html.fromHtml(noticeData.getText()));
        txtNotiContents.setText(Html.fromHtml(noticeData.getText(), Html.FROM_HTML_MODE_COMPACT));
        txtNotiTitle.setText(noticeData.getSubject());
    }
}
