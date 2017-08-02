package app.swuinfo.guru.com.swuinfo;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ShuttleDriverActivity extends CommonActivity {

    double mLatitude, mLongitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);

        findViewById(R.id.btnShuttle1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startLocationService();
                GPSListener gpsListener = new GPSListener();
                mLatitude = gpsListener.latitude;
                mLongitude = gpsListener.longitude;
                new ShuttleLocationTask("swu1", mLatitude, mLongitude).execute();
            }
        });
        findViewById(R.id.btnShuttle2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GPSListener gpsListener = new GPSListener();
                mLatitude = gpsListener.latitude;
                mLongitude = gpsListener.longitude;
                new ShuttleLocationTask("swu1", mLatitude, mLongitude).execute();
            }
        });
        findViewById(R.id.btnShuttle3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GPSListener gpsListener = new GPSListener();
                mLatitude = gpsListener.latitude;
                mLongitude = gpsListener.longitude;
                new ShuttleLocationTask("swu1", mLatitude, mLongitude).execute();
            }
        });
        findViewById(R.id.btnShuttle4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GPSListener gpsListener = new GPSListener();
                mLatitude = gpsListener.latitude;
                mLongitude = gpsListener.longitude;
                new ShuttleLocationTask("swu1", mLatitude, mLongitude).execute();
            }
        });
        findViewById(R.id.btnShuttle5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GPSListener gpsListener = new GPSListener();
                mLatitude = gpsListener.latitude;
                mLongitude = gpsListener.longitude;
                new ShuttleLocationTask("swu1", mLatitude, mLongitude).execute();
            }
        });
    }


    //

    //서버에 올리기
    public class ShuttleLocationTask extends AsyncTask<String, Void, String> {
        public static final String URL_SHUTTLE = "http://172.16.13.217:8080/rest/updateShuttleLocation.do";
        private String shuttleNo;
        private double latitude, longitude;

        ShuttleLocationTask(String shuttleNo, double latitude, double longitude) {
            this.shuttleNo = shuttleNo;
            this.latitude = latitude;
            this.longitude = longitude;
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                RestTemplate restTemplate = new RestTemplate();
                //restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                restTemplate.getMessageConverters().add(new FormHttpMessageConverter());

                MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
                map.add("userId", shuttleNo);
                map.add("latitude", latitude);
                map.add("longitude", longitude);

                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

                HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(map, headers);

                return restTemplate.postForObject(URL_SHUTTLE, request, String.class);
            } catch (Exception e) {
                return null;
            } finally {
            }
        }

        @Override
        protected void onPostExecute(String s) {
            Gson gson = new Gson();
            try {
                ShuttleBean sbean = gson.fromJson(s, ShuttleBean.class);
                if (sbean != null) {
                    //데이터가 있다
                    if (sbean.getResult().equals("ok")) {
                        if (sbean != null) {
                            Toast.makeText(ShuttleDriverActivity.this, "출발~", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                    }
                }
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "파싱실패", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }
    }

    //계속적으로 콜백처리
    private class GPSListener implements LocationListener {
        double latitude; double longitude;

        @Override
        public void onLocationChanged(Location location) {
            latitude = location.getLatitude();
            longitude = location.getLongitude();
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    }

    private void startLocationService() {
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        GPSListener gpsListener = new GPSListener();
        long minTime = 5000;//5초
        float minDistance = 0;
        List<LocationInfo> list = null;
        double lat = 0, lon = 0;

        try {
            //뽀인트! GPS를 이용한 위치 요청
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, minTime, minDistance, gpsListener);//5초에 한번씩 정보갱신


            //뽀인트2! 네트워크를 이용한 위치 요청
            lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,minTime, minDistance, gpsListener);

            Location lastLocation=lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if(lastLocation!=null){
                lat=lastLocation.getLatitude();
                lon=lastLocation.getLongitude();
            }
            LocationInfo location1 = new LocationInfo(lat, lon);
            list.add(location1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public class LocationInfo {
        private double latitude;
        private double longitude;

        LocationInfo(double latitude, double longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }
    }
}
