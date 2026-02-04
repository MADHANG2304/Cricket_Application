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
    }

    public Match addMatch(Team team1 , Team team2){
        Match match = new Match(team1, team2);
        matches.add(match); 

        return match;
    } 

    public void getTeamPlayers(Team team){
        ArrayList<Player> players = team.getPlayers();
        System.out.println(team.getTeamName() + " Players :");
        for(Player player : players){
            System.out.println("Name : " + player.getPlayerName());
        }
    }

    public void addTeams(Team team){
        teams.add(team);
    }

    public  ArrayList<Team> getAllTeams(){
        return teams;
    }

    public void addStadium(Stadium stadium){
        stadiums.add(stadium);
    }

    public ArrayList<Stadium> getAllStadiums(){
        return stadiums;
    }

    public MatchSchedule createMatchSchedule(){
        return new MatchSchedule(teams);
    }

    public void displayPointsTable(){
        System.err.println("<---   Points Table of " + tournament + "   --->");

        for(Team team : teams){
            System.out.println(team.getTeamName() + " : " + team.getPoints());
        }
    }
}
