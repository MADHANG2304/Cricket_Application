public class Player {
    private String playerName;
    private int matchPlayed;
    private int totalRuns;
    private int numberOfCentury;
    private int numberOfHalfCentury;

    public Player(String playerName, int matchPlayed, int totalRuns, int numberOfCentury, int numberOfHalfCentury){
        this.playerName = playerName;
        this.matchPlayed = matchPlayed;
        this.totalRuns = totalRuns;
        this.numberOfCentury = numberOfCentury;
        this.numberOfHalfCentury = numberOfHalfCentury;
    }

    //Setter
    public void addMatchPlayed(){
        matchPlayed += 1;
    }

    public void addRuns(int runs){
        totalRuns += runs;
    }

    public void addHalfCentury(){
        numberOfHalfCentury += 1;
    }

    public void addCentury(){
        numberOfCentury += 1;
    }


    //Getter
    public String getPlayerName(){
        return playerName;
    }

    public int totalMatchPlayed(){
        return matchPlayed;
    }

    public int totalRuns(){
        return totalRuns;
    }

    public int totalHalfCentury(){
        return numberOfHalfCentury;
    }

    public int totalCentury(){
        return numberOfCentury;
    }
}
