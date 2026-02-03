import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);
    static AddTeam addTeam = new AddTeam();
    static Tournament tournament = new Tournament("IPL");
    static ArrayList<Stadium> stadiums = new ArrayList<>();

    public static void addPlayer(Team team) {
        while (true) {
            System.out.println("\nSelect Player Option");
            System.out.println("1. Add a new Player");
            System.out.println("2. View All Player of team " + team.getTeamName());
            System.out.println("3. Add Home Stadium");
            System.out.println("4. Go Back");

            int choice = scan.nextInt();
            scan.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Player Name: ");
                    String playerName = scan.nextLine();

                    Player player = new Player(playerName, 0, 0, 0, 0);
                    addTeam.addPlayerToTeam(team, player);

                    System.out.println("Player added successfully!");
                    break;

                case 2:
                    System.out.println("Team Players of " + team.getTeamName());
                    ArrayList<Player> players = team.getPlayers();
                    for(Player p : players){
                        System.out.println(p.getPlayerName());
                    }
                    break;

                case 3:
                    
                    if(addTeam.addStadium(team, stadiums)){
                        System.out.println("Home Stadium added");
                    }
                    else{
                        System.out.println("Home Stadium not added");
                    }
                    break;
                case 4:
                    return;

                default:
                    System.out.println("Invalid Option!");
            }
        }
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("\nSelect Your Option");
            System.out.println("1. Create a new team");
            System.out.println("2. Create a new match");
            System.out.println("3. Create a new stadium");
            System.out.println("4. View All Stadium");
            System.out.println("5. Exit");

            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {

                case 1: {
                    System.out.print("Enter Team Name: ");
                    String teamName = scan.nextLine();

                    Team team = addTeam.createTeam(teamName);

                    System.out.println("Team created successfully!");
                    addPlayer(team);
                    break;
                }

                case 2: {
                    if (addTeam.getAllTeams().size() < 2) {
                        System.out.println("At least 2 teams required!");
                        break;
                    }

                    System.out.println("Select Team 1:");
                    for (int i = 0; i < addTeam.getAllTeams().size(); i++) {
                        System.out.println((i + 1) + ". " +
                        addTeam.getAllTeams().get(i).getTeamName());
                    }
                    
                    int t1 = scan.nextInt() - 1;

                    System.out.println("Select Team 2:");
                    int t2 = scan.nextInt() - 1;

                    Team team1 = addTeam.getAllTeams().get(t1);
                    Team team2 = addTeam.getAllTeams().get(t2);

                    Match match = tournament.addMatch(team1, team2);

                    System.out.print("Enter Team 1 Score: ");
                    int score1 = scan.nextInt();

                    System.out.print("Enter Team 2 Score: ");
                    int score2 = scan.nextInt();

                    match.matchWinner(score1, score2);
                    System.out.println("Winner is: " + match.getWinner().getTeamName());
                    break;
                }

                case 3:
                        System.out.println("Enter Stadium Name : ");
                        String stadiumName = scan.nextLine();
                        System.out.println("Enter Stadium Location : ");
                        String location = scan.nextLine();
                        System.out.println("Enter Stadium Capacity : ");
                        int capacity = scan.nextInt();
                        System.out.println("Enter Stadium Home Team : ");
                        scan.nextLine();
                        String homeTeam = scan.nextLine();
                        Stadium stadium = new Stadium(stadiumName, location, capacity, homeTeam);
                        stadiums.add(stadium);
                        System.out.println("Stadium created successfully!");
                        break;

                case 4:
                    System.out.println("All Staidums of IPL");
                    for(Stadium i : stadiums){
                        System.out.println("Stadium : " + i.getStadiumName() + " Location : " + i.getLocation() + " Capacity : " + i.getCapacity() + " Home Team : " + i.getHomeTeamName());
                    }
                    break;

                case 5:
                    System.out.println("Thanks for creation!");
                    System.exit(0);
                
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
