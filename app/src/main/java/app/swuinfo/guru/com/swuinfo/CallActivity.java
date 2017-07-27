package app.swuinfo.guru.com.swuinfo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class CallActivity extends AppCompatActivity {

    private EditText editText;
    private Button btn1, btn2, btn3;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        editText = (EditText) findViewById(R.id.edtFilter);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        listView = (ListView)findViewById(R.id.listView);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel : 010.0000.0000"));
                i.setData(Uri.parse("tel : 010.0000.0000"));
                try {
                    startActivity(i);
                } catch (Exception e ) {
                    e.printStackTrace();
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel : 010.1111.1111"));
                i.setData(Uri.parse("tel : 010.1111.1111"));
                try {
                    startActivity(i);
                } catch (Exception e ) {
                    e.printStackTrace();
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel : 010.2222.2222"));
                i.setData(Uri.parse("tel : 010.2222.2222"));
                try {
                    startActivity(i);
                } catch (Exception e ) {
                    e.printStackTrace();
                }
            }
        });

    } // end onCreate

} // end Class
