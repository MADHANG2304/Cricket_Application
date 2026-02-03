
import java.util.ArrayList;

public class Team {
    private String teamName;
    private ArrayList<Player> players;
    private int points;
    private Stadium stadium;

    public Team(String teamA){
        teamName = teamA;
        players = new ArrayList<>();
    }
    
    public String getTeamName(){
        return teamName;
    }
    
    public void addPlayer(Player player){
        players.add(player);
    }

    public ArrayList<Player> getPlayers(){
        return players;
    }

    public void setStadium(Stadium stadium){
        this.stadium = stadium;
    }

    public Stadium getStadium(){
        return stadium;
    }

    public int getPoints(){
        return points;
    }

    public void addPoints(int newPoints){
        points += newPoints;
    }
}
