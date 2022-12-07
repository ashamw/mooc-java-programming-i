import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class SportStatistics {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> rows = new ArrayList<>();
        int teamCount = 0;
        int homeCount = 0;
        int visitingTeamCount = 0;
        int wins = 0;
        int losses = 0;
        String homeTeam = null;
        String visitingTeam = null;
        Scanner sc = new Scanner(System.in);

        // ASK FILE
        System.out.println("File: ");
        String filename = scan.nextLine();
        try {
            Scanner readFile = new Scanner(Paths.get(filename));
            while(readFile.hasNextLine()) {
                String line = readFile.nextLine();
                rows.add(line);
            }
            // ASK TEAM
        System.out.println("Team: ");
        String team = sc.nextLine();

        // CALCULATE
        for (String row : rows) {
            String[] data = row.split(",");
            homeTeam = data[0];
            visitingTeam = data[1];
            homeCount = Integer.valueOf(data[2]);
            visitingTeamCount = Integer.valueOf(data[3]);

            if (team.equals(homeTeam)) {
                teamCount++;
                if (homeCount > visitingTeamCount) {
                    wins++;
                } else {
                    losses++;
                }
            } else if (team.equals(visitingTeam)) {
                teamCount++;
                if (visitingTeamCount > homeCount) {
                    wins++;
                } else {
                    losses++;
                }
            }
        }

        // PRINT
        System.out.println("Games: " + teamCount);
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        } catch (Exception e) {
            e.getMessage();
        }

        
    }
}
