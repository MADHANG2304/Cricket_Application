import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);
    static Tournament tournament = new Tournament("IPL");
    static AddTeam addTeam = new AddTeam(tournament);
    static MatchSchedule matchSchedule;
    static ArrayList<Team> allTeams;

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
                    System.out.print("\nEnter Player Name: ");
                    String playerName = scan.nextLine();

                    Player player = new Player(playerName, 0, 0, 0, 0);
                    addTeam.addPlayerToTeam(team, player);

                    System.out.println("\n<---   Player added successfully!   --->");
                    break;

                case 2:
                    System.out.println("\nTeam Players of " + team.getTeamName());
                    ArrayList<Player> players = team.getPlayers();
                    for (Player p : players) {
                        System.out.println(p.getPlayerName());
                    }
                    break;

                case 3:

                    if (addTeam.addStadium(team)) {
                        System.out.println("\n<---   Home Stadium added   --->");
                    } else {
                        System.out.println("\n<---   Home Stadium not added   --->");
                    }
                    break;
                case 4:
                    return;

                default:
                    System.out.println("Invalid Option!");
            }
        }
    }

    public static void addMatches(MatchSchedule matchSchedule) {
        while (true) {
            System.out.println("\nSelect Match Option");
            System.out.println("1. Schedule Matches");
            System.out.println("2. View All Matches");
            System.out.println("3. Update Match");
            System.out.println("4. Go Back");

            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    matchSchedule.scheduleMatch();
                    System.out.println("\n<---   Tournament Matches are Scheduled   --->");
                    System.out.println();
                    break;
                case 2:
                    ArrayList<Match> matches = matchSchedule.getMatches();
                    System.out.println("\n<-----     Schedule     ----->");
                    for (Match i : matches) {
                        System.out.println(i.getTeam1().getTeamName() + " vs " + i.getTeam2().getTeamName());
                    }
                    break;
                case 3:
                    matches = matchSchedule.getMatches();
                    System.out.println("\n<---   Pick a match to update:   --->");
                    int index = 0;
                    for (Match i : matches) {
                        System.out.println(
                                (index++) + ": " + i.getTeam1().getTeamName() + " vs " + i.getTeam2().getTeamName());
                    }
                    int id = scan.nextInt();
                    updateMatch(matches.get(id));
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid Input");
            }
        }
    }

    public static void updateMatch(Match match) {
        Team team1 = match.getTeam1();
        Team team2 = match.getTeam2();

        while (true) {
            System.out.println("\nSelect Match Option");
            System.out.println("1. Add Player Score");
            System.out.println("2. Add Match Score");
            System.out.println("3. Get Player Score");
            System.out.println("4. Get Match Winner");
            System.out.println("5. Go Back");

            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    ArrayList<Player> team1Players = team1.getPlayers();
                    ArrayList<Player> team2Players = team2.getPlayers();

                    System.out.println("\nSelect Team");
                    System.out.println("1: " + team1.getTeamName());
                    System.out.println("2: " + team2.getTeamName());

                    int teamChoice = scan.nextInt();
                    System.out.println("Choose the Player:");
                    if (teamChoice == 1) {
                        for (int i = 0; i < team1Players.size(); i++) {
                            System.out.println(i + ": " + team1Players.get(i).getPlayerName());
                        }
                        Player currPlayer = team1Players.get(scan.nextInt());
                        System.out.println(currPlayer.getPlayerName());
                        System.out.print("Enter Player Score: ");
                        int score = scan.nextInt();
                        match.addPlayerScore(currPlayer, score);
                    }

                    else {
                        for (int i = 0; i < team2Players.size(); i++) {
                            System.out.println(i + ": " + team2Players.get(i));
                        }
                        System.out.println();
                        Player currPlayer = team2Players.get(scan.nextInt());
                        System.out.println(currPlayer.getPlayerName());
                        System.out.print("Enter Player Score");
                        int score = scan.nextInt();
                        match.addPlayerScore(currPlayer, score);
                    }

                    System.out.println("\nPlayer Score Updated");
                    break;

                case 2:
                    System.out.println("\nEnter the score of team " + team1.getTeamName());
                    int score1 = scan.nextInt();
                    System.out.println("Enter the score of team " + team2.getTeamName());
                    int score2 = scan.nextInt();
                    match.matchWinner(score1, score2);
                    System.out.println("\n<---   Match Score Updated   --->");
                    break;

                case 3:
                    ArrayList<Player> playerTeam1 = team1.getPlayers();
                    ArrayList<Player> playerTeam2 = team2.getPlayers();

                    System.out.println("\nSelect Team");
                    System.out.println("1: " + team1.getTeamName());
                    System.out.println("2: " + team2.getTeamName());

                    int playerTeamChoice = scan.nextInt();
                    System.out.println("Choose the Player:");

                    if (playerTeamChoice == 1) {
                        for (int i = 0; i < playerTeam1.size(); i++) {
                            System.out.println(i + ": " + playerTeam1.get(i).getPlayerName());
                        }
                        Player currPlayer = playerTeam1.get(scan.nextInt());
                        System.out.println();
                        System.out.println(
                                currPlayer.getPlayerName() + " scored " + match.getPlayerScore(currPlayer) + " runs");
                    } else {
                        for (int i = 0; i < playerTeam2.size(); i++) {
                            System.out.println(i + ": " + playerTeam2.get(i).getPlayerName());
                        }
                        Player currPlayer = playerTeam2.get(scan.nextInt());
                        System.out.println();
                        System.out.println(
                                currPlayer.getPlayerName() + " scored " + match.getPlayerScore(currPlayer) + " runs");
                    }
                    break;

                case 4:
                    System.out.println("\n<---   Winner of the match" + team1.getTeamName() + " vs "
                            + team2.getTeamName() + "   --->");
                    System.out.print("<----    WINNER: " + match.getWinner().getTeamName() + "    ---->");
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid Input");
            }
        }
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("\nSelect Your Option");
            System.out.println("1. Create a new team");
            System.out.println("2. Create a new stadium");
            System.out.println("3. Update a Team");
            System.out.println("4. View All Teams");
            System.out.println("5. View All Stadium");
            System.out.println("6. Schedule Match");
            System.out.println("7. Get Match Details");
            System.out.println("8. Exit");

            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {

                case 1: {
                    System.out.print("Enter Team Name: ");
                    String teamName = scan.nextLine();

                    Team team = addTeam.createTeam(teamName);

                    System.out.println("\n<---   Team created successfully!   --->");
                    tournament.addTeams(team);
                    allTeams = tournament.getAllTeams();
                    addPlayer(team);
                    break;
                }

                case 2:
                    System.out.print("Enter Stadium Name: ");
                    String stadiumName = scan.nextLine();
                    System.out.print("Enter Stadium Location: ");
                    String location = scan.nextLine();
                    System.out.print("Enter Stadium Capacity: ");
                    int capacity = scan.nextInt();
                    System.out.print("Enter Stadium Home Team: ");
                    scan.nextLine();
                    String homeTeam = scan.nextLine();
                    Stadium stadium = new Stadium(stadiumName, location, capacity, homeTeam);
                    tournament.addStadium(stadium);
                    System.out.println("\n<---   Stadium created successfully!   --->");
                    break;

                case 3:
                    boolean isTeamFound = false;
                    ArrayList<Team> teams = tournament.getAllTeams();
                    System.out.print("Enter the Team Name: ");
                    String teamName = scan.nextLine();
                    Team team = null;
                    for (Team currTeam : teams) {
                        if (currTeam.getTeamName().equals(teamName)) {
                            team = currTeam;
                            isTeamFound = true;
                        }
                    }
                    if (!isTeamFound) {
                        System.out.print("\n<---   Team not Found!   --->");
                    } else {
                        addPlayer(team);
                    }
                    break;

                case 4:
                    System.out.println("\n<----    All Teams of IPL    ---->");
                    teams = tournament.getAllTeams();
                    for (Team i : teams) {
                        System.out.println(i.getTeamName());
                    }
                    break;

                case 5:
                    System.out.println("\n<----    All Staidums of IPL    ---->");
                    ArrayList<Stadium> stadiums = tournament.getAllStadiums();
                    for (Stadium i : stadiums) {
                        System.out.println("Stadium : " + i.getStadiumName() + ", Location : " + i.getLocation()
                                + ", Capacity : " + i.getCapacity() + ", Home Team : " + i.getHomeTeamName());
                    }
                    break;

                case 6:
                    if (matchSchedule == null) {
                        matchSchedule = tournament.createMatchSchedule();
                    }
                    addMatches(matchSchedule);
                    break;

                case 7:
                    ArrayList<Match> matches = matchSchedule.getMatches();
                    System.out.println("\nSelect the Match");
                    for (int i = 0; i < matches.size(); i++) {
                        System.out.println(i + ": " + matches.get(i).getTeam1().getTeamName() + " vs "
                                + matches.get(i).getTeam2().getTeamName());
                    }
                    int matchChoice = scan.nextInt();
                    Match match = matches.get(matchChoice);
                    System.out.println("\n<---   Match between " + match.getTeam1().getTeamName() + " and "
                            + match.getTeam2().getTeamName() + "   --->");
                    System.out.println("\n<----    Match Winner is " + match.getWinner().getTeamName() + "    ---->");
                    break;

                case 8:
                    System.out.println("\n<-----     Thanks for creation!     ----->");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
