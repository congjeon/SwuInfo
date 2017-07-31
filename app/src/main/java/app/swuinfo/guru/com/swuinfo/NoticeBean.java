package app.swuinfo.guru.com.swuinfo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xnote on 2017-07-28.
 */

public class NoticeBean implements Serializable{
    private List<Item> items;

    class Item implements Serializable{
        private String Subject;
        private String Text;
        private String Dates;

        public String getSubject() {
            return Subject;
        }

        public void setSubject(String subject) {
            Subject = subject;
        }

        public String getText() {
            return Text;
        }

        public void setText(String text) {
            Text = text;
        }

        public String getDates() {
            return Dates;
        }

        public void setDates(String dates) {
            Dates = dates;
        }
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
