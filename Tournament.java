import java.util.ArrayList;

public class Tournament {
    private String tournament;
    private ArrayList<Team> teams;
    private ArrayList<Match> matches;
    private ArrayList<Stadium> stadiums;
    private String startDate;
    private String endDate;

    public Tournament(String tournamentName){
        tournament = tournamentName;
        teams = new ArrayList<>();
        matches = new ArrayList<>();
        stadiums = new ArrayList<>();
        createStadium();
    }

    public Match addMatch(Team team1 , Team team2){
        Match match = new Match(team1, team2);
        matches.add(match); 

        return match;
    } 

    public void createStadium(){
        Stadium stadium = new Stadium("Chepauk", "Chennai", 40000, "CSK");
        stadiums.add(stadium);
        stadium = new Stadium("Wankede", "Mumbai", 40000, "MI");
        stadiums.add(stadium);
        stadium = new Stadium("Chinnaswamy", "Bangalore", 30000, "RCB");
        stadiums.add(stadium);
        stadium = new Stadium("Narendra Modi Stadium", "Ahamadabad", 60000, "GT");
        stadiums.add(stadium);
        stadium = new Stadium("Arun Jetli", "Delhi", 25000, "DC");
        stadiums.add(stadium);
    }

    public void getTeamPlayers(Team team){
        ArrayList<Player> players = team.getPlayers();
        System.out.println(team.getTeamName() + " Players :");
        for(Player player : players){
            System.out.println("Name : " + player.getPlayerName());
        }
    }

    public ArrayList<Stadium> getAllStadiums(){
        return stadiums;
    }

    public void displayPointsTable(){
        System.err.println("<---   Points Table of " + tournament + "   --->");

        for(Team team : teams){
            System.out.println(team.getTeamName() + " : " + team.getPoints());
        }
    }
}
