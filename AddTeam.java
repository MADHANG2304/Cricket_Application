import java.util.ArrayList;

public class AddTeam {

    static Tournament tournament;
    private ArrayList<Team> teams;

    public AddTeam(Tournament tournament) {
        this.tournament = tournament;
        teams = new ArrayList<>();
    }

    public Team createTeam(String teamName) {
        Team team = new Team(teamName);
        teams.add(team);
        return team;
    }

    public boolean addStadium(Team team ){
        ArrayList<Stadium> stadiums = tournament.getAllStadiums();
        for(Stadium stadium : stadiums){
            if(stadium.getHomeTeamName().equals(team.getTeamName())){
                team.setStadium(stadium);
                return true;
            }
        }
        return false;
    }

    public void addPlayerToTeam(Team team, Player player) {
        team.addPlayer(player);
    }

    public ArrayList<Team> getAllTeams() {
        return teams;
    }
}

