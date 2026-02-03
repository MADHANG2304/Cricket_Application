import java.util.HashMap;

public class Match {
    private Team team1;
    private Team team2;
    private Team winner;
    private boolean isCompleted;
    private HashMap<Player , Integer> playerScore;
    private String date;
    private String startTime;
    private String endTime;

    public Match(Team team1 , Team team2){
        this.team1 = team1;
        this.team2 = team2;
        playerScore = new HashMap<>();
        isCompleted = false;
    }

    public void addPlayerScore(Player player , int score){
        playerScore.put(player , score);

        player.addRuns(score);
        player.addMatchPlayed();

        if(score >= 100){
            player.addCentury();
        }
        else if(score >= 50){
            player.addHalfCentury();
        }
    }

    public void matchWinner(int score1 , int score2){
        isCompleted = true;

        if(score1 > score2){
            winner = team1;
            team1.addPoints(2);
        }
        else{
            winner = team2;
            team2.addPoints(2);
        }
    }

    public Team getWinner(){
        return  winner;
    }

    public boolean isCompleted(){
        return isCompleted;
    }
}
