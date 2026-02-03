
import java.util.ArrayList;

public class MatchSchedule {
    
    private ArrayList<Team> teams; 
    private ArrayList<Match> matches;
    private int totalMatches;
    private Stadium stadium;
    private String matchDate;
    private String matchTime;

    public MatchSchedule() {
        teams = new ArrayList<>();
        matches = new ArrayList<>();
    }

    public void scheduleMatch() {

    }

    public ArrayList<Match> getMatches() {
        return matches;
    }

}
