
package app.swuinfo.guru.com.swuinfo;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import android.support.v4.app.Fragment;

/**
 * Created by pc on 2017-08-01.
 */


public class ShuttleMapActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mGoogleMap;
    private static boolean mIsFirstMap = false;//한번만 주고 이동시키지 않겠다.
    //근접경보 intent 키 정의
    public static final String PROXI_INTENT_KEY = "proximity";
    //근접 경보 위치 정보를 저장하고 있는 List
    private ArrayList<PendingIntent> mPendingIntentList = new ArrayList<PendingIntent>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shuttle_map);
        //권한이 있나 없나 체크해서, 권한 없으면 권한 요청
        String[] permissions = {
                android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION};
        ActivityCompat.requestPermissions(this, permissions, 1);

        ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMapAsync(this);

        startLocationService();

        //android.app.FragmentManager fragmentManager=getFragmentManager();
        //MapFragment mapFragment=(MapFragment)fragmentManager.findFragmentById(R.id.map);
        //mapFragment.getMapAsync(this);
//근접경보위치 등록
        register(1000, 37.629285, 127.090435, 1000, 1000 * 60 * 60);
        register(1001, 37.621787, 127.087897, 1000, 1000 * 60 * 60);
        ProxBroadcast pb=new ProxBroadcast(PROXI_INTENT_KEY);
        registerReceiver(pb,pb.getFilter());
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        googleMap.setMyLocationEnabled(true);
        googleMap.getUiSettings().setZoomControlsEnabled(true);//줌 컨트롤러가 생성된다.
        LatLng SEOUL = new LatLng(37.56, 126.97);

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(SEOUL);
        markerOptions.title("서울");
        markerOptions.snippet("한국의 수도");

        googleMap.addMarker(markerOptions);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(10));//10배


    }

    //위치 정보 확인 셋팅 시작
    private void startLocationService() {
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        ShuttleMapActivity.GPSListener gpsListener = new ShuttleMapActivity.GPSListener();
        long minTime = 5000;//5초
        float minDistance = 0;

        try {

            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                return;
            }
            //뽀인트! GPS를 이용한 위치 요청
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, minTime, minDistance, gpsListener);//5초에 한번씩 정보갱신


            //뽀인트2! 네트워크를 이용한 위치 요청
            lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, minTime, minDistance, gpsListener);
            //마지막 사용했던 위치정보를 확인한다.
            Location lastLocation = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (lastLocation != null) {
                Double lat = lastLocation.getLatitude();
                Double lon = lastLocation.getLongitude();
                String msg = "마지막 위치:" + lat + "." + lon;
                ToastUtil.showToast(ShuttleMapActivity.this, msg);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //GPS가 동작할 경우, GPS정보가 계속적으로 콜백 처리
    private class GPSListener implements LocationListener {
        @Override
        public void onLocationChanged(Location location) {
            Double latitude = location.getLatitude();
            Double longitude = location.getLongitude();
            if (mIsFirstMap == false) {//why?
                String msg = "Latitude(위도):" + latitude + "\nLontitude(경도):" + longitude;
                Log.i("TEST", msg);
                ToastUtil.showToast(ShuttleMapActivity.this, msg);
                if (mGoogleMap != null) {
                    if (!mIsFirstMap) {
                        LatLng latLng = new LatLng(latitude, longitude);
                        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                        mGoogleMap.animateCamera(CameraUpdateFactory.zoomTo(15));
                        mIsFirstMap = true;
                    }
                }
            }

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

    }//end GPSListener

    //근접경보 등록
    private void register(int id, double lat, double lng, float radius, long expiration) {
        Intent pIntent = new Intent(PROXI_INTENT_KEY);
        pIntent.putExtra("id", id);
        pIntent.putExtra("latitude", lat);
        pIntent.putExtra("longitude", lng);
        PendingIntent pi = PendingIntent.getBroadcast(ShuttleMapActivity.this, id, pIntent, PendingIntent.FLAG_CANCEL_CURRENT);
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        lm.addProximityAlert(lat, lng, radius, expiration, pi);
        mPendingIntentList.add(pi);
    }
}

