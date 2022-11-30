package Streams.SecondTask;

public class MatchResult {
    private String hostName;
    private String guestName;
    private int hostGoals;
    private int guestGoals;

    public MatchResult(String hostName, String guestName, int hostGoals, int guestGoals) {
        this.hostName = hostName;
        this.guestName = guestName;
        this.hostGoals = hostGoals;
        this.guestGoals = guestGoals;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public int getHostGoals() {
        return hostGoals;
    }

    public void setHostGoals(int hostGoals) {
        this.hostGoals = hostGoals;
    }

    public int getGuestGoals() {
        return guestGoals;
    }

    public void setGuestGoals(int guestGoals) {
        this.guestGoals = guestGoals;
    }

    @Override
    public String toString() {
        return hostName + " - " + guestName + "(" + hostGoals + ":" + guestGoals + ")";
    }

    int getGoalDifference() {
        return hostGoals - guestGoals;
    }

    String[] getTeamNames() {
        return new String[] {hostName, guestName};
    }

    int getGoals() {
        return hostGoals + guestGoals;
    }
}
