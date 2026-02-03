import java.util.ArrayList;

public class Stadium {
    private String stadiumName;
    private String location;
    private String homeTeamName;
    private int numberOfMatchesPlayed;  
    private int capacity;
    private ArrayList<Match> hostedMatches;


    public Stadium(String stadiumName, String location, int capacity, String homeTeamName) {
        this.stadiumName = stadiumName;
        this.location = location;
        this.capacity = capacity;
        this.homeTeamName = homeTeamName;
        this.hostedMatches = new ArrayList<>();
    }

    public void addMatch(Match match) {
        hostedMatches.add(match);
        numberOfMatchesPlayed++;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public String getHomeTeamName(){
        return homeTeamName;
    }

    public String getLocation(){
        return location;
    }
    
    public int getCapacity(){
        return capacity;
    }

    public int getNumberOfMatchesPlayed() {
        return numberOfMatchesPlayed;
    }

}
