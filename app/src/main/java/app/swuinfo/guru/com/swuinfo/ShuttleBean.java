package app.swuinfo.guru.com.swuinfo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by xnote on 2017-08-02.
 */

public class ShuttleBean {
    private String result;
    private ShuttleBean.ShuttleLocation ShuttleLocationSub;
    private ArrayList<ShuttleBean.ShuttleLocation> shuttleLocationList;

    class ShuttleLocation implements Serializable {
        private String userId;
        private String latitude;
        private String longitude;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public ShuttleLocation getShuttleLocationSub() {
        return ShuttleLocationSub;
    }

    public void setShuttleLocationSub(ShuttleLocation shuttleLocationSub) {
        ShuttleLocationSub = shuttleLocationSub;
    }

    public ArrayList<ShuttleLocation> getShuttleLocationList() {
        return shuttleLocationList;
    }

    public void setShuttleLocationList(ArrayList<ShuttleLocation> shuttleLocationList) {
        this.shuttleLocationList = shuttleLocationList;
    }
}
