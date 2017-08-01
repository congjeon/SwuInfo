package app.swuinfo.guru.com.swuinfo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by user on 2017-07-31.
 */

public class CallBean implements Serializable {

    private String team;
    private String team_Tel;

    public CallBean() {

    }

    public CallBean(String team, String teamTell) {
        this.team = team;
        this.team_Tel = teamTell;
    }

    public String getTeam_Tel() {
        return team_Tel;
    }

    public void setTeam_Tel(String team_Tel) {
        this.team_Tel = team_Tel;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
