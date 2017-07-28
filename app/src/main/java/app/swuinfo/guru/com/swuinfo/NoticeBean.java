package app.swuinfo.guru.com.swuinfo;

import java.util.List;

/**
 * Created by xnote on 2017-07-28.
 */

public class NoticeBean {
    private List<Item> items;

    class Item {
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
