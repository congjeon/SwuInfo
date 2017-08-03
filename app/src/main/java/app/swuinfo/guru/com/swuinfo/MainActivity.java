package app.swuinfo.guru.com.swuinfo;

import android.*;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends CommonActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int permission = ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION);
        int permission2 = ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION);
        if(permission == PackageManager.PERMISSION_GRANTED && permission2 == PackageManager.PERMISSION_GRANTED){

        } else {
            ActivityCompat.requestPermissions(MainActivity.this, new String[] {android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
        }

        startActivity(new Intent(MainActivity.this, SplashActivity.class));

        findViewById(R.id.btnNotice).setOnClickListener(clickButton);
        findViewById(R.id.btnSchedule).setOnClickListener(clickButton);
        findViewById(R.id.btnSite).setOnClickListener(clickButton);
        findViewById(R.id.btnCall).setOnClickListener(clickButton);
        findViewById(R.id.btnShuttle).setOnClickListener(clickButton);
        }

        //메뉴 인텐트로 이동할때 첫 메뉴로 뭘 보여줄지 결정하기 위함
        private View.OnClickListener clickButton = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menuIntent = new Intent(MainActivity.this, MenuActivity.class);
                switch (view.getId()) {
                    case R.id.btnNotice:
                        menuIntent.putExtra("where", 1);
                        break;
                    case R.id.btnSchedule:
                        menuIntent.putExtra("where", 2);
                        break;
                    case R.id.btnSite:
                        menuIntent.putExtra("where", 3);
                        break;
                    case R.id.btnCall:
                        menuIntent.putExtra("where", 4);
                        break;
                    case R.id.btnShuttle:
                        menuIntent.putExtra("where", 5);
                        break;
                }
                startActivity(menuIntent);
            }
        };
}
