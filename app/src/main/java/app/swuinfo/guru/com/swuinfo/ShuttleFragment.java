package app.swuinfo.guru.com.swuinfo;

import android.Manifest;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ShuttleFragment extends Fragment {

   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(app.swuinfo.guru.com.swuinfo.R.layout.ShuttleFragment);
        String[] permissions = {
                android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION};
        ActivityCompat.requestPermissions(this, permissions, 1);
        findViewById(R.id.tabShuttle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLocationService();
            }
        });
    }//end onCreate
    private void startLocationService() {
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        GPSListener gpsListener = new GPSListener();
        long minTime = 5000;//5초
        float minDistance = 0;

        try {

            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                return;
            }
            //뽀인트! GPS를 이용한 위치 요청
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, minTime, minDistance, gpsListener);//5초에 한번씩 정보갱신

            //뽀인트2! 네트워크를 이용한 위치 요청
            lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,minTime, minDistance, gpsListener);
            //마지막 사용했던 위치정보를 확인한다.
            Location lastLocation=lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if(lastLocation!=null){
                Double lat=lastLocation.getLatitude();
                Double lon=lastLocation.getLongitude();
                String msg="마지막 위치:"+lat+"."+lon;
                ToastUtil.showToast(ShuttleFragment.this,msg);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //GPS가 동작할 경우, GPS정보가 계속적으로 콜백 처리
    private class GPSListener implements LocationListener {
        @Override
        public void onLocationChanged(Location location) {
            Double latitude=location.getLatitude();
            Double longitude=location.getLongitude();
            String msg="Latitude(위도):"+latitude+"\nLontitude(경도):"+longitude;
            Log.i("TEST",msg);
            ToastUtil.showToast(ShuttleFragment.this,msg);

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
    }*/
}
