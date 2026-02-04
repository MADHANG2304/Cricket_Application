
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class MatchSchedule {

    private ArrayList<Team> teams;
    private ArrayList<Match> matches;
    private int totalMatches;
    private Stadium stadium;
    private String matchDate;
    private String matchTime;

    public MatchSchedule(ArrayList<Team> teams) {
        this.teams = new ArrayList<>(teams);
        matches = new ArrayList<>();
    }

    public void scheduleMatch() {
        Random r = new Random();
        HashSet<Team> check = new HashSet<>();

        while (teams.size() >= 2) {
            int index1 = r.nextInt(teams.size());
            int index2 = r.nextInt(teams.size());

            if (index1 == index2)
                continue;

            Team team1 = teams.get(index1);
            Team team2 = teams.get(index2);

            if (check.contains(team1) || check.contains(team2)) continue;

            check.add(team1);
            check.add(team2);
            Match match = new Match(team1, team2);
            matches.add(match);

            if (index1 > index2) {
                teams.remove(team1);
                teams.remove(team2);
            } 
            else {
                teams.remove(team2);
                teams.remove(team1);
            }
        }

        totalMatches = matches.size();
    }

    public ArrayList<Match> getMatches() {
        return matches;
    }

}
