import java.util.ArrayList;

public class AddTeam {

    private ArrayList<Team> teams;

    public AddTeam() {
        teams = new ArrayList<>();
    }

    public Team createTeam(String teamName) {
        Team team = new Team(teamName);
        teams.add(team);
        return team;
    }

    public boolean addStadium(Team team , ArrayList<Stadium> stadiums){
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

