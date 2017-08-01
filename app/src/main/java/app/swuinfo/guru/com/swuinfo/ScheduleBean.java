package app.swuinfo.guru.com.swuinfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ScheduleBean implements Serializable {

	private String result;
	private ScheduleBeanSub scheduleBeanSub;
	private ArrayList<ScheduleBeanSub> scheduleBean;

	class ScheduleBeanSub implements Serializable{
		private int year;
		private int month;
		private int day;
		private String data;

		public int getYear() {
			return year;
		}
		public void setYear(int year) {
			this.year = year;
		}
		public int getMonth() {
			return month;
		}
		public void setMonth(int month) {
			this.month = month;
		}
		public int getDay() {
			return day;
		}
		public void setDay(int day) {
			this.day = day;
		}
		public String getData() {
			return data;
		}
		public void setData(String data) {
			this.data = data;
        }
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public ScheduleBeanSub getScheduleBeanSub() {
        return scheduleBeanSub;
    }

    public void setScheduleBeanSub(ScheduleBeanSub scheduleBeanSub) {
        this.scheduleBeanSub = scheduleBeanSub;
    }

    public ArrayList<ScheduleBeanSub> getScheduleBean() {
        return scheduleBean;
    }

    public void setScheduleBean(ArrayList<ScheduleBeanSub> scheduleBean) {
        this.scheduleBean = scheduleBean;
    }
}
