package app.swuinfo.guru.com.swuinfo;

/**
 * Created by seonmi on 2017-07-27.
 */

public class ScheDuleItem {

    private String mDay;
    private String mTitle;

    public String getmDay() {
        return mDay;
    }

    public void setmDay(String mDay) {
        this.mDay = mDay;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    /* 생성자 */
    public ScheDuleItem(String day,String title) {
        this.mDay=day;
        this.mTitle=title;
    }

}
